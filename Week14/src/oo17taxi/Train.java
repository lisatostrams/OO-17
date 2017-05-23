package oo17taxi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Trains bring a number of passengers to a station in the Taxi simulation
 * 
 * @author pieterkoopman
 */
public class Train implements Runnable{
    private int TRAIN_TRIPS;
    private int MIN_TRAVELLERS;
    private int MAX_TRAVELLERS;
    private int nrOfPassengers;
    private final Station station;
    private int nrOfTrips = 0;
    //Simulator sim;

    public Train(Station station, int train_trips, int min_travellers, int max_travellers) {
        this.TRAIN_TRIPS = train_trips;
        this.MIN_TRAVELLERS = min_travellers;
        this.MAX_TRAVELLERS = max_travellers;
        this.station = station;
        this.nrOfPassengers = 0;
    }

    /**
     * Populate this train with number nrOfPassengers
     *
     * @param number the number of passengers of this train
     */
    public synchronized void loadPassengers(int number) throws InterruptedException {
        //Thread.sleep(50);
        nrOfPassengers = number;
    }

    /**
    * empties this train and augment the number of Passengers at the station with
    * this nrOfPassenegers
    */
    public synchronized void unloadPassengers() throws InterruptedException {
        nrOfTrips += 1;
        station.enterStation(nrOfPassengers);
        Thread.sleep(100);
    }

    public void closeStation() {
        station.close();
    }

    public int getNrOfTrips() {
        return nrOfTrips;
    }

    @Override
    public void run() {
        while(nrOfTrips < TRAIN_TRIPS){
            if(station.waitingPassengers() == 0){
                //Synchronized(sim);
                try {
                    loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    unloadPassengers();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}