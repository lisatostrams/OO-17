/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

import java.util.Random;

/**
 *
 * @author mauri
 */
public class MeerkeuzeVraag extends Vraag{
    
    private String [] antwoorden;
    private int juisteAntwoord;
    
    public MeerkeuzeVraag(String vraag, String[] antwoorden, int juisteantwoord, int gewicht){
        super(vraag,gewicht);
        this.antwoorden = antwoorden;
        this.juisteAntwoord = juisteantwoord;
    }
    
    public MeerkeuzeVraag(String vraag, String[] antwoorden, int juisteantwoord){
        super(vraag);
        this.antwoorden = antwoorden;
        this.juisteAntwoord = juisteantwoord;
    }

    @Override
    public boolean isCorrect(String antwoord) {
        return antwoord.equalsIgnoreCase(antwoorden[juisteAntwoord]);
    }

    public String getAntwoord(int i){
        return antwoorden[i];
    }
    @Override
    public String juisteAntwoord() {
        return antwoorden[juisteAntwoord];
    }
    
    @Override
    public Vraag duplicate(){
        Random random = new Random();
        int shift = random.nextInt(antwoorden.length);
        String vraag = this.toString();
        String[] antwoorden2 = new String[antwoorden.length];
        for(int i = 0; i < antwoorden.length; i++)
            antwoorden2[i] = antwoorden[(i+shift)%antwoorden.length];
        MeerkeuzeVraag nieuw = new MeerkeuzeVraag(vraag, antwoorden2, (juisteAntwoord + shift)%antwoorden.length, super.getGewicht());
        return nieuw;
    }
}
