---
layout: default
title: "Etapa 07 — Streams API"
---

# Etapa 07 — Streams API

Un **Stream** es una secuencia de elementos sobre la que se encadenan operaciones funcionales. La evaluación es **lazy**: nada se procesa hasta que se llega a la operación terminal.

```
Fuente → operaciones intermedias (lazy) → operación terminal (dispara el cómputo)
```

## Operaciones intermedias (devuelven Stream)

| Operación | Qué hace |
|-----------|----------|
| `filter(Predicate)` | Descarta elementos que no cumplen la condición |
| `map(Function)` | Transforma cada elemento |
| `sorted()` | Ordena los elementos |
| `distinct()` | Elimina duplicados |
| `limit(n)` | Toma los primeros n elementos |

## Operaciones terminales (cierran el Stream)

| Operación | Qué devuelve |
|-----------|-------------|
| `collect(Collector)` | Lista, Set, Map… |
| `reduce(identity, BinaryOperator)` | Un solo valor acumulado |
| `count()` | Número de elementos |
| `forEach(Consumer)` | void — efecto secundario |
| `sum()` / `average()` | En streams primitivos |

## Ejemplos del proyecto

```java
List<Integer> numbers = List.of(-3, -1, 0, 1, 2, 3, 4, 5, 6);

// Filtrar positivos
List<Integer> positivos = numbers.stream()
        .filter(n -> n > 0)
        .collect(Collectors.toList());
// → [1, 2, 3, 4, 5, 6]

// Duplicar elementos
List<Integer> dobles = numbers.stream()
        .map(n -> n * 2)
        .collect(Collectors.toList());

// Suma total
int suma = numbers.stream()
        .reduce(0, Integer::sum);
// → 17

// Tubería completa: filtrar + duplicar + sumar
int resultado = numbers.stream()
        .filter(n -> n > 0)
        .map(n -> n * 2)
        .reduce(0, Integer::sum);
// positivos: 1+2+3+4+5+6=21 → duplicados: 42
```

## Stream paralelo

Cuando la colección es grande y la operación es independiente por elemento, se puede paralelizar con una sola palabra:

```java
long suma = numeros.parallelStream()   // ← solo cambia esto
        .filter(n -> n % 2 == 0)
        .mapToLong(Integer::longValue)
        .sum();
```

---

[← Method References](06-method-references) · [Siguiente: Functional Interfaces →](08-functional-interfaces)
