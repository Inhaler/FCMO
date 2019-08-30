package helpers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {

	 public static Connection conn = null;

	    public static void DBConnect() throws ClassNotFoundException {
	        Class.forName("com.microsoft.sqlserver.SQLServerDriver");
	        String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
	        String user = "sa";
	        String pass = "root";
	        try {
	            conn = DriverManager.getConnection(dbURL, user, pass);
	            DatabaseMetaData ds = (DatabaseMetaData) conn.getMetaData();
	            System.out.println("Driver name: " + ds.getDriverName());
	            System.out.println("Driver version: " + ds.getDriverVersion());
	            System.out.println("Product name: " + ds.getDatabaseProductName());
	            System.out.println("Product version: " + ds.getDatabaseProductVersion());
	        } catch (Exception ex) {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (Exception exs) {
	                System.out.println(exs.getMessage());
	            }
	        }
	    }

	    public static void DBClose() {
	        try {
	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static void executeQuery(String qry) {
	        try {
	            PreparedStatement preSt = conn.prepareStatement(qry);
	            preSt.execute();
	            ResultSet rs = preSt.executeQuery();
//	            while(rs.next()){
//	            
//	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	
}
