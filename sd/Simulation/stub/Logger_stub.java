package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.client.Hostess;
import Simulation.client.Passenger;
import Simulation.client.Pilot;
import Simulation.message.struct.LoggerMessage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static Simulation.message.struct.LoggerMessage.LG_Message.*;

public class Logger_stub {
    /**
     *   Singleton reference to Array Transfer
     */
    private static Logger_stub logger_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     * @return Singleton ArrivalTransfer instance
     */
    public static Logger_stub getInstance()
    {
        if (logger_stub == null)
        {
            logger_stub = new Logger_stub();
        }

        return logger_stub;
    }

    public void send(LoggerMessage outM){
        ClientCom con = new ClientCom("localhost",4004);
        LoggerMessage in;
        if (con.open()){
            con.writeObject(outM);
            in = (LoggerMessage) con.readObject();
            if (in.getType() != SUCCESS){
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }


    // Passenger methods
    public void pass_state(Passenger.State st, int id){
        this.send(new LoggerMessage(PASS_STATE, st,id));
    }
    //Passenger log
    public void pass_state_log(Passenger.State st, int id, String x){
        this.send(new LoggerMessage(PASS_STATE_LOG, st,id, x));
    }

    public void pil_state(Pilot.State p){
        this.send(new LoggerMessage(PIL_STATE, p));
    }
    public void pil_state_log(Pilot.State p, String x) {
        this.send(new LoggerMessage(PIL_STATE_LOG, p, x));
    }
    public void pil_board_start(Pilot.State p, int fn){
        this.send(new LoggerMessage(PIL_STATE_LOG,p,fn));
    }

    // Hostess method
    public void hostess_state(Hostess.State ht){
        this.send(new LoggerMessage(HOS_STATE, ht));
    }

    public void hostess_state_log(Hostess.State ht, String x){
        this.send(new LoggerMessage(HOS_STATE_LOG, ht, x));
    }

    public void shutdown(){
        
        this.send(new LoggerMessage(LoggerMessage.LG_Message.SHUT)); 
        
    }
}