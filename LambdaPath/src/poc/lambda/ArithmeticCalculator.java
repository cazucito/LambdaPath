package poc.lambda;

/**
 *
 * @author cazucito
 */
@FunctionalInterface
public interface ArithmeticCalculator {

    /**
     * Model a generic arithmetic operation with two operands
     *
     * @param in1 input operand
     * @param in2 input operand
     */
    public abstract void doOperation(int in1, int in2);
}
