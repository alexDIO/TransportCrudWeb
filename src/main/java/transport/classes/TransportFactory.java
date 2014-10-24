package transport.classes;

import hibernate.*;

/**
 * Created by olomakovskyi on 9/5/2014.
 */
public class TransportFactory {
    public static Transport getTransport(String transportType, Integer id) {
        switch (transportType.trim().toLowerCase()) {
            case "coupe":
                return new Coupe(id);
            case "sedan":
                return new Sedan(id);
            case "limousine":
                return new Limousine(id);
            case "truck":
                return new Truck(id);
            case "bus":
                return new Bus(id);
            case "trolleybus":
                return new TrolleyBus(id);
            case "tram":
                return new Tram(id);
        }
        return null;
    }

    public static TransportEntity getTransportEntity(String transportType) {
        switch (transportType.trim().toLowerCase()) {
            case "coupe":
                return new CoupeEntity();
            case "sedan":
                return new SedanEntity();
            case "limousine":
                return new LimousineEntity();
            case "truck":
                return new TruckEntity();
            case "bus":
                return new BusEntity();
            case "trolleybus":
                return new TrolleybusEntity();
            case "tram":
                return new TramEntity();
        }
        return null;
    }
}
