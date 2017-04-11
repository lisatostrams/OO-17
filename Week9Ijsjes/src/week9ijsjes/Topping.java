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
public abstract class Topping extends Ijsje{

    protected Ijsje ijsje;
    
    public Topping(Ijsje ijsje){
        this.ijsje = ijsje;
    }
    
    @Override
    int prijs() {
        return ijsje.prijs();
    }
    
    public abstract String toString();
    
}
