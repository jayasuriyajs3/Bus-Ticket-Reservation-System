import java.util.*;

// Abstract Bus class
abstract class Bus {
    protected int busId;
    protected String busName;
    protected int totalSeats;
    protected int availableSeats;

    public Bus(int busId, String busName, int totalSeats) {
        this.busId = busId;
        this.busName = busName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public void showAvailability() {
        System.out.println("Bus: " + busName + " | Available Seats: " + availableSeats);
    }

    public abstract double calcFare();
}

class SleeperBus extends Bus {
    public SleeperBus(int busId, String busName, int totalSeats) {
        super(busId, busName, totalSeats);
    }

    @Override
    public double calcFare() {
        return 800.0; // flat fare for sleeper
    }
}

class SeaterBus extends Bus {
    public SeaterBus(int busId, String busName, int totalSeats) {
        super(busId, busName, totalSeats);
    }

    @Override
    public double calcFare() {
        return 500.0; // flat fare for seater
    }
}

class Ticket {
    private static int idCounter = 1;
    private int ticketId;
    private String passengerName;
    private int seatNo;
    private double fare;
    private Bus bus;

    public Ticket(String passengerName, Bus bus, int seatNo) {
        this.ticketId = idCounter++;
        this.passengerName = passengerName;
        this.bus = bus;
        this.seatNo = seatNo;
        this.fare = bus.calcFare();
    }

    public int getTicketId() { return ticketId; }
    public int getSeatNo() { return seatNo; }

    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketId +
                " | Passenger: " + passengerName +
                " | Seat No: " + seatNo +
                " | Fare: " + fare +
                " | Bus: " + bus.busName);
    }
}

class Waitlist {
    private Queue<String> queue = new LinkedList<>();

    public void addPassenger(String name) {
        queue.add(name);
        System.out.println(name + " added to waitlist.");
    }

    public String getNextPassenger() {
        return queue.poll(); // returns and removes first person
    }

    public void showWaitlist() {
        System.out.println("Current Waitlist: " + queue);
    }
}

public class Main {
    private static List<Ticket> tickets = new ArrayList<>();
    private static Waitlist waitlist = new Waitlist();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bus sleeper = new SleeperBus(1, "Chennai-Coimbatore Sleeper", 2);
        Bus seater = new SeaterBus(2, "Chennai-Coimbatore Seater", 2);

        while (true) {
            System.out.println("\n=== BUS RESERVATION SYSTEM ===");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Show Availability");
            System.out.println("5. Show Waitlist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();
                    System.out.println("Choose Bus: 1. Sleeper | 2. Seater");
                    int busChoice = sc.nextInt();
                    sc.nextLine();
                    Bus selectedBus = (busChoice == 1) ? sleeper : seater;
                    bookTicket(name, selectedBus);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int ticketId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Choose Bus: 1. Sleeper | 2. Seater");
                    int cancelChoice = sc.nextInt();
                    sc.nextLine();
                    Bus cancelBus = (cancelChoice == 1) ? sleeper : seater;
                    cancelTicket(ticketId, cancelBus);
                    break;

                case 3:
                    viewTickets();
                    break;

                case 4:
                    sleeper.showAvailability();
                    seater.showAvailability();
                    break;

                case 5:
                    waitlist.showWaitlist();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Book ticket method
    public static void bookTicket(String passengerName, Bus bus) {
        if (bus.availableSeats > 0) {
            int seatNo = bus.totalSeats - bus.availableSeats + 1;
            Ticket ticket = new Ticket(passengerName, bus, seatNo);
            tickets.add(ticket);
            bus.availableSeats--;
            System.out.println("Ticket booked successfully!");
            ticket.displayTicket();
        } else {
            waitlist.addPassenger(passengerName);
        }
    }

    // Cancel ticket method
    public static void cancelTicket(int ticketId, Bus bus) {
        Ticket toCancel = null;
        for (Ticket t : tickets) {
            if (t.getTicketId() == ticketId) {
                toCancel = t;
                break;
            }
        }
        if (toCancel != null) {
            tickets.remove(toCancel);
            bus.availableSeats++;
            System.out.println("Ticket " + ticketId + " cancelled successfully!");

            // Assign seat to first person in waitlist
            String nextPassenger = waitlist.getNextPassenger();
            if (nextPassenger != null) {
                bookTicket(nextPassenger, bus);
            }
        } else {
            System.out.println("Ticket not found!");
        }
    }

    // View all booked tickets
    public static void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            for (Ticket t : tickets) {
                t.displayTicket();
            }
        }
    }
}