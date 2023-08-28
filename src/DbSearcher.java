import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.ResultSet;

// A class exclusively for searching for information in the DB. 
public class DbSearcher {

  // Getter methods. 
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
  // These functions extract information from the ResultSet. 
	public static String getUserPass (ResultSet Rs) {
    try {
      return Rs.getString("Password");
    } catch(SQLException ex) {
      return "NULL"; 
    }
	}

  public static String getUserName(ResultSet Rs){
    try{
      return Rs.getString("User Name"); 
    } catch(SQLException ex){
      return "NULL"; 
    }
  }

  public static String getUserEmail(ResultSet Rs) {
    try {
      return Rs.getString("User Email"); 
    } catch (SQLException ex){
      return "NULL"; 
    }
  }

  public static int getUserId(ResultSet Rs){
    try {
      return Rs.getInt("ID"); 
    } catch (SQLException ex) {
      return -1; 
    }
  }


  public static void main(String[] args){

    DbConnector d = new DbConnector();
    DbSearcher dS = new DbSearcher(); 

		String url = "jdbc:mysql://localhost:3306/UserBooks";
		String user = "root"; 
		String pass = ""; 

	  d.openDbConnection(url, user, pass); 

    ResultSet r = null; 
    ResultSet rs = null; 

    r = dS.getUserInfo("shales_nuts", d.conn);
    rs = dS.getUserInfo("shales_balls", d.conn); 


    System.out.println("Uname(shales_nuts): " + getUserName(r)); 
    System.out.println("Email:" + getUserEmail(r)); 

    System.out.println("Uname(shales_balls)" + getUserName(rs)); 
    System.out.println("Email: " + getUserEmail(rs)); 
    
   d.closeDbConnection();  

  }



}

