package Simulation.message.struct;

import Simulation.client.Hostess;
import Simulation.client.Passenger;
import Simulation.client.Pilot;
import java.util.ArrayList;
import java.util.logging.Logger;
import Simulation.message.Message;
import java.io.Serializable;
import static Simulation.message.struct.LoggerMessage.LG_Message.*;

public class LoggerMessage implements Serializable, Message{
    public enum LG_Message{
        //GENERIC MESSAGE
        SUCCESS,
        SHUT,

        //Pilot
        PIL_STATE,
        PIL_STATE_LOG,

        //Hostess
        HOS_STATE,
        HOS_STATE_LOG,

        //Passenger
        PASS_STATE,
        PASS_STATE_LOG,

        DEPARTED,
        SUMMARY
    }

    private LG_Message type;
    private int id;
    //auxiliary variables
    int FN; // number of flight
    public Passenger.State ST_Passenger; // State of the Passengers; save state of each passenger
    public Pilot.State ST_Pilot; // State of the Pilot
    public Hostess.State ST_Hostess; // State of the Hostess

    public ArrayList<Integer> Q; // State of the waiting queue
    public ArrayList<Integer> IN_F; // State of in flight
    public ArrayList<Integer> ATL; // State of number of passengers that have already arrived at their destination
    private String log;
    public ArrayList<String> Summary = new ArrayList<>();
    public int capacity;

    //constructor primary
    public LoggerMessage(LG_Message type) {this.type = type;}

    //state passenger
    public LoggerMessage(LG_Message type, Passenger.State st, int id){
        this(type);
        this.id = id;
        this.ST_Passenger = st;
    }
    //log passenger
    public LoggerMessage(LG_Message type, Passenger.State st, int id, String x){
        this(type, st, id);
        this.log = x;
    }

    public LoggerMessage(LG_Message type, ArrayList<Integer> x, Passenger.State st, int id){
        this(type, st, id);

    }

    //state hostess
    public LoggerMessage(LG_Message type, Hostess.State ht){
        this(type);
        this.ST_Hostess = ht;
    }

    public LoggerMessage(LG_Message type, Hostess.State ht,String x){
        this(type, ht);
        this.log = x;
    }

    //inform plane take off
    public LoggerMessage(LG_Message type, Hostess.State ht, int cap){
        this(type, ht);
        this.capacity = cap;
    }

    //states pilot
    public LoggerMessage(LG_Message type, Pilot.State pl){
        this(type);
        this.ST_Pilot = pl;
    }

    //logger pilot
    public LoggerMessage(LG_Message type, Pilot.State pl, String x){
        this(type,pl);
        this.log = x;
    }

    //pilot set fn
    public LoggerMessage(LG_Message type, Pilot.State pl, int fn){
        this(type,pl);
        this.FN = fn;
    }


    public LG_Message getType() { return this.type; }


    @Override
    public String toString() {
        return " type='" + getType();
    }

    public String getLog() {
        return log;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getSummary() {
        return Summary;
    }

    public int getFN() { return FN; }

    public Passenger.State getST_Passenger() { return ST_Passenger; }

    public Pilot.State getST_Pilot() { return ST_Pilot; }

    public Hostess.State getST_Hostess() { return ST_Hostess; }

    public ArrayList<Integer> getQ() { return Q; }

    public ArrayList<Integer> getIN_F() { return IN_F; }

    public ArrayList<Integer> getATL() { return ATL; }


}
