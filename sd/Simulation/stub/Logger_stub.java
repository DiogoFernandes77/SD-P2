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

    // create and add arrays
    public void arr(String x, ArrayList<Integer> arrayList){ this.send(new LoggerMessage(x,arrayList)); }
    public void arrQ(String x, Queue<Integer> que) {
        ArrayList<Integer> q = new ArrayList<>(que);
        this.send(new LoggerMessage(x,q));
    }

    public void departed(int cap){
        ArrayList<Integer> summ = new ArrayList<>();
        summ.add(cap);
        this.send(new LoggerMessage(DEPARTED,summ));
    }

    // Passenger methods
    public void pass_state(Passenger.State st, int id){this.send(new LoggerMessage(PASS_STATE, st,id));}
    public void pass_state_log(Passenger.State st, int id, String x){
        this.send(new LoggerMessage(PASS_STATE, st,id, x));
    }
    /*//public void pass_air(Passenger.State st, int id){ this.send(new LoggerMessage(PASS_GOING_TO_AIRPORT, id, st));}
    public void pass_enter(ArrayList<Integer> arrayList){ this.send(new LoggerMessage(PASS_ENTER_QUEUE, arrayList);}
    public void pass_in_fl(Passenger.State st, int id, ArrayList<Integer> arrayList){ this.send(new LoggerMessage(PASS_IN_FL,arrayList, st, id));}
    public void pass_wait(Passenger.State st, int id, ArrayList<Integer> arrayList){ this.send(new LoggerMessage(PASS_WAIT_QUEUE, arrayList, st, id));}
    public void pass_leave(Passenger.State st,int id, ArrayList<Integer> arrayList){ this.send(new LoggerMessage(PASS_LEAVE_PLANE, arrayList, st, id));}
*/
    // Pilot methods
    public void pilot_at_trans(Pilot.State p){
        this.send(new LoggerMessage(PIL_PARK_AT_TRANSFER_GATE, p));
        }
    public void pilot_ready(Pilot.State p, int fn) { 
        this.send(new LoggerMessage(PIL_INFORM_PLANE_RDY_BOARD, p, fn)); }
    
        public void pilot_fly_for(Pilot.State p, int fn, int total){ this.send(new LoggerMessage(PIL_FlY_TO_DEST, p, fn, total)); 
    }
    public void pilot_wait(Pilot.State p) { this.send(new LoggerMessage(PIL_WAIT_FOR_ALL_BOARDING, p)); }
    public void pilot_fly_bck(Pilot.State p, int fn) { this.send(new LoggerMessage(PIL_FLY_TO_DEP, p, fn)); }
    public void pilot_deb(Pilot.State p, int fn){ this.send(new LoggerMessage(PIL_AN_ARRIVAL, p, fn)); }

    // Hostess method

    public void hostess_next_fl(Hostess.State h){ 
        this.send(new LoggerMessage(HOS_WAIT_NEXT_FLIGHT, h));
    }
    public void hostess_wt_pass(Hostess.State h){ 
        this.send(new LoggerMessage(HOS_WAIT_FOR_PASSENGER, h));
    }
    public void hostess_chk(Hostess.State h){
         this.send(new LoggerMessage(HOS_CHECK_DOCUMENTS, h));
        }
    public void hostess_rdy_fly(Hostess.State h, int cap){
        this.send(new LoggerMessage(HOS_INFORM_PLANE_TAKEOFF, h, cap));
    }

    public void shutdown(){
        
        this.send(new LoggerMessage(LoggerMessage.LG_Message.SHUT)); 
        
    }
}