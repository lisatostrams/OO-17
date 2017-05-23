
package oo17taxi;

/**
 * main Class: create a SImulation and execute it.
 * 
 * @author pieterkoopman
 */
public class OO17Taxi {

  public static void main(String[] args) {
    Simulation sim = new Simulation();
    while (! sim.ended()) {
      sim.step();
    }
    sim.showStatistics();
  }
}
