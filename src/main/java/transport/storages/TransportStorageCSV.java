package transport.storages;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import transport.*;
import transport.classes.Transport;
import transport.classes.TransportConverter;
import transport.classes.TransportPojo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by olomakovskyi on 9/3/2014.
 */
public class TransportStorageCSV implements TransportStorage {
    private final TransportPropertiesHolder propertiesHolder;
    private final TransportConverter converter;

    public TransportStorageCSV(TransportPropertiesHolder propertiesHolder, TransportConverter converter) {
        this.propertiesHolder = propertiesHolder;
        this.converter = converter;
    }

    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {

        //creation of Transport Object and Pojo for writing to csv
        Transport newTransport = converter.convertPojoToTransport(inPojo);
        TransportPojo newPojo = converter.convertTransportToPojo(newTransport);

        //getting of all existing pojo from file
        Map<Integer, TransportPojo> pojoMap = getAllPojoFromFile();
        pojoMap.put(newPojo.getId(), newPojo);

        writeAllPojoToFile(pojoMap);
    }

    @Override
    public void deleteTransport(int id) throws IOException {
        Map<Integer, TransportPojo> pojoMap = getAllPojoFromFile();
        pojoMap.remove(id);
        writeAllPojoToFile(pojoMap);

    }

    @Override
    public Map<Integer, Transport> getAllTransport() throws IOException {
        Map<Integer, Transport> resultMap = new HashMap<>();
        Map<Integer, TransportPojo> pojoMap = getAllPojoFromFile();

        if (pojoMap.size() > 0) {
            for (Map.Entry<Integer, TransportPojo> entry : pojoMap.entrySet()) {
                resultMap.put(entry.getKey(), converter.convertPojoToTransport(entry.getValue()));
            }
        }
        return resultMap;
    }

    private Map<Integer, TransportPojo> getAllPojoFromFile() throws IOException {
        Map<Integer, TransportPojo> resultMap = new HashMap<>();

        File transportFile = new File(propertiesHolder.getCsvFilename());

        if (transportFile.exists()) {

            ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(propertiesHolder.getCsvFilename()), CsvPreference.STANDARD_PREFERENCE);

            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getTransportProcessor();

            TransportPojo inPojo;
            if (header != null) {
                while ((inPojo = beanReader.read(TransportPojo.class, header, processors)) != null) {
                    resultMap.put(inPojo.getId(), inPojo);
                }
            }
        }
        return resultMap;
    }

    private void writeAllPojoToFile(Map<Integer, TransportPojo> inMap) throws IOException {
        File transportFile = new File(propertiesHolder.getCsvFilename());
        if (!transportFile.exists()) {
            transportFile.createNewFile();
        }

        //creation of the writer
        ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter(propertiesHolder.getCsvFilename()), CsvPreference.STANDARD_PREFERENCE);

        //creation of the header
        final String[] header = {"ID", "TransportType", "Mark", "Color", "ManufactureYear", "PassengersCount", "EnergySource", "Transmission", "Load"};
        final CellProcessor[] transportProcessor = getTransportProcessor();

        //writing the header
        beanWriter.writeHeader(header);

        for (Map.Entry<Integer, TransportPojo> entry : inMap.entrySet()) {
            beanWriter.write(entry.getValue(), header, transportProcessor);
        }

        if (beanWriter != null) {
            beanWriter.close();
        }
    }

    private static CellProcessor[] getTransportProcessor() {
        CellProcessor[] transportProcessor = new CellProcessor[]{
                new ParseInt(),  // id
                new NotNull(), // transport type
                new Optional(), // mark
                new NotNull(),  // color
                new ParseInt(),  // manufacture year
                new ParseInt(), // passengers count
                new Optional(), // energy source
                new Optional(), // transmission
                new ParseInt() // load
        };

        return transportProcessor;
    }
}
