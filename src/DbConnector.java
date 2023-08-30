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
  

  // Searching methods for the DB. 
  
	public static ResultSet getUserInfo (String UserName, Connection c) {
		
		Statement stmt = null; 
		ResultSet rs = null; 

		try {
			stmt = c.createStatement(); 
			String query = " SELECT 'User Email', 'User Name', Name, ID FROM Users WHERE 'User Name' = %s; "; 
			String q = String.format(query, UserName); 

			if (stmt.execute(q)) {
				rs = stmt.getResultSet(); 
				return rs; 
			}

		} catch (SQLException ex) {
			// Print the error message.
			System.out.println("SQLException: " + ex.getMessage());
		 	System.out.println("SQLState: " + ex.getSQLState());
		  System.out.println("VendorError: " + ex.getErrorCode());

		} finally {
			if (rs != null) {
				try {
					rs.close(); 
				} catch (SQLException ex) { } // Do nothing. 
				rs = null; 
			}
			if (stmt != null) {
				try {
					stmt.close(); 
				} catch (SQLException ex) { } // Do nothing. 
			}	
		}
    return rs; 
  }


	public static ResultSet getUsersBooks (String userName, Connection c) { 
		
		// Use a WHERE Statement based on the Id and UserName. 
    Statement stmt = null; 
		ResultSet rs = null;
    ResultSet r = null; 
    int Id; 

		try {
      
      // Get the ID for the current user.  
      r = getUserInfo(userName, c); 
      Id = getUserId(r); 
      
      // Query for the books. 
			String bookQuery = " SELECT `Author Name`, `Book Title`, `Page Count`, `Times Read` FROM `Books` WHERE `ID` = %s; \n"; 
      String fBookQuery = String.format(bookQuery, Integer.toString(Id)); 

			if (stmt.execute(fBookQuery)) {
				rs = stmt.getResultSet(); 
				return rs; 
			}
		} catch (SQLException ex) {
			// Print the error message.
			System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {
			if (rs != null) {
				try {
					rs.close(); 
				} catch (SQLException ex) { } // Do nothing. 
				rs = null; 
			}
			if (stmt != null) {
				try {
					stmt.close(); 
				} catch (SQLException ex) { } // Do nothing. 
				stmt = null; 
			}
      if (r != null){
        try{
          r.close(); 
        } catch (SQLException ex) {} // Do nothing. 
      }
		}
    return rs; 
  }
  
  // Wrapper methods for extracting data from the ResultSet object. 
  


  // Methods for modifying the DB. 


	public static boolean insertUser (String UserName, String Name, String Password, String Email) {

		Statement stmt = null; 
    try {
      String query =	"INSERT INTO `Users` (`User Name`, `Name`, `Password`, `Email`) \n VALUES ('%s', '%s', '%s', '%s'); "; 
      String fQuery = String.format(query, UserName, Name, Password, Email); 

      if (stmt.execute(fQuery)){
          return true; 
      }
	  }  catch (SQLException ex) {
			// Print the error message.
			System.out.println("SQLException: " + ex.getMessage());
		 	System.out.println("SQLState: " + ex.getSQLState());
		  System.out.println("VendorError: " + ex.getErrorCode());
      

		} finally {
			if (stmt != null) {
				try {
					stmt.close(); 
				} catch (SQLException ex) { } // Do nothing. 
			}	
    }

    // Return after resource is handled and Statment isn't executed. 
    return false; 
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
    
    d.closeDbConnection(); 
  } 
} 
