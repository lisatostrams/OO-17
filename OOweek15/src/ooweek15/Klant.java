package OOweek15;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sjaak en Pieter
 */
public class Klant implements Runnable {    
    private final Winkel winkel;
    private final int klantNummer;
    private final int aantalArtikelen;
    private final static Random generator = new Random ();
    
    public Klant (int nummer, Winkel winkel) {
        this.winkel = winkel;
        klantNummer = nummer;
        aantalArtikelen = generator.nextInt (20) + 1;
    }

    @Override
    public void run() {
        //gewenste artikelen verzamelen
        winkel.pakArtikelen(aantalArtikelen);
        
        //een kassa kiezen
        winkel.getKassa(klantNummer);
        
        //wacht tot hij aan de beurt is
        if(winkel.getKassa(klantNummer).aantalOpBand()==winkel.getKassa(klantNummer).getBANDGROOTTE()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Klant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            // alle artikelen op de band van de gekozen kassa legt
            
        }
        
        
        
        // de gescande artikelen uit de bak haalt
        
    }
}
