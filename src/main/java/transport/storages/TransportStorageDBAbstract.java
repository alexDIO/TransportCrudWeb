package transport.storages;

import transport.TransportPropertiesHolder;
import transport.classes.*;

import java.io.IOException;

/**
 * Created by olomakovskyi on 9/17/2014.
 */
public abstract class TransportStorageDBAbstract implements TransportStorage {
    private final TransportConverter converter;

    protected TransportStorageDBAbstract(TransportConverter converter) {
        this.converter = converter;
    }

    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {
        Transport newTransport = converter.convertPojoToTransport(inPojo);
        TransportPojo newPojo = converter.convertTransportToPojo(newTransport);

        writePojo(newPojo);
    }

    protected abstract void writePojo(TransportPojo inPojo);
}
