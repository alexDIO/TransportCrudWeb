package transport.storages;

import transport.TransportPropertiesHolder;

import java.io.IOException;

/**
 * Created by olomakovskyi on 9/4/2014.
 */
public class TransportStorageFactory {
    //pattern factory
    public static TransportStorage getStorage() throws IOException, TransportStorageException {
        TransportPropertiesHolder propertiesHolder = new TransportPropertiesHolder();
        switch (propertiesHolder.getSource().toLowerCase()) {
            case "csv":
                return new TransportStorageCSV();
            case "txt":
                return new TransportStorageTXT();
            case "xls":
                return new TransportStorageXLS();
            case "db":
                return new TransportStorageDB();
            case "db.prepared":
                return new TransportStorageDBPrepared();
            case "hibernate":
                return new TransportStorageHibernate();
            default:
                throw new TransportStorageException();
        }
    }
}
