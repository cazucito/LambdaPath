package poc.lambda;

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
    public void add(int in1, int in2) {
        int result = 0;
        result = in1 + in2;
        System.out.println("\tResult (" + in1 + " + " + in2 + ") = " + result);
    }
}