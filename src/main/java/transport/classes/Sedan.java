package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class Sedan extends PassengerCar {
    private final int passengersCount = 5;

    public Sedan() {
        super("Sedan");
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    @Override
    public String toString() {
        return String.format("ID - %s: %s, mark - %s, color - %s, manufacture year - %s, passengers count - %s, energy source - %s, transmission - %s",
                id, transportType, mark, color, manufactureYear, passengersCount, energySource, transmission);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sedan sedan = (Sedan) o;
        if (transportType != null ? !transportType.equals(sedan.color) : sedan.transportType != null) return false;
        if (id != sedan.id) return false;
        if (manufactureYear != sedan.manufactureYear) return false;
        if (passengersCount != sedan.passengersCount) return false;
        if (color != null ? !color.equals(sedan.color) : sedan.color != null) return false;
        if (energySource != null ? !energySource.equals(sedan.energySource) : sedan.energySource != null)
            return false;
        if (mark != null ? !mark.equals(sedan.mark) : sedan.mark != null) return false;
        if (transmission != null ? !transmission.equals(sedan.transmission) : sedan.transmission != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + manufactureYear;
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        result = 31 * result + passengersCount;
        result = 31 * result + (energySource != null ? energySource.hashCode() : 0);
        return result;
    }
}
