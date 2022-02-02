package pareser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import spiel.Spiel;
 
public class JsonParserV2 {	
	
	public static String plattform;
	
	public static ArrayList<Spiel> jsonParser(String fileLocation){				
		
		return getGames(getFileContent(fileLocation));
	}

	private static String getFileContent(String fileLocation) {
		
		File spielFile = new File(fileLocation);		
		
		String spieleFileContent = null;
		
		try {
			
			spieleFileContent = new String(Files.readAllBytes(Paths.get(spielFile.toURI())));
			
		} catch (IOException e) {
			
			System.out.println("File does not exist!");		
		}	
		
		return spieleFileContent;
	}


	public static ArrayList<Spiel> getGames(String spieleFileContent){
		
		ArrayList<Spiel> allGames   = new ArrayList<>();		
		
		JSONObject spieleJsonObjekt = new JSONObject(spieleFileContent);		
		
		plattform = spieleJsonObjekt.getString("plattform");
		
		JSONArray spieleJsonArray   = spieleJsonObjekt.getJSONArray("spiele");				
			
		for (int i = 0; i < spieleJsonArray.length(); i++) {			
			
			JSONObject desc = spieleJsonArray.getJSONObject(i).getJSONObject("beschreibung");				
			
			allGames.add(new Spiel(
							spieleJsonArray.getJSONObject(i).getInt   ("id"),
							spieleJsonArray.getJSONObject(i).getString("name"),
							spieleJsonArray.getJSONObject(i).getString("edition"),
							spieleJsonArray.getJSONObject(i).getString("genre"),
							spieleJsonArray.getJSONObject(i).getInt   ("alterseinstufung"),
							spieleJsonArray.getJSONObject(i).getString("hersteller"),
							spieleJsonArray.getJSONObject(i).getString("erscheinungsdatum"),
							spieleJsonArray.getJSONObject(i).getInt   ("anzahl_der_player"),
							desc.getString("de"),
							desc.getString("en"),
							spieleJsonArray.getJSONObject(i).getBoolean("verfuegbar"),
							spieleJsonArray.getJSONObject(i).getDouble ("preis_mit_mwst")
					   
			));						
		}			
		
		return allGames;
	}
}
