/*
 * 
 * 1. You are tasked with developing a function that performs the following on an integer array: divides each element by a divisor, retrieves an element by index, and calculates the average of elements. Implement exception handling to manage issues with invalid indexes, zero divisors, or improper input formats.

Input Format
•	The first line contains n, representing the size of an array.
•	The second line contains n integers representing the array elements.
•	The third line contains an integer representing the divisor.
•	The fourth line contains an integer representing the index to access.

Output Format
•	Print each element divided by the divisor separated by spaces. 
•	Print the element at the specified index.
•	Print the average of all elements as a float value.
•	If the input is invalid (division by zero or out-of-bound indexes or non-integer ), print Invalid input.

Constraints
•	Handle cases for division by zero, out-of-bound indexes, and non-integer inputs.

// INPUT:
5
10 20 30 40 50
5
2


OUTPUT :
2 4 6 8 10 
30
30.00

 * 
 */


 import java.util.*;

public class ArrayProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int divisor = sc.nextInt();
            int index = sc.nextInt();

            if (divisor == 0) {
                throw new ArithmeticException("Invalid Input");
            }

            for (int i = 0; i < n; i++) {
                System.out.print((array[i] / divisor) + " ");
            }
            System.out.println();

            if (index < 0 || index >= n) {
                throw new ArrayIndexOutOfBoundsException("Invalid Input");
            }
            System.out.println(array[index]);

            double average = Arrays.stream(array).average().orElse(0.0);
            System.out.printf("%.2f%n", average);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } finally {
            sc.close();
        }
    }
}
