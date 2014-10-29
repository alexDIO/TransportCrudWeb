package transport.classes;

import hibernate.*;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class TransportConverter{
    private final TransportEntityFactory entityFactory;
    private final TransportFactory transportFactory;

    public TransportConverter(TransportEntityFactory entityFactory, TransportFactory transportFactory) {
        this.entityFactory = entityFactory;
        this.transportFactory = transportFactory;
    }

    public Transport convertPojoToTransport(TransportPojo inPojo) {
        Transport resultTransport = transportFactory.getTransport(inPojo.getTransportType());

        resultTransport.setId(inPojo.getId());
        resultTransport.setMark(inPojo.getMark());
        resultTransport.setColor(inPojo.getColor());
        resultTransport.setManufactureYear(inPojo.getManufactureYear());
        resultTransport.setEnergySource(inPojo.getEnergySource());

        if (resultTransport instanceof PassengerTransport) {
            ((PassengerTransport) resultTransport).setPassengersCount(inPojo.getPassengersCount());
            if (resultTransport instanceof PassengerCar) {
                ((PassengerCar) resultTransport).setTransmission(inPojo.getTransmission());
            }
        } else {
            ((Truck) resultTransport).setLoad(inPojo.getLoad());
        }

        return resultTransport;
    }

    public TransportPojo convertTransportToPojo(Transport inTransport) {
        TransportPojo resultPojo = new TransportPojo();

        resultPojo.setId(inTransport.getId());
        resultPojo.setTransportType(inTransport.getTransportType());
        resultPojo.setMark(inTransport.getMark());
        resultPojo.setColor(inTransport.getColor());
        resultPojo.setManufactureYear(inTransport.getManufactureYear());
        resultPojo.setEnergySource(inTransport.getEnergySource());
        if (inTransport instanceof PassengerTransport) {
            resultPojo.setPassengersCount(((PassengerTransport) inTransport).getPassengersCount());
            if (inTransport instanceof PassengerCar) {
                resultPojo.setTransmission(((PassengerCar) inTransport).getTransmission());
            }
        } else {
            resultPojo.setLoad(((Truck) inTransport).getLoad());
        }

        return resultPojo;
    }

    public Transport convertStringToTransport(String inString, String separator) {
        String[] array = inString.replace("\n", "").split(String.format("\\%s", separator));
        Transport resultTransport = transportFactory.getTransport(array[1]);

        resultTransport.setId(Integer.parseInt(array[0]));
        resultTransport.setMark(array[2]);
        resultTransport.setColor(array[3]);
        resultTransport.setManufactureYear(Integer.parseInt(array[4]));
        resultTransport.setEnergySource(array[6]);
        if (resultTransport instanceof PassengerTransport) {
            ((PassengerTransport) resultTransport).setPassengersCount(Integer.parseInt(array[5]));
            if (resultTransport instanceof PassengerCar) {
                ((PassengerCar) resultTransport).setTransmission(array[7]);
            }
        } else {
            ((Truck) resultTransport).setLoad(Integer.parseInt(array[8]));
        }

        return resultTransport;
    }

    public String convertTransportToString(Transport inTransport, String separator) {
        StringBuilder builder = new StringBuilder();

        builder.append(inTransport.getId());
        builder.append(separator);
        builder.append(inTransport.getTransportType());
        builder.append(separator);
        builder.append(inTransport.getMark());
        builder.append(separator);
        builder.append(inTransport.getColor());
        builder.append(separator);
        builder.append(inTransport.getManufactureYear());
        builder.append(separator);

        if (inTransport instanceof PassengerTransport) {
            builder.append(((PassengerTransport) inTransport).getPassengersCount());
        } else {
            builder.append(0);
        }

        builder.append(separator);
        builder.append(inTransport.getEnergySource());
        builder.append(separator);

        if (inTransport instanceof PassengerCar) {
            builder.append(((PassengerCar) inTransport).getTransmission());
        } else {
            builder.append("");
        }

        builder.append(separator);

        if (inTransport instanceof Truck) {
            builder.append(((Truck) inTransport).getLoad());
        } else {
            builder.append(0);
        }
        builder.append("\n");

        return builder.toString();
    }

    public String convertTransportToString(Transport inTransport, String separator, String delimiter) {
        StringBuilder builder = new StringBuilder();

        builder.append(inTransport.getId());
        builder.append(separator);
        builder.append(delimiter);
        builder.append(inTransport.getTransportType());
        builder.append(delimiter);
        builder.append(separator);
        builder.append(delimiter);
        builder.append(inTransport.getMark());
        builder.append(delimiter);
        builder.append(separator);
        builder.append(delimiter);
        builder.append(inTransport.getColor());
        builder.append(delimiter);
        builder.append(separator);
        builder.append(inTransport.getManufactureYear());
        builder.append(separator);

        if (inTransport instanceof PassengerTransport) {
            builder.append(((PassengerTransport) inTransport).getPassengersCount());
        } else {
            builder.append(0);
        }

        builder.append(separator);
        builder.append(delimiter);
        builder.append(inTransport.getEnergySource());
        builder.append(delimiter);
        builder.append(separator);
        builder.append(delimiter);

        if (inTransport instanceof PassengerCar) {
            builder.append(((PassengerCar) inTransport).getTransmission());
        } else {
            builder.append("");
        }

        builder.append(delimiter);
        builder.append(separator);

        if (inTransport instanceof Truck) {
            builder.append(((Truck) inTransport).getLoad());
        } else {
            builder.append(0);
        }

        return builder.toString();
    }

    public TransportEntity convertPojoToTransportEntity(TransportPojo inPojo) {
        TransportEntity resultTransport = entityFactory.getTransportEntity(inPojo.getTransportType());

        resultTransport.setId(inPojo.getId());
        resultTransport.setColor(inPojo.getColor());
        resultTransport.setManufactureYear(inPojo.getManufactureYear());
        resultTransport.setEnergySource(inPojo.getEnergySource());

        if (resultTransport instanceof PassengerTransportEntity) {
            ((PassengerTransportEntity) resultTransport).setPassengersCount(inPojo.getPassengersCount());
            if (resultTransport instanceof PassengerCarEntity) {
                ((PassengerCarEntity) resultTransport).setTransmission(inPojo.getTransmission());
            }
        } else {
            ((TruckEntity) resultTransport).setLoad(inPojo.getLoad());
        }

        return resultTransport;
    }

}
