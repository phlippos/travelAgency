package travelAgency;

import java.util.regex.Pattern;

public abstract class Person {
	private String name;
    private String surname;
    private String BuergerID;
    private String phonenumber;
    private String email;
    private String city;
    private String address;
    
    public Person(String BuergerID) {
    	this.BuergerID =BuergerID;
    }
    public Person(String BuergerID,String name, String surname ) {
    	this(BuergerID);
    	this.name = name;
    	this.surname = surname;    	
    }
    public Person(String BuergerID,String name, String surname,String phonenumber,String email,String city,String address) {
    	this(BuergerID,name,surname);
    	this.phonenumber = phonenumber;
    	this.email = email;
    	this.city = city;
    	this.address = address;
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBuergerID() {
		return BuergerID;
	}
	public void setBuergerID(String BuergerID) {
		this.BuergerID = BuergerID;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
	public abstract String toString();		//abstract method toString from Object class
	
	public boolean equals(Object obj) {
		boolean value  = false; //equals mehod from Object class
		if(obj instanceof Mitarbeiter) {
			Mitarbeiter mitarbeiter = (Mitarbeiter)obj;
			if(this.BuergerID.compareTo(mitarbeiter.getBuergerID()) == 0) {
				value = true;
			}	
		}else if(obj instanceof Kunde) {
			Kunde kunde = (Kunde)obj;
			if(this.BuergerID.compareTo(kunde.getBuergerID()) == 0) {
				value = true;
			}	
		}
		return value;
	}
	
	public static boolean checkBuergerID(String BuergerID) throws FalschBuergerIDException {
		if(Pattern.matches("\\d{7}", BuergerID)) {
			return true;
		}else {
			throw new FalschBuergerIDException("falsche BuergerID");
		}
	} 
	
	public static boolean checkName(String name) {
		if(Pattern.matches("([a-zA-Z]*\\.*\\s*)*", name) && name.length()>=2) {
			return true;
		}else {
			System.out.println("Falsche Name");
			return false;
		}
	}
	
	public static boolean checkNachName(String nachname) {
		if(Pattern.matches("[a-zA-Z]*",nachname) && nachname.length()>=2) {
			return true;
		}else {
			System.out.println("Falsche Nachname");
			return false;
		}
	}
	

    
}
