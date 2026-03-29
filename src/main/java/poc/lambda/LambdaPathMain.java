package poc.lambda;

import poc.util.Printer;
import poc.util.MessageType;

/**
 * Main flow about a possible route from individual and unrelated classes to
 * lambda expressions
 *
 * @author cazucito
 */
public class LambdaPathMain {

    public static void main(String[] args) {
        Printer.print(MessageType.HEADER, "LAMBDA PATH");
        int a = 6, b = 3;
        Printer.print(MessageType.TITLE, "[00] Variable Values");
        Printer.print(MessageType.INFO, "a = " + a + " | b = " + b);
        //
        Printer.print(MessageType.TITLE, "[01] No interface");
        AdderNoInterface adder = new AdderNoInterface();
        adder.add(a, b);
        SubtracterNoInterface subtracter = new SubtracterNoInterface();
        subtracter.subtract(a, b);
        //
        Printer.print(MessageType.TITLE, "[02] With interface");
        ArithmeticCalculator genericRef02 = new Adder();
        genericRef02.doOperation(a, b);
        ArithmeticCalculator genericRef022 = new Subtracter();
        genericRef022.doOperation(a, b);
        genericRef022 = new Multiplyer();
        genericRef022.doOperation(a, b);
        //
        Printer.print(MessageType.TITLE, "[03] With anonymous inner class");
        ArithmeticCalculator genericRef03 = new ArithmeticCalculator() {
            @Override
            public int doOperation(int in1, int in2) {
                int result = in1 * in2;
                Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + result);
                return result;
            }

        };
        genericRef03.doOperation(a, b);
        //
        Printer.print(MessageType.TITLE, "[04] With interface and launcher");
        ArithmeticCalculator genericRef04 = new Adder();
        OperationInvoker.invoke(a, b, genericRef04);
        OperationInvoker.invoke(a, b, new Subtracter());
        OperationInvoker.invoke(a, b, new ArithmeticCalculator() {
            @Override
            public int doOperation(int in1, int in2) {
                int result = in1 * in2;
                Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + result);
                return result;
            }
        });
        //
        Printer.print(MessageType.TITLE, "[05] With lambda expressions");
        OperationInvoker.invoke(a, b, (int in1, int in2) -> {
            int result = in1 * in2;
            Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + result);
            return result;
        });
        OperationInvoker.invoke(a, b, (in1, in2) -> {
            Printer.print(MessageType.MESSAGE, "Result (" + in1 + " * " + in2 + ") = " + (in1 * in2));
            return in1 * in2;
        });
        ArithmeticCalculator sub = (in1, in2) -> {
            Printer.print(MessageType.MESSAGE, "Result (" + in1 + " - " + in2 + ") = " + (in1 - in2));
            return in1 - in2;
        };
        OperationInvoker.invoke(a, b, sub);
        OperationInvoker.invoke(a, b, sub);
        Printer.print(MessageType.FOOTER, "");
    }

}
