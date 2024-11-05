/*
 * 
 * Collection Interface
1. During a school event, students need to check in and out. Design a Classroom attendance system that allows adding a student, marking their status as Present or Absent, and printing the entire attendance list when requested.
For input 1: Add a student, A single line with the student’s name.
For input 2: Mark attendance, student’s name, and their attendance status (Present/Absent) separated by space.
For input 3: Display all the student's name and their attendance status.

Input Format
•	The first line contains n, the number of input commands.
•	The next n lines contain one of the above commands with the following inputs (if applicable).

Output Format
•	For input 3, Display all the students with their attendance status.
•	If a student's name was not found while marking attendance print Student not found.
•	If the input is invalid (attendance or invalid command), print Invalid input.

Constraints
•	Student names must be non-empty strings.
•	Attendance status should only be Present or Absent.


INPUT:

6
1 John
2 John Absent
1 Emma
2 Emma Present
2 Bob Absent
3

OUTPUT:
John Absent
Emma Present
Student not found

 * 
 */


 import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassroomAttendance {
    private Map<String, String> attendanceMap = new HashMap<>();

    public void addStudent(String name) {
        if (name.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }
        attendanceMap.put(name, "Unknown");
    }

    public void markAttendance(String name, String status) {
        if (!attendanceMap.containsKey(name)) {
            System.out.println("Student not found");
            return;
        }
        if (!status.equals("Present") && !status.equals("Absent")) {
            System.out.println("Invalid input");
            return;
        }
        attendanceMap.put(name, status);
    }

    public void displayAttendance() {
        for (Map.Entry<String, String> entry : attendanceMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Attendance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassroomAttendance attendanceSystem = new ClassroomAttendance();
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("1")) {
                String name = sc.nextLine().trim();
                attendanceSystem.addStudent(name);
            } else if (command.equals("2")) {
                String name = sc.next();
                String status = sc.next();
                attendanceSystem.markAttendance(name, status);
            } else if (command.equals("3")) {
                attendanceSystem.displayAttendance();
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
