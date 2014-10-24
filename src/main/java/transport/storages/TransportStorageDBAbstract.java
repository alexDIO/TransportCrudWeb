package transport.storages;

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

    protected abstract void writePojo(TransportPojo inPojo);
}
