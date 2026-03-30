package poc.lambda;

import poc.util.MessageType;
import poc.util.Printer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demostración de la Streams API de Java (etapa 07).
 *
 * <p>Un {@link java.util.stream.Stream} es una secuencia de elementos sobre la que se pueden
 * encadenar operaciones intermedias (perezosas) y una operación terminal (que dispara el cómputo).
 * Toda la tubería es evaluada de forma lazy.</p>
 *
 * @author cazucito
 */
public class StreamsDemo {

    /**
     * Filtra los números positivos de una lista y devuelve la sublista resultante.
     *
     * @param numbers lista de enteros de entrada
     * @return lista con solo los elementos mayores que cero
     */
    public static List<Integer> filterPositives(List<Integer> numbers) {
        List<Integer> result = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        Printer.print(MessageType.MESSAGE, "filter(n > 0) → " + result);
        return result;
    }

    /**
     * Duplica cada elemento de la lista mediante la operación {@code map}.
     *
     * @param numbers lista de enteros de entrada
     * @return lista con cada elemento multiplicado por dos
     */
    public static List<Integer> doubleAll(List<Integer> numbers) {
        List<Integer> result = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        Printer.print(MessageType.MESSAGE, "map(n * 2) → " + result);
        return result;
    }

    /**
     * Suma todos los elementos de la lista mediante la operación {@code reduce}.
     *
     * @param numbers lista de enteros de entrada
     * @return suma total de los elementos
     */
    public static int sumAll(List<Integer> numbers) {
        int result = numbers.stream()
                .reduce(0, Integer::sum);
        Printer.print(MessageType.MESSAGE, "reduce(Integer::sum) → " + result);
        return result;
    }

    /**
     * Encadena {@code filter} + {@code map} + {@code reduce} en una sola tubería.
     * Filtra positivos, los duplica y suma el resultado.
     *
     * @param numbers lista de enteros de entrada
     * @return suma de los positivos duplicados
     */
    public static int filterMapReduce(List<Integer> numbers) {
        int result = numbers.stream()
                .filter(n -> n > 0)
                .map(n -> n * 2)
                .reduce(0, Integer::sum);
        Printer.print(MessageType.MESSAGE,
                "filter + map + reduce sobre " + numbers + " → " + result);
        return result;
    }

    /**
     * Cuenta cuántos elementos de la lista son mayores que un umbral dado.
     *
     * @param numbers   lista de enteros
     * @param threshold umbral de comparación
     * @return cantidad de elementos mayores que {@code threshold}
     */
    public static long countGreaterThan(List<Integer> numbers, int threshold) {
        long count = numbers.stream()
                .filter(n -> n > threshold)
                .count();
        Printer.print(MessageType.MESSAGE,
                "count(n > " + threshold + ") en " + numbers + " → " + count);
        return count;
    }
}
