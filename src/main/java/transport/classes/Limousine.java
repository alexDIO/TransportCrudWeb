package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class Limousine extends PassengerCar {

    public Limousine() {
        super("Limousine");
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

        Limousine limousine = (Limousine) o;
        if (transportType != null ? !transportType.equals(limousine.color) : limousine.transportType != null)
            return false;
        if (id != limousine.id) return false;
        if (manufactureYear != limousine.manufactureYear) return false;
        if (passengersCount != limousine.passengersCount) return false;
        if (color != null ? !color.equals(limousine.color) : limousine.color != null) return false;
        if (energySource != null ? !energySource.equals(limousine.energySource) : limousine.energySource != null)
            return false;
        if (mark != null ? !mark.equals(limousine.mark) : limousine.mark != null) return false;
        if (transmission != null ? !transmission.equals(limousine.transmission) : limousine.transmission != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + manufactureYear;
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        result = 31 * result + passengersCount;
        result = 31 * result + (energySource != null ? energySource.hashCode() : 0);
        return result;
    }
}
