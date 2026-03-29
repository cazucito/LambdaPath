---
layout: default
title: "Etapa 03 — Clase anónima interna"
---

# Etapa 03 — Clase anónima interna

En lugar de crear una clase con nombre, se implementa la interfaz directamente en el punto de uso mediante una **clase anónima interna**.

## Código

```java
ArithmeticCalculator multiplicacion = new ArithmeticCalculator() {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 * in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + result);
        return result;
    }
};

multiplicacion.doOperation(6, 3);  // Result (6 * 3) = 18
```

## Ventajas

- No es necesario crear un archivo `.java` separado para una implementación de un solo uso.
- La lógica queda junto al punto de uso.

## Desventajas

- Sintaxis verbosa: 6 líneas para una operación simple.
- El compilador genera una clase interna anónima (`$1`, `$2`…) en el bytecode.

---

[← Con interfaz](02-con-interfaz) · [Siguiente: Invocador →](04-invocador)
