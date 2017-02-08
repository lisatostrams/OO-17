package ooweek2;

import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Leest woorden uit gegeven file en 
 * kan pseudo random woorden uit die lijst leveren
 * OO 2017 opgave 2
 * 
 * @author Pieter Koopman
 */
public class WoordLezer {
    private final List<String> woorden;
    private final Random rand;
    
    /**
     * Sla woorden uit file op in een arrayList.
     * IOexceptions bij het lezen worden gevangen en afgedrukt.
     * 
     * @param fileNaam: fileNaam van de file met woorden
     */
    public WoordLezer(String fileNaam) {
        rand = new Random ();
        woorden = new ArrayList<> ();
        String pattern = "\\S+"; // minstens een niet spatie
        
        try {
            FileReader fileReader = new FileReader(fileNaam);
            Scanner file = new Scanner(fileReader);
            
            while (file.hasNext(pattern)) {
                woorden.add(file.next(pattern).toLowerCase());
            }
            fileReader.close();
        } catch ( IOException ioe ) {
            System.out.println("Fout bij lezen van de file " + fileNaam + 
                               ": " + ioe.getMessage() );
        }
    }

    /**
     * @return het aantal gelezen woorden.
     */
    public int getAantalWoorden() {
        return woorden.size();
    }

    /**
     * Geeft een pseudo random woord uit de lijst met opgeslagen woorden,
     * of het lege woord als de lijst leeg is.
     * 
     * @return gekozen woord
     */
    public String geefWoord() {
        if (! woorden.isEmpty()) {
            return woorden.get(rand.nextInt(getAantalWoorden()));
        } else {
            return "";
        }
    }
}
