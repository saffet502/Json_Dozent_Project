package spiel;
public class Spiel {

	private int id;
	private String name;
	private String edition;
	private String genre;
	private int alterseinstufung;
	private String hersteller;
	private String erscheinungsdatum;
	private int anzahl_der_player;
	private String beschreibung_de;
	private String beschreibung_en;
	private boolean istVerfuegbar;
	private double preis_mit_mwst;	
	
//	public Spiel() {
//		
//		this(0, "Spielname", "Edition", "Genre", 0, "Hersteller", "00.00.0000", 0, "de", "en", true, 0);		
//		
//	}
	
	public Spiel(int id, String name, String edition, String genre, int alterseinstufung, String hersteller, String erscheinungsdatum,
			int anzahl_der_player, String beschreibung_de, String beschreibung_en, boolean istVerfuegbar, double preis_mit_mwst) 
	{

		this.id = id;
		this.name = name;
		this.edition = edition;
		this.genre = genre;
		this.alterseinstufung = alterseinstufung;
		this.hersteller = hersteller;
		this.erscheinungsdatum = erscheinungsdatum;
		this.anzahl_der_player = anzahl_der_player;
		this.beschreibung_de = beschreibung_de;
		this.beschreibung_en = beschreibung_en;
		this.istVerfuegbar = istVerfuegbar;
		this.preis_mit_mwst = preis_mit_mwst;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getAlterseinstufung() {
		return alterseinstufung;
	}
	public void setAlterseinstufung(int alterseinstufung) {
		this.alterseinstufung = alterseinstufung;
	}
	public String getHersteller() {
		return hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}	
	public String getErscheinungsdatum() {
		return erscheinungsdatum;
	}
	public void setErscheinungsdatum(String erscheinungsdatum) {
		this.erscheinungsdatum = erscheinungsdatum;
	}
	public int getAnzahl_der_player() {
		return anzahl_der_player;
	}
	public void setAnzahl_der_player(int anzahl_der_player) {
		this.anzahl_der_player = anzahl_der_player;
	}
	public String getBeschreibung_de() {
		return beschreibung_de;
	}
	public void setBeschreibung_de(String beschreibung_de) {
		this.beschreibung_de = beschreibung_de;
	}
	public String getBeschreibung_en() {
		return beschreibung_en;
	}
	public void setBeschreibung_en(String beschreibung_en) {
		this.beschreibung_en = beschreibung_en;
	}
	public boolean istVerfuegbar() {
		return istVerfuegbar;
	}
	public void setIstVerfuegbar(boolean istVerfuegbar) {
		this.istVerfuegbar = istVerfuegbar;
	}
	public double getPreis_mit_mwst() {
		return preis_mit_mwst;
	}
	public void setPreis_mit_mwst(double preis_mit_mwst) {
		this.preis_mit_mwst = preis_mit_mwst;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "\n\tid= " + id + "\n\tname= " + name + "\n\tedition= " + edition + "\n\tgenre= " + genre
				+ "\n\talterseinstufung= " + alterseinstufung + "\n\thersteller= " + hersteller + "\n\terscheinungsdatum= "
				+ erscheinungsdatum + "\n\tanzahl_der_player= " + anzahl_der_player + "\n\tbeschreibung_de= "
				+ beschreibung_de + "\n\tbeschreibung_en= " + beschreibung_en + "\n\tistVerfuegbar= " + istVerfuegbar
				+ "\n\tpreis_mit_mwst= " + preis_mit_mwst;
	}		
}
