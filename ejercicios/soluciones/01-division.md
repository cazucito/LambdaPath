# Solución — Ejercicio 01: División segura

## Clase Divider

```java
package poc.lambda;

import poc.util.MessageType;
import poc.util.Printer;

/**
 * Implementación de ArithmeticCalculator que divide dos enteros con manejo
 * de división entre cero.
 */
public class Divider implements ArithmeticCalculator {

    @Override
    public int doOperation(int in1, int in2) {
        if (in2 == 0) {
            Printer.print(MessageType.LOGIC_ERROR, "División entre cero: " + in1 + " / 0");
            return 0;
        }
        int result = in1 / in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " / " + in2 + ") = " + result);
        return result;
    }
}
```

## Lambda equivalente en main

```java
// Lambda con manejo de división entre cero
ArithmeticCalculator divisionSegura = (a, b) -> b == 0 ? 0 : a / b;

OperationInvoker.invoke(6, 3, divisionSegura);  // Result (6 / 3) = 2
OperationInvoker.invoke(6, 0, divisionSegura);  // devuelve 0 silenciosamente
OperationInvoker.invoke(6, 0, new Divider());   // imprime mensaje de error
```

## Puntos clave

- La lambda ternaria `b == 0 ? 0 : a / b` es concisa pero no imprime el error.
- La clase `Divider` es más completa: imprime el mensaje de error apropiado.
- Ambas cumplen el contrato de devolver `0` ante división entre cero.
