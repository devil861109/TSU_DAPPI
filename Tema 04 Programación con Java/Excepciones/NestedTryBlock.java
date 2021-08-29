package org.sisoftware;

public class NestedTryBlock {

    /**
     * Exceptions
     **/

    public static void main(String[] args) {

        /**
         * Nested try block
         */

        // outer try-catch block
        try {
            int exampleArray[] = {1, 2, 3, 4, 5};
            System.out.println(exampleArray[9]);

            // second, inner try-block inside another try block
            try {
                int x = exampleArray[3] / 0; // division
                System.out.println("Result of division: " + x);
            } catch (ArithmeticException e2) {
                System.out.println("ArithmeticException - Division by zero is not possible");
            }

        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("ArrayIndexOutOfBoundsException - Element at such index does not exists");
        }
    }
}
