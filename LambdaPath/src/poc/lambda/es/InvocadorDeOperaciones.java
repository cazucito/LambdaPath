package poc.lambda.es;

import poc.lambda.*;

/**
 * Clase invocadora, contiene un método de clase (static) que encapsula el
 * proceso de invocación
 *
 * @author cazucito
 */
public class InvocadorDeOperaciones {

    /**
     * Aplica la operación aritmética (tercer parámetro) a los parámetros in1 e
     * in2 mediante el llamado al método <code>hazOperacion</code> con la
     * referencia genérica operacion de tipo <code>CalculadoraAritmetica</code>
     *
     * <cite> in1 operacion in2 </cite>
     *
     * @param in1 operando 1
     * @param in2 operando 2
     * @param operacion Operación a realizar
     */
    public static void invoca(int in1, int in2, CalculadoraAritmetica operacion) {
        operacion.hazOperacion(in1, in2);
    }
}
