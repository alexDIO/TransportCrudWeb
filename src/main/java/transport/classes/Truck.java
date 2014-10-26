package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class Truck extends Transport {
    private final String energySource = "Petrol";
    private Integer load;

    public Truck() {
        super("Truck");
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public String getEnergySource() {
        return energySource;
    }

    @Override
    public String toString() {
        return String.format("ID - %s: %s, mark - %s, color - %s, manufacture year - %s, energy source - %s, load - %s",
                id, transportType, mark, color, manufactureYear, energySource, load);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;
        if (transportType != null ? !transportType.equals(truck.color) : truck.transportType != null) return false;
        if (id != truck.id) return false;
        if (manufactureYear != truck.manufactureYear) return false;
        if (load != truck.load) return false;
        if (color != null ? !color.equals(truck.color) : truck.color != null) return false;
        if (energySource != null ? !energySource.equals(truck.energySource) : truck.energySource != null)
            return false;
        if (mark != null ? !mark.equals(truck.mark) : truck.mark != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + manufactureYear;
        result = 31 * result + load;
        result = 31 * result + (energySource != null ? energySource.hashCode() : 0);
        return result;
    }
}
