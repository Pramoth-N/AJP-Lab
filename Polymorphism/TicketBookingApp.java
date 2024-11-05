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

 