import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 


public class DbModifier {

  // Both functions should be called after a connection is made

  // Consider not using this function
	public static String getUserPass (String UserName) {
	
	}


	public static ResultSet getUserInfo (String UserName) {
		
		Statement stmt = null; 
		ResultSet rs = null; 

		try {
			stmt = conn.createStatement(); 
			String query = " SELECT 'User Email', 'User Name', Name, ID FROM Users WHERE 'User Name' = %s; "; 
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
			if (stmt != null) {
				try {
					stmt.close(); 
				} catch (SQLException ex) { } // Do nothing. 
			}	
		}
	}

	public static ResultSet getUsersBooks (String UserName, int Id) { 
		
		// Use a JOIN Statement 
		Statement stmt = null;
		ResultSet rs = null; 

		try {
			stmt = conn.createStatement(); 
			String query = " SELECT `Author Name`, `Book Title`, `Page Count`, `Times Read` FROM `Books` WHERE `ID` = %s; "; 

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
			if (stmt != null) {
				try {
					stmt.close(); 
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
	
	public static void removeUser (String UserName, int Id) {
		
		// SELECT? 
  }
  
  public static void main(String[] args){
  }
}

