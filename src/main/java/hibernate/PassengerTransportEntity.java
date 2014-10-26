package hibernate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by olomakovskyi on 10/22/2014.
 */

@Entity
public abstract class PassengerTransportEntity extends TransportEntity{
    @Column(name = "f_passengersCount")
    private int passengersCount;

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }
}
