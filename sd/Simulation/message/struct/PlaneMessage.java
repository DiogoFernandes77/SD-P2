package Simulation.message.struct;

import Simulation.entities.Passenger;
import Simulation.locations.Plane;
import Simulation.message.Message;
import java.io.Serializable;

public class PlaneMessage implements Serializable, Message{
    public enum PlMessage{
        // generic    
        SUCCESSS,
        SHUT,
        
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
    private int flight_id;
    private Passenger person;

   
   


    public PlaneMessage(PlMessage type){
        this.type = type;

    }

    public PlaneMessage(PlMessage type, int flight_id){
        this.type = type;
        this.flight_id = flight_id;
        
    }



    public PlaneMessage(PlMessage type, Passenger person){
        this.type = type;
        this.person = person;


    }
    
    public PlMessage getType() {
        return this.type;
    }

    public int getFlight_id() {
        return this.flight_id;
    }

    public Passenger getPerson() {
        return this.person;
    }


}