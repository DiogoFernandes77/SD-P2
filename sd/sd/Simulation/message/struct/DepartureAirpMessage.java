package Simulation.message.struct;

import Simulation.message.Message;
import java.io.Serializable;

/**
 * Struct of Message usaged by DepAirp_stub
 */
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

    /**
     * Constructor for setting type of message received
     * @param type
     */
    public DepartureAirpMessage(DpAirpMessage type){ this.type = type; }

    /**
     * Constructor for message of passenger of person_id
     * @param type,
     * @param person_id
     */
    public DepartureAirpMessage(DpAirpMessage type, int person_id){
        this.type = type;
        this.person_id = person_id;
    }

    /**
     * Constructor for message of type check
     * @param type,
     * @param check
     */
    public DepartureAirpMessage(DpAirpMessage type, boolean check){
        this.type = type;
        this.check = check;
    }

    /**
     * Verify check
     * @return <li>True <li>False
     */
    public boolean isCheck() {
        return this.check;
    }

    /**
     * Get person_id
     * @return person_id
     */
    public int getPerson_id() {
        return this.person_id;
    }

    /**
     * Get type of enum
     * @return type enum
     */
    @Override
    public Enum getType() {
        return this.type;
    }

    /**
     * Obtain String of enum
     * @return "Type:" + type
     */
    @Override
    public String toString() {
        return "Type: " + type;
    }
}