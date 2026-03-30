# Ejercicio 01 — División segura

**Concepto:** interfaz funcional `ArithmeticCalculator` + lambda
**Dificultad:** ⭐

## Enunciado

El proyecto define la interfaz funcional `ArithmeticCalculator` con el método `int doOperation(int in1, int in2)`.

Hasta ahora solo hay clases para suma, resta y multiplicación. Tu tarea es:

1. Crear una clase `Divider` que implemente `ArithmeticCalculator` y calcule `in1 / in2`.
2. La clase debe imprimir el resultado igual que `Adder` y compañía.
3. Manejar la **división entre cero**: en lugar de lanzar excepción, devolver `0` e imprimir un mensaje de error.
4. Crear una **lambda equivalente** directamente en `main` (sin clase) y usarla con `OperationInvoker.invoke`.

## Código de partida

```java
package poc.lambda;

import poc.util.MessageType;
import poc.util.Printer;

/**
 * TODO: implementar división segura.
 */
public class Divider implements ArithmeticCalculator {

    @Override
    public int doOperation(int in1, int in2) {
        // TODO: dividir in1 / in2 con manejo de división entre cero
        return 0;
    }
}
```

## Pistas

- Usa `MessageType.LOGIC_ERROR` para el mensaje de error cuando `in2 == 0`.
- La lambda en `main` puede ser: `(a, b) -> b == 0 ? 0 : a / b`.
- Prueba con `OperationInvoker.invoke(6, 3, new Divider())` y `OperationInvoker.invoke(6, 0, new Divider())`.

## Criterio de aceptación

- `new Divider().doOperation(6, 3)` devuelve `2`.
- `new Divider().doOperation(6, 0)` devuelve `0` sin lanzar excepción.

---

[Ver solución](soluciones/01-division.md) · [← Ejercicios](README.md)
