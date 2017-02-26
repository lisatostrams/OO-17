/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * Tweekeuzevraag subklasse
 */
public class TweekeuzeVraag extends MeerkeuzeVraag{
    
 //   private int juisteAntwoord;
    
    /**
     * Deze constructor maakt een vraag aan, op dezelfde manier als zijn superklasse MeerkeuzeVraag,
     * alleen worden er hier 2 aparte strings meegegeven die worden omgezet in een array van strings van lengte 2.
     * @param vraag
     * @param antwoord1
     * @param antwoord2
     * @param juisteantwoord
     * @param gewicht 
     */
    public TweekeuzeVraag(String vraag, String antwoord1, String antwoord2, int juisteantwoord, int gewicht) {
        super(vraag, new String [] {antwoord1, antwoord2} ,juisteantwoord, gewicht);
    }
    
    /**
     * Deze constructor maakt een vraag aan, op dezelfde manier als zijn superklasse MeerkeuzeVraag,
     * alleen worden er hier 2 aparte strings meegegeven die worden omgezet in een array van strings van lengte 2.
     * @param vraag
     * @param antwoord1
     * @param antwoord2
     * @param juisteantwoord 
     */
    public TweekeuzeVraag(String vraag, String antwoord1, String antwoord2, int juisteantwoord){
        super(vraag, new String [] {antwoord1, antwoord2} ,juisteantwoord);

    }

    /**
     * 
     * @param antwoord
     * @return of het meegegeven antwoord gelijk is (zonder naar hoofdletters te kijken) aan het goede antwoord. 
     */
    @Override
    public boolean isCorrect(String antwoord) {
        return antwoorden[juisteAntwoord].equalsIgnoreCase(antwoord);
    }

    /**
     * 
     * @return het juiste antwoord
     */
    @Override
    public String juisteAntwoord() {
        return antwoorden[juisteAntwoord];
    }
    
    /**
     * Deze functie returned de string met de keuze van 2 antwoorden en vervolgens de vraag.
     * @return 
     */
    @Override
    public String toString() {
        return (this.antwoorden[0] + " of " + this.antwoorden[1] + ": " + this.vraag) ; 
    }
   
}
