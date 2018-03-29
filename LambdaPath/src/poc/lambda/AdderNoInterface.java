package poc.lambda;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Add and print two ints
 *
 * @author cazucito
 */
public class AdderNoInterface {

   /**
     * Add and print two ints ( in1 + in2 )
     * @param in1 param 1
     * @param in2 param 2
     */
    public void add(int in1, int in2) {
        int result = 0;
        result = in1 + in2;
        Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " + " + in2 + ") = " + result);
    }
}
