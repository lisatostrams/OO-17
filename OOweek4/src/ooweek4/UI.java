/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * Alle interactie tussen gebruiker en programma gebeurt hier
 */
public class UI {
    List<Vraag> verkeerdBeantwoordeVragen;
    List<Vraag> vragen; 
    Scanner scan;
    public UI(){
        verkeerdBeantwoordeVragen = new LinkedList<>();
        vragen = new LinkedList<>();
        scan = new Scanner(System.in); 
        addVragen(); 
        speel();
        
    }
    
    public void speel(){
        String input; 
        int punten = 0; //ronde 1
        System.out.println("Ronde 1! \n\n");
        for(Vraag v : vragen) {
            System.out.println(v); 
            input = scan.nextLine();
            if(v.isCorrect(input)) {
                System.out.println("Correct!");
                punten += v.gewicht; 
            } else {
                System.out.println("Nope.");
                verkeerdBeantwoordeVragen.add(v.duplicate()); 
            }
        }
        speel2(verkeerdBeantwoordeVragen, punten); 
    }
    
    public void speel2(List<Vraag>verkeerdBeantwoordeVragen, int punten){
        int puntenx = 0; //ronde 2
        String input;
        System.out.println("Ronde 2! \n\n"); 
        for(Vraag v : verkeerdBeantwoordeVragen) {
            System.out.println(v); 
            input = scan.nextLine();
            if(v.isCorrect(input)) {
                System.out.println("Correct!");
                puntenx += v.gewicht; 
            } else {
                System.out.println("Nope. Correcte antwoord was: " + v.juisteAntwoord());
            }
        }
        System.out.println("Je hebt " + punten + " punten gehaald in de eerste ronde en " + puntenx + " in de tweede ronde.");
        
    }
    
       public void addVragen() {
        vragen.add(new MeerkeuzeVraag( 
            "Hoe print je   \"Hello world  \" op een regel in Java?", 
            new String []  { 
            "System.out.print(  \"Hello world  \");", 
            "System.out.println(  \"Hello world  \");", 
            "cout <<  \"Hello world  \";" },  
            1 
            )); 
        vragen.add(new TweekeuzeVraag( 
            "Is er verschil tussen een interface en een abstracte klasse?", 
            "Ja", "Nee", 0,
            5)); 
        vragen.add(new OpenVraag( 
            "Wat is de complexiteit van binair zoeken?", 
            "O(log N)" 
            )); 
        vragen.add(new MeerkeuzeVraag( 
            "Wat is de complexiteit van slim in situ sorteren?", 
            new String []  { 
                "O(N^2)", 
                "O(N log N)", 
                "O(N)", 
                "O(log N)" }, 
            1, 
            4)); 
        vragen.add(new OpenVraag( 
            "Hoe lees je in Java een integer i uit een scanner s?", 
            "i = s.nextInt();", 
            2));
        vragen.add(new MeerkeuzeVraag( 
            "Hoe lees je in Java een niet leeg woord uit scanner s?", 
            new String [] { 
                "s.nextline()", 
                "s.next(  \"    S+  \")", 
                "s.next(  \"    a*  \")", 
                "s.next(  \"    S*  \")", 
                "s.next(  \"        s+  \")", 
                "s.next(  \"    s+  \")", 
                "s.nextString(  \"    s*  \")", 
                "s.next(  \"        S+  \")", 
                "s.nextString()" }, 
            7, 
            1));
        vragen.add(new OpenVraag( 
            "Hoeveel constructoren je minstens maken bij een klasse in Java?", 
            "0", 
            2)); 
        vragen.add(new TweekeuzeVraag( 
            "Is er een maximum aantal constructoren van een klasse in Java?", 
            "Ja", "Nee", 1 
            )); 
        
    }
   
}
