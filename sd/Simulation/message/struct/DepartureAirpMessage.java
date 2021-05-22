package Simulation.message.struct;

import Simulation.message.Message;
import java.io.Serializable;

public class DepartureAirpMessage implements Serializable, Message{
    public enum DpAirpMessage{
        // generic    
        SUCCESS,
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
        
        GET_CURRENT_CAPACITY,
        GET_BOARD_MIN,
        GET_BOARD_MAX,
        GET_IS_QUEUE_EMPTY,
        GET_PASSENGER_LEFT,
        STILL_PASSENGER
    }

    private DpAirpMessage type; 
    private int person_id;
    private boolean check; 

    public DepartureAirpMessage(DpAirpMessage type){ this.type = type; }

    public DepartureAirpMessage(DpAirpMessage type, int person_id){
        this.type = type;
        this.person_id = person_id;
    }
    
    public DepartureAirpMessage(DpAirpMessage type, boolean check){
        this.type = type;
        this.check = check;
    }

    public boolean isCheck() {
        return this.check;
    }
    
    public int getPerson_id() {
        return this.person_id;
    }

    @Override
    public Enum getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Type: " + type;
    }
}