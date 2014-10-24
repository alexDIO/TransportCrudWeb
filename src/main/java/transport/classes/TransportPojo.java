package transport.classes;

/**
 * Created by Alex on 9/6/2014.
 */
public class TransportPojo {
    private int id;
    private String transportType;
    private String mark;
    private String color;
    private int manufactureYear;
    private int passengersCount;
    private String energySource;
    private String transmission;
    private int load;

    public TransportPojo() {

    }

    public TransportPojo(int id, String transportType, String mark, String color, int manufactureYear, int passengersCount, String energySource, String transmission, int load) {
        this.id = id;
        this.transportType = transportType;
        this.mark = mark;
        this.color = color;
        this.manufactureYear = manufactureYear;
        this.passengersCount = passengersCount;
        this.energySource = energySource;
        this.transmission = transmission;
        this.load = load;
    }

    public TransportPojo(int id, String transportType, String mark, String color, int manufactureYear, String energySource) {
        this.id = id;
        this.transportType = transportType;
        this.mark = mark;
        this.color = color;
        this.manufactureYear = manufactureYear;
        this.energySource = energySource;
    }

    public String getTransportType() {
        return this.transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public String getEnergySource() {
        return energySource;
    }

    public void setEnergySource(String energySource) {
        this.energySource = energySource;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}
