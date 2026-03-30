---
layout: default
title: "Etapa 08 — Interfaces funcionales estándar"
---

# Etapa 08 — Interfaces funcionales estándar

Java incluye en `java.util.function` un conjunto de interfaces funcionales genéricas listas para usar. Conocerlas evita crear interfaces propias innecesarias.

## Las más importantes

| Interfaz | Firma | Descripción |
|----------|-------|-------------|
| `Predicate<T>` | `T → boolean` | Condición / filtro |
| `Function<T,R>` | `T → R` | Transformación |
| `Consumer<T>` | `T → void` | Efecto secundario |
| `Supplier<T>` | `() → T` | Proveedor de valor |
| `UnaryOperator<T>` | `T → T` | Transformación mismo tipo |
| `BinaryOperator<T>` | `(T,T) → T` | Combina dos valores del mismo tipo |
| `BiFunction<T,U,R>` | `(T,U) → R` | Transforma dos argumentos |

## Relación con el proyecto

`ArithmeticCalculator` es equivalente a `BinaryOperator<Integer>` / `IntBinaryOperator`:

```java
// Interfaz propia del proyecto
ArithmeticCalculator suma = (a, b) -> a + b;

// Interfaz estándar equivalente — misma lambda, diferente tipo
BinaryOperator<Integer> sumaEstandar = Integer::sum;
```

## Ejemplos

```java
// Predicate<T>: T → boolean
Predicate<Integer> esPositivo = n -> n > 0;
esPositivo.test(5);   // true
esPositivo.test(-1);  // false

// Function<T,R>: T → R
Function<Integer, String> aTexto = n -> "Número: " + n;
aTexto.apply(42);   // "Número: 42"

// UnaryOperator<T>: T → T
UnaryOperator<Integer> doble = n -> n * 2;
doble.apply(6);   // 12

// BinaryOperator<T>: (T,T) → T
BinaryOperator<Integer> suma = Integer::sum;
suma.apply(6, 3);  // 9

// Supplier<T>: () → T
Supplier<Integer> constante = () -> 42;
constante.get();  // 42

// Consumer<T>: T → void
Consumer<String> imprimir = msg -> System.out.println(msg);
imprimir.accept("Hola");
```

## Composición de interfaces

Las interfaces funcionales estándar incluyen métodos `default` para componer operaciones:

```java
Predicate<Integer> esPositivo = n -> n > 0;
Predicate<Integer> esPar      = n -> n % 2 == 0;

// Composición: positivo Y par
Predicate<Integer> positivoPar = esPositivo.and(esPar);
positivoPar.test(4);   // true
positivoPar.test(-4);  // false

// Composición: función encadenada
Function<Integer, Integer> triplicar = n -> n * 3;
Function<Integer, String>  aTexto    = n -> "val=" + n;
Function<Integer, String>  pipeline  = triplicar.andThen(aTexto);
pipeline.apply(4);  // "val=12"
```

---

[← Streams](07-streams) · [Siguiente: Rendimiento →](09-rendimiento)
