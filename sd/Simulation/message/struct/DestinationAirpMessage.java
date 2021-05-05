package Simulation.message.struct;

import Simulation.entities.Passenger;
import Simulation.message.Message;
import java.io.Serializable;

public class DestinationAirpMessage implements Serializable, Message{
    public enum DstAirpMessage{
            // generic    
        SUCCESSS,
        SHUT,
        
        //Pilot
        
        
        //Hostess
        


        //Passenger
        PASS_DEATH
    }
    
    private DstAirpMessage type;
    private Passenger person;

	


    public DestinationAirpMessage(DstAirpMessage type){
        this.type = type;

    }

    public DestinationAirpMessage(DstAirpMessage type, Passenger person){
        this.type = type;
        this.person = person;


    }
   
    public DstAirpMessage getType() {
		return this.type;
	}
	public Passenger getPerson() {
		return this.person;
	}
    
    @Override
    public String toString() {
        return " type='" + getType();
    }
            
            
}