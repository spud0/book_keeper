import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

// TODO
//  - Write statements for the Database. 
//  	- INSERT's, JOIN's, etc. 
//
//  - Test. 

public class BookManager {	
	
	// Fields. 
	private static Connection conn; 
	public static String Username; 
	// public static 


	// Database Connection Managers. 
	
	public static void openDbConnection (String url, String user, String pass) {
		System.out.println("Establishing a connection to the DB...");
		try {
			conn = DriverManager.getConnection(url, user, pass); 

		} catch (SQLException ex){
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
				ex.printStackTrace(); 
				System.err.println("SQL State:" + ex.getSQLState()); 
				System.out.println("Message:" + ex.getMessage()); 
			}
		}
	}

	// Database Information Retrievers. 

	public static String getUserPass (String UserName) {
	
	}


	public static ResultSet getUserInfo (String UserName) {
		
		Statement stmt = null; 
		ResultSet rs = null; 
		try {
			stmt = conn.createStatement(); 
			String query = """
				       	SELECT 'User Email', 'User Name', Name, ID 
				       	FROM Users WHERE 'User Name' = %s;
				       """;

			String q = String.format(query, UserName); 

			if (stmt.execute(q) {
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
			if (rs != null) {
				try {
					rs.close(); 
				} catch (SQLException ex) { } // Do nothing. 
			}	
		}
	}

	public static ResultSet getUsersBooks (String UserName) { 
		
		// Use a JOIN Statement 
		Statement stmt = null;
		ResultSet rs = null; 

		try {
			stmt = conn.createStatement(); 
			String query = """

				       """;

			if (stmt.execute(query) {
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
			if (rs != null) {
				try {
					rs.close(); 
				} catch (SQLException ex) { } // Do nothing. 
				stmt = null; 
			}
		}
	}
	// Database Modifiers. Insert Functions. 

	public static void insertUser (String UserName) {

		Statement stmt = null; 
		"INSERT INTO Users () VALUES"; 
	}

	public static void insertBooks (String UserName) {

	}


	// Remove Functions. 
	
	public static void removeUser (String UserName) {
		
		// SELECT? 
	}
	

	public static void main(String[] args){
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception x){
			System.err.println(x.getMessage()); 
		}
		BookManager bm = new BookManager(); 
		String url = "jdbc:mysql://localhost:3306/UserBooks";
		String user = "root"; 
		String pass = ""; 

		bm.openDbConnection(url, user, pass); 

		// DO SQL statement things...
	
		bm.closeDbConnection();
	}

}
