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
        PIL_INFORM_PLANE_RDY_BOARD,
        PIL_WAIT_FOR_ALL_BOARDING,
        PIL_PARK_AT_TRANSFER_GATE,
        PIL_FlY_TO_DEST,
        PIL_AN_ARRIVAL,
        PIL_FLY_TO_DEP,

        //Hostess
        HOS_CHECK_DOCUMENTS,
        HOS_INFORM_PLANE_TAKEOFF,
        HOS_WAIT_NEXT_FLIGHT,
        HOS_WAIT_BOARDING,
        HOS_WAIT_FOR_PASSENGER,

        //Passenger
        PASS_STATE,
        PASS_GOING_TO_AIRPORT,
        PASS_ENTER_QUEUE,
        PASS_IN_FL,
        PASS_WAIT_QUEUE,
        PASS_LEAVE_PLANE,

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

    //constructor primary
    public LoggerMessage(LG_Message type) {this.type = type;}

    //construct type id passenger
    public LoggerMessage(LG_Message type, Passenger.State st, int id){
        this(type);
        this.id = id;
        this.ST_Passenger = st;
    }
    public LoggerMessage(LG_Message type, Passenger.State st, int id, String x){
        this(type, st, id);
        this.log = x;
          
        
    }

    public LoggerMessage(LG_Message type, ArrayList<Integer> x, Passenger.State st, int id){
        this(type, st, id);

        if(LG_Message.PASS_ENTER_QUEUE.equals(type))
            this.Q = x;
        else if(LG_Message.PASS_WAIT_QUEUE.equals(type))
            this.IN_F = x;
        else if (LG_Message.PASS_LEAVE_PLANE.equals(type))
            this.ATL = x;
    }

    //construct hostess
    public LoggerMessage(LG_Message type, Hostess.State ht){
        this(type);
        this.ST_Hostess = ht;
    }

    //inform plane take off
    public LoggerMessage(LG_Message type, Hostess.State ht, int cap){
        this(type, ht);
        this.log = "\nFlight " + FN + " departed with " + cap + " passengers.\n";
    }

    //construct pilot
    public LoggerMessage(LG_Message type, Pilot.State pl){
        this(type);
        this.ST_Pilot = pl;
    }
    //pilot message log
    public LoggerMessage(LG_Message type, Pilot.State pl, int fn){
        this(type,pl);
        if (PIL_INFORM_PLANE_RDY_BOARD.equals(type))
            this.log =  "\nFlight " + fn + ": boarding started.\n";
        else if (PIL_AN_ARRIVAL.equals(type))
            this.log = "\nFlight " + fn + ": arrived.\n";
        else if(PIL_FLY_TO_DEP.equals(type))
            this.log = "\nFlight " + fn + ": returning.\n";
    }

    // flight departed
    public LoggerMessage(LG_Message type, Pilot.State pl, int fn, int total){
        this(type, pl);
        this.log = "\nFlight " + FN + " departed with " + total + " passengers.\n";
    }

    // create array Q, inf, atl
    public LoggerMessage(String x, ArrayList<Integer> arrayList){
        if (x.equals("Q"))
            this.Q = arrayList;
        else if (x.equals("IN_F"))
            this.IN_F = arrayList;
        else if (x.equals("ATL"))
            this.ATL = arrayList;
    }

    //add Array Q, inf, at

    public LoggerMessage(LG_Message type, int f){
        this(type);
        this.FN = f;
    }

    public LoggerMessage(LG_Message type, ArrayList<Integer> cap){
        this.type = type;
        for (Integer integer : cap) Summary.add("Flight " + FN + " departed with " + integer + " passengers.");
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
