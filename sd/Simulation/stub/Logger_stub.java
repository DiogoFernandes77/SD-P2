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
/**
 * Logger_stub communication
 */
public class Logger_stub {
    /**
     * Singleton reference to Logger_stub
     */
    private static Logger_stub logger_stub = null;

    /**
     * Communication function
     * Creates a singleton for Logger_stub .
     *
     * @return Singleton Logger_stub instance
     */
    public static Logger_stub getInstance() {
        if (logger_stub == null) {
            logger_stub = new Logger_stub();
        }
        return logger_stub;
    }

    /**
     * Communication function
     * Set ID, and state of passenger
     *
     * @param st
     * @param id
     */
    public void pass_state(Passenger_State st, int id) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PASS_STATE, st, id);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Set ID, state of passenger and log
     *
     * @param st
     * @param id
     * @param x
     */
    public void pass_state_log(Passenger_State st, int id, String x) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PASS_STATE_LOG, st, id, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * output flight x: passenger y checked.
     *
     * @param x
     */
    public void pass_check(String x) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PASS_CHECK, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Set state of pilot
     *
     * @param p
     */
    public void pil_state(Pilot_State p) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PIL_STATE, p);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();

            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }

            con.close();
        }
    }

    /**
     * Communication function
     * Set state of pilot and log
     *
     * @param p
     * @param x
     */
    public void pil_state_log(Pilot_State p, String x) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PIL_STATE_LOG, p, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();

            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }

            con.close();
        }
    }

    /**
     * Communication function
     * Set state of pilot and number of flight
     *
     * @param p
     * @param fn
     */
    public void pil_board_start(Pilot_State p, int fn) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PIL_STATE_LOG, p, fn);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }

            con.close();
        }
    }

    /**
     * Communication function
     * departed
     *
     * @param capacity
     */
    public void departed(int capacity) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(DEPARTED, capacity);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Set state of hostess and log
     *
     * @param ht
     */
    // Hostess method
    public void hostess_state(Hostess_State ht) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(HOS_STATE, ht);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Set state of hostess and log
     *
     * @param ht
     * @param x
     */
    public void hostess_state_log(Hostess_State ht, String x) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(HOS_STATE_LOG, ht, x);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Passenger enters on queue
     * @param arrayList
     */
    public void pass_enter_queue(Queue<Integer> arrayList) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;
        ArrayList<Integer> list = new ArrayList<>(arrayList);
        if (con.open()) {
            requestMessage = new LoggerMessage(PASS_IN_Q, list);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Passegenrs enters in plane
     * @param arrayList
     */
    public void pass_in_flight(ArrayList<Integer> arrayList) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PASS_ENTER_PLANE, arrayList);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Communication function
     * Passenger leaves plane
     * @param arrayList
     */
    public void pass_leave_plane(ArrayList<Integer> arrayList) {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(PASS_ATL, arrayList);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }

    /**
     * Shutdown log
     */
    public void shutdown() {
        ClientCom con = new ClientCom("localhost", 4004);
        LoggerMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new LoggerMessage(SHUT);
            con.writeObject(requestMessage);
            responseMessage = (LoggerMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Logger");
            }
            con.close();
        }
    }
}