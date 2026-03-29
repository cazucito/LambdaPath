package poc.lambda;

/**
 * Interfaz funcional que modela una operación aritmética genérica con dos operandos.
 *
 * @author cazucito
 */
@FunctionalInterface
public interface ArithmeticCalculator {

    /**
     * Ejecuta una operación aritmética genérica con dos operandos enteros.
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la operación aritmética
     */
    int doOperation(int in1, int in2);
}
