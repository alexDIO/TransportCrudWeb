package transport.storages;

import transport.TransportStorageManager;
import transport.classes.*;

import java.io.IOException;

/**
 * Created by olomakovskyi on 9/17/2014.
 */
public abstract class TransportStorageDBAbstract implements TransportStorage {
    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {
        Transport newTransport = TransportManager.convertPojoToTransport(inPojo);
//        TransportStorageManager.storedCars.put(newTransport.getId(), newTransport);
        TransportPojo newPojo = TransportManager.convertTransportToPojo(newTransport);

        writePojo(newPojo);
    }

    @Override
    public void updateTransport(int id) throws IOException {
        Transport targetTransport = TransportManager.updateTransport(TransportStorageManager.storedCars.get(id));
        TransportStorageManager.storedCars.put(id, targetTransport);

        deleteTransport(id);

        writePojo(TransportManager.convertTransportToPojo(targetTransport));
    }

    protected abstract void writePojo(TransportPojo inPojo);
}
