package writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import spiel.Spiel;

public class JsonWriter {
	
	public static void exportToJsonFile(ArrayList<Spiel> allGames, String plattform, String writeFilePath) {		
		
		// Before
//		String data = inJsonEncoding(allGames, plattform);	
//		writeJsonFile(data, writeFilePath);		
		
		// After		
		writeJsonFile(inJsonEncoding(allGames, plattform), writeFilePath);			
	}
	
	public static void writeJsonFile(String dataToWrite, String writeFilePath) {
		
		FileWriter file = null;
		try {
			
			file = new FileWriter(writeFilePath);
			
			file.write(dataToWrite);
			
			file.flush();
			file.close();	
			
			System.out.println("The file was successfully exported!");
			
		} catch (IOException e) {
			System.err.println("The file was not exported!");
		}
	}
	
	
	
	public static String inJsonEncoding(ArrayList<Spiel> allGames, String plattform) {
		
		JSONObject spieleJsonObject = new JSONObject();
		JSONArray  spieleJsonArray  = new JSONArray();
		JSONObject spielJsonObject            = null;
		
		spieleJsonObject.put("plattform", plattform);			
		
		for(Spiel game : allGames) {
			
			spielJsonObject = new JSONObject();
			
			spielJsonObject.put("id"               , game.getId());
			spielJsonObject.put("name"             , game.getName());
			spielJsonObject.put("edition"          , game.getEdition());
			spielJsonObject.put("genre"            , game.getGenre());
			spielJsonObject.put("alterseinstufung" , game.getAlterseinstufung());
			spielJsonObject.put("hersteller"       , game.getHersteller());
			spielJsonObject.put("erscheinungsdatum", game.getErscheinungsdatum());
			spielJsonObject.put("anzahl_der_player", game.getAnzahl_der_player());
			spielJsonObject.put("verfuegbar"       , game.istVerfuegbar());
			spielJsonObject.put("preis_mit_mwst"   , game.getPreis_mit_mwst());
			
			JSONObject beschreibung = new JSONObject();
			
			beschreibung.put("de", game.getBeschreibung_de());
			beschreibung.put("en", game.getBeschreibung_en());
			
			spielJsonObject.put("beschreibung", beschreibung);			
			
			spieleJsonArray.put(spielJsonObject);
		}		
		
		spieleJsonObject.put("spiele", spieleJsonArray);
		
		return spieleJsonObject.toString();
	}

}
