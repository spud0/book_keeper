import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.ResultSet;


// A class exclusively for inserting and removing data from the DB. 
public class DbModifier {

  // Insert Functions. 
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

	public static boolean insertBooks (String UserName, int Id) {
    
		Statement stmt = null; 
    try {
      // Change the query here. 
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


	// Remove Functions. 
	
	public static void removeUser (String UserName, int Id) {
		
  }

  
  public static void removeBooks(String UserName, int Id){


  }


  public static void main(String[] args){

  }
}

