package OOweek15;
/**
 *
 * @author Sjaak en Pieter
 */
public class Kassa {
    
    private static final int BANDGROOTTE = 40, BAKGROOTTE = 10;
    private BWR band;
    private BWR bak;
    
    public Kassa(int grootte){
        band = new BWR(BANDGROOTTE);
        bak = new BWR(BAKGROOTTE);
    }
        
    public void legOpBand (Artikel artikel) {
        band.stopIn(artikel);
    }
    
    public Artikel haalVanBand () {
        if(!band.isLeeg())
            return (Artikel) band.haalUit();
        return null;
    }

    public void legInBak (Artikel artikel) {
        bak.stopIn(artikel);
    }
    
    public Artikel haalUitBak () {
        if(!bak.isLeeg())
            return (Artikel) bak.haalUit();
        return null;
    }
    
    public void wachtOpKlant () {
        
    }
    
    public int aantalOpBand () {
        return band.getAantal();
    }
    
    public int getBANDGROOTTE(){
        return BANDGROOTTE;
    }
}
