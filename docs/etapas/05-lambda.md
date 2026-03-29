---
layout: default
title: "Etapa 05 — Expresiones lambda"
---

# Etapa 05 — Expresiones lambda

Las **expresiones lambda** reemplazan las clases anónimas con una sintaxis compacta. Son posibles gracias a que `ArithmeticCalculator` es una interfaz funcional (un solo método abstracto).

## Sintaxis

```
(parámetros) -> { cuerpo }
```

## Evolución de la sintaxis

```java
// Forma completa (equivalente a la clase anónima de la etapa 03)
OperationInvoker.invoke(6, 3, (int in1, int in2) -> {
    int result = in1 * in2;
    Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + result);
    return result;
});

// Forma concisa (tipos inferidos)
OperationInvoker.invoke(6, 3, (in1, in2) -> {
    Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + (in1 * in2));
    return in1 * in2;
});

// Lambda asignada a variable y reutilizada
ArithmeticCalculator sub = (in1, in2) -> {
    Printer.print(MessageType.MESSAGE, "Result (" + in1 + " - " + in2 + ") = " + (in1 - in2));
    return in1 - in2;
};
OperationInvoker.invoke(6, 3, sub);
OperationInvoker.invoke(6, 3, sub);
```

## Comparativa

| Característica | Clase concreta | Clase anónima | Lambda |
|----------------|---------------|---------------|--------|
| Líneas de código | ~8 | ~6 | 1-3 |
| Archivo separado | Sí | No | No |
| Reutilizable por nombre | Sí | No | Si se asigna a variable |
| Legibilidad | Alta | Media | Alta |

---

[← Invocador](04-invocador) · [Volver al inicio →](../)
