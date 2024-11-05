
/*
 * 
 * 2. A ticket booking system where multiple users attempt to book tickets for the same event. Each user is represented by a thread. Implement a program that simulates this process while ensuring that no more tickets are booked than available.

Input Format
•	total_tickets (integer) Total number of available tickets.
•	p (integer) Number of users attempting to book tickets.
•	Next p lines Each line contains user_id (int), and tickets_requested (int).

Output Format
•	For each user request, print Booking Success if tickets are booked or Booking Failed if insufficient tickets are available.
•	After all bookings, display the remaining tickets.

Constraints
•	1 ≤ total_tickets ≤ 50
•	1 ≤ p ≤ 20

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

class TicketBookingSystem {
    private int availableTickets;

    public TicketBookingSystem(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public synchronized boolean bookTickets(int userId, int ticketsRequested) {
        if (ticketsRequested <= availableTickets) {
            availableTickets -= ticketsRequested;
            System.out.printf("User %d: Booking Success%n", userId);
            return true;
        } else {
            System.out.printf("User %d: Booking Failed%n", userId);
            return false;
        }
    }

    public int getRemainingTickets() {
        return availableTickets;
    }
}

class User extends Thread {
    private int userId;
    private int ticketsRequested;
    private TicketBookingSystem bookingSystem;

    public User(int userId, int ticketsRequested, TicketBookingSystem bookingSystem) {
        this.userId = userId;
        this.ticketsRequested = ticketsRequested;
        this.bookingSystem = bookingSystem;
    }

    @Override
    public void run() {
        bookingSystem.bookTickets(userId, ticketsRequested);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTickets = sc.nextInt();
        int p = sc.nextInt();
        
        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalTickets);
        List<User> users = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            int userId = sc.nextInt();
            int ticketsRequested = sc.nextInt();
            User user = new User(userId, ticketsRequested, bookingSystem);
            users.add(user);
            user.start();
        }

        for (User user : users) {
            try {
                user.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("Remaining tickets: " + bookingSystem.getRemainingTickets());
    }
}


// Alternative code Without Threads

import java.util.Scanner;

class TicketBookingSystem {
    private int availableTickets;

    public TicketBookingSystem(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public boolean bookTickets(int userId, int ticketsRequested) {
        if (ticketsRequested <= availableTickets) {
            availableTickets -= ticketsRequested;
            System.out.printf("User %d: Booking Success%n", userId);
            return true;
        } else {
            System.out.printf("User %d: Booking Failed%n", userId);
            return false;
        }
    }

    public int getRemainingTickets() {
        return availableTickets;
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalTickets = sc.nextInt();
        int p = sc.nextInt();
        
        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalTickets);

        for (int i = 0; i < p; i++) {
            int userId = sc.nextInt();
            int ticketsRequested = sc.nextInt();
            bookingSystem.bookTickets(userId, ticketsRequested);
        }

        System.out.println("Remaining tickets: " + bookingSystem.getRemainingTickets());
    }
}
