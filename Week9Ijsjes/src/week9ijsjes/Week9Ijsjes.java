/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9ijsjes;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mauri
 */
public class Week9Ijsjes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Ijsje> ijsjes = new LinkedList<>();
        ijsjes.add(new Slagroom(new YoghurtIjs()));
        ijsjes.add(new Chocodip(new Spikkels(new VanilleIjs())));
        for(Ijsje ijs : ijsjes){
            System.out.println(ijs.geefBeschrijving() + " $" + ijs.prijs());
        }
    }
    
}
