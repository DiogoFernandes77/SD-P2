/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */
package Simulation.client;
import Simulation.stub.Logger_stub;
import Simulation.stub.Plane_stub;
import Simulation.stub.DepAirp_stub;
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
        Logger_stub.getInstance().pilot_at_trans(pilot_state);
    }

    //implementation of the method run which establishes the thread operativeness
    @Override
    public void run(){
        do{
            setFlightID();
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

    private void setFlightID(){
    	id_to_set++;
        Plane_stub.getInstance().setFlightId(id_to_set);
    }
    
    private void informPlaneReadyForBoarding(){
        pilot_state = State.READY_FOR_BOARDING;
        Logger_stub.getInstance().pilot_ready(pilot_state, id_to_set);
        System.out.println("Pilot " + pilot_state);
        DepAirp_stub.getInstance().informPlaneReadyForBoarding();
    }

    private void waitForAllInBoarding(){
        pilot_state = State.WAIT_FOR_BOARDING;
        Logger_stub.getInstance().pilot_wait(pilot_state);
        DepAirp_stub.getInstance().waitForAllInBoarding();
    }

    private void flyToDestinationPoint(){
        pilot_state = State.FLYING_FORWARD;
        Logger_stub.getInstance().pilot_fly_for(pilot_state, id_to_set,flight_passanger_number);
        Plane_stub.getInstance().flyToDestinationPoint();
    }

    private void announceArrival(){
        pilot_state = State.DEBOARDING;
        Logger_stub.getInstance().pilot_deb(pilot_state, id_to_set);
        Plane_stub.getInstance().announceArrival();
    }

    private void flyToDeparturePoint(){
        pilot_state = State.FLYING_BACK;
        Logger_stub.getInstance().pilot_fly_bck(pilot_state,id_to_set);
        Plane_stub.getInstance().flyToDeparturePoint();
    }
    
    private void parkAtTransferGate(){
        pilot_state = State.AT_TRANSFER_GATE;
        Logger_stub.getInstance().pilot_at_trans(pilot_state);
        DepAirp_stub.getInstance().parkAtTransferGate();
    }

    public boolean stillPassenger(){
        return DepAirp_stub.getInstance().stillPassenger();
    }

    public int getFlight_passanger_number() {
        return this.flight_passanger_number;
    }

    public void setFlight_passanger_number(int flight_passanger_number) { this.flight_passanger_number = flight_passanger_number; }
}
