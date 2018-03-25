package poc.lambda.es;

/**
 * Resta e imprime un entero de otro
 *
 * @author cazucito
 */
public class Restadora implements CalculadoraAritmetica {
   /**
     * Resta e imprime dos enteros ( in1 - in2 )
     * @param in1 parámetro 1
     * @param in2 parámetro 2
     */
    @Override
    public void hazOperacion(int in1, int in2) {
        int resultado;
        resultado = in1 - in2;
        System.out.println("\tResultado (" + in1 + " - " + in2 + ") = " + resultado);
    }
}
