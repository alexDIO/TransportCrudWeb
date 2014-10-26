package transport.storages;

import transport.TransportPropertiesHolder;

import java.io.IOException;
import java.util.Map;

/**
 * Created by olomakovskyi on 9/4/2014.
 */
public class TransportStorageFactory {

    private final TransportPropertiesHolder propertiesHolder;
    private final Map<String, TransportStorage> map;

    public TransportStorageFactory(TransportPropertiesHolder propertiesHolder, Map<String, TransportStorage> map) {
        this.map = map;
        this.propertiesHolder = propertiesHolder;
    }

    public TransportStorage getStorage() throws IOException, TransportStorageException {
       if (map.containsKey(propertiesHolder.getSource())) {
           return map.get(propertiesHolder.getSource());
       } else {
           throw new TransportStorageException();
       }
    }
}
