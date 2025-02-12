
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int count;

    TicketReservationSystem() {
        this.last = null;
        this.count = 0;
    }

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        count++;
    }

    void removeTicket(int ticketId) {
        if (last == null)
            return;
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last)
                        last = prev;
                }
                count--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: "
                    + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    void searchTicket(String key) {
        if (last == null)
            return;
        Ticket current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(key) || current.movieName.equalsIgnoreCase(key)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName
                        + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: "
                        + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);
        if (!found)
            System.out.println("No matching ticket found.");
    }

    int countTickets() {
        return count;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Abhay", "Avengers", "A1", "10:00 AM");
        system.addTicket(2, "Divyansh", "Batman", "B2", "12:00 PM");
        system.addTicket(3, "Dhruv", "Avengers", "C3", "02:00 PM");

        system.displayTickets();

        system.searchTicket("Avengers");

        System.out.println("Total tickets booked: " + system.countTickets());

        system.removeTicket(2);
        system.displayTickets();
    }
}
