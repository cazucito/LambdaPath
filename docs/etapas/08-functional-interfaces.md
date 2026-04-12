---
layout: tutorial
title: "Etapa 08 — Functional Interfaces"
description: "Domina las interfaces funcionales estándar de Java: Predicate, Function, Consumer, Supplier y más."
stage_number: 8
learning_objectives:
  - Usar Predicate para filtros
  - Aplicar Function para transformaciones
  - Emplear Consumer para efectos secundarios
  - Utilizar Supplier para generación
  - Combinar interfaces funcionales
---

Java 8 incluye interfaces funcionales estándar en `java.util.function`. Conocerlas evita reinventar la rueda.

## Las 4 Interfaces Fundamentales

### 1. Predicate<T> — Prueba una condición

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

// Uso
Predicate<Integer> isPositive = n -> n > 0;
Predicate<String> isLong = s -> s.length() > 5;

// En Streams
list.stream()
    .filter(isPositive)
    .collect(Collectors.toList());
```

**Métodos de combinación:**
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
Predicate<Integer> isPositive = n -> n > 0;

// AND lógico
Predicate<Integer> isPositiveEven = isPositive.and(isEven);

// OR lógico  
Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);

// Negación
Predicate<Integer> isNotPositive = isPositive.negate();
```

### 2. Function<T, R> — Transforma T en R

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

// Uso
Function<String, Integer> length = String::length;
Function<Integer, String> toString = String::valueOf;

// Composición
Function<String, String> trimAndUpper = 
    ((Function<String, String>) String::trim)
        .andThen(String::toUpperCase);
```

### 3. Consumer<T> — Realiza una acción

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

// Uso
Consumer<String> print = System.out::println;
Consumer<String> log = s -> Logger.info(s);

// Composición
Consumer<String> printAndLog = print.andThen(log);
```

### 4. Supplier<T> — Proporciona un valor

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}

// Uso
Supplier<LocalDateTime> now = LocalDateTime::now;
Supplier<List<String>> listFactory = ArrayList::new;
Supplier<Double> random = Math::random;

// En Optional
String value = optional.orElseGet(() -> "default");
```

## Variantes Primitivas

Evitan autoboxing (mejor rendimiento):

| Objeto | Primitivo |
|--------|-----------|
| `Predicate<T>` | `IntPredicate`, `LongPredicate`, `DoublePredicate` |
| `Function<T, R>` | `IntFunction<R>`, `ToIntFunction<T>` |
| `Consumer<T>` | `IntConsumer`, `LongConsumer` |
| `Supplier<T>` | `IntSupplier`, `BooleanSupplier` |

```java
// Con autoboxing (menos eficiente)
Function<Integer, Integer> square = x -> x * x;

// Sin autoboxing (más eficiente)
IntUnaryOperator square = x -> x * x;

// En streams
IntStream.range(1, 100)
    .filter(x -> x % 2 == 0)  // IntPredicate
    .map(x -> x * x)          // IntUnaryOperator
    .sum();                   // IntStream sum
```

## Otras Interfaces Útiles

### UnaryOperator<T> — T → T

```java
// Cuando entrada y salida son del mismo tipo
UnaryOperator<String> trim = String::trim;
UnaryOperator<Integer> doubleIt = x -> x * 2;
```

### BinaryOperator<T> — (T, T) → T

```java
// Para reducciones del mismo tipo
BinaryOperator<Integer> sum = Integer::sum;
BinaryOperator<String> concat = String::concat;

int total = numbers.stream()
    .reduce(0, Integer::sum);  // BinaryOperator
```

### BiFunction<T, U, R> — (T, U) → R

```java
BiFunction<String, Integer, String> repeat = 
    (s, n) -> s.repeat(n);

// Map.merge usa BiFunction
map.merge(key, 1, Integer::sum);
```

## Cuadro de Referencia Rápida

```
┌──────────────────┬─────────────────┬─────────────────────────────┐
│ Interface        │ Método          │ Uso típico                  │
├──────────────────┼─────────────────┼─────────────────────────────┤
│ Predicate<T>     │ test(T) → bool  │ filter(), anyMatch()        │
│ Function<T,R>    │ apply(T) → R    │ map(), transformaciones     │
│ Consumer<T>      │ accept(T) → void│ forEach(), side effects     │
│ Supplier<T>      │ get() → T       │ factory, lazy init          │
│ UnaryOperator<T> │ apply(T) → T    │ modificaciones in-place     │
│ BinaryOperator<T>│ apply(T,T) → T  │ reduce(), combinaciones     │
└──────────────────┴─────────────────┴─────────────────────────────┘
```

<div class="callout tip">
  <div class="callout-title">💡 Mejor práctica</div>
  Prefiere las interfaces del paquete <code>java.util.function</code> antes de crear tus propias interfaces funcionales. Son universales, optimizadas y todos los desarrolladores Java las reconocen.
</div>