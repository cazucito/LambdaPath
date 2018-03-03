package poc.lambda;

/**
 * Invoker class, contains static methods to encapsulate the invocation process
 * @author cazucito
 */
public class OperationInvoker {
    /**
     * Apply the arithmetic operation (third param) to the param in1 and in2 by 
     * calling doOperation method with a generic reference ArithmeticCalculator
     * in1 operation in2
     * @param in1
     * @param in2
     * @param operation 
     */
    public static void invoke(int in1, int in2, ArithmeticCalculator operation){
        operation.doOperation(in1, in2);
    }
}
