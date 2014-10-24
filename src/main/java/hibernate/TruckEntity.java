package hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by olomakovskyi on 10/22/2014.
 */

@Entity
@DiscriminatorValue("Truck")
public class TruckEntity extends TransportEntity {
    @Column(name = "f_load")
    private int load;

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}
