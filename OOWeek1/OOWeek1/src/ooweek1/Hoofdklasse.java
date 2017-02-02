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
    
    public Hoofdklasse(){
        System.out.println("Hoe groot moet de groep studenten worden?");
        Scanner scan = new Scanner(System.in);
        int grootte = scan.nextInt();
        Groep groep = new Groep(grootte);
        for(int i = 0; i < grootte; i++){
            System.out.println("Wat is de voornaam van student " + i + "?");
            Scanner scan1 = new Scanner(System.in);
            String voornaam = scan1.nextLine();
            System.out.println("Wat is de achternaam van student " + i + "?");
            Scanner scan2 = new Scanner(System.in);
            String achternaam = scan2.nextLine();
            System.out.println("Wat is het studentnummer van student " + i + "?");
            Scanner scan3 = new Scanner(System.in);
            int snummer = scan3.nextInt();
            Student s = new Student(voornaam,achternaam,snummer);
            groep.voegToe(s);
        }
        System.out.println("De groep bevat nu:"+ "\n" + groep.toString());
        System.out.println("Van welk lidnummer wilt u de voor en achternaam aanpassen? Geef een negatief lidnummer als dit niet van toepassing is.");
        int n = scan.nextInt();
        while(n >= 0){
            
            System.out.println("Wat is de nieuwe voornaam?");
            Scanner scan4 = new Scanner(System.in);
            String voornaam = scan4.nextLine();
            System.out.println("Wat is de nieuwe achternaam?");
            Scanner scan5 = new Scanner(System.in);
            String achternaam = scan5.nextLine();
            groep.getStudent(n).setNaam(voornaam, achternaam);
            System.out.println("De groep bevat nu:"+ "\n" + groep.toString());
            System.out.println("Van welk lidnummer wilt u de voor en achternaam aanpassen? Geef een negatief lidnummer als dit niet van toepassing is.");
            n = scan.nextInt();
        }
    }
    
}
