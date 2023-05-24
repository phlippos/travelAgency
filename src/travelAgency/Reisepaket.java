package travelAgency;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reisepaket {
	
	private String paketID;
	private String destination;
	private SimpleDateFormat datum;
	private int dauer;
	private float preis;
	
								//Constructors
	public Reisepaket(String paketID) {
		this.paketID = paketID;
		
	}
	public Reisepaket(String paketID,String destination,float preis) {
		this(paketID);
		this.destination = destination;
		this.preis = preis;
	}
	public Reisepaket(String paketID,String destination,SimpleDateFormat datum,int dauer,float preis) {
		this(paketID,destination,preis);
		this.datum = datum;
		this.dauer = dauer;
	}
	
	public String getPaketID() {
		return paketID;
	}
	public void setPaketID(String paketID) {
		this.paketID = paketID;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public SimpleDateFormat getDatum() {
		return datum;
	}
	public void setDatum(SimpleDateFormat datum) {
		this.datum = datum;
	}
	public int getDauer() {
		return dauer;
	}
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	public float getPreis() {
		return preis;
	}
	public void setPreis(float preis) {
		this.preis = preis;
	}
	@Override
	public String toString() {
		return "PaketID : " + this.paketID + "\nDestination : " + this.destination + "\nDatum : " + this.datum.toPattern() + "\nFur " + this.dauer +" Tag.\nPreiss : " + this.preis + "$";
	}
	@Override
	public boolean equals(Object obj) {
		Reisepaket rp = (Reisepaket)obj;
		if(this.paketID.compareTo(rp.getPaketID()) == 0) {
			return true;
		}else {
			return false;
		}
	}
}
