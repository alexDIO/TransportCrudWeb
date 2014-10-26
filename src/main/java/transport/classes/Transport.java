package transport.classes;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public abstract class Transport implements ITransport {
    protected Integer id;
    protected String transportType;
    protected String mark;
    protected String color;
    protected Integer manufactureYear;
    protected String energySource;

    protected Transport(String transportType) {
        this.transportType = transportType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
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

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getEnergySource() {
        return energySource;
    }

    public void setEnergySource(String energySource) {
        this.energySource = energySource;
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
