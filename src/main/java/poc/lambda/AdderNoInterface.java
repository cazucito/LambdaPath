package poc.lambda;

import poc.util.Printer;
import poc.util.MessageType;

/**
 * Add and print two ints
 *
 * @author cazucito
 */
public class AdderNoInterface {

   /**
     * Add and print two ints ( in1 + in2 )
     * @param in1 param 1
     * @param in2 param 2
     */
    public int add(int in1, int in2) {
        int result = in1 + in2;
        Printer.print(MessageType.MESSAGE, "Result (" + in1 + " + " + in2 + ") = " + result);
        return result;
    }
}
