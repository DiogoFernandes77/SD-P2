package Simulation.message.struct;

import Simulation.States.*;

import java.util.ArrayList;
import java.util.logging.Logger;
import Simulation.message.Message;
import java.io.Serializable;
import static Simulation.message.struct.LoggerMessage.LG_Message.*;
/**
 * Struct of Message usaged by Logger_Stub
 */
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
        PASS_IN_Q_SET,
        PASS_IN_Q,
        PASS_ENTER_PLANE,
        PASS_ENTER_PLANE_SET,
        PASS_ATL,
        PASS_ATL_SET,
        PASS_CHECK,

        DEPARTED,
        SUMMARY
    }

    private LG_Message type;
    private int id;
    //auxiliary variables
    int FN; // number of flight
    public Passenger_State ST_Passenger; // State of the Passengers; save state of each passenger
    public Pilot_State ST_Pilot; // State of the Pilot
    public Hostess_State ST_Hostess; // State of the Hostess

    public ArrayList<Integer> Q; // State of the waiting queue
    public ArrayList<Integer> IN_F; // State of in flight
    public ArrayList<Integer> ATL; // State of number of passengers that have already arrived at their destination
    private String log;
    public ArrayList<String> Summary = new ArrayList<>();
    public int capacity;

    /**
     * Constructor for setting type of message received
     * @param type
     */
    public LoggerMessage(LG_Message type) {this.type = type;}

    /**
     * Constructor for setting type of message received.
     * Set ID, and state of passenger
     * @param type
     * @param st
     * @param id
     */
    public LoggerMessage(LG_Message type, Passenger_State st, int id){
        this(type);
        this.id = id;
        this.ST_Passenger = st;
    }

    /**
     * Constructor for setting type of message received.
     * Set ID, state of passenger and log
     * @param type
     * @param st
     * @param id
     * @param x
     */
    public LoggerMessage(LG_Message type, Passenger_State st, int id, String x){
        this(type, st, id);
        this.log = x;
    }

    /**
     * Constructor for setting type of message received.
     * Set state of hostess
     * @param type
     * @param ht
     */
    public LoggerMessage(LG_Message type, Hostess_State ht){
        this(type);
        this.ST_Hostess = ht;
    }

    /**
     * Constructor for setting type of message received.
     * Set state of hostess and log
     * @param type
     * @param ht
     * @param x
     */
    public LoggerMessage(LG_Message type, Hostess_State ht,String x){
        this(type, ht);
        this.log = x;
    }

    /**
     * Constructor for setting type of message received.
     * Set state of pilot
     * @param type
     * @param pl
     */
    public LoggerMessage(LG_Message type, Pilot_State pl){
        this(type);
        this.ST_Pilot = pl;
    }

    /**
     * Constructor for setting type of message received.
     * Set state of pilot and log
     * @param type
     * @param pl
     * @param x
     */
    public LoggerMessage(LG_Message type, Pilot_State pl, String x){
        this(type,pl);
        this.log = x;
    }

    /**
     * Constructor for setting type of message received.
     * Set state of pilot and number of flight
     * @param type
     * @param pl
     * @param fn
     */
    public LoggerMessage(LG_Message type, Pilot_State pl, int fn){
        this(type,pl);
        this.FN = fn;
    }

    /* * Constructor for setting type of message received.
     * @param type
     * @param arrayList
     * Verify arrayList receive and create a new one based on receive type message
     */
    public LoggerMessage(LG_Message type, ArrayList<Integer> arrayList){
        this(type);
        if (PASS_ENTER_PLANE.equals(type))
            this.IN_F = arrayList;
        else if (PASS_IN_Q.equals(type))
            this.Q = arrayList;
        else if(PASS_ATL.equals(type))
            this.ATL = arrayList;
    }

    /* * Constructor for setting type of message received.
     * @param type
     * @param x - output: passenger x checked
     */
    public LoggerMessage(LG_Message type, String x){
        this(type);
        this.log = x;
    }
    /* * Constructor for setting type of message received.
    departed
     * @param type
     * @param capacity
     */
    public LoggerMessage(LG_Message type, int capacity){
        this(type);
        this.capacity = capacity;
    }
    /**
     * Get type of enum
     * @return type enum
     */
    public LG_Message getType() { return this.type; }

    /**
     * Obtain String of enum
     * @return "Type:" + type
     */
    @Override
    public String toString() {
        return " type='" + getType();
    }

    /**
     * Get String of log
     * @return log
     */
    public String getLog() {
        return log;
    }
    /**
     * Get String id of passenger
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Get capacity plane
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Summary of flight : output in end of file
     * @return Summary
     */
    public ArrayList<String> getSummary() {
        return Summary;
    }

    /**
     * Get Number of flight
     * @return FN
     */
    public int getFN() { return FN; }

    /**
    * Get State of passenger
     */
    public Passenger_State getST_Passenger() { return ST_Passenger; }
    /**
     * Get State of pilot
     */
    public Pilot_State getST_Pilot() { return ST_Pilot; }
    /**
     * Get State of hostess
     */
    public Hostess_State getST_Hostess() { return ST_Hostess; }

    /**
     * Get arraylist of passenger that are in queue
     * @return Q
     */
    public ArrayList<Integer> getQ() { return Q; }
    /**
     * Get arraylist of passenger that are in flight
     * @return IN_F
     */
    public ArrayList<Integer> getIN_F() { return IN_F; }
    /**
     * Get arraylist of passenger that arrived at destination
     * @return ATL
     */
    public ArrayList<Integer> getATL() { return ATL; }


}
