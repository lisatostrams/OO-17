/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo17taxi;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */

import java.lang.Thread;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
    private Thread[] threads;
    private boolean hasEnded = false;

    /**
     * Constructor of Siimulator which makes 4 new Taxi objects and 1 train object.
     */
    public Simulator(){
        station = new Station();
        taxis   = new Taxi[NR_OF_TAXIS];
        for (int i = 0; i < NR_OF_TAXIS; i++) {
            taxis[i] = i < NR_OF_SMALL_TAXIS ?
                new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station):
                new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
        }
        train = new Train(station, TRAIN_TRIPS, MIN_TRAVELLERS, MAX_TRAVELLERS);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(train);
        for(Taxi tax : taxis){
            executor.execute(tax); 
        }
        executor.shutdown();
        try {
            boolean ended = executor.awaitTermination(2, TimeUnit.MINUTES);
            if(ended) showStatistics();
            else System.out.println("Timed out");
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        
    }
    
    /**
     * 
     * @return if the people who work at the station can close it.
     */
    public boolean ended() {
        return (train.getNrOfTrips() == TRAIN_TRIPS && station.waitingPassengers() == 0);
    }

    /**
     * shows statistics
     */
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
