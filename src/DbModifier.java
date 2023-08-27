import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.ResultSet;


public class DbModifier {

  // Insert Functions. 

	public static void insertUser (String UserName, String Name, String Password, String Email) {

		Statement stmt = null; 
	  String query =	"INSERT INTO `Users` (``, ``, ``, ``) \n VALUES ('', '', '', ''); "; 
	}

	public static void insertBooks (String UserName, int Id) {

	}


	// Remove Functions. 
	
	public static void removeUser (String UserName, int Id) {
		
		// SELECT? 
  }
  public static void removeBooks(String UserName, int Id){


  }


  public static void main(String[] args){
  }
}

