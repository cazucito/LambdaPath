---
layout: tutorial
title: "Etapa 07 — Streams API"
description: "Procesa colecciones de forma declarativa con filter, map, reduce y otras operaciones funcionales."
stage_number: 7
learning_objectives:
  - Crear Streams desde diferentes fuentes
  - Encadenar operaciones intermedias
  - Usar operaciones terminales efectivamente
  - Comprender la evaluación lazy
  - Aplicar parallelStream cuando convenga
---

Un **Stream** es una secuencia de elementos que soporta operaciones funcionales. La evaluación es **lazy**: las operaciones intermedias no se ejecutan hasta que se invoca una operación terminal.

## Pipeline de un Stream

```
Fuente → Operación Intermedia → Operación Intermedia → Terminal
  (List)     (filter)              (map)               (collect)
                                              ↓
                                         Resultado
```

## Creando Streams

```java
// Desde colección
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream1 = numbers.stream();

// Desde valores
Stream<String> stream2 = Stream.of("a", "b", "c");

// Desde array
int[] array = {1, 2, 3};
IntStream stream3 = Arrays.stream(array);

// Stream infinito (¡con limit!)
Stream<Integer> infinite = Stream.iterate(0, n -> n + 2).limit(10);
```

## Operaciones Intermedias (Lazy)

| Operación | Descripción | Ejemplo |
|-----------|-------------|---------|
| `filter(Predicate)` | Conserva elementos que cumplen condición | `.filter(n -> n > 0)` |
| `map(Function)` | Transforma cada elemento | `.map(String::length)` |
| `sorted()` | Ordena elementos | `.sorted()` |
| `distinct()` | Elimina duplicados | `.distinct()` |
| `limit(n)` | Toma primeros n elementos | `.limit(5)` |
| `skip(n)` | Salta primeros n elementos | `.skip(2)` |

## Operaciones Terminales (Eager)

| Operación | Retorna | Uso |
|-----------|---------|-----|
| `collect(Collector)` | Colección | `.collect(Collectors.toList())` |
| `reduce(identity, op)` | Valor acumulado | `.reduce(0, Integer::sum)` |
| `forEach(Consumer)` | void | `.forEach(System.out::println)` |
| `count()` | long | `.count()` |
| `findFirst()` | Optional | `.findFirst()` |
| `anyMatch(Predicate)` | boolean | `.anyMatch(s -> s.isEmpty())` |

## Ejemplos Prácticos

```java
List<Integer> numbers = List.of(-3, -1, 0, 1, 2, 3, 4, 5, 6);

// 1. Filtrar positivos
List<Integer> positivos = numbers.stream()
    .filter(n -> n > 0)
    .collect(Collectors.toList());
// Resultado: [1, 2, 3, 4, 5, 6]

// 2. Mapear a cuadrados
List<Integer> cuadrados = numbers.stream()
    .filter(n -> n > 0)
    .map(n -> n * n)
    .collect(Collectors.toList());
// Resultado: [1, 4, 9, 16, 25, 36]

// 3. Reducir a suma
int suma = numbers.stream()
    .filter(n -> n > 0)
    .reduce(0, Integer::sum);
// Resultado: 21

// 4. Pipeline completo
int resultado = numbers.stream()
    .filter(n -> n > 0 && n % 2 == 0)  // positivos pares
    .map(n -> n * n)                    // al cuadrado
    .reduce(0, Integer::sum);           // sumar
// 4² + 6² = 16 + 36 = 52
```

<div class="callout info">
  <div class="callout-title">ℹ️ Evaluación Lazy</div>
  Las operaciones intermedias (<code>filter</code>, <code>map</code>) no hacen nada hasta que se llama una operación terminal. Esto permite optimizaciones como <strong>short-circuiting</strong>.
</div>

## Collectors Útiles

```java
List<String> result = stream.collect(Collectors.toList());
Set<String> result = stream.collect(Collectors.toSet());

// Agrupar
Map<Integer, List<String>> byLength = strings.stream()
    .collect(Collectors.groupingBy(String::length));

// Unir con separador
String joined = strings.stream()
    .collect(Collectors.joining(", "));

// Estadísticas
IntSummaryStatistics stats = numbers.stream()
    .mapToInt(Integer::intValue)
    .summaryStatistics();
// stats.getAverage(), stats.getMax(), etc.
```

## Parallel Streams

```java
// Solo cuando la colección es grande y operación es independiente
long suma = numeros.parallelStream()
    .filter(n -> n % 2 == 0)
    .mapToLong(Integer::longValue)
    .sum();
```

<div class="callout warning">
  <div class="callout-title">⚠️ Cuidado con parallelStream</div>
  No siempre es más rápido. Usar solo cuando:
  <ul>
    <li>La colección tiene miles+ de elementos</li>
    <li>La operación es CPU-intensiva</li>
    <li>No hay condiciones de carrera</li>
  </ul>
  Ver etapa 09 para comparativa de rendimiento.
</div>