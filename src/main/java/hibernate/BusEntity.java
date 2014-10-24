package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by olomakovskyi on 10/22/2014.
 */
@Entity
@DiscriminatorValue("Bus")
public class BusEntity extends PassengerTransportEntity {

}
