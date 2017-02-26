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
 * Open vraag subklasse
 */
public class OpenVraag extends Vraag{
    
    /**
     * Deze constructor maakt een open vraag aan, met een meegegeven gewicht.
     * @param vraag
     * @param antwoord
     * @param gewicht 
     */
    public OpenVraag(String vraag, String antwoord, int gewicht){
        super(vraag,antwoord,gewicht); 
    }
    
    /**
     * Deze constructor maakt een open vraag aan, zonder een meegegeven gewicht.
     * @param vraag
     * @param antwoord 
     */
    public OpenVraag(String vraag, String antwoord){
        super(vraag, antwoord);
    }
}
