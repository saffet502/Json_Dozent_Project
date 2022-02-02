package api_json;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import api_json.ToDoVerwaltung.ToDo;
import api_json.ToDoVerwaltung.ToDoDAO;
import connection_factory.ConnectionFactory;

public class ToDoUtilityClass {
	
	public static void parseToDoJsonObjectsThenInsert(String allToDos) {	
		
		Connection con = new ConnectionFactory("assignments").getCon();
		
		JSONArray allToDosJsonArray = new JSONArray(allToDos);
		
		for(int i=0; i<allToDosJsonArray.length(); i++) {
			
			ToDoDAO.insertToDosIntoAssignment(createToDoObject(allToDosJsonArray.getJSONObject(i)), con);
		}
		
		try {
			con.close();
		} catch (SQLException e) {


			System.err.println(e.getMessage());
		}
		
	}
	
	public static ToDo createToDoObject(JSONObject toDoJsonObject) {			
		
		return new ToDo(toDoJsonObject.getInt("id"), toDoJsonObject.getInt("userId"), toDoJsonObject.getString("title"), toDoJsonObject.getBoolean("completed"));
	}
}
