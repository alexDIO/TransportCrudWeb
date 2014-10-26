package transport.storages;

import transport.*;
import transport.classes.*;


import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 9/7/2014.
 */
public class TransportStorageTXT implements TransportStorage {
    private final TransportPropertiesHolder propertiesHolder;
    private final TransportConverter converter;

    public TransportStorageTXT(TransportPropertiesHolder propertiesHolder,TransportConverter converter , Date creationDate){
        this.propertiesHolder = propertiesHolder;
        this.converter = converter;
        System.out.println(String.format("Storage was created at %s", creationDate));
    }

    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {
        //getting of all existing pojo from file
        Map<Integer, String> stringMap = getAllFromFile();
        Map<Integer, Transport> transportMap = new HashMap<>();

        if (stringMap.size() > 0) {
            for (Map.Entry<Integer, String> entry : stringMap.entrySet()) {
                transportMap.put(entry.getKey(), converter.convertStringToTransport(entry.getValue(), propertiesHolder.getTextSeparator()));
            }

        }

        Transport newTransport = converter.convertPojoToTransport(inPojo);
        String newString = converter.convertTransportToString(newTransport, propertiesHolder.getTextSeparator());

        stringMap.put(inPojo.getId(), newString);

        writeAllToFile(stringMap);
    }

    @Override
    public void deleteTransport(int id) throws IOException {
        Map<Integer, String> stringMap = getAllFromFile();
        stringMap.remove(id);
        writeAllToFile(stringMap);
    }

    @Override
    public Map<Integer, Transport> getAllTransport() throws IOException {
        Map<Integer, Transport> resultMap = new HashMap<>();
        Map<Integer, String> strings = getAllFromFile();

        for (Map.Entry<Integer, String> entry : strings.entrySet()) {
            resultMap.put(entry.getKey(), converter.convertStringToTransport(entry.getValue(), propertiesHolder.getTextSeparator()));
        }

        return resultMap;
    }

    public Map<Integer, String> getAllFromFile() throws IOException {
        Map<Integer, String> resultMap = new HashMap<>();

        File transportFile = new File(propertiesHolder.getTextFilename());
        if (transportFile.exists()) {
            String s;
            String id;

            BufferedReader in = new BufferedReader(new FileReader(transportFile.getAbsoluteFile()));

            while ((s = in.readLine()) != null) {
                id = s.substring(0, s.indexOf(propertiesHolder.getTextSeparator()));
                resultMap.put(Integer.parseInt(id), s + "\n");
            }
        }
        return resultMap;
    }

    public void writeAllToFile(Map<Integer, String> inMap) throws IOException {
        File transportFile = new File(propertiesHolder.getTextFilename());
        if (!transportFile.exists()) {
            transportFile.createNewFile();
        }

        PrintWriter writer = new PrintWriter(transportFile.getAbsoluteFile());
        for (Map.Entry<Integer, String> entry : inMap.entrySet()) {
            writer.write(entry.getValue());
        }
        writer.close();
    }
}
