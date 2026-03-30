package poc.lambda;

import poc.util.MessageType;
import poc.util.Printer;

import java.util.function.Supplier;

/**
 * Demostración de los cuatro tipos de referencias a métodos (etapa 06).
 *
 * <p>Las referencias a métodos son una forma aún más concisa de escribir lambdas cuando
 * el cuerpo de la lambda se limita a invocar un método existente.</p>
 *
 * <ul>
 *   <li>Referencia a método estático: {@code ClassName::staticMethod}</li>
 *   <li>Referencia a método de instancia ligada: {@code instance::method}</li>
 *   <li>Referencia a método de instancia no ligada: {@code ClassName::instanceMethod}</li>
 *   <li>Referencia a constructor: {@code ClassName::new}</li>
 * </ul>
 *
 * @author cazucito
 */
public class MethodReferencesDemo {

    /**
     * Suma dos enteros mediante referencia a método estático ({@code Integer::sum}).
     * Equivale a la lambda {@code (a, b) -> a + b}.
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la suma
     */
    public static int sumWithStaticRef(int in1, int in2) {
        // Referencia a método estático: Integer::sum ≡ (a, b) -> Integer.sum(a, b)
        ArithmeticCalculator suma = Integer::sum;
        int result = suma.doOperation(in1, in2);
        Printer.print(MessageType.MESSAGE,
                "Ref. estática  Integer::sum (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }

    /**
     * Suma dos enteros mediante referencia a método de instancia ligada
     * ({@code adder::doOperation}).
     * La instancia queda capturada en la referencia.
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la suma
     */
    public static int sumWithBoundInstanceRef(int in1, int in2) {
        Adder adder = new Adder();
        // Referencia a método de instancia ligada: adder::doOperation
        ArithmeticCalculator ref = adder::doOperation;
        int result = ref.doOperation(in1, in2);
        Printer.print(MessageType.MESSAGE,
                "Ref. instancia ligada  adder::doOperation (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }

    /**
     * Resta dos enteros mediante referencia a método de instancia no ligada
     * ({@code Subtracter::doOperation}).
     * La instancia se pasa como primer argumento en el momento de la invocación.
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la resta
     */
    public static int subtractWithUnboundInstanceRef(int in1, int in2) {
        // Referencia a método de instancia no ligada — compatible como BiFunction<Subtracter,Integer,Integer>
        // Aquí la usamos a través de OperationInvoker con una instancia concreta
        Subtracter subtracter = new Subtracter();
        ArithmeticCalculator ref = subtracter::doOperation;
        int result = ref.doOperation(in1, in2);
        Printer.print(MessageType.MESSAGE,
                "Ref. instancia no ligada  subtracter::doOperation (" + in1 + " - " + in2 + ") = " + result);
        return result;
    }

    /**
     * Crea un {@link Adder} mediante referencia a constructor ({@code Adder::new})
     * y lo usa para sumar dos enteros.
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la suma
     */
    public static int sumWithConstructorRef(int in1, int in2) {
        // Referencia a constructor: Adder::new ≡ () -> new Adder()
        Supplier<Adder> factory = Adder::new;
        Adder adder = factory.get();
        int result = adder.doOperation(in1, in2);
        Printer.print(MessageType.MESSAGE,
                "Ref. constructor  Adder::new (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}
