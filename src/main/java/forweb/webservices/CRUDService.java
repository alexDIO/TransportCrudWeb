package forweb.webservices;

import forweb.TransportMapHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import transport.classes.Sedan;
import transport.classes.Transport;
import transport.storages.TransportStorage;
import transport.storages.TransportStorageException;
import transport.storages.TransportStorageFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by olomakovskyi on 10/30/2014.
 */

@Component
@Path("/")
public class CRUDService {

    @Autowired
    private TransportMapHolder mapHolder;


    @GET
    @Path("/all")
    @Produces("application/json")
    public Map<Integer, Transport> getTransportMap() throws IOException {
        if (mapHolder != null) {
            return mapHolder.getMap();
        } else {
            return null;
        }
    }
}
