package hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olomakovskyi on 10/24/2014.
 */

@Entity
@Table(name = "t_manufacturers", uniqueConstraints =
        @UniqueConstraint(columnNames = "f_manufacturer")
)
public class ManufacturerEntity {
    @Id
    @Column (name = "f_manufacturer", unique = true, nullable = false)
    private String manufacturer;
    private List<TransportEntity> entityList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "f_manufacturers")

    public List<TransportEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<TransportEntity> entityList) {
        this.entityList = entityList;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
