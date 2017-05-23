/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo17taxi;

/**
 *
 * @author mauri
 */

import java.lang.Thread;

public class Simulator{
    
   /**
   * Constants for the size of the simulation
   */
  public static final int TRAIN_TRIPS       = 10;
  public static final int MIN_TRAVELLERS    = 60;
  public static final int MAX_TRAVELLERS    = 80;
  public static final int CAPACITY_SMALL    = 4;
  public static final int CAPACITY_LARGE    = 7;
  public static final int TIME_SMALL        = 2;
  public static final int TIME_LARGE        = 3;
  public static final int NR_OF_TAXIS       = 4;
  public static final int NR_OF_SMALL_TAXIS = 2;

  /**
   * main elements of the simulation
   */
  private final Taxi[]  taxis;
  private final Train   train;
  private final Station station;
  
  public Simulator(){
    station = new Station();
    taxis   = new Taxi[NR_OF_TAXIS];
    for (int i = 0; i < NR_OF_TAXIS; i++) {
      taxis[i] = i < NR_OF_SMALL_TAXIS ?
                    //new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station) :
                    Thread small = new Thread(new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station));
                    new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
    }
    train = new Train(station);
  }
  
}
