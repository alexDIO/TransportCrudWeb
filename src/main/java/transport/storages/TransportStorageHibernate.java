package transport.storages;

import hibernate.ManufacturerEntity;
import hibernate.TransportEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import transport.classes.Transport;
import transport.classes.TransportConverter;
import transport.classes.TransportPojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by olomakovskyi on 10/20/2014.
*/
public class TransportStorageHibernate implements TransportStorage {
    private SessionFactory factory;
    private final TransportConverter converter;
    private ManufacturerStorage manufacturers;

    public TransportStorageHibernate(TransportConverter converter, ManufacturerStorage manufacturers) {
        factory = new Configuration().configure().buildSessionFactory();
        this.converter = converter;
        this.manufacturers = manufacturers;
    }

    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TransportEntity transport = converter.convertPojoToTransportEntity(inPojo);
            ManufacturerEntity manufacturer = manufacturers.getManufacturer(inPojo.getMark());
            transport.setMark(manufacturer);
            session.save(transport);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void deleteTransport(int id) throws IOException {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TransportEntity transport = (TransportEntity) session.get(TransportEntity.class, id);
            session.delete(transport);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Map<Integer, Transport> getAllTransport() throws IOException {
        Map<Integer, Transport> resultMap = new HashMap<>();
        List<TransportEntity> list = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            list = session.createCriteria(TransportEntity.class).list();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        for (TransportEntity elem : list) {
            TransportPojo pojo = new TransportPojo(elem.getId(), elem.getTransportType(), elem.getMark().getDescription(), elem.getColor(), elem.getManufactureYear(), /*elem.getPassengersCount(),*/
                    elem.getEnergySource()/*, elem.getTransmission(), elem.getLoad()*/);
            resultMap.put(elem.getId(), converter.convertPojoToTransport(pojo));
        }

        return resultMap;
    }
}
