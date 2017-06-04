package OOweek15;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * @author Sjaak en Pieter
 */
public class Klant implements Runnable {

    private final Winkel winkel;
    private final int klantNummer;
    private final int aantalArtikelen;
    private final static Random generator = new Random();

    public Klant(int nummer, Winkel winkel) {
        this.winkel = winkel;
        klantNummer = nummer;
        aantalArtikelen = generator.nextInt(20) + 1;
    }

    @Override
    public void run() {
        gebruikKassa();
        
    }
    
    private synchronized void gebruikKassa() {
        //gewenste artikelen verzamelen
        List<Artikel> artikelen = winkel.pakArtikelen(aantalArtikelen);
        System.out.println("Klant " + klantNummer + " pakt " + aantalArtikelen + " artikelen");
        
        //een kassa kiezen
        int kassa_nr = generator.nextInt(5);
        Kassa gekozenKassa = winkel.getKassa(kassa_nr);
        
        System.out.println("Klant " + klantNummer + " kiest kassa " + kassa_nr);

        //wacht tot hij aan de beurt is
        while (!gekozenKassa.wachtOpKlant()) {
            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Klant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        gekozenKassa.claim();
        
        System.out.println("Klant " + klantNummer + " is nu bij kassa " + kassa_nr);
        
        while (artikelen.size() > 0) { // zolang er nog artikelen zijn
            
            if (gekozenKassa.aantalOpBand() == gekozenKassa.getBANDGROOTTE()) {
                try { // als de band vol is, wacht dan
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Klant.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // alle artikelen op de band van de gekozen kassa legt
                gekozenKassa.legInBak(artikelen.remove(0));
            }
        }
        // een bordje neerzetten
        gekozenKassa.legInBak(null);
        
        System.out.println("Klant " + klantNummer + " heeft alle artikelen op de band gelegd " + kassa_nr);

        // de gescande artikelen uit de bak haalt
        for (int i = 0; i < aantalArtikelen; i++) {
            gekozenKassa.haalUitBak();
        }
        gekozenKassa.release();
        
        System.out.println("Klant " + klantNummer + " is klaar bij kassa " + kassa_nr);
        
        notifyAll();
    }
}
