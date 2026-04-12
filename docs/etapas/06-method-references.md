---
layout: tutorial
title: "Etapa 06 — Method References"
description: "Simplifica aún más el código con referencias a métodos: Class::method, instance::method y Class::new."
stage_number: 6
learning_objectives:
  - Usar las 4 formas de method references
  - Convertir lambdas a method references
  - Identificar cuándo aplicar cada forma
  - Comprender la equivalencia lambda ↔ method reference
---

Las **referencias a métodos** (Method References) son una forma más concisa de escribir lambdas cuando el cuerpo de la lambda solo llama a un método existente.

## Las 4 Formas de Method References

| Forma | Sintaxis | Cuándo usar |
|-------|----------|-------------|
| Estático | `Class::staticMethod` | Llama a un método estático |
| Instancia particular | `obj::instanceMethod` | Llama a método de objeto específico |
| Arbitraria | `Class::instanceMethod` | Llama a método de cualquier instancia |
| Constructor | `Class::new` | Crea nuevas instancias |

## 1. Referencia a Método Estático

```java
// Lambda
Function<String, Integer> parseInt = s -> Integer.parseInt(s);

// Method Reference
Function<String, Integer> parseInt = Integer::parseInt;

// Uso
Integer numero = parseInt.apply("42");  // 42
```

## 2. Referencia a Método de Instancia (Particular)

```java
String prefix = "Hello, ";

// Lambda
Consumer<String> greeter = name -> prefix.concat(name);

// Method Reference
Consumer<String> greeter = prefix::concat;

// Uso
greeter.accept("World");  // "Hello, World"
```

## 3. Referencia a Método de Instancia (Arbitraria)

```java
List<String> names = Arrays.asList("anna", "bob", "carlos");

// Lambda
names.sort((a, b) -> a.compareToIgnoreCase(b));

// Method Reference
names.sort(String::compareToIgnoreCase);
```

<div class="callout info">
  <div class="callout-title">ℹ️ Cómo funciona</div>
  <code>String::compareToIgnoreCase</code> es equivalente a <code>(a, b) -> a.compareToIgnoreCase(b)</code>. El primer parámetro se convierte en el objeto receptor del método.
</div>

## 4. Referencia a Constructor

```java
// Lambda
Supplier<List<String>> listFactory = () -> new ArrayList<>();

// Method Reference
Supplier<List<String>> listFactory = ArrayList::new;

// Uso
List<String> list = listFactory.get();
```

### Constructores parametrizados

```java
// Lambda
Function<String, Integer> creator = s -> new Integer(s);

// Method Reference
Function<String, Integer> creator = Integer::new;

// Arrays
IntFunction<int[]> arrayCreator = size -> new int[size];
IntFunction<int[]> arrayCreator = int[]::new;
```

## Tabla de Equivalencias

| Lambda | Method Reference |
|--------|------------------|
| `s -> Integer.parseInt(s)` | `Integer::parseInt` |
| `s -> System.out.println(s)` | `System.out::println` |
| `(a, b) -> a.compareTo(b)` | `String::compareTo` |
| `() -> new ArrayList<>()` | `ArrayList::new` |
| `x -> Math.abs(x)` | `Math::abs` |

## En Streams

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// map con method reference
List<Integer> lengths = names.stream()
    .map(String::length)           // x -> x.length()
    .collect(Collectors.toList());

// filter con method reference
List<String> nonEmpty = names.stream()
    .filter(String::isEmpty)       // x -> !x.isEmpty()
    .collect(Collectors.toList());

// forEach con method reference
names.forEach(System.out::println); // s -> System.out.println(s)
```

<div class="callout tip">
  <div class="callout-title">💡 Regla de oro</div>
  Si una lambda solo llama a un método existente, considera usar un method reference. Es más legible y expresa la intención claramente.
</div>

## Cuándo NO usar

```java
// ❌ No simplifica, es más confuso
Function<Integer, Integer> multiply = x -> x * 2;
// No hay method reference directo para esto

// ❌ Lambda con lógica adicional
list.stream()
    .map(s -> s.toUpperCase().trim())  // No se puede con ::
    .collect(Collectors.toList());
```