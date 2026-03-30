---
layout: default
title: "Etapa 06 — Referencias a métodos"
---

# Etapa 06 — Referencias a métodos (Method References)

Las **referencias a métodos** son una forma más concisa de escribir una lambda cuando su único propósito es llamar a un método ya existente.

```
ClassName::methodName   // en lugar de   (args) -> ClassName.methodName(args)
```

## Los cuatro tipos

### 1. Referencia a método estático — `ClassName::staticMethod`

```java
// Lambda equivalente: (a, b) -> Integer.sum(a, b)
ArithmeticCalculator suma = Integer::sum;
suma.doOperation(6, 3);  // 9
```

### 2. Referencia a método de instancia ligada — `instance::method`

La instancia queda capturada en la referencia; no se pasa como argumento.

```java
Adder adder = new Adder();
// Lambda equivalente: (a, b) -> adder.doOperation(a, b)
ArithmeticCalculator ref = adder::doOperation;
ref.doOperation(6, 3);  // 9
```

### 3. Referencia a método de instancia no ligada — `ClassName::instanceMethod`

La instancia se suministra en el momento de la invocación (primer argumento).

```java
// La instancia se pasa al invocar
Subtracter sub = new Subtracter();
ArithmeticCalculator ref = sub::doOperation;
ref.doOperation(6, 3);  // 3
```

### 4. Referencia a constructor — `ClassName::new`

```java
// Lambda equivalente: () -> new Adder()
Supplier<Adder> factory = Adder::new;
Adder adder = factory.get();
adder.doOperation(6, 3);  // 9
```

## Comparativa

| Forma | Código |
|-------|--------|
| Lambda completa | `(a, b) -> Integer.sum(a, b)` |
| Referencia a método | `Integer::sum` |

---

[← Lambda](05-lambda) · [Siguiente: Streams →](07-streams)
