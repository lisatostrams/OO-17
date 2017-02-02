/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek1;

import java.util.Scanner;

/**
 *
 * @author Maurice Swanenberg
 * @author Lisa Tostrams
 */
public class Hoofdklasse {
    
     /**
     * constructor krijgt grootte van groep van gebruiker en maakt groep aan
     * vraagt naam en studentnummer voor alle leden van de groep en voegt die toe
     * aan de groep totdat de groep vol is.
     */
    public Hoofdklasse(){
        System.out.println("Hoe groot moet de groep studenten worden?");
        Scanner scan = new Scanner(System.in);
        int grootte = scan.nextInt();
        Groep groep = new Groep(grootte);
        for(int i = 0; i < grootte; i++){
            System.out.println("Wat is de voornaam van student " + (i+1) + "?");
            Scanner scan1 = new Scanner(System.in);
            String voornaam = scan1.nextLine();
            System.out.println("Wat is de achternaam van student " + (i+1) + "?");
            Scanner scan2 = new Scanner(System.in);
            String achternaam = scan2.nextLine();
            System.out.println("Wat is het studentnummer van student " + (i+1) + "?");
            Scanner scan3 = new Scanner(System.in);
            int snummer = scan3.nextInt();
            Student s = new Student(voornaam,achternaam,snummer);
            groep.voegToe(s);
        }
        printGroep(groep); 
        System.out.println("Van welk lidnummer wilt u de voor en achternaam aanpassen? Geef een negatief lidnummer als dit niet van toepassing is.");
        int n = scan.nextInt()-1;
        while(n >= 0){
            
            System.out.println("Wat is de nieuwe voornaam?");
            Scanner scan4 = new Scanner(System.in);
            String voornaam = scan4.nextLine();
            System.out.println("Wat is de nieuwe achternaam?");
            Scanner scan5 = new Scanner(System.in);
            String achternaam = scan5.nextLine();
            groep.getStudent(n).setNaam(voornaam, achternaam);
            printGroep(groep); 
            System.out.println("Van welk lidnummer wilt u de voor en achternaam aanpassen? Geef een negatief lidnummer als dit niet van toepassing is.");
            n = scan.nextInt();
        }
    }
     /**
     * drukt de tekst De groep bevat nu: gevolgd door alle studenten uit de 
     * groep af.
     */
    private void printGroep(Groep groep) {
        System.out.println("De groep bevat nu:"+ "\n" + groep.toString());
    }
    
}
