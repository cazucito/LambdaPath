package poc.lambda;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Substrac and print a int from another
 *
 * @author cazucito
 */
public class SubtracterNoInterface {

    /**
     * Subtract and print two ints ( in1 - in2 )
     *
     * @param in1 param 1
     * @param in2 param 2
     */
    public int subtract(int in1, int in2) {
        int result = in1 - in2;
        Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }
}
