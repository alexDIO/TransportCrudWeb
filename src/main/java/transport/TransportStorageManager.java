package transport;

import java.io.IOException;
import transport.classes.Transport;
import transport.storages.*;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by olomakovskyi on 9/3/2014.
 */
public class TransportStorageManager {
    public static Map<Integer, Transport> storedCars;

    public static void main(String[] args) throws IOException {
        int nextID = 0;
        TransportStorage storage = null;
        try {
            storage = TransportStorageFactory.getStorage();
        } catch (TransportStorageException e) {
            System.out.println(e);
        }

        storedCars = storage.getAllTransport();

        if (storedCars.size() == 0) {
            System.out.println("There are no cars in storage.");
            nextID = 0;
        } else {
            for (Map.Entry<Integer, Transport> entry : storedCars.entrySet()) {
                System.out.println(entry.getValue());
            }
            nextID = Collections.max(storedCars.keySet()) + 1;
        }

        System.out.println("Enter 'add', 'update', delete', 'show all' or 'exit' for corresponding operation.");
        Scanner scanner = new Scanner(System.in);
        String inString;// = scanner.nextLine().toLowerCase();
        int enteredID;

        while (!"exit".equals(inString = scanner.nextLine().toLowerCase())) {
            switch (inString) {
                case "add":
//                    storage.addTransport(nextID++);
                    System.out.println("Successfully added.");
                    break;
                case "update":
                    System.out.println("Enter target's id.");
                    enteredID = Integer.parseInt(scanner.nextLine());
                    if (storedCars.containsKey(enteredID)) {
                        storage.updateTransport(enteredID);
                        System.out.println("Successfully updated.");
                    } else {
                        System.out.println("Incorrect id.");
                    }
                    break;
                case "delete":
                    System.out.println("Enter target's id.");
                    enteredID = Integer.parseInt(scanner.nextLine());
                    if (storedCars.containsKey(enteredID)) {
                        storage.deleteTransport(enteredID);
                        storedCars.remove(enteredID);
                        System.out.println("Successfully deleted.");
                    } else {
                        System.out.println("Incorrect id.");
                    }
                    break;
                case "show all":
                    storedCars = storage.getAllTransport();
                    for (Map.Entry<Integer, Transport> entry : storedCars.entrySet()) {
                        System.out.println(entry.getValue());
                    }
                    break;
                default:
                    System.out.println("Incorrect command.");
            }
//            inString = scanner.nextLine().toLowerCase();
        }
    }
}
