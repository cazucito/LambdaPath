package poc.lambda.es;

/**
 *
 * @author cazucito
 */
@FunctionalInterface
public interface CalculadoraAritmetica {

    /**
     * Modela una operación aritmética genérica con dos operandos
     *
     * @param in1 operando de entrada 1
     * @param in2 operando de entrada 2
     * @return resultado de la operación aritmética
     */
    int hazOperacion(int in1, int in2);
}
