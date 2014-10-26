package hibernate;

import java.util.Map;

/**
 * Created by Alex on 10/25/2014.
 */
public class TransportEntityFactory {
    private Map<String, TransportEntity> map;

    public TransportEntityFactory(Map<String, TransportEntity> map){
        this.map = map;
    }

    public TransportEntity getTransportEntity(String transportType) {
        return map.get(transportType.toLowerCase());
    }
}
