package sqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTesting {

    public static void main(String[] args) throws SQLException {
		/*
		 * try { // Provide the SQL command as an argument if (args.length < 1) {
		 * System.out.println("Usage: DatabaseTesting <SQL_Command>"); return; }
		 * String sqlCommand = args[0];
		 * DB(sqlCommand);
		 * 
		 */
            
            String sqlCommand = "select * from EPS_QA.config.tblAppSetting tas where [Key] ='StartMocking'"; //args[0];
            DB(sqlCommand);
        
    }

    public static void DB(String sqlCommand) throws SQLException {
        final String DB_URL = "jdbc:sqlserver://10.12.2.80:1433";
        final String user = "CS_Reader";
        final String pass = "R3ad3r";
        Connection conn = null;
        Statement stmt = null;

        try {
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, user, pass);

            // Execute a query
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sqlCommand);

            /** Extract and Single column data data
            while (result.next()) {
                int status = result.getInt(1);
                System.out.println(status);
             
             **/   
                
            // Get column count and names
            int columnCount = result.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(result.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            // Print data
            while (result.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }
			
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
