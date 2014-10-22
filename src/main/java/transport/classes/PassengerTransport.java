package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public abstract class PassengerTransport extends Transport {
    protected int passengersCount;

    protected PassengerTransport(Integer id, String transportType) {
        super(id, transportType);
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public void setEnergySource(String energySource) {
        this.energySource = energySource;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public String getEnergySource() {
        return energySource;
    }
}
