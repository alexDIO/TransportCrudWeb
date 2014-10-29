package hibernate;

import javax.persistence.*;

/**
 * Created by olomakovskyi on 10/20/2014.
 */

@Entity
@Table(name = "t_transport", uniqueConstraints = {
        @UniqueConstraint(columnNames = "f_transportType"),
        @UniqueConstraint(columnNames = "f_mark")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "f_transportType", discriminatorType = DiscriminatorType.STRING)
public abstract class TransportEntity {
    @Id
    @Column(name = "f_id")
    private int id;

    @Column(name = "f_transportType", insertable = false, updatable = false)
    private String transportType;

    @ManyToOne
    @JoinColumn (name = "f_mark")
    private ManufacturerEntity mark;

    @Column(name = "f_color")
    private String color;

    @Column(name = "f_manufactureYear")
    private int manufactureYear;

    @Column(name = "f_energySource")
    private String energySource;

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

    public ManufacturerEntity getMark() {
        return mark;
    }

    public void setMark(ManufacturerEntity mark) {
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
}
