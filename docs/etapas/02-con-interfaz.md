---
layout: default
title: "Etapa 02 — Con interfaz funcional"
---

# Etapa 02 — Implementación de interfaz funcional

Se introduce la interfaz `ArithmeticCalculator`, un contrato común que todas las operaciones deben implementar.

## La interfaz

```java
@FunctionalInterface
public interface ArithmeticCalculator {
    int doOperation(int in1, int in2);
}
```

La anotación `@FunctionalInterface` garantiza que la interfaz tenga exactamente un método abstracto — prerequisito para usar lambdas más adelante.

## Implementaciones

```java
public class Adder implements ArithmeticCalculator {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}
```

## Uso con referencia genérica

```java
ArithmeticCalculator calc = new Adder();
calc.doOperation(6, 3);  // Result (6 + 3) = 9

calc = new Subtracter();
calc.doOperation(6, 3);  // Result (6 - 3) = 3
```

## Ventajas sobre la Etapa 01

- Un único método `doOperation` para todas las operaciones.
- La referencia `ArithmeticCalculator` puede apuntar a cualquier implementación.
- Preparación para polimorfismo y lambdas.

---

[← Sin interfaz](01-sin-interfaz) · [Siguiente: Clase anónima →](03-clase-anonima)
