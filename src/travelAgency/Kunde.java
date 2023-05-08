package travelAgency;

public class Kunde extends Person {

    private String kunde_id;
	
    public Kunde(String BuergerID) {
    	super(BuergerID);
    }
    public Kunde(String BuergerID, String kunde_id){
    	super(BuergerID);
    	this.kunde_id= kunde_id;
    }
    public Kunde(String kunde_id,String name,String surname, String BuergerID ){
    	super(BuergerID,name,surname);
        this.kunde_id = kunde_id;
    }

    public Kunde(String kunde_id,String name,String surname, String BuergerID,String city,String address,String phonenumber,String email ){
    	super(BuergerID,name,surname,phonenumber,email,city,address);
    	this.kunde_id = kunde_id;
    }
    
	public String getKunde_id() {
		return kunde_id;
	}
	public void setKunde_id(String kunde_id) {
		this.kunde_id = kunde_id;
	}
	@Override
	public String toString() {
		return "Kunde ID : "+ this.kunde_id + " Name : " + getName() + " Nachname : " + getSurname() + " BuergerID : " + getBuergerID();
	}
    

}
