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
