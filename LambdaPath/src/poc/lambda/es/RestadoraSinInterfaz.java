package poc.lambda.es;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Resta e imprime un entero de otro
 *
 * @author cazucito
 */
public class RestadoraSinInterfaz {

    /**
     * REsta e imprime dos enteros ( in1 - in2 )
     *
     * @param in1 parámetro 1
     * @param in2 parámetro 2
     */
    public void resta(int in1, int in2) {
        int resultado;
        resultado = in1 - in2;
        Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " - " + in2 + ") = " + resultado);
    }
}
