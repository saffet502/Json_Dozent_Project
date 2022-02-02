package pareser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
 
public class JsonParser {

	public static void main(String[] args) {	
		
		
		// 1
		String fileLocation = "data/spiele.json";
		
		// 2
		File spielFile = new File(fileLocation);
				
		try {
			
			// 3
			String spieleFileContent = new String(Files.readAllBytes(Paths.get(spielFile.toURI())));
			
//			System.out.println(spieleFileContent);			
			
			// 4
			JSONObject spieleJsonObjekt = new JSONObject(spieleFileContent);
			
//			System.out.println(spieleJsonObjekt);
//			System.out.println();

			// 5
			String plattform = spieleJsonObjekt.getString("plattform");
			
			System.out.println("plattform: " + plattform);
			System.out.println();
			
			// 6
			JSONArray spiele = spieleJsonObjekt.getJSONArray("spiele");
			
//			System.out.println(spiele);
//			System.out.println();
			
			// 7
			for (int i = 0; i < spiele.length(); i++) {
				
//				System.out.println(spiele.get(i));
				
				JSONObject desc = spiele.getJSONObject(i).getJSONObject("beschreibung");
				
//				System.out.println(desc);
				
				System.out.println("id: "                   + spiele.getJSONObject(i).getInt   ("id"));
				System.out.println("\tName:               " + spiele.getJSONObject(i).getString("name"));
				System.out.println("\tEdition:            " + spiele.getJSONObject(i).getString("edition"));
				System.out.println("\tGenre:              " + spiele.getJSONObject(i).getString("genre"));
				System.out.println("\tAlterseinstufung:   " + spiele.getJSONObject(i).getInt   ("alterseinstufung"));
				System.out.println("\tHersteller:         " + spiele.getJSONObject(i).getString("hersteller"));
				System.out.println("\tRrscheinungsdatum:  " + spiele.getJSONObject(i).getString("erscheinungsdatum"));
				System.out.println("\tAnzahl der Spieler: " + spiele.getJSONObject(i).getInt   ("anzahl_der_player"));				
				System.out.println("\tBeschreibung de:    " + desc.getString("de"));				
				System.out.println("\tBeschreibung en:    " + desc.getString("en"));
				System.out.println("\tVerfuegbar:         " + spiele.getJSONObject(i).getBoolean("verfuegbar"));
				System.out.println("\tPreis_mit_mwst:     " + spiele.getJSONObject(i).getDouble("preis_mit_mwst") + " €");
				
				System.out.println();
			}			
			
		} catch (IOException e) {
			
			System.out.println("File does not exist!");		
		}		
		
	}

}
