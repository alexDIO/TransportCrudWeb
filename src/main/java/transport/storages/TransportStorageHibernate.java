package transport.storages;

import hibernate.TransportEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import transport.classes.Transport;
import transport.classes.TransportManager;
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

    public TransportStorageHibernate(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {

    }

    @Override
    public void updateTransport(int id) throws IOException {

    }

    @Override
    public void deleteTransport(int id) throws IOException {

    }

    @Override
    public Map<Integer, Transport> getAllTransport() throws IOException {
        Map<Integer,Transport> resultMap = new HashMap<>();
        List<TransportEntity> list = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            list = session.createCriteria(TransportEntity.class).list();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        for (TransportEntity elem : list){
            TransportPojo pojo = new TransportPojo(elem.getId(),elem.getTransportType(),elem.getMark(),elem.getColor(),elem.getManufactureYear(),elem.getPassengersCount(),
                    elem.getEnergySource(),elem.getTransmission(),elem.getLoad());
            resultMap.put(elem.getId(), TransportManager.convertPojoToTransport(pojo));
        }

        return resultMap;
    }
}
