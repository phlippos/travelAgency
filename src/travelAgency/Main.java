package travelAgency;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;  
public class Main {

    public static void main(String[] args) throws ParseException {
    	//Mitarbeiter[] mitarbeiter = new Mitarbeiter[100];
       // Kunde[] kunden = new Kunde[100];
    	ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
    	ArrayList<Kunde> kunden = new ArrayList<Kunde>();
    	ArrayList<Reisepaket> rpaket = new ArrayList<Reisepaket>();
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
          System.out.println("  7- Reisepaket hinzufuegen");
          System.out.println("  8- Alle Reisepakete auflisten");
          System.out.println("  9- Reisepaket suchen");
          System.out.println("  10- Reisepaketpreis aendern");
          System.out.println("  100 - Programm beenden");
          try {
          operation = sc.nextInt();sc.nextLine();
          }catch(InputMismatchException e ) {
        	  System.out.println("Bitte geben Sie eine gueltige Option ein");
          }
          if (operation == 1) {             
        	  //boolean checkBuergerID=true;
        	  System.out.println("Geben Sie bitte ihre TC-Nummer ein");
        	  String BuergerID = sc.nextLine(); 
        	  try {
	        	  if(Person.checkBuergerID(BuergerID)) {		// BUergerID überprüfen	        		
	        		Mitarbeiter m1 = new Mitarbeiter(BuergerID);
	        		if(!mitarbeiter.contains(m1)) {
		        		System.out.println("Geben Sie bitte ihren Namen ein");
		                String name = sc.nextLine();
		                System.out.println("Geben Sie bitte ihren Nachnamen ein");
		                String surname = sc.nextLine();
		                if(Person.checkName(name) && Person.checkNachName(surname)) {
			                Mitarbeiter m = new Mitarbeiter(Integer.toString(mitarbeiterzahl),BuergerID,name,surname);
			                mitarbeiter.add(m);		
		                }
	        		 }
	        	  }
        	  }catch(FalschBuergerIDException e) {
        		  System.out.println(e);
        	  }
          } else if (operation == 2) {             
        	  mitarbeiter.forEach((n) -> {
        		  System.out.println(n);
        	  });
          } else if(operation == 3){
        	  System.out.println("Geben Sie bitte BuergerID ein.");
        	  String BuergerID = sc.nextLine();     		
        	  Mitarbeiter m1 = new Mitarbeiter(BuergerID);
        	  if(mitarbeiter.contains(m1)) {
        		  System.out.println("Name : "+ mitarbeiter.get(mitarbeiter.indexOf(m1)).getName());
    			  System.out.println("Nachname : " +mitarbeiter.get(mitarbeiter.indexOf(m1)).getSurname());
        	  }
        	  else{
      			System.out.println("Person konnte nicht gefunden werden");
      		  }        	  
          } else if (operation == 4) {            
        	  //boolean checkBuergerIDK = true;
        	  System.out.println("Geben Sie bitte ihre BuergerID ein.");
        	  String BuergerIDK = sc.nextLine();
        	  try {
	        	  if(Person.checkBuergerID(BuergerIDK)) {     		  
	        		  Kunde k1 = new Kunde(BuergerIDK);
	        		  if(!kunden.contains(k1)) {
		          	      System.out.println("Geben Sie bitte ihren Namen ein");
		                  String name = sc.nextLine();
		                  System.out.println("Geben Sie bitte ihren Nachnamen ein");
		                  String surname = sc.nextLine();
		                  if(Person.checkName(name) && Person.checkNachName(surname)) {
			            	  Kunde k = new Kunde(Integer.toString(kundezahl),name,surname,BuergerIDK);
			            	  kunden.add(k);		            	
		            	  }
	        		  }  
	        	  }
        	  }catch(FalschBuergerIDException e) {
        		  System.out.println(e);
        	  }
          } else if (operation == 5) {
        	  kunden.forEach((n)->{
        		  System.out.println(n);
        	  });
          }else if(operation == 6){
        	  System.out.println("Geben Sie bitte BuergerID ein.");
        	  String BuergerIDK = sc.nextLine();
        	  Kunde k1 = new Kunde(BuergerIDK);
        	  if(kunden.contains(k1)) {
        		  System.out.println("Name : "+ kunden.get(kunden.indexOf(k1)).getName());
    			  System.out.println("Nachname : " + kunden.get(kunden.indexOf(k1)).getSurname());
        	  }
        	  else{
      			System.out.println("Person konnte nicht gefunden werden");
      		  }       	  	  
          }else if(operation == 7) {
        	  System.out.println("Wohin?");
        	  String destination = sc.nextLine();
        	  System.out.println("Wann(dd/mm/yyyy)");
        	  SimpleDateFormat date ;       	  
			  date = new SimpleDateFormat(sc.nextLine());
        	  System.out.println("Wie viel Tag?");
        	  int dauer = sc.nextInt();
        	  System.out.println("Wie viel kostet die Reissepaket");
        	  float preis = sc.nextFloat();
        	  Reisepaket reisepaket = new Reisepaket(Integer.toString(rpaket.size()),destination,date,dauer,preis);
        	  rpaket.add(reisepaket);
          }else if(operation == 8) {
        	  rpaket.forEach(
        			  (n) -> {
        				  System.out.println("********************");
        				  System.out.println(n);
        				  System.out.println("********************");
        			  }
        			  );
          }else if(operation == 9) {
        	  System.out.println("Geben Sie PaketID ein : ");
        	  String reisepaketID = sc.nextLine();
        	  Reisepaket reisepaket = new Reisepaket(reisepaketID);
        	  if(rpaket.contains(reisepaket)) {
        		  System.out.println(rpaket.get(rpaket.indexOf(reisepaket)));
        	  }
          }else if(operation == 10) {
        	  System.out.println("Geben Sie PaketID ein : ");
        	  String reisepaketID = sc.nextLine();
        	  Reisepaket reisepaket = new Reisepaket(reisepaketID);
        	  if(rpaket.contains(reisepaket)) {
        		  System.out.println("Neuer Preis : ");
        		  float preis = sc.nextFloat();
        		  rpaket.get(rpaket.indexOf(reisepaket)).setPreis(preis);
        		  System.out.println(rpaket.get(rpaket.indexOf(reisepaket)));
        	  }
          }
        }                                           
    }
}
