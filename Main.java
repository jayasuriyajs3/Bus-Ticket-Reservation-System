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