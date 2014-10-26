package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by olomakovskyi on 10/22/2014.
 */

@Entity
public abstract class PassengerCarEntity extends PassengerTransportEntity {
    @Column(name = "f_transmission")
    private String transmission;

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
