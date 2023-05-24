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
    
    public Person() {
    	
    }
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
		if(checkName(name)) {
			this.name = name;
		}
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(checkSurname(surname)){
			this.surname = surname;
		}
	}
	public String getBuergerID() {
		return BuergerID;
	}
	public void setBuergerID(String BuergerID) {
		if(checkBuergerID(BuergerID)) {
			this.BuergerID = BuergerID;
		}
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
	@Override
	public boolean equals(Object obj)  {
		boolean value  = false; //equals method from Object class
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
			throw new FalschBuergerIDException("falsche BuergerID. Die Länge von BuergerID muss 7 sein!");
		}
	} 
	
	public static boolean checkName(String name) throws FalschNameException {
		if(name.length()>=2) {
			if(Pattern.matches("([a-zA-Z]*\\.*\\s*)*", name)) {
				return true;
			}else {
				throw new FalschNameException("Der Name enthält ungültige Buchstaben!");
			}
		}else {
			throw new FalschNameException("Die Lange vom Namen muss größer als 1 sein!");
		}
	}
	
	public static boolean checkSurname(String surname) throws FalschSurnameException{
		if(surname.length()>=2) {
			if(Pattern.matches("[a-zA-Z]*",surname)) {
				return true;
			}else {
				throw new FalschSurnameException("Der Nachname kann nur aus Buchstaben bestehen!");
			}
		}else {
			throw new FalschSurnameException("Die Länge vom Nachnamen muss größer als 1 sein!");
		}
	}
}
