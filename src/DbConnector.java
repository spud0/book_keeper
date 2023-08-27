import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.ResultSet;

public class DbConnector {	

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
    
    DbConnector d = new DbConnector(); 

		String url = "jdbc:mysql://localhost:3306/UserBooks";
		String user = "root"; 
		String pass = ""; 

	  d.openDbConnection(url, user, pass); 

		// DO SQL statement things...
    Statement s = null; 
    ResultSet r = null; 

		try {
      s = conn.createStatement(); 
			String query = "SELECT * FROM `Users`";

			if (s.execute(query)) {
				r = s.getResultSet(); 
			}

      // handle the ResultSet
      //
      while (r.next()){

        int id = r.getInt("ID"); 
        String un = r.getString("User Name"); 
        String n = r.getString("Name"); 
        String p = r.getString("Password"); 
        String e = r.getString("User Email");  

        System.out.println("id: " + id); 
        System.out.println("Uname: " + un); 
        System.out.println("Name: " + n);
        System.out.println("Pass: " + p); 
        System.out.println("Email: " + e); 
      }

      
		} catch (SQLException ex) {
			// Print the error message.
			System.out.println("SQLException: " + ex.getMessage());
		  System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {
			if (s != null) {
				try {
					s.close(); 
				} catch (SQLException ex) { } // Do nothing. 
				s = null; 
			}

      if (r != null){
        try{
          r.close(); 
        } catch (SQLException ex) {}
      }
		}
	
		d.closeDbConnection(); 
  }
}
