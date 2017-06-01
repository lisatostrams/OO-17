package OOweek15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author Sjaak en Pieter
 */
public class Winkel {
  public static final int AANTAL_KASSAS = 5;

  private final Kassa[] kassas;
  private final boolean open = false;

  public Winkel(ExecutorService executor) {
    kassas = new Kassa[AANTAL_KASSAS];
    for (int i = 0; i < AANTAL_KASSAS; i += 1) {
      kassas[i] = new Kassa();
      executor.execute(new Kassiere(kassas[i]));
    }
  }

  public List<Artikel> pakArtikelen(int aantal) {
    ArrayList<Artikel> artikelen = new ArrayList<>(aantal);
    for (int i = 1; i <= aantal; i += 1) {
      artikelen.add(new Artikel(i));
    }
    return artikelen;
  }

  public Kassa getKassa(int kassa_nr) {
    return kassas[kassa_nr];
  }
}
