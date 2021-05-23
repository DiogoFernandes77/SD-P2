package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.client.Hostess;
import Simulation.client.Passenger;
import Simulation.client.Pilot;
import Simulation.message.struct.DepartureAirpMessage;
import Simulation.message.struct.LoggerMessage;
import Simulation.States.*;
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
    public static Logger_stub getInstance() {
        if (logger_stub == null) {
            logger_stub = new Logger_stub();
        }

        return logger_stub;
    }

    // Passenger methods
    public void pass_state(Passenger_State st, int id){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PASS_STATE, st,id);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    //Passenger log
    public void pass_state_log(Passenger_State st, int id, String x){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PASS_STATE_LOG, st,id, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void pass_check(String x){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PASS_CHECK,x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    } //flight x: passenger y checked.

    public void pil_state(Pilot_State p){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PIL_STATE, p);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();

            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }

            con.close();
        }
    
    }

    public void pil_state_log(Pilot_State p, String x) {
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PIL_STATE_LOG, p, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
           
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            
           
            con.close();
        }
    }

    public void pil_board_start(Pilot_State p, int fn){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PIL_STATE_LOG,p,fn);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            
            con.close();
        }
    }

    public void departed(int capacity){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(DEPARTED, capacity);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    // Hostess method
    public void hostess_state(Hostess_State ht){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(HOS_STATE, ht);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void hostess_state_log(Hostess_State ht, String x){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(HOS_STATE_LOG, ht, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void pass_enter_queue(Queue<Integer> arrayList){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;
        ArrayList<Integer>list = new ArrayList<>(arrayList);
        if (con.open()){
            requestMessage = new LoggerMessage(PASS_IN_Q,list);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void pass_in_flight(ArrayList<Integer> arrayList){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PASS_ENTER_PLANE,arrayList);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void pass_leave_plane_set(ArrayList<Integer> arrayList){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PASS_ATL_SET,arrayList);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void pass_leave_plane(ArrayList<Integer> arrayList){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(PASS_ATL,arrayList);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    public void shutdown(){
        ClientCom con = new ClientCom("l040101-ws04.ua.pt",22353);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()){
            requestMessage = new LoggerMessage(SHUT);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }
}