package oo17taxi;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pieterkoopman
 */
public class Taxi implements Runnable{

    private final int taxiId;
    private final int maxNrOfPassengers;
    private final int transportationTime;
    private final Station station;
    //Simulator sim;
    
    private int totalNrOfPassengers = 0;
    private int nrOfRides = 0;
  
    public Taxi(int nr, int maxNumberOfPassengers, int transportationTime, Station station) {
        this.taxiId = nr;
        this.maxNrOfPassengers = maxNumberOfPassengers;
        this.transportationTime = transportationTime;
        this.station = station;
        System.out.println("Taxi " + nr + " created");
    }

    /**
     * Try to take the maximum number of passengers from the station. 
     * If actual number op passengers is less then that number is taken
     * When there are no passengers the taxi just waits a little
     */
    public synchronized void takePassengers() {
        int passengersWaiting = station.waitingPassengers();        
        if ( passengersWaiting > 0 ) {
            int nrOfPassengers = Math.min(passengersWaiting, maxNrOfPassengers);
            station.leaveStation(nrOfPassengers);
            totalNrOfPassengers += nrOfPassengers;
            nrOfRides++;
            System.out.println("Taxi " + taxiId + " takes " + nrOfPassengers + " passengers");
        } else {  
            System.out.println("There are no passengers for taxi " + taxiId);  
        }
    }
    /**
     * Calculates the total time of this taxi by multiplying the number of rides by the transportation time
     * @return total time
     */
    public int calcTotalTime() {
        return transportationTime * nrOfRides;
    }
    

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }

    @Override
    public void run() {
        //Synchronized(sim);
        if(station.waitingPassengers() == 0)
            try {
                Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (station.waitingPassengers() > 0) {
            takePassengers();
        }
    }
}