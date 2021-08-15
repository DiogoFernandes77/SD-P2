package Simulation.message.struct;

import Simulation.message.Message;
import java.io.Serializable;
/**
 * Struct of Message usaged by DestAirp_stub
 */
public class DestinationAirpMessage implements Serializable, Message{
    public enum DstAirpMessage{
        // generic
        SUCCESS,
        SHUT,
        //Pilot
        //Hostess
        //Passenger
        PASS_DEATH
    }
    
    private DstAirpMessage type;
    private int id;

    /**
     * Constructor for setting type of message received
     * @param type
     */
    public DestinationAirpMessage(DstAirpMessage type){
        this.type = type;
    }

    /**
     * Constructor for message of passenger of person_id
     * @param type,
     * @param id
     */
    public DestinationAirpMessage(DstAirpMessage type, int id){
        this.type = type;
        this.id = id;
    }

    /**
     * Obtain id of passenger
     * @return id
     */
	public int getId() {
		return this.id;
	}

    /**
     * Get type of enum
     * @return type enum
     */
    @Override
    public DstAirpMessage getType() {
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