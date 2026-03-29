package poc.lambda.es;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para las clases de operaciones aritméticas en español.
 */
class OperacionesAritmeticasTest {

    private PrintStream salidaOriginal;

    @BeforeEach
    void suprimirSalida() {
        salidaOriginal = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
    }

    @AfterEach
    void restaurarSalida() {
        System.setOut(salidaOriginal);
    }

    // --- Sumadora ---

    @Test
    void sumadoraSumaPositivos() {
        assertEquals(9, new Sumadora().hazOperacion(6, 3));
    }

    @Test
    void sumadoraConCero() {
        assertEquals(6, new Sumadora().hazOperacion(6, 0));
    }

    @Test
    void sumadoraConNegativo() {
        assertEquals(-3, new Sumadora().hazOperacion(-6, 3));
    }

    // --- Restadora ---

    @Test
    void restadoraRestaPositivos() {
        assertEquals(3, new Restadora().hazOperacion(6, 3));
    }

    @Test
    void restadoraResultadoNegativo() {
        assertEquals(-3, new Restadora().hazOperacion(3, 6));
    }

    @Test
    void restadoraConCero() {
        assertEquals(6, new Restadora().hazOperacion(6, 0));
    }

    // --- Multiplicadora ---

    @Test
    void multiplicadoraMultiplicaPositivos() {
        assertEquals(18, new Multiplicadora().hazOperacion(6, 3));
    }

    @Test
    void multiplicadoraPorCero() {
        assertEquals(0, new Multiplicadora().hazOperacion(6, 0));
    }

    @Test
    void multiplicadoraNegativos() {
        assertEquals(18, new Multiplicadora().hazOperacion(-6, -3));
    }

    // --- SumadoraSinInterfaz ---

    @Test
    void sumadoraSinInterfazSuma() {
        assertEquals(9, new SumadoraSinInterfaz().suma(6, 3));
    }

    // --- RestadoraSinInterfaz ---

    @Test
    void restadoraSinInterfazResta() {
        assertEquals(3, new RestadoraSinInterfaz().resta(6, 3));
    }

    // --- InvocadorDeOperaciones con lambdas ---

    @Test
    void invocadorDelegaSuma() {
        assertEquals(9, InvocadorDeOperaciones.invoca(6, 3, (a, b) -> a + b));
    }

    @Test
    void invocadorDelegaResta() {
        assertEquals(3, InvocadorDeOperaciones.invoca(6, 3, (a, b) -> a - b));
    }

    @Test
    void invocadorDelegaMultiplicacion() {
        assertEquals(18, InvocadorDeOperaciones.invoca(6, 3, (a, b) -> a * b));
    }

    @Test
    void invocadorDelegaConClaseConcreta() {
        assertEquals(9, InvocadorDeOperaciones.invoca(6, 3, new Sumadora()));
    }
}
