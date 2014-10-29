package hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olomakovskyi on 10/24/2014.
 */

@Entity
@Table(name = "t_manufacturers", uniqueConstraints =
        @UniqueConstraint(columnNames = "f_description")
)
public class ManufacturerEntity {
    @Id
    @Column (name = "f_description", nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mark")

    private List<TransportEntity> entityList;

    public List<TransportEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<TransportEntity> entityList) {
        this.entityList = entityList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
