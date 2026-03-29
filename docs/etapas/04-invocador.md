---
layout: default
title: "Etapa 04 — Invocador con referencia genérica"
---

# Etapa 04 — Invocador con referencia genérica

Se introduce `OperationInvoker`, una clase que recibe la operación como **parámetro**. Esto desacopla quién decide la operación de quién la ejecuta.

## El invocador

```java
public class OperationInvoker {
    public static int invoke(int in1, int in2, ArithmeticCalculator operation) {
        return operation.doOperation(in1, in2);
    }
}
```

## Uso

```java
// Con clase concreta
ArithmeticCalculator suma = new Adder();
OperationInvoker.invoke(6, 3, suma);  // Result (6 + 3) = 9

// Con clase anónima inline
OperationInvoker.invoke(6, 3, new ArithmeticCalculator() {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 * in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + result);
        return result;
    }
});
```

## Patrón de diseño

Este es el patrón **Strategy**: el comportamiento (la operación) se encapsula y se pasa como argumento, permitiendo cambiar el algoritmo en tiempo de ejecución.

---

[← Clase anónima](03-clase-anonima) · [Siguiente: Lambda →](05-lambda)
