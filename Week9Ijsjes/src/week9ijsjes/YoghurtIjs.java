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
public class YoghurtIjs extends Ijsje{

    public YoghurtIjs(){
        beschrijving = "YoghurtIjs";
        prijs();
    }
    
    @Override
    int prijs() {
        return 200;
    }
}
