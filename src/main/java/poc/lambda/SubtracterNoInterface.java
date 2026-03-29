package poc.lambda;

import poc.util.Printer;
import poc.util.MessageType;

/**
 * Clase independiente (sin interfaz) que resta dos enteros e imprime el resultado.
 * Representa la etapa 01 del tutorial: clases sin interfaz común.
 *
 * @author cazucito
 */
public class SubtracterNoInterface {

    /**
     * Resta dos enteros, imprime el resultado y lo devuelve ( in1 - in2 ).
     *
     * @param in1 primer operando (minuendo)
     * @param in2 segundo operando (sustraendo)
     * @return resultado de la resta
     */
    public int subtract(int in1, int in2) {
        int result = in1 - in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }
}
