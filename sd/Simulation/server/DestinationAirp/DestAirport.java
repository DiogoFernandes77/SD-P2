/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */

package Simulation.server.DestinationAirp;

import java.util.ArrayList;
//import Simulation.server.Log_file.Logger_Class;

public class DestAirport{
    private static DestAirport destArp_instance = null;
    private final ArrayList<Integer> passenger_arrived;
    public DestAirport(){
        passenger_arrived = new ArrayList<Integer>();
        // synchronized(Logger_Class.class){
        //     Logger_Class.getInstance().setATL(passenger_arrived);
        // }
    }

    // public static DestAirport getInstance() {
    //     if (destArp_instance == null)
    //         destArp_instance = new DestAirport();
    //     return destArp_instance;
    // }

    //---------------------------------------------------/Passenger methods/-----------------------------------------------------//
    
    //Passenger death, adds himself to the list of passenger that arrived
    public void Passenger_death(int person){ passenger_arrived.add(person); }

} 