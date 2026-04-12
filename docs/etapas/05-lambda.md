---
layout: tutorial
title: "Etapa 05 — Expresiones lambda"
description: "Aprende a usar expresiones lambda en Java para escribir código más conciso y funcional."
stage_number: 5
learning_objectives:
  - Comprender la sintaxis de expresiones lambda
  - Identificar cuándo se puede usar una lambda
  - Diferenciar entre lambdas con y sin tipos explícitos
  - Asignar lambdas a variables para reutilización
  - Comparar lambdas con clases anónimas
---

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

## Sintaxis abreviada

Cuando el cuerpo de la lambda es una sola expresión, puedes omitir las llaves y el `return`:

```java
// Lambda con una sola expresión (return implícito)
ArithmeticCalculator multiply = (a, b) -> a * b;

// Lambda sin parámetros (requiere paréntesis vacíos)
Runnable task = () -> System.out.println("Hello!");

// Lambda con un solo parámetro (puedes omitir paréntesis)
Consumer<String> printer = msg -> System.out.println(msg);
```

## Reglas de tipado

<div class="callout info">
  <div class="callout-title">ℹ️ Inferencia de tipos</div>
  El compilador Java puede inferir los tipos de los parámetros a partir del contexto. Si declaras los tipos explícitamente, debes hacerlo en <strong>todos</strong> los parámetros.
</div>

```java
// ✅ Correcto - tipos explícitos
(int a, int b) -> a + b

// ✅ Correcto - tipos inferidos
(a, b) -> a + b

// ❌ Incorrecto - mezcla no permitida
(int a, b) -> a + b
```

## Comparativa de enfoques

| Característica | Clase concreta | Clase anónima | Lambda |
|----------------|---------------|---------------|--------|
| Líneas de código | ~8 | ~6 | 1-3 |
| Archivo separado | Sí | No | No |
| Reutilizable por nombre | Sí | No | Sí (asignada a variable) |
| Legibilidad | Media | Media | **Alta** |
| Sobrecarga de clases | Sí (una por operación) | Sí (clase anónima) | **No** |

## Casos de uso comunes

### Callbacks y event handlers

```java
button.addActionListener(e -> {
    System.out.println("¡Botón presionado!");
});
```

### Operaciones de colecciones

```java
list.sort((a, b) -> a.length() - b.length());
```

### Threads

```java
new Thread(() -> {
    // Código del hilo
}).start();
```

<div class="callout tip">
  <div class="callout-title">💡 Tip</div>
  Las lambdas no son solo "azúcar sintáctica" — el compilador las optimiza diferente que las clases anónimas, generando bytecode más eficiente usando <code>invokedynamic</code>.
</div>