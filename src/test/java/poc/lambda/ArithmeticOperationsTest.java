package poc.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para las clases de operaciones aritméticas.
 */
class ArithmeticOperationsTest {

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

    // --- Adder (suma con interfaz) ---

    @Test
    void adderSumsPositives() {
        assertEquals(9, new Adder().doOperation(6, 3));
    }

    @Test
    void adderWithZero() {
        assertEquals(6, new Adder().doOperation(6, 0));
    }

    @Test
    void adderWithNegative() {
        assertEquals(-3, new Adder().doOperation(-6, 3));
    }

    // --- Subtracter (resta con interfaz) ---

    @Test
    void subtracterSubtractsPositives() {
        assertEquals(3, new Subtracter().doOperation(6, 3));
    }

    @Test
    void subtracterResultNegative() {
        assertEquals(-3, new Subtracter().doOperation(3, 6));
    }

    @Test
    void subtracterWithZero() {
        assertEquals(6, new Subtracter().doOperation(6, 0));
    }

    // --- Multiplyer (multiplicación con interfaz) ---

    @Test
    void multiplyerMultipliesPositives() {
        assertEquals(18, new Multiplyer().doOperation(6, 3));
    }

    @Test
    void multiplyerByZero() {
        assertEquals(0, new Multiplyer().doOperation(6, 0));
    }

    @Test
    void multiplyerNegatives() {
        assertEquals(18, new Multiplyer().doOperation(-6, -3));
    }

    // --- AdderNoInterface (suma sin interfaz) ---

    @Test
    void adderNoInterfaceSums() {
        assertEquals(9, new AdderNoInterface().add(6, 3));
    }

    // --- SubtracterNoInterface (resta sin interfaz) ---

    @Test
    void subtracterNoInterfaceSubtracts() {
        assertEquals(3, new SubtracterNoInterface().subtract(6, 3));
    }

    // --- OperationInvoker (invocador con lambdas) ---

    @Test
    void invokerDelegatesAddition() {
        assertEquals(9, OperationInvoker.invoke(6, 3, (a, b) -> a + b));
    }

    @Test
    void invokerDelegatesSubtraction() {
        assertEquals(3, OperationInvoker.invoke(6, 3, (a, b) -> a - b));
    }

    @Test
    void invokerDelegatesMultiplication() {
        assertEquals(18, OperationInvoker.invoke(6, 3, (a, b) -> a * b));
    }

    @Test
    void invokerDelegatesWithConcreteClass() {
        assertEquals(9, OperationInvoker.invoke(6, 3, new Adder()));
    }
}
