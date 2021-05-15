package Simulation.message.struct;

import Simulation.message.Message;
import java.io.Serializable;

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

	


    public DestinationAirpMessage(DstAirpMessage type){
        this.type = type;

    }

    public DestinationAirpMessage(DstAirpMessage type, int id){
        this.type = type;
        this.id = id;


    }
   
    public DstAirpMessage getType() {
		return this.type;
	}
	public int getId() {
		return this.id;
	}
    
    @Override
    public String toString() {
        return " type='" + getType();
    }
            
            
}