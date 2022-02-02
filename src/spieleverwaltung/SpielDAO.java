package spieleverwaltung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import spiel.Spiel;

public class SpielDAO {
	
	public static ArrayList<Spiel> getGamesByPlattformId(int plattform_id, Connection con) {		
		
		ArrayList<Spiel> allGames = new ArrayList<>();
		
		String query = "SELECT * FROM spiel WHERE plattform_id=?";
		
		ResultSet rs = null;			
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, plattform_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {					
				
				allGames.add(new Spiel(
						
						rs.getInt    (1),
						rs.getString (2),
						rs.getString (3),
						rs.getString (4),
						rs.getInt    (5),
						rs.getString (6),
						rs.getString (7),
						rs.getInt    (8),
						rs.getString (9),
						rs.getString (10),
						rs.getBoolean(11),
						rs.getDouble (12)
						
						));
			}		
			
		} catch (SQLException e) {			
			
			System.err.println(e.getMessage());
		
		}	
		
		return allGames;		
	}
	
	public static void insertGame(Spiel game, int plattform_id, Connection con) {
		
		int response = 0;
		
		String query = "INSERT INTO spiel(id, name, edition, genre,"
				+ " alterseinstufung, hersteller,"
				+ "erscheinungsdatum, anzahl_der_player, "
				+ "beschreibung_de, beschreibung_en, verfuegbar, "
				+ "preis_mit_mwst, plattform_id) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt    (1,  game.getId());
			ps.setString (2,  game.getName());
			ps.setString (3,  game.getEdition());
			ps.setString (4,  game.getGenre());
			ps.setInt    (5,  game.getAlterseinstufung());
			ps.setString (6,  game.getHersteller());
			ps.setString (7,  getFormattedDate(game.getErscheinungsdatum())); // 2014-11-18
			ps.setInt    (8,  game.getAnzahl_der_player());
			ps.setString (9,  game.getBeschreibung_de());
			ps.setString (10, game.getBeschreibung_en());			
			ps.setBoolean(11, game.istVerfuegbar());			
			ps.setDouble (12, game.getPreis_mit_mwst());			
			ps.setInt    (13, plattform_id);			
			
			response = ps.executeUpdate();
			
			if(response == 1) {
				System.out.println("Spiel-Objekt mit \"id\": " + game.getId() + " wurde erfolgreich in die Tabelle als Datenstaz hizugefügt");
			}
			else {
				System.out.println("Spiel-Objekt mit \"id\": " + game.getId() + " wurde erfolgreich in die Tabelle nicht hizugefügt");
			}
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage());
		}
		
		
//		System.out.println(getFormattedDate(game.getErscheinungsdatum()));
		
	}
	
	private static String getFormattedDate(String date) { 
		
		String[] splittedDate = null;
		
		if(date.contains(".")) { // 18.11.2014
			
			splittedDate = date.trim().split("\\."); // [18, 11, 2014]			
		}
		else if(date.contains("/")) { // 18/11/2014
			
			splittedDate = date.trim().split("/"); // [18, 11, 2014]			
		}
		
		date = splittedDate[2] + "-" + splittedDate[1] + "-" + splittedDate[0]; // 2014-11-18
			
		
		return date;
	}
}
