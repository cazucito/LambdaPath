---
layout: tutorial
title: "Etapa 09 — Rendimiento"
description: "Compara el rendimiento de loops tradicionales vs Streams vs Parallel Streams para elegir la mejor opción."
stage_number: 9
learning_objectives:
  - Comparar loop vs Stream vs ParallelStream
  - Entender cuándo usar cada enfoque
  - Identificar overhead de Streams
  - Aplicar mejores prácticas de rendimiento
---

No siempre "más moderno" significa "más rápido". Veamos cuándo usar cada enfoque.

## Comparativa Visual

```
Pequeñas colecciones (< 1000):
Loop for    ▓▓▓▓▓▓▓▓▓▓  (más rápido)
Stream      ▓▓▓▓▓▓▓▓▓▓▓  (ligeramente más lento)
Parallel    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  (mucho más lento)

Grandes colecciones (> 10000), CPU-intensive:
Loop for    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
Stream      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
Parallel    ▓▓▓▓▓▓▓▓▓▓  (más rápido en múltiples cores)
```

## Benchmark Simple

```java
List<Integer> numbers = // ... 1 millón de elementos

// 1. Loop tradicional
long start = System.nanoTime();
int sum1 = 0;
for (int n : numbers) {
    if (n % 2 == 0) {
        sum1 += n * n;
    }
}
long timeLoop = System.nanoTime() - start;

// 2. Stream secuencial
start = System.nanoTime();
int sum2 = numbers.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(n -> n * n)
    .sum();
long timeStream = System.nanoTime() - start;

// 3. Parallel Stream
start = System.nanoTime();
int sum3 = numbers.parallelStream()
    .filter(n -> n % 2 == 0)
    .mapToInt(n -> n * n)
    .sum();
long timeParallel = System.nanoTime() - start;
```

## Resultados Típicos

| Colección | Loop | Stream | Parallel | Mejor opción |
|-----------|------|--------|----------|--------------|
| 100 elementos | 0.1μs | 0.3μs | 50μs | **Loop** |
| 10,000 elementos | 10μs | 15μs | 200μs | **Loop** o **Stream** |
| 1M elementos, simple | 5ms | 8ms | 10ms | **Loop** |
| 1M elementos, complejo | 100ms | 120ms | 40ms | **Parallel** |

<div class="callout info">
  <div class="callout-title">ℹ️ Overhead de Streams</div>
  Los Streams tienen overhead por:
  <ul>
    <li>Creación de objetos intermedios</li>
    <li>Invocación de lambdas (aunque JIT optimiza)</li>
    <li>Coordinación en parallel streams</li>
  </ul>
  Para pocas operaciones simples, un loop puede ser 2-3x más rápido.
</div>

## Cuándo Usar Cada Uno

### Usa Loop cuando:
- La colección es pequeña (< 1000 elementos)
- Necesitas máxima performance
- La lógica es compleja con múltiples breaks/continues
- Estás en un hot path crítico

```java
// Loop: máxima performance
for (Item item : items) {
    if (item.isValid()) {
        process(item);
        if (shouldStop(item)) break;
    }
}
```

### Usa Stream cuando:
- El código debe ser legible y declarativo
- Encadenas múltiples operaciones
- No es un hot path crítico
- Trabajas con Optional

```java
// Stream: más legible
items.stream()
    .filter(Item::isValid)
    .map(Item::getValue)
    .filter(v -> v > threshold)
    .findFirst()
    .ifPresent(this::process);
```

### Usa Parallel Stream cuando:
- La colección es grande (> 10,000 elementos)
- La operación es CPU-intensiva
- No hay condiciones de carrera
- Tienes múltiples cores disponibles

```java
// Parallel: para cálculos pesados
List<Result> results = largeDataset.parallelStream()
    .map(this::expensiveComputation)
    .collect(Collectors.toList());
```

## ⚠️ Peligros de Parallel Stream

<div class="callout error">
  <div class="callout-title">❌ NUNCA uses parallelStream cuando:</div>
  <ul>
    <li>Modificas variables externas (no thread-safe)</li>
    <li>El orden importa y usas forEach (no forEachOrdered)</li>
    <li>La fuente no es splittable eficientemente (Stream.iterate)</li>
    <li>La operación es I/O bound (bloquea el ForkJoinPool común)</li>
  </ul>
</div>

```java
// ❌ ERROR: race condition
List<Integer> result = new ArrayList<>();
numbers.parallelStream()
    .forEach(result::add); // ConcurrentModificationException!

// ✅ CORRECTO: collector thread-safe
List<Integer> result = numbers.parallelStream()
    .collect(Collectors.toList());
```

## Mejores Prácticas

1. **Prefiere primitivos:** `IntStream` vs `Stream<Integer>`
2. **Evita boxing:** Usa `mapToInt` en lugar de `map`
3. **Short-circuit:** `findFirst` detiene el procesamiento temprano
4. **Mide antes de optimizar:** No asumas, benchmark

## Resumen

```
┌─────────────────┬─────────────┬──────────────┬───────────────┐
│ Situación       │ Loop        │ Stream       │ Parallel      │
├─────────────────┼─────────────┼──────────────┼───────────────┤
| Pequeño dataset │ ✅ Mejor    │ ⚠️ Overhead  │ ❌ Peor       │
| Gran dataset    │ ✅ OK       │ ✅ OK        │ ✅ Mejor*     │
| Legibilidad     │ ⚠️ Verboso  │ ✅ Mejor     │ ⚠️ Igual      │
| CPU-intensive   │ ✅ OK       │ ✅ OK        │ ✅ Mejor      │
| I/O-bound       │ ✅ Mejor    │ ✅ OK        │ ❌ NO!        │
└─────────────────┴─────────────┴──────────────┴───────────────┘
* Solo si hay suficientes cores y la operación es splittable
```

<div class="callout tip">
  <div class="callout-title">💡 Regla de oro</div>
  Empieza con <strong>Stream</strong> por legibilidad. Si el profiling muestra que es un cuello de botella, considera <strong>loop</strong> o <strong>parallelStream</strong> según el caso.
</div>