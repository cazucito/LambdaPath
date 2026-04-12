---
layout: tutorial
title: "Etapa 02 — Con interfaz"
description: "Introduce el concepto de interfaz funcional (@FunctionalInterface) para definir un contrato común entre operaciones."
stage_number: 2
learning_objectives:
  - Comprender qué es una interfaz funcional
  - Usar @FunctionalInterface correctamente
  - Implementar múltiples clases con el mismo contrato
  - Entender el beneficio del polimorfismo
---

Una **interfaz funcional** es una interfaz con **exactamente un método abstracto**. Define un contrato que múltiples clases pueden implementar.

## Definiendo el Contrato

```java
@FunctionalInterface
public interface ArithmeticCalculator {
    int doOperation(int in1, int in2);
}
```

La anotación `@FunctionalInterface` es opcional pero **recomendada**: el compilador verificará que solo haya un método abstracto.

## Implementando el Contrato

Ahora todas las operaciones implementan la misma interfaz:

```java
public class Adder implements ArithmeticCalculator {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}

public class Subtracter implements ArithmeticCalculator {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 - in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }
}

public class Multiplyer implements ArithmeticCalculator {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 * in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " * " + in2 + ") = " + result);
        return result;
    }
}
```

## Uso Polimórfico

```java
// Ahora podemos usar polimorfismo
ArithmeticCalculator adder = new Adder();
ArithmeticCalculator subtracter = new Subtracter();

adder.doOperation(6, 3);       // Result (6 + 3) = 9
subtracter.doOperation(6, 3);  // Result (6 - 3) = 3
```

## Beneficios del Enfoque

| Aspecto | Sin Interfaz | Con Interfaz |
|---------|-------------|--------------|
| Contrato | ❌ No existe | ✅ Definido |
| Polimorfismo | ❌ Imposible | ✅ Total |
| Extensibilidad | ❌ Difícil | ✅ Fácil |
| Método uniforme | ❌ Varios nombres | ✅ `doOperation` |

<div class="callout info">
  <div class="callout-title">ℹ️ ¿Por qué "Funcional"?</div>
  Una interfaz funcional puede tratarse como una función (comportamiento) porque tiene un solo método. Esto es fundamental para lambdas — lo veremos en etapas posteriores.
</div>

## Preparando el Terreno

Aunque hemos mejorado el diseño, aún necesitamos:
1. **Crear una clase** para cada operación (archivo .java)
2. **Compilar y mantener** múltiples archivos

La siguiente etapa muestra cómo las **clases anónimas** eliminan la necesidad de archivos separados.