package poc.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas unitarias para la demostración de Streams API (etapa 07).
 */
class StreamsDemoTest {

    private PrintStream originalOut;

    /** Lista mixta usada en la mayoría de pruebas. */
    private static final List<Integer> MIXED = List.of(-3, -1, 0, 1, 2, 3, 4, 5);

    @BeforeEach
    void suppressOutput() {
        originalOut = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOut);
    }

    // --- filterPositives ---

    @Test
    void filterPositivesReturnsSoloPositivos() {
        List<Integer> result = StreamsDemo.filterPositives(MIXED);
        assertTrue(result.stream().allMatch(n -> n > 0));
    }

    @Test
    void filterPositivesCount() {
        assertEquals(5, StreamsDemo.filterPositives(MIXED).size());
    }

    @Test
    void filterPositivesEmptyListReturnsEmpty() {
        assertEquals(0, StreamsDemo.filterPositives(List.of()).size());
    }

    // --- doubleAll ---

    @Test
    void doubleAllDuplicaElementos() {
        List<Integer> result = StreamsDemo.doubleAll(List.of(1, 2, 3));
        assertEquals(List.of(2, 4, 6), result);
    }

    @Test
    void doubleAllPreservaTamano() {
        assertEquals(MIXED.size(), StreamsDemo.doubleAll(MIXED).size());
    }

    // --- sumAll ---

    @Test
    void sumAllSumaCorrectamente() {
        assertEquals(15, StreamsDemo.sumAll(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void sumAllListaVaciaEsCero() {
        assertEquals(0, StreamsDemo.sumAll(List.of()));
    }

    @Test
    void sumAllConNegativos() {
        assertEquals(0, StreamsDemo.sumAll(List.of(-3, -1, 0, 1, 2, 1)));
    }

    // --- filterMapReduce ---

    @Test
    void filterMapReduceResultadoCorrecto() {
        // positivos de MIXED: 1,2,3,4,5 → duplicados: 2,4,6,8,10 → suma: 30
        assertEquals(30, StreamsDemo.filterMapReduce(MIXED));
    }

    @Test
    void filterMapReduceListaSoloNegativos() {
        assertEquals(0, StreamsDemo.filterMapReduce(List.of(-5, -3, -1)));
    }

    // --- countGreaterThan ---

    @Test
    void countGreaterThanResultadoCorrecto() {
        // en MIXED, elementos > 2: 3,4,5 → 3
        assertEquals(3, StreamsDemo.countGreaterThan(MIXED, 2));
    }

    @Test
    void countGreaterThanUmbralAlto() {
        assertEquals(0, StreamsDemo.countGreaterThan(MIXED, 10));
    }
}
