import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.ResultSet;

public class DbManager {	

  private static Connection conn;
  public static String Username; 

	// Database Connection Managers. 
  public static void openDbConnection (String url, String user, String pass) {
		System.out.println("Establishing a connection to the DB...");
		try {
			conn = DriverManager.getConnection(url, user, pass); 

		} catch (SQLException ex){
      System.out.println("Couldn't connect to the DB."); 
      System.err.println("SQL State:" + ex.getSQLState()); 
			System.out.println("Message:" + ex.getMessage()); 
		}
	}

  public static void closeDbConnection () {
		System.out.println("Closing the DB connection..."); 
		if (conn != null) {
			try {
			conn.close(); 

			} catch (SQLException ex){
				System.out.println("Couldn't close the DB connection.");
        System.err.println("SQL State:" + ex.getSQLState()); 
				System.out.println("Message:" + ex.getMessage()); 
			}
		}
	}


  public static void main(String[] args){
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception x){
			System.err.println(x.getMessage()); 
		}
    
  } 
} 
