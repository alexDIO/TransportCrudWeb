package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by olomakovskyi on 10/20/2014.
 */

@Entity
@Table(name = "t_transport")
public class TransportEntity {
    @Id
    @Column(name = "f_id")
    private int id;

    @Column(name = "f_transportType")
    private String transportType;

    @Column(name = "f_mark")
    private String mark;

    @Column(name = "f_color")
    private String color;

    @Column(name = "f_manufactureYear")
    private int manufactureYear;

    @Column(name = "f_passengersCount")
    private int passengersCount;

    @Column(name = "f_energySource")
    private String energySource;

    @Column(name = "f_transmission")
    private String transmission;

    @Column(name = "f_load")
    private int load;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
