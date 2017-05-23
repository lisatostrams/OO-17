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
    private boolean hasEnded = false;

    public Simulator(){
        station = new Station();
        taxis   = new Taxi[NR_OF_TAXIS];
        for (int i = 0; i < NR_OF_TAXIS; i++) {
            taxis[i] = i < NR_OF_SMALL_TAXIS ?
                new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station):
                new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
        }
        train = new Train(station, TRAIN_TRIPS, MIN_TRAVELLERS, MAX_TRAVELLERS);
        for(Taxi tax : taxis){
            new Thread(tax).start();
        }
        new Thread(train).start();
    }

    public boolean ended() {
        return (train.getNrOfTrips() == TRAIN_TRIPS && station.waitingPassengers() == 0);
    }

    public void showStatistics() {
        System.out.println("All persons have been transported");
        System.out.println("Total transport time in this simulation:" + calcTotalTime(taxis));
        System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
        System.out.println("Total number of persons transported in this simulation: " + calcTotalNrOfPassengers(taxis));
    }

    /**
     * Calculates the total time of the simulation by looping over all taxis
     *
     * @param taxis
     * @return total time
    */
    private static int calcTotalTime(Taxi[] taxis) {
        int time = 0;
        for (Taxi taxi : taxis) {
            time += taxi.calcTotalTime();
        }
        return time;
    }

    /**
     * Calculates the total number of passengers that has been transported by
     * looping over all taxis
     *
     * @param taxis
     * @return total number of passengers
     */
    private static int calcTotalNrOfPassengers(Taxi[] taxis) {
        int total = 0;
        for (Taxi taxi : taxis) {
            total += taxi.getTotalNrOfPassengers();
        }
        return total;
    }
}
