package api_json;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiData {

	public static String getApiData(String apiAdresse) {			
		
		// 1. URL-Objekt der eingegebenen Adresse erzeugen
		URL url = getUrl(apiAdresse);
		
		if(url != null) {			
				
			// 2. openStream() stellt eine Verbindung mit der Adresse her dann ermöglicht Scanner die Source-Data abzulesen und schließlich wird in einer Variable gespeichert  
			Scanner sourceData = getSourceData(url);
			
			if(sourceData != null) {
				
				// 3. Source-Data iterieren und als String speichern
				String data = new String();
				
				while(sourceData.hasNext()) {
					
					data += sourceData.nextLine();
				}					
				sourceData.close();
				return data;
			}			
		} 		
		return "";				
	}	
	
	// 2
	public static Scanner getSourceData(URL url) {
		
		try {
			
			return new Scanner(url.openStream());
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	// 1
	public static URL getUrl(String apiAdresse) {
		
		try {
			return new URL(apiAdresse); // Wird zurückgegeben, wenn die Format der übergebenen Adresse gültig ist
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		}
		return null; // Wird zurückgegeben, wenn die Format der übergebenen Adresse nicht gültig ist
	}
}
