package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public abstract class PassengerCar extends PassengerTransport {
    protected String transmission;

    protected PassengerCar(Integer id, String transportType) {
        super(id, transportType);
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }
}
