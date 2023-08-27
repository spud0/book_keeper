import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.ResultSet;

// A class exclusively for searching for information in the DB. 
public class DbSearcher {

  // Getter methods. 
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
  
  
	public static ResultSet getUsersBooks (String UserName, int Id) { 
		
		// Use a WHERE Statement based on the Id and UserName. 
		Statement idStmt = null;
    Statement bookStmt = null; 
		ResultSet rs = null; 

		try {

      // Query for the ID for the proviced UserName. 
			idStmt = conn.createStatement(); 
      String idQuery = "SELECT `ID` FROM `Users` WHERE `User Name` = %s \n"; 
      String fIdQuery = String.format(idQuery, UserName); 

      // Query for the books. 
			String bookQuery = " SELECT `Author Name`, `Book Title`, `Page Count`, `Times Read` FROM `Books` WHERE `ID` = %s; \n"; 
      String fQuery = String.format(bookQuery, Integer.toString(Id)); 

			if (idStmt.execute(fIdQuery) {
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

	public static String getUserPass (ResultSet Rs) {
    return Rs.getString("Password"); 
	}

  public static String getUserName(ResultSet Rs){
    return Rs.getString("User Name"); 
  }

  public static void main(String[] args){

  }


}

