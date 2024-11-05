// package Constructors;
/*
 * 
 * 
 * 2. Karthick develops a library system where books can be added with default details (title and author) using a default constructor, and custom details using a parameterized constructor. Help Karthick implement a function to check if a book with a specific title and author exists in the library.
Input Format
•	The first line input consists of two strings representing the title and author.
•	The second line consists of two strings representing the title and author used to verify if the book exists.

Output Format
•	Print true if the book exists with the provided title and author, otherwise false.
•	Print Invalid input, if input contains special characters.

Constraints
•	0 <= Length of Title & Author <= 50

 * 
 * 
 */


 import java.util.Scanner;

public class LibrarySystem {
    private String title;
    private String author;

    public LibrarySystem() {
        this.title = "Default Title";
        this.author = "Default Author";
    }

    public LibrarySystem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean exists(String title, String author) {
        return this.title.equals(title) && this.author.equals(author);
    }

    public static boolean isValidInput(String input) {
        return input.matches("[a-zA-Z0-9 ]*");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            String[] input = sc.nextLine().split(" ");
            String[] check = sc.nextLine().split(" ");
            sc.close();
            String inputTitle = input[0];
            String inputAuthor = input[1];
            String checkTitle = check[0];
            String checkAuthor = check[1];

            if (isValidInput(inputTitle) && isValidInput(inputAuthor) && isValidInput(checkTitle) && isValidInput(checkAuthor)) {
                LibrarySystem book = new LibrarySystem(inputTitle, inputAuthor);
                System.out.println(book.exists(checkTitle, checkAuthor));
            } else {
                System.out.println("Invalid input");
            }
        
    }
}
