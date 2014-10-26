package transport;

import java.sql.*;

/**
* Created by olomakovskyi on 9/2/2014.
*/
public class DataBaseService {
    private final PreparedStatement insertStatement;
    private final PreparedStatement deleteStatement;
    private final PreparedStatement selectStatement;

    public DataBaseService(String driverName, String databaseURL, String databaseLogin, String databasePassword, String insertStatement, String deleteStatement,
                           String selectStatement) throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        //connection to server
        Connection conn = DriverManager.getConnection(databaseURL, databaseLogin, databasePassword);
        this.insertStatement = conn.prepareStatement(insertStatement);
        this.deleteStatement = conn.prepareStatement(deleteStatement);
        this.selectStatement = conn.prepareStatement(selectStatement);
    }

    public void executePreparedInsert(int id, String transportType, String mark, String color, int manufactureYear, int passengersCount, String energySource, String transmission, int load) throws SQLException {
        insertStatement.setInt(1, id);
        insertStatement.setString(2, transportType);
        insertStatement.setString(3, mark);
        insertStatement.setString(4, color);
        insertStatement.setInt(5, manufactureYear);
        insertStatement.setInt(6, passengersCount);
        insertStatement.setString(7, energySource);
        insertStatement.setString(8, transmission);
        insertStatement.setInt(9, load);
        insertStatement.execute();
    }

    public void executePreparedDelete(int condition) throws SQLException {
        deleteStatement.setInt(1, condition);
        deleteStatement.execute();
    }

    public ResultSet executePreparedSelect() throws SQLException {
        //ResultSet rs = selectStatement.executeQuery();
        return selectStatement.executeQuery();
    }
}
