---
layout: default
title: "Etapa 09 — Comparación de rendimiento"
---

# Etapa 09 — Comparación de rendimiento

¿Los Streams son más lentos que un bucle `for`? La respuesta depende del contexto.

## El benchmark del proyecto

Operación: **suma de números pares** en una lista de 500 000 enteros.

```java
// Bucle for tradicional
long sum = 0;
for (int n : numbers) {
    if (n % 2 == 0) sum += n;
}

// Stream secuencial
long sum = numbers.stream()
        .filter(n -> n % 2 == 0)
        .mapToLong(Integer::longValue)
        .sum();

// Stream paralelo
long sum = numbers.parallelStream()
        .filter(n -> n % 2 == 0)
        .mapToLong(Integer::longValue)
        .sum();
```

## Resultados orientativos

| Enfoque | Tiempo aproximado |
|---------|------------------|
| Bucle `for` | ~5-15 ms |
| Stream secuencial | ~10-25 ms |
| Stream paralelo | ~3-8 ms (multi-núcleo) |

> Los tiempos varían según JVM, hardware y warmup. Para benchmarks rigurosos usa [JMH](https://github.com/openjdk/jmh).

## Cuándo usar cada uno

| Criterio | Recomendación |
|----------|--------------|
| Listas pequeñas (< 10 000 elementos) | Bucle o Stream — sin diferencia práctica |
| Listas grandes, operación costosa | `parallelStream()` |
| Legibilidad primero | Stream — más declarativo |
| Rendimiento crítico probado | Bucle `for` o `IntStream` primitivo |
| Operación con estado compartido | Evitar `parallelStream()` |

## Conclusión

La decisión entre bucle, stream y stream paralelo **no es de rendimiento sino de legibilidad y corrección**. Usa streams cuando mejoran la claridad del código; usa `parallelStream()` solo cuando hayas medido que hay un cuello de botella real.

---

[← Functional Interfaces](08-functional-interfaces) · [Volver al inicio →](../)
