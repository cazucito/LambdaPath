package poc.lambda;

import poc.util.Impresor;
import poc.util.TipoMensajes;

/**
 * Main flow about a possible route from individual and unrelated classes to
 * lambda expressions
 *
 * @author cazucito
 */
public class LambdaPathMain {

    public static void main(String[] args) {
        Impresor.muestraEnConsola(TipoMensajes.ENCABEZADO, "LAMBDA PATH");
        int a = 6, b = 3;
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[00] Variable Values");
        Impresor.muestraEnConsola(TipoMensajes.INFO, "a = " + a + " | b = " + b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[01] No interface");
        AdderNoInterface adder = new AdderNoInterface();
        adder.add(a, b);
        SubtracterNoInterface subtracter = new SubtracterNoInterface();
        subtracter.subtract(a, b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[02] With interface");
        ArithmeticCalculator genericRef02 = new Adder();
        genericRef02.doOperation(a, b);
        ArithmeticCalculator genericRef022 = new Subtracter();
        genericRef022.doOperation(a, b);
        genericRef022 = new Multiplyer();
        genericRef022.doOperation(a, b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[03] With interface");
        ArithmeticCalculator genericRef03 = new ArithmeticCalculator() {
            @Override
            public void doOperation(int in1, int in2) {
                int result = 0;
                result = in1 * in2;
                Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " * " + in2 + ") = " + result);
            }

        };
        genericRef03.doOperation(a, b);
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[04] With interface and launcher");
        ArithmeticCalculator genericRef04 = new Adder();
        OperationInvoker.invoke(a, b, genericRef04);
        OperationInvoker.invoke(a, b, new Subtracter());
        OperationInvoker.invoke(a, b, new ArithmeticCalculator() {
            @Override
            public void doOperation(int in1, int in2) {
                int result = 0;
                result = in1 * in2;
                Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " * " + in2 + ") = " + result);
            }
        });
        //
        Impresor.muestraEnConsola(TipoMensajes.TITULO, "[05] With lambda expressions");
        OperationInvoker.invoke(a, b, (int in1, int in2) -> {
            int result = 0;
            result = in1 * in2;
            Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " * " + in2 + ") = " + result);
        });
        OperationInvoker.invoke(a, b, (in1, in2) -> Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " * " + in2 + ") = " + (in1 * in2)));
        ArithmeticCalculator sub = (in1, in2) -> Impresor.muestraEnConsola(TipoMensajes.MENSAJE, "Result (" + in1 + " - " + in2 + ") = " + (in1 - in2));
        OperationInvoker.invoke(a, b, sub);
        OperationInvoker.invoke(a, b, sub);
        Impresor.muestraEnConsola(TipoMensajes.PIE, "");
    }

}
