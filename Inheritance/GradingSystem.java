import java.util.Scanner;

abstract class Student {
    protected String name;
    protected String id;
    protected int[] grades;

    public Student(String name, String id, int[] grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public abstract double calculateAverage();

    public static boolean isValidGrade(int grade) {
        return grade >= 0 && grade <= 100;
    }
}

class Undergraduate extends Student {
    public Undergraduate(String name, String id, int[] grades) {
        super(name, id, grades);
    }

    @Override
    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}

class Postgraduate extends Student {
    public Postgraduate(String name, String id, int[] grades) {
        super(name, id, grades);
    }

    @Override
    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}

public class GradingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String studentType = sc.nextLine();
            String name = sc.nextLine();
            String id = sc.nextLine();
            int numberOfGrades = sc.nextInt();

            int[] grades = new int[numberOfGrades];
            for (int i = 0; i < numberOfGrades; i++) {
                grades[i] = sc.nextInt();
                if (grades[i] < 0 || grades[i] > 100) {
                    System.out.println("Invalid input");
                    return;
                }
            }

            Student student;
            if (studentType.equalsIgnoreCase("Undergraduate")) {
                student = new Undergraduate(name, id, grades);
            } else if (studentType.equalsIgnoreCase("Postgraduate")) {
                student = new Postgraduate(name, id, grades);
            } else {
                System.out.println("Invalid input");
                return;
            }

            System.out.printf("Average score: %.2f%n", student.calculateAverage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }
}
