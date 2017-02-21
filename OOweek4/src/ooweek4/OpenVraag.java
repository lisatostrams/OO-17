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
public class OpenVraag extends Vraag{
    
    private String antwoord;
    
    public OpenVraag(String vraag, String antwoord, int gewicht){
        super(vraag,gewicht);
        this.antwoord = antwoord;
    }
    
    public OpenVraag(String vraag, String antwoord){
        super(vraag);
        this.antwoord = antwoord;
    }

    @Override
    public boolean isCorrect(String antwoord) {
        return this.antwoord.equalsIgnoreCase(antwoord);
    }

    @Override
    public String juisteAntwoord() {
        return this.antwoord;
    }
}
