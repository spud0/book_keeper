import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

// TODO
//  - Establish connection with the database 
//  - Probably install MariaDB database driver instead of "DriverManager"
//  - Write a constructor? Let the compiler do it? 

public class BookManager {	
	
	private static Connection conn; 

	public static void openDbConnection(String url) {
		System.out.println("Establishing a connection to the DB...");
		try {
			conn = DriverManager.getConnection(url); 

		} catch (SQLException ex){
			System.err.println("SQL State:" + ex.getSQLState()); 
			System.out.println("Message:" + ex.getMessage()); 
		}
	}

	public static void closeDbConnection() {
		System.out.println("Closing the DB connection"); 
		try {
			conn.close(); 

		} catch (SQLException ex){
			System.err.println("SQL State:" + ex.getSQLState()); 
			System.out.println("Message:" + ex.getMessage()); 
		}
	}

	
	public static void main(String[] args){
		BookManager bm = new BookManager(); 
		String url = "jdbc:mariadb://localhost:3306/BookKeeper"; 
		bm.openDbConnection(url); 

		// DO SQL statement things...
	
		bm.closeDbConnection();
	}

}
