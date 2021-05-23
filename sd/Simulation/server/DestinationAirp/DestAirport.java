/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */

package Simulation.server.DestinationAirp;

import Simulation.stub.Logger_stub;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DestAirport{
    private final Lock lock;
    private static DestAirport destArp_instance = null;
    private static ArrayList<Integer> passenger_arrived;
    public DestAirport(){
        passenger_arrived = new ArrayList<Integer>();
        lock = new ReentrantLock();
    }

    //---------------------------------------------------/Passenger methods/-----------------------------------------------------//
    
    //Passenger death, adds himself to the list of passenger that arrived
    public void Passenger_death(int person){ 
        lock.lock();
        try{
            passenger_arrived.add(person);
        
            Logger_stub.getInstance().pass_leave_plane(passenger_arrived);
        
        
        }catch(Exception e){
            System.out.println("Interrupter Exception Error - " + e);
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        
        
        
        
        }



    } 