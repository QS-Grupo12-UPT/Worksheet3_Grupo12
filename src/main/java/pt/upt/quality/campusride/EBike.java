package pt.upt.quality.campusride;

public class EBike extends Bike implements Electric {
    private static final int MAX_BATTERY = 100;

    private int batteryLevel;

    public EBike(String id, int batteryLevel) {
        super(id);
        if (batteryLevel < 0 || batteryLevel > MAX_BATTERY) {
            throw new IllegalArgumentException("Battery level must be between 0 and " + MAX_BATTERY);
        }
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
        batteryLevel = Math.min(MAX_BATTERY, batteryLevel + amount);
    }
}
