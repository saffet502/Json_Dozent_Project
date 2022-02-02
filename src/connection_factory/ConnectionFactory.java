package connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public ConnectionFactory(String db) {
		this.createConnection(db);
	}	
	
	private void createConnection(String db) {		
		
		String url      = "jdbc:mysql://localhost:3306/" + db;
		String username = "root";
		String password = "";		
		
		try {
			
			this.setCon(DriverManager.getConnection(url, username, password));
			
		} catch (SQLException e) {
			
			System.out.println("Verbindung konnte nicht hergestellt werden!");
		}
		
	}
}
