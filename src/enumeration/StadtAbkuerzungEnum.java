package enumeration;

public enum StadtAbkuerzungEnum {
	
	BW("Baden-Württemberg"),
	BY("Bayern"),
	BE("Berlin"),
	BB("Brandenburg"),
	HB("Bremen"),
	HH("Hamburg"),
	HE("Hessen"),
	MV("Mecklenburg-Vorpommern"),
	NI("Niedersachsen"),
	NW("Nordrhein-Westfalen"),
	RP("Rheinland Pfalz"),
	SL("Saarland"),
	SN("Sachsen"),
	ST("Sachen-Anhalt"),
	SH("Schleswig Holstein"),
	TH("Thüringen"),
	NATIONAL("National");
	
	public final String stadtName;
	
	StadtAbkuerzungEnum(String stadtName){
		this.stadtName = stadtName;
	}
}
