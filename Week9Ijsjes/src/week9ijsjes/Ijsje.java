/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9ijsjes;

/**
 *
 * @author mauri
 */
public abstract class Ijsje {
    protected String beschrijving =  "onbekend ijsje";
    abstract int prijs();
    protected String geefBeschrijving(){
        return beschrijving;
    }
}
