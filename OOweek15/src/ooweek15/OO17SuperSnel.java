package OOweek15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Sjaak en Pieter
 */
public class OO17SuperSnel {

  private static final int AANTAL_KLANTEN = 30;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    Winkel winkel = new Winkel(executor);
    for (int i = 0; i < AANTAL_KLANTEN; i++) {
      executor.execute(new Klant(i, winkel));
    }
  }
  // wait until everyone is done
}
