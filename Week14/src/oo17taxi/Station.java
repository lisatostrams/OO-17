package oo17taxi;

/**
 * Class that holds the number of persons arriving by train at the station and
 * waiting for a taxi
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    
    public synchronized void enterStation(int nrOfPassengers) {
        nrOfPassengersAtStation += nrOfPassengers;
        totalNrOfPassengers += nrOfPassengers;
        System.out.println(nrOfPassengers + " passengers arrived at station");
    }
    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public synchronized void leaveStation(int nrOfPassengers) {
        nrOfPassengersAtStation -= nrOfPassengers;
    }

    public synchronized int waitingPassengers() {
        return nrOfPassengersAtStation;
    }
    
    public void close() {
        isClosed = true;
    }
    
    public boolean isClosed() {
        return isClosed;     
    }

    public synchronized int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }
}