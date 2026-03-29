package poc.lambda;

import poc.util.Printer;
import poc.util.MessageType;

/**
 * Clase independiente (sin interfaz) que suma dos enteros e imprime el resultado.
 * Representa la etapa 01 del tutorial: clases sin interfaz común.
 *
 * @author cazucito
 */
public class AdderNoInterface {

    /**
     * Suma dos enteros, imprime el resultado y lo devuelve ( in1 + in2 ).
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la suma
     */
    public int add(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}
