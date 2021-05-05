package Simulation.message.struct;

import Simulation.client.Passenger;
import Simulation.message.Message;
import java.io.Serializable;

public class DepartureAirpMessage implements Serializable, Message{
    @Override
    public Enum getType() {
        return null;
    }

    public enum DpAirpMessage{
        // generic    
        SUCCESSS,
        SHUT,
        
        //Pilot
        PIL_INFORM_PLANE_RDY_BOARD,
        PIL_WAIT_FOR_ALL_BOARDING,
        PIL_PARK_AT_TRANSFER_GATE,
        //Hostess
        HOS_PREPARE_PASS_BOARDING,
        HOS_CHECK_DOCUMENTS,
        HOS_WAIT_FOR_NEXT_PASSENGER,
        HOS_INFORM_PLANE_TAKEOFF,
        HOS_WAIT_NEXT_FLIGHT,


        //Passenger
        PASS_ENTER_QUEUE,
        PASS_WAIT_QUEUE,
        PASS_SHOW_DOCS,
        
  
    }
    private DpAirpMessage type; 
    private Passenger person;


    public DepartureAirpMessage(DpAirpMessage type){
        this.type = type;

    }

    public DepartureAirpMessage(DpAirpMessage type, Passenger person){
        this.type = type;
        this.person = person;
    }

}