/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek2;

import java.util.Scanner;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class Galg {
    
    private String woord;
    private StringBuilder woordToestand = new StringBuilder();
    private StringBuilder goedeLetters = new StringBuilder();
    private StringBuilder fouteLetters = new StringBuilder();
    private int fouten;
    private int maximumFouten;
    private boolean geraden = false;
    
    public Galg (String s){
        this.woord = s;
        this.fouten = 0;
        this.maximumFouten = 10;
    }
    
    public Galg (){
        WoordLezer woordlezer = new WoordLezer("woorden.txt");
        this.woord = woordlezer.geefWoord();
        this.fouten = 0;
        this.maximumFouten = 10;
    }
    
    public boolean raadLetter(char let){
        if(checkLetterInWoord(let)){
            goedeLetters.append(let);
            pasWoordAan();
            return true;
        }
        else{
            fouten++;
            fouteLetters.append(let);
            return false;
        }
    }
    
    public StringBuilder pasWoordAan(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < woord.length(); i++){
            sb.append('.');
        }
        woordToestand = sb;
        for(int i = 0; i < goedeLetters.length(); i++){
            for(int j = 0; j < woord.length(); j++){
                if(woord.charAt(j) == goedeLetters.charAt(i))
                    woordToestand.setCharAt(j,goedeLetters.charAt(i));
            }
        }
        geraden = isGeraden();
        return woordToestand;
    }
    
    public boolean isGeraden(){
        for(int i = 0; i < woord.length(); i++){
            if(woord.charAt(i)!= woordToestand.charAt(i))
                return false;
        }
        return true;
    }
    
    public boolean checkLetterInWoord(char a){
        for(int i = 0; i < woord.length(); i++){
            if(woord.charAt(i)==a)
                return true;
        }
        return false;
    }
    
    public int getFouten(){
        return fouten;
    }
    
    public int getMaxFouten(){
        return maximumFouten;
    }
    
    public boolean getGeraden(){
        return geraden;
    }
    
    public String getWoord(){
        return woord;
    }
        
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Het huidige woord is: ").append(woordToestand).append('\n').append("De fout geraden letters zijn: ").append(fouteLetters).append('\n');
        return sb.toString();
    }
}
