/*
 * 
 * 
 * Method overloading and overriding
1. You are tasked with creating a community library system. Implement a class Library that manages traditional book entries, allowing users to add and display book details. Extend this class into a DigitalLibrary that handles digital resources with additional functionalities.

Input Format
•	For Library: A String for title, a String for author, and an int for publication year each on new line. 
•	For digital library: The next line contains a String for the title, a String for the author, an int for publication year, a String for file format , and a String for the download link each on new line.

Output Format
•	Confirmation message indicating the book's details and the format (if applicable) on new line.
•	Print the book type as Digital if book contains a download link otherwise print Physical.
•	If input year is invalid (such as negative or non-integer), print "Invalid input".
•	For invalid file format, print "-1".

Constraints
•	1000 <= publication year <= 9999
•	Book titles, authors, formats, and download links must be non-empty strings.
•	The format should be one of the standard digital formats (PDF, TXT, ODT, XSL).

 * 
 * 
 */


 import java.util.Scanner;

class Library {
    protected String title;
    protected String author;
    protected int publicationYear;

    public Library(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + publicationYear);
    }
}

class DigitalLibrary extends Library {
    private String fileFormat;
    private String downloadLink;

    public DigitalLibrary(String title, String author, int publicationYear, String fileFormat, String downloadLink) {
        super(title, author, publicationYear);
        this.fileFormat = fileFormat;
        this.downloadLink = downloadLink;
    }

    public boolean isValidFormat() {
        return fileFormat.equalsIgnoreCase("PDF") || fileFormat.equalsIgnoreCase("TXT") || fileFormat.equalsIgnoreCase("XLS") || fileFormat.equalsIgnoreCase("ODT");

    }

    @Override
    public void display() {
        super.display();
        System.out.println((isValidFormat() ? fileFormat : "-1"));
        System.out.println( (downloadLink.isEmpty() ? "Physical" : "Digital"));
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String data[] = sc.nextLine().split(" ");
            String title = data[0];
            String author = data[1];
            int year = Integer.parseInt(data[2]);


            if (year < 0) {
                System.out.println("Invalid input");
                return;
            }

            String format = "";
            String link = "";

            if (data.length == 5) {
                format = data[3];
                link = data[4];
                DigitalLibrary digitalBook = new DigitalLibrary(title, author, year, format, link);
                digitalBook.display();
            } else {
                Library physicalBook = new Library(title, author, year);
                physicalBook.display();
                System.out.println("Physical");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }
}
