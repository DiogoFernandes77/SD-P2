/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */

package Simulation.server.DestinationAirp;

import Simulation.stub.Logger_stub;
import java.util.ArrayList;

public class DestAirport{
    private static DestAirport destArp_instance = null;
    private final ArrayList<Integer> passenger_arrived;
    public DestAirport(){
        passenger_arrived = new ArrayList<Integer>();
        Logger_stub.getInstance().arr("ATL",passenger_arrived);
    }

    //---------------------------------------------------/Passenger methods/-----------------------------------------------------//
    
    //Passenger death, adds himself to the list of passenger that arrived
    public void Passenger_death(int person){ passenger_arrived.add(person);
        Logger_stub.getInstance().arr("ATL",passenger_arrived); }
} 