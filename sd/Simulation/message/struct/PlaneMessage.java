package Simulation.message.struct;

import Simulation.message.Message;
import java.io.Serializable;
/**
 * Struct of Message usaged by Plane
 */
public class PlaneMessage implements Serializable, Message{
    public enum PlMessage{
        // generic    
        SUCCESS,
        SHUT,
        GET_CAPACITY,
        //Pilot
        PIL_FlY_TO_DEST,
        PIL_SET_FLIGHT_ID,
        PIL_AN_ARRIVAL,
        PIL_FLY_TO_DEP,
        
        //Hostess
        HOS_WAIT_BOARDING,

        //Passenger
        PASS_BOARD_PLANE,
        PASS_WAIT_END_FLIGHT,
        PASS_LEAVE_PLANE
    }

    private PlMessage type;
    private int id;

    /**
     * Constructor for setting type of message received
     * @param type
     */
    public PlaneMessage(PlMessage type){
        this.type = type;
    }
    /**
     * Constructor for setting type of message received of passenger of id
     * @param type,
     * @param id
     */
    public PlaneMessage(PlMessage type, int id){
        this.type = type;
        this.id = id;
    }

    /**
     * Get type of enum
     * @return type enum
     */
    public PlMessage getType() {
        return this.type;
    }

    /**
     * Get person_id
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Obtain String of enum
     * @return "Type:" + type
     */
    @Override
    public String toString() {
        return " type:'" + getType();
    }
}