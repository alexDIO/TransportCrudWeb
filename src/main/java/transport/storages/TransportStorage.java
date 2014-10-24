package transport.storages;

import transport.classes.TransportPojo;
import transport.classes.Transport;

import java.io.IOException;
import java.util.Map;

/**
 * Created by olomakovskyi on 9/3/2014.
 */
public interface TransportStorage {
    public void addTransport(TransportPojo inPojo) throws IOException;

    public void deleteTransport(int id) throws IOException;

    public Map<Integer, Transport> getAllTransport() throws IOException;
}
