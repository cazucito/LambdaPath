package poc.lambda.es;

/**
 * Suma e imprime dos enteros
 *
 * @author cazucito
 */
public class SumadoraSinInterfaz {

   /**
     * Suma e imprime dos enteros ( in1 + in2 )
     * @param in1 parámetro 1
     * @param in2 parámetro 2
     */
    public void suma(int in1, int in2) {
        int resultado;
        resultado = in1 + in2;
        System.out.println("\tResultado (" + in1 + " + " + in2 + ") = " + resultado);
    }
}
