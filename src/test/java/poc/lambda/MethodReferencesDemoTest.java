package poc.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Pruebas unitarias para la demostración de referencias a métodos (etapa 06).
 */
class MethodReferencesDemoTest {

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

    // --- Referencia a método estático ---

    @Test
    void staticRefSumsCorrectly() {
        assertEquals(9, MethodReferencesDemo.sumWithStaticRef(6, 3));
    }

    @Test
    void staticRefWithZero() {
        assertEquals(6, MethodReferencesDemo.sumWithStaticRef(6, 0));
    }

    @Test
    void staticRefWithNegatives() {
        assertEquals(-3, MethodReferencesDemo.sumWithStaticRef(-6, 3));
    }

    // --- Referencia a método de instancia ligada ---

    @Test
    void boundInstanceRefSumsCorrectly() {
        assertEquals(9, MethodReferencesDemo.sumWithBoundInstanceRef(6, 3));
    }

    @Test
    void boundInstanceRefWithNegatives() {
        assertEquals(0, MethodReferencesDemo.sumWithBoundInstanceRef(-3, 3));
    }

    // --- Referencia a método de instancia no ligada ---

    @Test
    void unboundInstanceRefSubtractsCorrectly() {
        assertEquals(3, MethodReferencesDemo.subtractWithUnboundInstanceRef(6, 3));
    }

    @Test
    void unboundInstanceRefResultNegative() {
        assertEquals(-3, MethodReferencesDemo.subtractWithUnboundInstanceRef(3, 6));
    }

    // --- Referencia a constructor ---

    @Test
    void constructorRefSumsCorrectly() {
        assertEquals(9, MethodReferencesDemo.sumWithConstructorRef(6, 3));
    }

    @Test
    void constructorRefWithZero() {
        assertEquals(0, MethodReferencesDemo.sumWithConstructorRef(0, 0));
    }
}
