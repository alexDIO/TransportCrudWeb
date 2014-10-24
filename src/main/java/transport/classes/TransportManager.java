package transport.classes;

import hibernate.PassengerCarEntity;
import hibernate.PassengerTransportEntity;
import hibernate.TransportEntity;
import hibernate.TruckEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by olomakovskyi on 8/19/2014.
 */
public class TransportManager {
    public static Transport createTransport(int id) {
//        if (true) {
//            //mock data
//            Coupe resultAutomobile = new Coupe(id);
//            resultAutomobile.setMark("test");
//            resultAutomobile.setColor("White");
//            resultAutomobile.setManufactureYear(1900);
//            resultAutomobile.setEnergySource("Petrol");
//            resultAutomobile.setTransmission("Manual");
//
//            return resultAutomobile;
//        }
        String[] allowedTransportTypesArray = {"coupe", "sedan", "limousine", "truck", "bus", "trolleybus", "tram"};

        List<String> allowedTransportTypes = Arrays.asList(allowedTransportTypesArray);
        String inTransportType;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose transport type: Coupe/Sedan/Limousine/Truck/Bus/TrolleyBus/Tram");
            inTransportType = scanner.next();
            if (allowedTransportTypes.contains(inTransportType)) {
                break;
            } else {
                System.out.println("Illegal transport type!");
            }
        }

        Transport inTransport = TransportFactory.getTransport(inTransportType, id);

        System.out.println("Enter mark of transport");
        inTransport.setMark(scanner.next());

        System.out.println("Enter color of transport");
        inTransport.setColor(scanner.next());

        System.out.println("Enter manufacture year of transport");
        inTransport.setManufactureYear(Integer.parseInt(scanner.next()));

        if (inTransport instanceof PassengerTransport) {
            if (!(inTransport instanceof Coupe || inTransport instanceof Sedan)) {
                System.out.println("Enter passengers count of transport");
                ((PassengerTransport) inTransport).setPassengersCount(Integer.parseInt(scanner.next()));
            }
            if (inTransport instanceof PassengerCar) {
                System.out.println("Enter energy source of transport");
                inTransport.setEnergySource(scanner.next());
                System.out.println("Enter transmission type");
                ((PassengerCar) inTransport).setTransmission(scanner.next());
            }
        } else {
            System.out.println("Enter load of transport");
            ((Truck) inTransport).setLoad(Integer.parseInt(scanner.next()));
        }

//        scanner.close();

        return inTransport;
    }

    public static Transport updateTransport(Transport targetTransport) {

        Scanner scanner = new Scanner(System.in);

        List<String> allowedTargetsToChange = new ArrayList<>();
        allowedTargetsToChange.add("color");
        if (targetTransport instanceof PassengerTransport) {
            if (!(targetTransport instanceof Coupe || targetTransport instanceof Sedan)) {
                allowedTargetsToChange.add("passengers_count");
            }
            if (targetTransport instanceof PassengerCar) {
                allowedTargetsToChange.add("energy_source");
                allowedTargetsToChange.add("transmission");
            }
        } else {
            allowedTargetsToChange.add("load");
        }

        String target;

        while (true) {
            System.out.println("Choose target to update. Allowed targets: ");
            for (String elem : allowedTargetsToChange) {
                System.out.println(String.format("%s ", elem));
            }
            target = scanner.next().toLowerCase();
            if (allowedTargetsToChange.contains(target)) {
                break;
            } else {
                System.out.println("Illegal target!");
            }
        }

        System.out.println("Enter new value.");
        String newValue = scanner.next();

        switch (target) {
            case "color":
                targetTransport.setColor(newValue);
                break;
            case "passengers count":
                ((PassengerTransport) targetTransport).setPassengersCount(Integer.parseInt(newValue));
                break;
            case "energy source":
                targetTransport.setEnergySource(newValue);
                break;
            case "transmission":
                ((PassengerCar) targetTransport).setTransmission(newValue);
                break;
            case "load":
                ((Truck) targetTransport).setLoad(Integer.parseInt(newValue));
        }

        return targetTransport;
    }

    public static Transport convertPojoToTransport(TransportPojo inPojo) {
        Transport resultTransport = TransportFactory.getTransport(inPojo.getTransportType(), inPojo.getId());

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

    public static TransportPojo convertTransportToPojo(Transport inTransport) {
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

    public static Transport convertStringToTransport(String inString, String separator) {
        String[] array = inString.split(String.format("\\%s", separator));
        Transport resultTransport = TransportFactory.getTransport(array[1], Integer.parseInt(array[0]));

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

    public static String convertTransportToString(Transport inTransport, String separator) {
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

        return builder.toString();
    }

    public static String convertTransportToString(Transport inTransport, String separator, String delimiter) {
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

    public static TransportEntity convertPojoToTransportEntity(TransportPojo inPojo) {
        TransportEntity resultTransport = TransportFactory.getTransportEntity(inPojo.getTransportType());

        resultTransport.setId(inPojo.getId());
        resultTransport.setMark(inPojo.getMark());
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
