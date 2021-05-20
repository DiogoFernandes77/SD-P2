/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */

package Simulation.client;

import java.util.ArrayList;
import java.util.Random;

//import Simulation.Log_file.Logger_Class;
import Simulation.stub.Plane_stub;
import Simulation.stub.DepAirp_stub;
import Simulation.stub.DestAirp_stub;

public class Passenger extends Thread{
    private int id_passenger = 0;
    private int count_AtDest = 0;

    public enum State{
        GOING_TO_AIRPORT,
        IN_QUEUE,
        IN_FLIGHT,
        AT_DESTINATION
    }
    private State passenger_state;
    
    public Passenger(int id){
        passenger_state = State.GOING_TO_AIRPORT;
        id_passenger = id;
        // synchronized (Logger_Class.class) {
        //     Logger_Class.getInstance().setST_Passenger(id_passenger, passenger_state);
        // }
    }

    //implementation of the method run which establishes the thread operativeness
    @Override
    public void run(){
        travelToAirport();
        enterQueue();
        waitInQueue();
        showDocuments();
        boardThePlane();
        waitForEndOfFlight();
        leaveThePlane();
        death();
    }

    //Passenger time to go to airport between 0 and 10 sec
    private void travelToAirport() {
        Random gen = new Random();
        int time = gen.nextInt(10);
        try{
            Thread.sleep(time * 100); 
        }catch(Exception e){
            System.out.print("Error traveling to airport");
        }
    }

    private void enterQueue(){
        passenger_state = State.IN_QUEUE;
        // synchronized (Logger_Class.class) {
        //     Logger_Class.getInstance().setST_Passenger(id_passenger, passenger_state);
        //     Logger_Class.getInstance().log_write("Passenger " + id_passenger + " is entering in queue");
        // }
        DepAirp_stub.getInstance().enterQueue(id_passenger);
    }

    private void waitInQueue(){
        passenger_state = State.IN_QUEUE;
        // synchronized (Logger_Class.class) {
        //     Logger_Class.getInstance().setST_Passenger(id_passenger, passenger_state);
        //     Logger_Class.getInstance().log_write("Passenger " + id_passenger + " is in queue");
        // }
        DepAirp_stub.getInstance().waitInQueue(id_passenger);
    }
    private void showDocuments(){ DepAirp_stub.getInstance().showDocuments(id_passenger); }

    private void boardThePlane(){ Plane_stub.getInstance().boardThePlane(id_passenger); }

    private void waitForEndOfFlight(){
        passenger_state = State.IN_FLIGHT;
        // synchronized (Logger_Class.class) {
        //     Logger_Class.getInstance().setST_Passenger(id_passenger, passenger_state);
        //     Logger_Class.getInstance().log_write("Passenger " + id_passenger + " is in flight");
        // }
        Plane_stub.getInstance().waitForEndOfFlight();
    }

    private void leaveThePlane(){ Plane_stub.getInstance().leaveThePlane(id_passenger); }

    private void death(){
        passenger_state = State.AT_DESTINATION;

        // synchronized (Logger_Class.class) {
        //     Logger_Class.getInstance().setST_Passenger(id_passenger, passenger_state);
        //     Logger_Class.getInstance().log_write("Passenger " + id_passenger + " is at destination");
        // }
        
        DestAirp_stub.getInstance().Passenger_death(id_passenger);
    }

    public int getId_passenger(){
    return id_passenger;
    }

}