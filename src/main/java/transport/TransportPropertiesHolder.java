package transport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by olomakovskyi on 9/3/2014.
 */
public class TransportPropertiesHolder {
//    private static final String PROPERTIES_FILE_NAME = "transport.properties";
    private static final String SOURCE = "source";
    private static final String CSV_FILENAME = "csv.filename";
    private static final String TEXT_FILENAME = "text.filename";
    private static final String TEXT_SEPARATOR = "text.separator";
    private static final String XLS_FILENAME = "xls.filename";
    private static final String XLS_SHEET_NAME = "xls.sheet.name";
    private static final String DRIVER_SYBASE = "driver.sybase";
    private static final String CONNECTION_URL = "connection.url";
    private static final String CONNECTION_LOGIN = "connection.login";
    private static final String CONNECTION_PASSWORD = "connection.password";
    private static final String SQL_DELETE = "sql.delete";
    private static final String SQL_INSERT = "sql.insert";
    private static final String SQL_SELECT = "sql.select";
    private static final String SQL_DELETE_PREPARED = "sql.delete.prepared";
    private static final String SQL_INSERT_PREPARED = "sql.insert.prepared";

    private final Properties transportProperties;

    public TransportPropertiesHolder(String fileName) throws IOException {
        transportProperties = new Properties();
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        transportProperties.load(stream);
    }

    public String getSource() {
        return String.valueOf(transportProperties.getProperty(SOURCE));
    }

    public String getCsvFilename() {
        return String.valueOf(transportProperties.getProperty(CSV_FILENAME));
    }

    public String getTextFilename() {
        return String.valueOf(transportProperties.getProperty(TEXT_FILENAME));
    }

    public String getTextSeparator() {
        return String.valueOf(transportProperties.getProperty(TEXT_SEPARATOR));
    }

    public String getXlsFilename() {
        return String.valueOf(transportProperties.getProperty(XLS_FILENAME));
    }

    public String getXlsSheetName() {
        return String.valueOf(transportProperties.getProperty(XLS_SHEET_NAME));
    }

    public String getDriverSybase() {
        return String.valueOf(transportProperties.getProperty(DRIVER_SYBASE));
    }

    public String getConnectionUrl() {
        return String.valueOf(transportProperties.getProperty(CONNECTION_URL));
    }

    public String getConnectionLogin() {
        return String.valueOf(transportProperties.getProperty(CONNECTION_LOGIN));
    }

    public String getConnectionPassword() {
        return String.valueOf(transportProperties.getProperty(CONNECTION_PASSWORD));
    }

    public String getSqlDelete() {
        return String.valueOf(transportProperties.getProperty(SQL_DELETE));
    }

    public String getSqlInsert() {
        return String.valueOf(transportProperties.getProperty(SQL_INSERT));
    }

    public String getSqlSelect() {
        return String.valueOf(transportProperties.getProperty(SQL_SELECT));
    }

    public String getSqlDeletePrepared() {
        return String.valueOf(transportProperties.getProperty(SQL_DELETE_PREPARED));
    }

    public String getSqlInsertPrepared() {
        return String.valueOf(transportProperties.getProperty(SQL_INSERT_PREPARED));
    }
}
