package travelAgency;

public class Mitarbeiter extends Person {
	   
    private String mitarbeiter_id;
   
    public Mitarbeiter(String BuergerID) {
    	super(BuergerID);
    }

    public Mitarbeiter(String mitarbeiter_id,String BuergerID){
    	super(BuergerID);
        this.mitarbeiter_id = mitarbeiter_id;       
    }
    public Mitarbeiter(String mitarbeiter_id,String BuergerID,String name,String surname){
    	super(BuergerID,name,surname);
    	this.mitarbeiter_id = mitarbeiter_id;    
    }
    public Mitarbeiter(String mitarbeiter_id,String name,String surname,String BuergerID,String phonenumber,String email,String city,String address){
    	super(BuergerID,name,surname,phonenumber,email,city,address);
    	this.mitarbeiter_id = mitarbeiter_id;
    }


    public String getMitarbeiter_id() {
		return mitarbeiter_id;
	}
	public void setMitarbeiter_id(String mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}

	@Override
	public String toString() {
		return "Mitarbeiter ID : "+ this.mitarbeiter_id + " Name : " + getName() + " Nachname : " + getSurname() + " BuergerID : " + getBuergerID();
	}

	
}
