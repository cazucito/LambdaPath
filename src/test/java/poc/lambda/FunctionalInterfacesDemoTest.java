package poc.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas unitarias para la demostración de interfaces funcionales estándar (etapa 08).
 */
class FunctionalInterfacesDemoTest {

    private PrintStream originalOut;

    @BeforeEach
    void suppressOutput() {
        originalOut = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOut);
    }

    // --- Predicate ---

    @Test
    void isPositiveTrueParaPositivo() {
        assertTrue(FunctionalInterfacesDemo.isPositive(5));
    }

    @Test
    void isPositiveFalseParaNegativo() {
        assertFalse(FunctionalInterfacesDemo.isPositive(-1));
    }

    @Test
    void isPositiveFalseParaCero() {
        assertFalse(FunctionalInterfacesDemo.isPositive(0));
    }

    // --- Function ---

    @Test
    void intToStringContieneElNumero() {
        assertTrue(FunctionalInterfacesDemo.intToString(42).contains("42"));
    }

    @Test
    void intToStringEsNoNulo() {
        assertEquals("Número: 7", FunctionalInterfacesDemo.intToString(7));
    }

    // --- UnaryOperator ---

    @Test
    void doubleItDuplicaPositivo() {
        assertEquals(12, FunctionalInterfacesDemo.doubleIt(6));
    }

    @Test
    void doubleItDuplicaNegativo() {
        assertEquals(-6, FunctionalInterfacesDemo.doubleIt(-3));
    }

    @Test
    void doubleItCeroEsCero() {
        assertEquals(0, FunctionalInterfacesDemo.doubleIt(0));
    }

    // --- BinaryOperator ---

    @Test
    void sumWithBinaryOperatorSumaCorrectamente() {
        assertEquals(9, FunctionalInterfacesDemo.sumWithBinaryOperator(6, 3));
    }

    @Test
    void sumWithBinaryOperatorConNegativos() {
        assertEquals(-3, FunctionalInterfacesDemo.sumWithBinaryOperator(-6, 3));
    }

    // --- Supplier ---

    @Test
    void getConstantRetorna42() {
        assertEquals(42, FunctionalInterfacesDemo.getConstant());
    }

    // --- Consumer (sin valor de retorno, solo verificamos que no lanza excepción) ---

    @Test
    void printWithConsumerNoLanzaExcepcion() {
        FunctionalInterfacesDemo.printWithConsumer("test");
    }
}
