/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */

package Simulation.entities;

import Simulation.Log_file.Logger_Class;
import Simulation.locations.DepartAirport;
import Simulation.locations.Plane;

public class Pilot extends Thread{
    public enum State{
        AT_TRANSFER_GATE,
        READY_FOR_BOARDING,
        WAIT_FOR_BOARDING,
        FLYING_FORWARD,
        DEBOARDING,
        FLYING_BACK
    }

    private State pilot_state;
    private int flight_passanger_number;
    public int id_to_set = 0;
    private State get_State(){
        return pilot_state;
    }

    public Pilot(){
        pilot_state = State.AT_TRANSFER_GATE;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
        }
    }

    //implementation of the method run which establishes the thread operativeness
    @Override
    public void run(){
        do{
            informPlaneReadyForBoarding();
            waitForAllInBoarding();
            System.out.print("PILOT: GOING TO FLY \n" );
            flyToDestinationPoint();
            System.out.print("PILOT: Arrived \n" );
            announceArrival();
            flyToDeparturePoint();
            parkAtTransferGate();
        }while(stillPassenger());
        
        System.out.println("PILOT RUNS ENDED \n");
    }

    private void informPlaneReadyForBoarding(){
        id_to_set++;
        Plane.getInstance().setFlightId(id_to_set);
        pilot_state = State.READY_FOR_BOARDING;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
            Logger_Class.getInstance().setFN(id_to_set);
            Logger_Class.getInstance().board_start("\nFlight " + id_to_set + ": boarding started.\n");
        }
        System.out.println("Pilot " + pilot_state);
        DepartAirport.getInstance().informPlaneReadyForBoarding();
    }

    private void waitForAllInBoarding(){
        pilot_state = State.WAIT_FOR_BOARDING;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
            Logger_Class.getInstance().log_write("Pilot is waiting for boarding");
        }
        DepartAirport.getInstance().waitForAllInBoarding();
    }

    private void flyToDestinationPoint(){
        pilot_state = State.FLYING_FORWARD;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
            Logger_Class.getInstance().log_write("Pilot is flying forward");
        }
        Plane.getInstance().flyToDestinationPoint();
    }

    private void announceArrival(){
        pilot_state = State.DEBOARDING;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
            Logger_Class.getInstance().board_start("\nFlight " + id_to_set + ": arrived.\n");
        }
        Plane.getInstance().announceArrival();
    }

    private void flyToDeparturePoint(){
        pilot_state = State.FLYING_BACK;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
            Logger_Class.getInstance().board_start("\nFlight " + id_to_set + ": returning.\n");
        }
        Plane.getInstance().flyToDeparturePoint();
    }
    
    private void parkAtTransferGate(){
        pilot_state = State.AT_TRANSFER_GATE;
        synchronized (Logger_Class.class)
        {
            Logger_Class.getInstance().setST_Pilot(pilot_state);
            Logger_Class.getInstance().log_write("Pilot is at transfer gate");
        }
        DepartAirport.getInstance().parkAtTransferGate();
    }

    public boolean stillPassenger(){
        return DepartAirport.getInstance().stillPassenger();
    }

    public int getFlight_passanger_number() {
        return this.flight_passanger_number;
    }

    public void setFlight_passanger_number(int flight_passanger_number) { this.flight_passanger_number = flight_passanger_number; }

}