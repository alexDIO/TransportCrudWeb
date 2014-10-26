package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class Bus extends PassengerTransport {
    private final String energySource = "Petrol";

    public Bus() {
        super("Bus");
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

        Bus bus = (Bus) o;
        if (transportType != null ? !transportType.equals(bus.color) : bus.transportType != null) return false;
        if (id != bus.id) return false;
        if (manufactureYear != bus.manufactureYear) return false;
        if (passengersCount != bus.passengersCount) return false;
        if (color != null ? !color.equals(bus.color) : bus.color != null) return false;
        if (energySource != null ? !energySource.equals(bus.energySource) : bus.energySource != null)
            return false;
        if (mark != null ? !mark.equals(bus.mark) : bus.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + manufactureYear;
        result = 31 * result + passengersCount;
        result = 31 * result + (energySource != null ? energySource.hashCode() : 0);
        return result;
    }
}
