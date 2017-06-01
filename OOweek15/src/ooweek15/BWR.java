package OOweek15;
/**
 *
 * @author Sjaak en Pieter
 * @param <Artikel>
 */
public class BWR<Artikel>{

    //private Artikel<T> elementen;
    //private final T[] elementen;
    private final Artikel[] elementen;
    private int aantal, begin, eind;

    public BWR(int grootte) {
        //elementen = new int[grootte];
        elementen = (Artikel[])new Object[grootte];
        aantal = 0;
        begin = 0;
        eind = 0;
    }

    public void stopIn(Artikel item) {
        elementen[eind] = item;
        eind = (eind + 1) % elementen.length;
        aantal = aantal + 1;
    }

    public Artikel haalUit() { // neemt aan dat er een element is
        Artikel item = elementen[begin];
        begin = (begin + 1) % elementen.length;
        aantal = aantal - 1;
        return item;
    }

    public boolean isLeeg() {
        return aantal == 0;
    }
    
    public int getAantal(){
        return aantal;
    }
}
