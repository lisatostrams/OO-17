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
public class WinkelWagen {
    List<Artikel> ww;
    
    public WinkelWagen(){
        ww = new LinkedList<>();
    }
    
    public void voegToe(Artikel a){
        ww.add(a);
    }
    
    public void verwijder(Artikel a){
        
    }
    
    public double totaalPrijs(){
        for(Artikel a : ww){
            
        }
    }
}
