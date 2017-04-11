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
public class Chocodip extends Topping{

    public Chocodip(Ijsje ijsje) {
        super(ijsje);
    }

    @Override
    public String toString() {
        return ijsje.toString() + ", chocodip";
    }
    
    @Override
    public int prijs(){
        return super.prijs() + 30;
    }
    
}
