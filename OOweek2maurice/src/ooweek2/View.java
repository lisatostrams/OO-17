/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class View {
    
    private Galg galg;
    
    public View(){
        galg = maakGalg();
        raadWoord();
    }
    
    public Galg maakGalg(){
        System.out.println("Kies 1 als u zelf een woord wilt kiezen, of 2 als het programma een woord voor u moet kiezen.");
        Scanner scan1 = new Scanner(System.in);
        int getal = scan1.nextInt();
        try {
            if(getal == 1 || getal == 2){
                if(getal == 1){
                    System.out.println("Welk woord kiest u?");
                    Scanner scan2 = new Scanner(System.in);
                    String woord = scan2.nextLine();
                    Galg galg = new Galg(woord);
                    return galg;
                }
                else{
                    Galg galg = new Galg();
                    return galg;
                }
            }
        } catch(InputMismatchException a) {
            System.out.println("Het getal wat u heeft gekozen is niet 1 en ook niet 2.");    
        }
        return maakGalg();
    }
    
    public void raadWoord(){
        galg.pasWoordAan();
        System.out.println(galg.toString());
        while(galg.getFouten() < galg.getMaxFouten() && galg.getGeraden() == false){
            raad();
            System.out.println(galg.toString());
        }
        if(galg.getGeraden())
            System.out.println("Gefeliciteerd! U heeft het woord geraden!");
        else
            System.out.println("Helaas! Het woord was " + galg.getWoord());
    }
    
    public void raad(){
        System.out.println("Welke letter wilt u raden?");
        Scanner scan = new Scanner(System.in);
        String letter = scan.nextLine();
        char let = letter.charAt(0);
        if(galg.raadLetter(let))
            System.out.println(galg.toString());
        else
            System.out.println("Helaas deze letter zit er niet in");
    }
}
