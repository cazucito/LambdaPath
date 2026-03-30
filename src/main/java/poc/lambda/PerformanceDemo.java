package poc.lambda;

import poc.util.MessageType;
import poc.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Comparación de rendimiento entre bucle tradicional, Stream secuencial y Stream paralelo
 * para una operación de filtrado y suma (etapa 09).
 *
 * <p><strong>Nota:</strong> los tiempos obtenidos en una sola ejecución son orientativos.
 * Para benchmarks rigurosos se recomienda JMH (Java Microbenchmark Harness).</p>
 *
 * @author cazucito
 */
public class PerformanceDemo {

    /** Tamaño de la lista usada en todos los benchmarks. */
    static final int LIST_SIZE = 500_000;

    /**
     * Genera la lista de enteros del 1 al {@link #LIST_SIZE} usada en los benchmarks.
     *
     * @return lista inmutable de enteros consecutivos
     */
    public static List<Integer> buildList() {
        return IntStream.rangeClosed(1, LIST_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Suma los números pares de la lista usando un bucle {@code for} tradicional.
     *
     * @param numbers lista de entrada
     * @return suma de los elementos pares
     */
    public static long sumEvensLoop(List<Integer> numbers) {
        long start = System.nanoTime();
        long sum = 0;
        for (int n : numbers) {
            if (n % 2 == 0) {
                sum += n;
            }
        }
        long elapsed = System.nanoTime() - start;
        Printer.print(MessageType.INFO,
                String.format("Bucle for     → suma=%d  tiempo=%d ms", sum, elapsed / 1_000_000));
        return sum;
    }

    /**
     * Suma los números pares de la lista usando un Stream secuencial.
     *
     * @param numbers lista de entrada
     * @return suma de los elementos pares
     */
    public static long sumEvensStream(List<Integer> numbers) {
        long start = System.nanoTime();
        long sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long elapsed = System.nanoTime() - start;
        Printer.print(MessageType.INFO,
                String.format("Stream        → suma=%d  tiempo=%d ms", sum, elapsed / 1_000_000));
        return sum;
    }

    /**
     * Suma los números pares de la lista usando un Stream paralelo.
     * Aprovecha los núcleos disponibles del procesador.
     *
     * @param numbers lista de entrada
     * @return suma de los elementos pares
     */
    public static long sumEvensParallelStream(List<Integer> numbers) {
        long start = System.nanoTime();
        long sum = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long elapsed = System.nanoTime() - start;
        Printer.print(MessageType.INFO,
                String.format("ParallelStream → suma=%d  tiempo=%d ms", sum, elapsed / 1_000_000));
        return sum;
    }

    /**
     * Ejecuta los tres benchmarks en secuencia e imprime los resultados comparativos.
     */
    public static void runAll() {
        Printer.print(MessageType.SUBTITLE,
                "Benchmark — suma de pares en lista de " + LIST_SIZE + " elementos");
        List<Integer> numbers = buildList();
        sumEvensLoop(numbers);
        sumEvensStream(numbers);
        sumEvensParallelStream(numbers);
    }
}
