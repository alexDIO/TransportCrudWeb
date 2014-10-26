package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class Coupe extends PassengerCar {
    private final int passengersCount = 2;

    public Coupe() {
        super("Coupe");
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

        Coupe coupe = (Coupe) o;
        if (transportType != null ? !transportType.equals(coupe.color) : coupe.transportType != null) return false;
        if (id != coupe.id) return false;
        if (manufactureYear != coupe.manufactureYear) return false;
        if (passengersCount != coupe.passengersCount) return false;
        if (color != null ? !color.equals(coupe.color) : coupe.color != null) return false;
        if (energySource != null ? !energySource.equals(coupe.energySource) : coupe.energySource != null)
            return false;
        if (mark != null ? !mark.equals(coupe.mark) : coupe.mark != null) return false;
        if (transmission != null ? !transmission.equals(coupe.transmission) : coupe.transmission != null)
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
        result = 31 * result + id;
        return result;
    }

}
