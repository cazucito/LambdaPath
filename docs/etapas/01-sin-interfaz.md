---
layout: tutorial
title: "Etapa 01 — Sin interfaz"
description: "Comienza con el diseño clásico de clases en Java: cada operación como clase concreta independiente sin contrato común."
stage_number: 1
learning_objectives:
  - Entender el problema de clases sin interfaz común
  - Identificar limitaciones del diseño clásico
  - Comprender por qué necesitamos un contrato
---

En esta primera etapa, cada operación es una **clase concreta independiente**. No existe un contrato común entre ellas.

## El Problema

Imagina que necesitas implementar operaciones aritméticas (suma, resta, multiplicación). El enfoque tradicional crea una clase por cada operación:

```java
public class AdderNoInterface {
    public int add(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}

public class SubtracterNoInterface {
    public int subtract(int in1, int in2) {
        int result = in1 - in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " - " + in2 + ") = " + result);
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

## ⚠️ Limitaciones Críticas

<div class="callout warning">
  <div class="callout-title">⚠️ Problemas de este enfoque</div>
  <ul>
    <li><strong>Métodos con nombres diferentes:</strong> Cada clase tiene su propio método (<code>add</code>, <code>subtract</code>)</li>
    <li><strong>Sin referencia genérica:</strong> No puedes tratarlas polimórficamente</li>
    <li><strong>Dificultad para extender:</strong> Agregar operaciones requiere nuevas clases con métodos únicos</li>
    <li><strong>Código duplicado:</strong> Lógica de impresión repetida en cada clase</li>
  </ul>
</div>

## ¿Qué necesitamos?

Un **contrato común** que defina: *"toda operación aritmética recibe dos enteros y devuelve un entero"*.

Este contrato es exactamente lo que proporciona una **interfaz funcional** — lo veremos en la siguiente etapa.

## Comparación Visual

```
Sin interfaz:                    Con interfaz (próxima etapa):
┌─────────────────┐              ┌──────────────────────┐
│ AdderNoInterface│              │  ArithmeticCalculator│ ← Contrato
│  - add()        │              │   - doOperation()    │
└─────────────────┘              └──────────────────────┘
┌─────────────────┐                        ↑
│SubtracterNoInt. │              ┌─────────┴─────────┐
│  - subtract()   │              │      Adder        │
└─────────────────┘              │  - doOperation()  │
                                 └───────────────────┘
                                 ┌───────────────────┐
                                 │    Subtracter     │
                                 │  - doOperation()  │
                                 └───────────────────┘
```

<div class="callout tip">
  <div class="callout-title">💡 Reflexión</div>
  Este enfoque sin interfaz era común en Java antes de Java 8. Aunque funciona, limita la flexibilidad y el polimorfismo. La siguiente etapa muestra cómo una interfaz funcional resuelve estos problemas.
</div>