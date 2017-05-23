package oo17taxi;

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
    public void loadPassengers(int number) {
        nrOfPassengers = number;
    }

    /**
    * empties this train and augment the number of Passengers at the station with
    * this nrOfPassenegers
    */
    public void unloadPassengers() {
        nrOfTrips += 1;
        station.enterStation(nrOfPassengers);
    }

    public void closeStation() {
        station.close();
    }

    public int getNrOfTrips() {
        return nrOfTrips;
    }

    @Override
    public void run() {
        while(nrOfTrips < TRAIN_TRIPS)
        if(station.waitingPassengers() == 0){
                loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
                unloadPassengers();
            }
        
    }
}