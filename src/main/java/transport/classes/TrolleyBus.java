package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class TrolleyBus extends PassengerTransport {
    private final String energySource = "Electricity";

    public TrolleyBus() {
        super("TrolleyBus");
    }

    public String getEnergySource() {
        return energySource;
    }

    @Override
    public String toString() {
        return String.format("ID - %s: %s, mark - %s, color - %s, manufacture year - %s, passengers count - %s, energy source - %s",
                id, transportType, mark, color, manufactureYear, passengersCount, energySource);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrolleyBus trolleybus = (TrolleyBus) o;
        if (transportType != null ? !transportType.equals(trolleybus.color) : trolleybus.transportType != null)
            return false;
        if (id != trolleybus.id) return false;
        if (manufactureYear != trolleybus.manufactureYear) return false;
        if (passengersCount != trolleybus.passengersCount) return false;
        if (color != null ? !color.equals(trolleybus.color) : trolleybus.color != null) return false;
        if (energySource != null ? !energySource.equals(trolleybus.energySource) : trolleybus.energySource != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + manufactureYear;
        result = 31 * result + passengersCount;
        result = 31 * result + (energySource != null ? energySource.hashCode() : 0);
        return result;
    }
}
