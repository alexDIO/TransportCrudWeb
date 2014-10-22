package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public abstract class Transport implements ITransport {
    protected int id;
    protected String transportType;
    protected String mark;
    protected String color;
    protected int manufactureYear;
    protected String energySource;

    protected Transport(Integer id, String transportType) {
        this.id = id;
        this.transportType = transportType;
    }

    public int getId() {
        return id;
    }

    public String getTransportType() {
        return transportType;
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

    public String getEnergySource() {
        return energySource;
    }

    public void setEnergySource(String energySource) {
        this.energySource = energySource;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public void repaint(String newColor) {
        this.color = newColor;
    }

    public void move() {
        System.out.println("Transport has been moved");
    }

    public void repair() {
        System.out.println("Transport has been repaired");
    }

}
