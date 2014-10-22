package transport.classes;

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
}
