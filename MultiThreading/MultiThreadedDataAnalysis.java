/*
 * 
 * 
 * 1. A data analysis to perform calculations (e.g., sum, average) on different sets of numbers. Use multithreading to compute each set's results simultaneously.

Input Format
•	s (integer) Number of data sets.
•	Next s lines Each line contains dataset_id (int), followed by a list of integers representing the dataset.

Output Format
•	For each dataset, print the result for dataset <dataset_id>: Sum = <sum>, Average = <average>.

Constraints
•	1 ≤ s ≤ 10
•	Each dataset contains 1 ≤ numbers ≤ 100


INPUT :

3
1 10 20 30
2 5 15 25 35 45
3 7 14


OUTPUT:
Result for dataset 1: Sum = 60, Average = 20.00
Result for dataset 2: Sum = 120, Average = 30.00
Result for dataset 3: Sum = 21, Average = 10.50

 * 
 * 
 */

/*
 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  NOTE :                                             *
 *  If the out order mismatch, dont use threads .      *
 * just calculate the sum and average and print it     *
 *                                                     *   
 * * * * * * * * * * * * * * * * * * * * * * * * * * * *                                                    
 */
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 
 class DataSetCalculator extends Thread {
     private int datasetId;
     private List<Integer> numbers;
 
     public DataSetCalculator(int datasetId, List<Integer> numbers) {
         this.datasetId = datasetId;
         this.numbers = numbers;
     }
 
     @Override
     public void run() {
         int sum = numbers.stream().mapToInt(Integer::intValue).sum();
         double average = (double) sum / numbers.size();
         System.out.printf("Result for dataset %d: Sum = %d, Average = %.2f%n", datasetId, sum, average);
     }
 }
 
 public class MultiThreadedDataAnalysis {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int s = sc.nextInt();
         sc.nextLine(); 
 
         List<DataSetCalculator> threads = new ArrayList<>();
 
         for (int i = 0; i < s; i++) {
             int datasetId = sc.nextInt();
             List<Integer> numbers = new ArrayList<>();
            String nums[] = sc.nextLine().trim().split("\\s+");
            for (String num : nums) {
                 numbers.add(Integer.parseInt(num));
             }
 
             DataSetCalculator calculator = new DataSetCalculator(datasetId, numbers);
             threads.add(calculator);
             calculator.start();
         }
 
         for (DataSetCalculator thread : threads) {
             try {
                 thread.join();
             } catch (InterruptedException e) {
                 System.out.println("Thread interrupted");
             }
         }
     }
 }
 