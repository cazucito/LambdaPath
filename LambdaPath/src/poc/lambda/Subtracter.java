package poc.lambda;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Substrac and print a int from another
 *
 * @author cazucito
 */
public class Subtracter implements ArithmeticCalculator {
   /**
     * Subtract and print two ints ( in1 - in2 )
     * @param in1 param 1
     * @param in2 param 2
     */
    @Override
    public void doOperation(int in1, int in2) {
        int result = 0;
        result = in1 - in2;
        Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " - " + in2 + ") = " + result);
    }
}
