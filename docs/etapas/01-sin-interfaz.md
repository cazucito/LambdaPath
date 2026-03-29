---
layout: default
title: "Etapa 01 — Sin interfaz"
---

# Etapa 01 — Clases independientes sin interfaz

En esta primera etapa, cada operación es una clase concreta independiente. No existe un contrato común entre ellas.

## Código

```java
public class AdderNoInterface {
    public int add(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}

public class SubtracterNoInterface {
    public int subtract(int in1, int in2) {
        int result = in1 - in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }
}
```

## Uso

```java
AdderNoInterface adder = new AdderNoInterface();
adder.add(6, 3);  // Result (6 + 3) = 9

SubtracterNoInterface subtracter = new SubtracterNoInterface();
subtracter.subtract(6, 3);  // Result (6 - 3) = 3
```

## Limitaciones

- Cada clase tiene su propio método con nombre distinto (`add`, `subtract`).
- No es posible referenciarlas de forma genérica.
- Agregar una nueva operación requiere crear una clase con un método con nombre nuevo.

---

[← Inicio](../) · [Siguiente: Con interfaz →](02-con-interfaz)
