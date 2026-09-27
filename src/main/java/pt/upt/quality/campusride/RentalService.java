package pt.upt.quality.campusride;

public class RentalService {
    private final Fleet fleet;

    public RentalService(Fleet fleet) {
        this.fleet = fleet;
    }

    public void rentVehicle(String id) {
        findOrThrow(id).rent();
    }

    public void returnVehicle(String id) {
        findOrThrow(id).returnVehicle();
    }

    public double estimatePrice(String id, int minutes) {
        return findOrThrow(id).calculatePrice(minutes);
    }

    private Vehicle findOrThrow(String id) {
        Vehicle vehicle = fleet.findById(id);
        if (vehicle == null) {
            throw new IllegalArgumentException("Unknown vehicle id: " + id);
        }
        return vehicle;
    }
}
