package poc.lambda.es;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Flujo principal de una posible ruta desde clases individuales hasta 
 * expresiones lambda
 *
 * @author cazucito
 */
public class RutaLambdaMain {

    public static void main(String[] args) {
    	Impresor.muestraEnConsola(TipoMensajes.ENCABEZADO, "RUTA LAMBDA");
        int a = 6, b = 3;
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[00] Valores De Variables");
        Impresor.muestraEnConsola(TipoMensajes.INFO, "a = " + a + " | b = " + b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[01] Sin Interfaz");
        SumadoraSinInterfaz sumadora = new SumadoraSinInterfaz();
        sumadora.suma(a, b);
        RestadoraSinInterfaz restadora = new RestadoraSinInterfaz();
        restadora.resta(a, b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[02] Con Interfaz");
        CalculadoraAritmetica refGeneric02 = new Sumadora();
        refGeneric02.hazOperacion(a, b);
        CalculadoraAritmetica refGeneric022 = new Restadora();
        refGeneric022.hazOperacion(a, b);
        refGeneric022 = new Multiplicadora();
        refGeneric022.hazOperacion(a, b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[03] Con Clases Internas");
        CalculadoraAritmetica refGenerica03 = new CalculadoraAritmetica() {
            @Override
            public void hazOperacion(int in1, int in2) {
                int resultado;
                resultado = in1 * in2;
                Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " * " + in2 + ") = " + resultado);
            }

        };
        refGenerica03.hazOperacion(a, b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[04] Con Interfaz Y Lanzador");
        CalculadoraAritmetica refGEnerica04 = new Sumadora();
        InvocadorDeOperaciones.invoca(a, b, refGEnerica04);
        InvocadorDeOperaciones.invoca(a, b, new Restadora());
        InvocadorDeOperaciones.invoca(a, b, new CalculadoraAritmetica() {
            @Override
            public void hazOperacion(int in1, int in2) {
                int resultado;
                resultado = in1 * in2;
                Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " * " + in2 + ") = " + resultado);
            }
        });
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[05] Con Expresiones Lambda");
        InvocadorDeOperaciones.invoca(a, b, (int in1, int in2) -> {
            int resultado = 0;
            resultado = in1 * in2;
            Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " * " + in2 + ") = " + resultado);
        });
        InvocadorDeOperaciones.invoca(a, b, (in1, in2) -> Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " * " + in2 + ") = " + (in1 * in2)));
        CalculadoraAritmetica resta = (in1, in2) -> Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Resultado (" + in1 + " - " + in2 + ") = " + (in1 - in2));
        InvocadorDeOperaciones.invoca(a, b, resta);
        InvocadorDeOperaciones.invoca(a, b, resta);
        Impresor.muestraEnConsola(TipoMensajes.PIE, "");
    }
}