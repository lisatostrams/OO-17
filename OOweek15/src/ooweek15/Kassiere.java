/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OOweek15;

/**
 *
 * @author Sjaak en Pieter
 */
public class Kassiere implements Runnable {

  private final Kassa kassa;

  public Kassiere(Kassa kassa) {
    this.kassa = kassa;
  }

  @Override
  public void run() { }
}
