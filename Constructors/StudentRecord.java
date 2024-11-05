



import java.util.Scanner;

public class StudentRecord {
    private String name;
    private int grade;

    public StudentRecord(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public boolean exists(String name, int grade) {
        return this.name.equals(name) && this.grade == grade;
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]*");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] check = sc.nextLine().split(" ");
        sc.close();
        String inputName = input[0];
        String inputGrade = input[1];
        String checkName = check[0];
        String checkGrade =  check[1];
        sc.close();
        if (!isValidName(inputName) || !isValidName(checkName)) {
            System.out.println("Invalid input");
            return;
        }
        int gradeToAdd;
        int gradeToCheck;
        
        try {
            gradeToAdd = Integer.parseInt(inputGrade);
            gradeToCheck = Integer.parseInt(checkGrade);

            StudentRecord student = new StudentRecord(inputName, gradeToAdd);
            System.out.println(student.exists(checkName, gradeToCheck));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }
}
