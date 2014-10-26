package transport.classes;

import java.util.Map;

/**
 * Created by olomakovskyi on 9/5/2014.
 */
public class TransportFactory {
    private Map<String, Transport> map;

    public TransportFactory(Map<String, Transport> map){
        this.map = map;
    }

    public Transport getTransport(String transportType) {
        return map.get(transportType.toLowerCase());
    }
}
