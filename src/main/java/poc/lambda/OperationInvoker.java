package poc.lambda;

/**
 * Clase invocadora que encapsula el proceso de invocación de una operación aritmética.
 * Recibe la operación como parámetro, habilitando el uso de lambdas (etapa 04 y 05).
 *
 * @author cazucito
 */
public class OperationInvoker {

    /**
     * Invoca la operación aritmética indicada sobre los dos operandos enteros.
     * Delega en {@link ArithmeticCalculator#doOperation(int, int)}.
     *
     * @param in1       primer operando
     * @param in2       segundo operando
     * @param operation implementación de la operación (clase, clase anónima o lambda)
     * @return resultado de la operación
     */
    public static int invoke(int in1, int in2, ArithmeticCalculator operation){
        return operation.doOperation(in1, in2);
    }
}
