package travelAgency;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;  
public class Main {

    public static void main(String[] args) {
    	//Mitarbeiter[] mitarbeiter = new Mitarbeiter[100];
       // Kunde[] kunden = new Kunde[100];
    	ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
    	ArrayList<Kunde> kunden = new ArrayList<Kunde>();
        int mitarbeiterzahl = 0;
        int kundezahl = 0;
        
      
        Scanner sc = new Scanner(System.in);
        
        int operation = 0;
        while (operation != 100) {

          System.out.println("Welche Operation moechten Sie durchfuehren?");
          System.out.println("  1- Mitarbeiter hinzufuegen");
          System.out.println("  2- Mitarbeiter auflisten");
          System.out.println(" 	3- Mitarbeiter suchen");
          System.out.println("  4- Kunde hinzufuegen");
          System.out.println("  5- Kunden auflisten");
          System.out.println(" 	6- Kunde suchen");
          System.out.println("  100 - Programm beenden");

          operation = sc.nextInt();sc.nextLine();
          if (operation == 1) {
              /* To do:
              a) Fragen Sie den Benutzer nach den Mitarbeiterinformationen
              b) Lesen Sie die Information mit sc.nextLine() und wenn notwendig mit sc.nextInt() ein
              c) Erstellen Sie eine Instanz Ihrer Klasse "Mitarbeiter" mit diesen Informationen
              c) Speichern Sie diese Instanz in das Array mitarbeiter */
        	  boolean checkBuergerID=true;
        	  System.out.println("Geben Sie bitte ihre TC-Nummer ein");
        	  String BuergerID = sc.nextLine(); 
        	  if(Person.checkBuergerID(BuergerID)) {		// BUergerID überprüfen
        		/*for(int i = 0 ; i<mitarbeiterzahl ; ++i) {
        			if(mitarbeiter[i].equals(BuergerId) == false) {
        				checkBuergerID=false;
        				break;
        			}
        		}*/
        		Mitarbeiter m1 = new Mitarbeiter(BuergerID);
        		if(!mitarbeiter.contains(m1)) {
	        		System.out.println("Geben Sie bitte ihren Namen ein");
	                String name = sc.nextLine();
	                System.out.println("Geben Sie bitte ihren Nachnamen ein");
	                String surname = sc.nextLine();
	                if(Person.checkName(name) && Person.checkNachName(surname)) {
		                Mitarbeiter m = new Mitarbeiter(Integer.toString(mitarbeiterzahl),BuergerID,name,surname);
		                mitarbeiter.add(m);
		               // mitarbeiter[mitarbeiterzahl] = m;
		                //mitarbeiterzahl++;
	                }
        		 }
        	  }	  
          } else if (operation == 2) {
              /* To do: Geben Sie BuergerID, Name und Nachname aller gespeicherten Mitarbeiter auf dem Bildschirm aus*/
        	 /* for(int i = 0; i<mitarbeiterzahl; i++) {
        		System.out.println(mitarbeiter[i]);
        		  
        	  }*/
        	  mitarbeiter.forEach((n) -> {
        		  System.out.println(n);
        	  });
          } else if(operation == 3){
        	  System.out.println("Geben Sie bitte BuergerID ein.");
        	  String BuergerID = sc.nextLine();
      		/*for(int i = 0; i<mitarbeiterzahl;i++) {
        		  if(BuergerID.equals(mitarbeiter[i].getBuergerID())) {
        			  exist = true;
        			  System.out.println("Name : "+ mitarbeiter[i].getName());
        			  System.out.println("Nachname : " +mitarbeiter[i].getSurname());
        			  break;
        		  }
        	  }*/
        	  Mitarbeiter m1 = new Mitarbeiter(BuergerID);
        	  if(mitarbeiter.contains(m1)) {
        		  System.out.println("Name : "+ mitarbeiter.get(mitarbeiter.indexOf(m1)).getName());
    			  System.out.println("Nachname : " +mitarbeiter.get(mitarbeiter.indexOf(m1)).getSurname());
        	  }
        	  else{
      			System.out.println("Person konnte nicht gefunden werden");
      		  }
        	  
          } else if (operation == 4) {
              /* To do:
              a) Fragen Sie den Benutzer nach den Kundeninformationen
              b) Lesen Sie die Information mit sc.nextLine() und wenn notwendig mit sc.nextInt() ein
              c) Erstellen Sie eine Instanz Ihrer Klasse "Kunde" mit diesen Informationen
              d) Speichern Sie diese Instanz in das Array kunden*/
        	  boolean checkBuergerIDK = true;
        	  System.out.println("Geben Sie bitte ihre BuergerID ein.");
        	  String BuergerIDK = sc.nextLine();
        	  if(Person.checkBuergerID(BuergerIDK)) {
        		  /*for(int i = 0; i<kundezahl; i++) { // BUergerID überprüfen
        			  if(kunden[i].equals(BuergerIDK) == false) {
        				  checkBuergerIDK = false;
        				  break;
        			  }
        			  
        		  }*/
        		  Kunde k1 = new Kunde(BuergerIDK);
        		  if(!kunden.contains(k1)) {
	          	      System.out.println("Geben Sie bitte ihren Namen ein");
	                  String name = sc.nextLine();
	                  System.out.println("Geben Sie bitte ihren Nachnamen ein");
	                  String surname = sc.nextLine();
	                  if(Person.checkName(name) && Person.checkNachName(surname)) {
		            	  Kunde k = new Kunde(Integer.toString(kundezahl),name,surname,BuergerIDK);
		            	  kunden.add(k);
		            	 // kunden[kundezahl] = k;
		            	 // kundezahl++;
	            	  }
        		  }  
        	  }
          } else if (operation == 5) {
              /* To do: Geben Sie BuergerID, Name und Nachname aller gespeicherten Kunden auf dem Bildschirm aus*/
        	  kunden.forEach((n)->{
        		  System.out.println(n);
        	  });
          }else if(operation == 6){
        	  System.out.println("Geben Sie bitte BuergerID ein.");
        	  String BuergerIDK = sc.nextLine();
        	  
      		 /* for(int i = 0; i<kundezahl;i++) {
        		  if(BuergerID.equals(kunden[i].getBuergerID())) {
        			  exist = true;
        			  System.out.println("Name : "+ kunden[i].getName());
        			  System.out.println("Nachname : " +kunden[i].getSurname());
        			  break;
        		  }
        	  }*/
        	  Kunde k1 = new Kunde(BuergerIDK);
        	  if(kunden.contains(k1)) {
        		  System.out.println("Name : "+ kunden.get(kunden.indexOf(k1)).getName());
    			  System.out.println("Nachname : " + kunden.get(kunden.indexOf(k1)).getSurname());
        	  }
        	  else{
      			System.out.println("Person konnte nicht gefunden werden");
      		  }
        	  
        	  
          }       
        }                                           
    }
}
