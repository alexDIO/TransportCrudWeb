package forweb;

import transport.classes.Transport;
import transport.classes.TransportManager;
import transport.classes.TransportPojo;
import transport.storages.TransportStorage;
import transport.storages.TransportStorageException;
import transport.storages.TransportStorageFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by olomakovskyi on 10/9/2014.
 */
public class TransportMapHolder {
    private Map<Integer, Transport> storedTransport;
    private TransportStorage storage;

    public TransportMapHolder(){
        try {
            TransportStorage storage = TransportStorageFactory.getStorage();
            storedTransport = storage.getAllTransport();
        } catch (TransportStorageException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Transport> getMap(){
        return storedTransport;
    }

    public void addTransport(int id, String transportType, String mark, String color, int manufactureYear, int passengersCount, String energySource, String transmission, int load){
        TransportPojo pojo = new TransportPojo(id, transportType, mark, color, manufactureYear, passengersCount, energySource, transmission, load);
        if (id == -1) {
            if (storedTransport.size() > 0) {
                pojo.setId(Collections.max(storedTransport.keySet()) + 1);
            } else {
                pojo.setId(0);
            }
        }
        try {
            storage = TransportStorageFactory.getStorage();
            storage.addTransport(pojo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransportStorageException e) {
            e.printStackTrace();
        }

        storedTransport.put(pojo.getId(), TransportManager.convertPojoToTransport(pojo));
    }

    public void deleteTransport(int id){
        try {
            storage = TransportStorageFactory.getStorage();
            storage.deleteTransport(id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransportStorageException e) {
            e.printStackTrace();
        }
        storedTransport.remove(id);
    }
}
