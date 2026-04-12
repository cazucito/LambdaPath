---
layout: tutorial
title: "Etapa 04 — Invocador"
description: "Aplica el patrón Strategy para pasar comportamiento como parámetro usando una interfaz funcional."
stage_number: 4
learning_objectives:
  - Comprender el patrón Strategy
  - Pasar comportamiento como parámetro
  - Desacoplar la lógica de ejecución
  - Preparar el terreno para lambdas
---

El **patrón Strategy** permite pasar **comportamiento como parámetro**. En lugar de que cada clase se ejecute a sí misma, delegamos la ejecución a un componente separado.

## El Invocador

```java
public class OperationInvoker {
    
    public static int invoke(int in1, int in2, 
                             ArithmeticCalculator calculator) {
        Printer.print(MessageType.INPUT, 
            "Inputs: in1=" + in1 + ", in2=" + in2);
        
        int result = calculator.doOperation(in1, in2);
        
        Printer.print(MessageType.OUTPUT, "Result: " + result);
        return result;
    }
}
```

## Uso con Clases Concretas

```java
// Crear estrategias
ArithmeticCalculator adder = new Adder();
ArithmeticCalculator multiplier = new Multiplyer();

// Ejecutar con diferentes estrategias
OperationInvoker.invoke(6, 3, adder);        // Suma
OperationInvoker.invoke(6, 3, multiplier);   // Multiplicación
```

## Uso con Clases Anónimas

```java
// Resta inline (sin crear archivo Subtracter.java)
OperationInvoker.invoke(6, 3, new ArithmeticCalculator() {
    @Override
    public int doOperation(int in1, int in2) {
        return in1 - in2;
    }
});

// Potencia inline
OperationInvoker.invoke(2, 3, new ArithmeticCalculator() {
    @Override
    public int doOperation(int base, int exp) {
        return (int) Math.pow(base, exp);
    }
});
```

## Beneficios del Patrón

<div class="callout info">
  <div class="callout-title">🎯 Ventajas del Invocador</div>
  <ul>
    <li><strong>Separación de responsabilidades:</strong> La operación define el "qué", el invocador el "cómo se ejecuta"</li>
    <li><strong>Reutilización:</strong> Lógica común (logging, validación) en un solo lugar</li>
    <li><strong>Flexibilidad:</strong> Nuevas operaciones sin modificar el invocador</li>
    <li><strong>Testabilidad:</strong> Fácil mockear el comportamiento</li>
  </ul>
</div>

## Aplicaciones Reales

```java
// Spring: TransactionTemplate
transactionTemplate.execute(status -> {
    // código transaccional
    return result;
});

// JUnit: Assertions
assertThrows(IllegalArgumentException.class, () -> {
    calculator.divide(1, 0);
});

// Java Streams: forEach
list.forEach(item -> {
    System.out.println(item);
});
```

## Punto Clave

El invocador no sabe (ni le importa) qué operación concreta recibe. Solo sabe que cumple con el contrato `ArithmeticCalculator`:

```
┌─────────────────┐         ┌──────────────────┐
│  Operation      │         │   Arithmetic     │
│  Invoker        │◄────────│   Calculator     │
│                 │  usa    │   (interfaz)     │
│ - invoke()      │         │   - doOperation()│
└─────────────────┘         └──────────────────┘
         │                           ↑
         │              ┌────────────┼────────────┐
         │              │            │            │
    ejecuta cualquiera de estas implementaciones:
    ┌────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐
    │ Adder  │  │Subtracter│  │Multiplyer│  │   ???    │
    │+doOp() │  │ +doOp()  │  │ +doOp()  │  │ +doOp()  │
    └────────┘  └──────────┘  └──────────┘  └──────────┘
```

<div class="callout tip">
  <div class="callout-title">💡 Hacia las Lambdas</div>
  Aunque estamos usando clases anónimas, el código sigue siendo verboso. La siguiente etapa muestra cómo las <strong>expresiones lambda</strong> simplifican drásticamente la sintaxis manteniendo la misma potencia.
</div>