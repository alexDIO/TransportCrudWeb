package transport.storages;

import transport.*;
import transport.classes.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
* Created by olomakovskyi on 9/11/2014.
*/
public class TransportStorageDBPrepared extends TransportStorageDBAbstract {
    private final TransportPropertiesHolder propertiesHolder;
    private final TransportConverter converter;
    private static DataBaseService databaseService;

    public TransportStorageDBPrepared(TransportPropertiesHolder propertiesHolder, TransportConverter converter) {
        super(converter);
        this.propertiesHolder = propertiesHolder;
        this.converter = converter;
    }

    @Override
    public void deleteTransport(int id) throws IOException {

        try {
            databaseService = new DataBaseService(propertiesHolder.getDriverSybase(), propertiesHolder.getConnectionUrl(), propertiesHolder.getConnectionLogin(),
                    propertiesHolder.getConnectionPassword(), propertiesHolder.getSqlInsertPrepared(), propertiesHolder.getSqlDeletePrepared(), propertiesHolder.getSqlSelect());
            databaseService.executePreparedDelete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<Integer, Transport> getAllTransport() throws IOException {
        Map<Integer, Transport> resultMap = new HashMap<>();
        TransportPojo newPojo;
        try {

            databaseService = new DataBaseService(propertiesHolder.getDriverSybase(), propertiesHolder.getConnectionUrl(), propertiesHolder.getConnectionLogin(),
                    propertiesHolder.getConnectionPassword(), propertiesHolder.getSqlInsertPrepared(), propertiesHolder.getSqlDeletePrepared(), propertiesHolder.getSqlSelect());

//            Class.forName(propertiesHolder.getDriverSybase());
//
//            Connection conn = DriverManager.getConnection(propertiesHolder.getConnectionUrl(), propertiesHolder.getConnectionLogin(), propertiesHolder.getConnectionPassword());
//
//            databaseService.executePreparedSelect();

            ResultSet selectResult = databaseService.executePreparedSelect();

//            Statement statement = conn.createStatement();
//
//            ResultSet selectResult = statement.executeQuery(propertiesHolder.getSqlSelect());

            while (selectResult.next()) {
                newPojo = new TransportPojo(selectResult.getInt(1), selectResult.getString(2), selectResult.getString(3), selectResult.getString(4), selectResult.getInt(5),
                        selectResult.getInt(6), selectResult.getString(7), selectResult.getString(8), selectResult.getInt(9));
                resultMap.put(newPojo.getId(), converter.convertPojoToTransport(newPojo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @Override
    protected void writePojo(TransportPojo inPojo) {

        try {
            databaseService = new DataBaseService(propertiesHolder.getDriverSybase(), propertiesHolder.getConnectionUrl(), propertiesHolder.getConnectionLogin(),
                    propertiesHolder.getConnectionPassword(), propertiesHolder.getSqlInsertPrepared(), propertiesHolder.getSqlDeletePrepared(), propertiesHolder.getSqlSelect());
            databaseService.executePreparedInsert(inPojo.getId(), inPojo.getTransportType(), inPojo.getMark(), inPojo.getColor(), inPojo.getManufactureYear(), inPojo.getPassengersCount(),
                    inPojo.getEnergySource(), inPojo.getTransmission(), inPojo.getLoad());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
