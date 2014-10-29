package transport.storages;

import hibernate.ManufacturerEntity;
import hibernate.TransportEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import transport.classes.Manufacturer;
import transport.classes.TransportPojo;

import java.util.*;

/**
 * Created by olomakovskyi on 10/28/2014.
 */
public class ManufacturerStorage {
    private SessionFactory factory;
    private Map<String, Manufacturer> map;
    private Map<String, ManufacturerEntity> mapEntity;

    public ManufacturerStorage() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Collection<Manufacturer> getAll(){
        if (map == null){
            fillMap();
        }
        return map.values();
    }

    public ManufacturerEntity getManufacturer(String description){
        if (map == null){
            fillMap();
        }
        return mapEntity.get(description);
    }

    private void fillMap(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<ManufacturerEntity> list = new ArrayList<>();

        try {
            list = session.createCriteria(ManufacturerEntity.class).list();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        map = new HashMap<>();
        mapEntity = new HashMap<>();

        for (ManufacturerEntity elem : list) {
            map.put(elem.getDescription(), new Manufacturer(elem.getDescription()));
            mapEntity.put(elem.getDescription(), elem);
        }
    }
}
