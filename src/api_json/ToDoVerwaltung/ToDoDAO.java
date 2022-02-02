package api_json.ToDoVerwaltung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoDAO {
	
	public static void insertToDosIntoAssignment(ToDo todo, Connection con) {
		
		int response = 0;
		
		String query = "INSERT INTO todo(id, userId, title, completed) VALUES(?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, todo.getId());
			ps.setInt(2, todo.getUserId());
			ps.setString(3, todo.getTitle());
			ps.setBoolean(4, todo.isCompleted());
			
			response = ps.executeUpdate();
			
			if(response == 1) {
				System.out.println("ToDo mit id(" + todo.getId() + ") wurde in die Tabelle erfolgreich hinzugefügt!\n");
			}
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage());
		}		
	}

}
