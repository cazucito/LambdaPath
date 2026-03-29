package poc.lambda;

import poc.util.Printer;
import poc.util.MessageType;

/**
 * Implementación de {@link ArithmeticCalculator} que resta dos enteros e imprime el resultado.
 *
 * @author cazucito
 */
public class Subtracter implements ArithmeticCalculator {

    /**
     * Resta dos enteros, imprime el resultado y lo devuelve ( in1 - in2 ).
     *
     * @param in1 primer operando (minuendo)
     * @param in2 segundo operando (sustraendo)
     * @return resultado de la resta
     */
    @Override
    public int doOperation(int in1, int in2) {
        int result = in1 - in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }
}
