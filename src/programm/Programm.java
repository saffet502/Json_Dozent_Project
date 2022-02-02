package programm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import connection_factory.ConnectionFactory;
import pareser.JsonParserV2;
import spiel.Spiel;
import spieleverwaltung.SpielDAO;
import writer.JsonWriter;

public class Programm {

	public static void main(String[] args) {		
		
		Connection conSpiele = new ConnectionFactory("spiele_vorbereitung").getCon(); 
		
		// JSON-Datei parsen
//		ArrayList<Spiel> allGames = JsonParserV2.jsonParser("data/xboxSpieleX.json");
		
//		System.out.println("Plattform: " + JsonParserV2.plattform);
		
		// Alle Spiele in die Tabelle "spiel" als Datensätze hizufügen
//		insertGames(allGames, 3, conSpiele);
		
		// Spiele: DB -> JSON-Datei
		ArrayList<Spiel> allGamesInDbToExport = SpielDAO.getGamesByPlattformId(3, conSpiele); 
//		showAllGames(allGamesInDbToExport);
//		 JsonWriter.exportToJsonFile(allGamesInDbToExport, "XBOX_SERIES_X", "exports/XBOX_SERIES_X_spiele.json");
		
		// Alle Spiele zeigen
//		showAllGames(allGames);
		
		// JSON-Datei schreiben
//		JsonWriter.exportToJsonFile(allGames, JsonParserV2.plattform, "exports/spiele03.json");
		
		closeConnection(conSpiele);
	}
	
	private static void closeConnection(Connection con) {
		
		try {
			con.close();
			
		} catch (SQLException e) {
		
			System.out.println("Verbindung konnte nicht geschlossen werden!");
		}
	}
	
	private static void insertGames(ArrayList<Spiel> allGames, 
			int plattform_id, Connection con) {
		
		for(Spiel game : allGames) {
			
//			System.out.println(game);
			
			SpielDAO.insertGame(game, plattform_id, con);
		}
		
		
		
	}
	
	private static void showAllGames(ArrayList<Spiel> allGames) {
		
		for(Spiel spiel : allGames) {
			
			System.out.println(spiel);
			System.out.println();
		}		
	}

}
