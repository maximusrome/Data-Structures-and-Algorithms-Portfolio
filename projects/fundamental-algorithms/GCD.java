/**
 * Name: GCD.java
 * Author: Max Rome
 * UNI: amr2386
 * Date: 9/10/22
 * Description: Computes the GCD of the two command-line arguments.
 */
public class GCD {
    /**
     * Iteratively computes the greatest common divisor of two integers
     * using Euclid's algorithm.
     * @param m the first integer
     * @param n the second integer
     * @return gcd(m, n)
     */
    public static int iterativeGcd(int m, int n) {
        while(n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }

    /**
     * Recursively computes the greatest common divisor of two integers
     * using Euclid's algorithm.
     * @param m the first integer
     * @param n the second integer
     * @return gcd(m, n)
     */
    public static int recursiveGcd(int m, int n) {
        return (n != 0) ? recursiveGcd(n, m % n) : m;
    }

    /**
     * Computes the greatest common divisor of two integers provided as
     * parameters to the program.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.print("Usage: java GCD <integer m> <integer n>");
            System.exit(1);
        } else {
            try {
                int m = Integer.parseInt(args[0]);
                try {
                    int n = Integer.parseInt(args[1]);
                    if (m == 0 && n == 0)
                        System.out.print("gcd("+m+", "+n+") = undefined");
                    else {
                        System.out.println("Iterative: " + "gcd(" +m+ ", " +n+ ") = " + iterativeGcd(Math.abs(m), Math.abs(n)));
                        System.out.print("Recursive: " + "gcd(" +m+ ", " +n+ ") = " + recursiveGcd(Math.abs(m), Math.abs(n)));
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Error: The second argument is not a valid integer.");
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.out.print("Error: The first argument is not a valid integer.");
                System.exit(1);
            }
        }
    }
}
