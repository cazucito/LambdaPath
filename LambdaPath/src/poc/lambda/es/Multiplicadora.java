package poc.lambda.es;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Multiplica e imprime dos enteros
 *
 * @author cazucito
 */
public class Multiplicadora implements CalculadoraAritmetica {

    /**
     * Multiplica e imprime dos enteros ( in1 * in2 )
     *
     * @param in1 parámetro 1
     * @param in2 parámetro 2
     */
    @Override
    public void hazOperacion(int in1, int in2) {
        int resultado;
        resultado = in1 * in2;
        Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " * " + in2 + ") = " + resultado);
    }
}
