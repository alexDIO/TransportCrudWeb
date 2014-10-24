package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by olomakovskyi on 10/22/2014.
 */
@Entity
@DiscriminatorValue("Sedan")
public class SedanEntity extends PassengerCarEntity {
}
