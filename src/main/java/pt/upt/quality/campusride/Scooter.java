package pt.upt.quality.campusride;

public class Scooter extends Vehicle implements Electric {
    private int batteryLevel;

    public Scooter(String id, int batteryLevel) {
        super(id);
        validateBattery(batteryLevel);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Charge amount cannot be negative");
        }
        batteryLevel = Math.min(100, batteryLevel + amount);
    }

    @Override
    public double calculatePrice(int minutes) {
        validateMinutes(minutes);

        double total;

        if (minutes <= 30) {
            total = minutes * 0.15;
        } else {
            total = (30 * 0.15) + ((minutes - 30) * 0.20);
        }

        return 1.00 + total;
    }

    private void validateBattery(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Battery must be between 0 and 100");
        }
    }
}
