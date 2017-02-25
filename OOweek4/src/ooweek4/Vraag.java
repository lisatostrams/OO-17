/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

/**
 *
 * @author mauri
 */
public abstract class Vraag {
    private int gewicht;
    private String vraag;
    public Vraag(String vraag, int gewicht){
        this.vraag = vraag;
        this.gewicht = gewicht;
    }
    public Vraag(String vraag){
        this.vraag = vraag;
        this.gewicht = 3;
    }
    public String toString(){
        return vraag;
    }
    public abstract boolean isCorrect(String antwoord);
    public abstract String juisteAntwoord();
    public Vraag duplicate(){
        return this;
    }
    public int getGewicht(){
        return gewicht;
    }
}
