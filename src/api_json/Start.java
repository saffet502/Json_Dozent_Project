package api_json;

import org.json.JSONObject;

import enumeration.StadtAbkuerzungEnum;
import writer.JsonWriter;

public class Start {

	public static void main(String[] args) {
		
		
//		String allHolidays = ApiData.getApiData("https://feiertage-api.de/api/?jahr=2022");
		String allToDos    = ApiData.getApiData("https://jsonplaceholder.typicode.com/users/1/todos");
		
//		System.out.println(allHolidays);
		System.out.println(allToDos);	

		
//		System.out.println(StadtAbkuerzungEnum.BE.stadtName);
//		
//		String name = "BE";
//		System.out.println(Enum.valueOf(StadtAbkuerzungEnum.class, name).stadtName);
			

		// 4. Write Data to JSON-File
//		 JsonWriter.writeJsonFile(allHolidays, "exports/apiDatenHolidays.json");	
//		 JsonWriter.writeJsonFile(allToDos   , "exports/apiDatenToDos.json");
		
		// 5. Insert into "ToDo" table in the DB "assignments"
		ToDoUtilityClass.parseToDoJsonObjectsThenInsert(allToDos);
	}	
}
