---
layout: tutorial
title: "Etapa 03 — Clase anónima"
description: "Usa clases anónimas para implementar interfaces funcionales sin crear archivos .java separados."
stage_number: 3
learning_objectives:
  - Crear clases anónimas inline
  - Comparar con clases nombradas
  - Entender cuándo usar cada enfoque
  - Identificar limitaciones de las clases anónimas
---

Una **clase anónima** es una clase sin nombre que se define e instancia en una sola expresión. Permite implementar una interfaz **sin crear un archivo .java separado**.

## Sintaxis de Clase Anónima

```java
InterfaceType objeto = new InterfaceType() {
    @Override
    public ReturnType metodo() {
        // implementación
    }
};
```

## Implementación Anónima

```java
// Suma como clase anónima
ArithmeticCalculator adder = new ArithmeticCalculator() {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
};

// Resta como clase anónima
ArithmeticCalculator subtracter = new ArithmeticCalculator() {
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 - in2;
        Printer.print(MessageType.MESSAGE, 
            "Result (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }
};

// Uso
adder.doOperation(6, 3);       // Result (6 + 3) = 9
subtracter.doOperation(6, 3);  // Result (6 - 3) = 3
```

## Comparativa: Nombrada vs Anónima

| Característica | Clase Nombrada | Clase Anónima |
|----------------|----------------|---------------|
| Archivo separado | ✅ Sí | ❌ No |
| Reutilizable | ✅ Varios lugares | ⚠️ Solo en scope actual |
| Legibilidad | ✅ Alta | ⚠️ Media (verbosa) |
| Uso único | ❌ Overhead | ✅ Ideal |
| Testing | ✅ Fácil | ⚠️ Más difícil |

<div class="callout tip">
  <div class="callout-title">💡 Cuándo usar cada una</div>
  <ul>
    <li><strong>Clase nombrada:</strong> Cuando la lógica se reutiliza en múltiples lugares o requiere testing unitario</li>
    <li><strong>Clase anónima:</strong> Para implementaciones de un solo uso, configuración, o callbacks</li>
  </ul>
</div>

## ¿Dónde se Usan?

Las clases anónimas son comunes en:

```java
// Listeners en GUIs (Swing, Android)
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("¡Clic!");
    }
});

// Threads simples
new Thread(new Runnable() {
    @Override
    public void run() {
        // Código del hilo
    }
}).start();

// Comparadores inline
Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
});
```

## Limitaciones

<div class="callout warning">
  <div class="callout-title">⚠️ Verbosidad</div>
  Las clases anónimas eliminan archivos separados, pero el código sigue siendo verboso. Cada implementación requiere ~6 líneas de "boilerplate". La siguiente etapa mostrará cómo las <strong>lambdas</strong> reducen esto a 1-3 líneas.
</div>

## Evolución Visual

```
Clase Nombrada:              Clase Anónima:
┌─────────────┐              ┌────────────────────────┐
│  Adder.java │              │ ArithmeticCalculator   │
│  class      │              │   adder = new ...() {  │
│  Adder      │              │   @Override            │
│  +add()     │              │   int doOperation(...) │
└─────────────┘              │ };                     │
                             └────────────────────────┘
        ↓                              ↓
   1 archivo                    Inline, sin archivo
   Reutilizable                 Scope local
```