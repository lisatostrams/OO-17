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
public class WasMachine extends Artikel{

    public WasMachine(){
        prijs = 499;
    }
    
    @Override
    double verzendkosten() {
        return 30;
    }
    
}
