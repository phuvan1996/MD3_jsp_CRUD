package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/crud_product";
    private static final String USERNAME = "root";
    private static final String PASS = "123456";
    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
           conn=DriverManager.getConnection(URL,USERNAME,PASS);

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement callst){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callst!=null){
            try {
                callst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
