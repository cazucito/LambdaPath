package poc.lambda;

import poc.util.MessageType;
import poc.util.Printer;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Demostración de las interfaces funcionales estándar del paquete {@code java.util.function}
 * (etapa 08).
 *
 * <p>Java proporciona un conjunto de interfaces funcionales genéricas listas para usar.
 * Conocerlas evita crear interfaces propias innecesarias.</p>
 *
 * <ul>
 *   <li>{@link Predicate}&lt;T&gt; — {@code T → boolean}</li>
 *   <li>{@link Function}&lt;T,R&gt; — {@code T → R}</li>
 *   <li>{@link Consumer}&lt;T&gt; — {@code T → void}</li>
 *   <li>{@link Supplier}&lt;T&gt; — {@code () → T}</li>
 *   <li>{@link UnaryOperator}&lt;T&gt; — {@code T → T}</li>
 *   <li>{@link BinaryOperator}&lt;T&gt; — {@code (T,T) → T}</li>
 * </ul>
 *
 * @author cazucito
 */
public class FunctionalInterfacesDemo {

    /**
     * Prueba si un número entero es positivo usando un {@link Predicate}.
     *
     * @param number número a evaluar
     * @return {@code true} si el número es mayor que cero
     */
    public static boolean isPositive(int number) {
        // Predicate<T>: T → boolean
        Predicate<Integer> positive = n -> n > 0;
        boolean result = positive.test(number);
        Printer.print(MessageType.MESSAGE,
                "Predicate isPositive(" + number + ") → " + result);
        return result;
    }

    /**
     * Convierte un entero a su representación en cadena de texto usando una {@link Function}.
     *
     * @param number entero a convertir
     * @return cadena con el valor del número
     */
    public static String intToString(int number) {
        // Function<T,R>: T → R
        Function<Integer, String> toString = n -> "Número: " + n;
        String result = toString.apply(number);
        Printer.print(MessageType.MESSAGE,
                "Function intToString(" + number + ") → " + result);
        return result;
    }

    /**
     * Duplica un número entero usando un {@link UnaryOperator}.
     *
     * @param number número a duplicar
     * @return el doble del número recibido
     */
    public static int doubleIt(int number) {
        // UnaryOperator<T>: T → T (caso especial de Function donde T == R)
        UnaryOperator<Integer> doubler = n -> n * 2;
        int result = doubler.apply(number);
        Printer.print(MessageType.MESSAGE,
                "UnaryOperator doubleIt(" + number + ") → " + result);
        return result;
    }

    /**
     * Suma dos enteros usando un {@link BinaryOperator}.
     * Muestra cómo {@link BinaryOperator} es equivalente a la interfaz propia
     * {@link ArithmeticCalculator} del proyecto.
     *
     * @param in1 primer operando
     * @param in2 segundo operando
     * @return resultado de la suma
     */
    public static int sumWithBinaryOperator(int in1, int in2) {
        // BinaryOperator<T>: (T,T) → T — equivalente a ArithmeticCalculator del proyecto
        BinaryOperator<Integer> suma = Integer::sum;
        int result = suma.apply(in1, in2);
        Printer.print(MessageType.MESSAGE,
                "BinaryOperator Integer::sum (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }

    /**
     * Obtiene un valor constante usando un {@link Supplier}.
     *
     * @return el valor 42 (constante de demostración)
     */
    public static int getConstant() {
        // Supplier<T>: () → T
        Supplier<Integer> constant = () -> 42;
        int result = constant.get();
        Printer.print(MessageType.MESSAGE,
                "Supplier getConstant() → " + result);
        return result;
    }

    /**
     * Imprime un mensaje usando un {@link Consumer}.
     *
     * @param message mensaje a imprimir
     */
    public static void printWithConsumer(String message) {
        // Consumer<T>: T → void
        Consumer<String> printer = msg ->
                Printer.print(MessageType.MESSAGE, "Consumer: " + msg);
        printer.accept(message);
    }
}
