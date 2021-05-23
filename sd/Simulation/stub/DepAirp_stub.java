package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.message.struct.DepartureAirpMessage;


import java.util.ArrayList;

import static Simulation.message.struct.DepartureAirpMessage.DpAirpMessage.*;
/**
 * DepAirp_stub communication
 */
public class DepAirp_stub {
    /**
     *   Singleton reference to Array Transfer
     */
    private static DepAirp_stub depAirp_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     * @return Singleton ArrivalTransfer instance
     */
    public static DepAirp_stub getInstance() {
        if (depAirp_stub == null) {
            depAirp_stub = new DepAirp_stub();
        }
        return depAirp_stub;
    }

    //-------------------------------------------------------pilot------------------------------------------------------------------
    /**
     * Pilot inform Hostess that plane is ready to board
     */
    public void informPlaneReadyForBoarding(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(PIL_INFORM_PLANE_RDY_BOARD);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Waits for the passenger enter in the plane until hostess gives the signal
     */
    public void waitForAllInBoarding(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(PIL_WAIT_FOR_ALL_BOARDING);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Pilot inform that he is in transfer gate
     */
    public void parkAtTransferGate(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(PIL_PARK_AT_TRANSFER_GATE);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    //-------------------------------------------------------Hostess------------------------------------------------------------------

    /**
     * Hostess gets ready and waits until first passenger
     */
    public void prepareForPassBoarding(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(HOS_PREPARE_PASS_BOARDING);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Hostess check documents of the passenger in queue
     */
    public void checkDocuments(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(HOS_CHECK_DOCUMENTS);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Hostess waits for the passengers
     */
    public void waitForNextPassenger(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(HOS_WAIT_FOR_NEXT_PASSENGER);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Hostess signals pilot that he can fly
     */
    public void informPlaneReadyToTakeOff(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(HOS_INFORM_PLANE_TAKEOFF);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Hostess waits until next flight
     */
    public void waitForNextFlight(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(HOS_WAIT_NEXT_FLIGHT);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
    //-------------------------------------------------------Hostess------------------------------------------------------------------

    /**
     * Passenger person enters in queue
     * @param person_id - id passenger
     */
    public void enterQueue(int person_id){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(PASS_ENTER_QUEUE, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
    
    /**
     * Passenger waits in the queue before showing docs
     * @param person_id - id passenger
     */
    public void waitInQueue(int person_id){   
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(PASS_WAIT_QUEUE, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    /**
     * Passenger shows documents
     * @param person_id - id passenger
     */
    public void showDocuments(int person_id){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(PASS_SHOW_DOCS, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
    /**
     * getCurrent_capacity
     * @return current_capacity
     */
    public int getCurrent_capacity(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        int current_capacity = -1;
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(GET_CURRENT_CAPACITY);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            current_capacity = responseMessage.getPerson_id();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return current_capacity;
    }
    /**
     * get passenger left
     * @return passenger_left
     */
    public int getPassenger_left(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        int passenger_left = -1;
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(GET_PASSENGER_LEFT);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            passenger_left = responseMessage.getPerson_id();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return passenger_left;
    }
    /**
     * getBoardingMax
     * @return boardMax
     */
    public int getBoardingMax(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        int board_max = -1;
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(GET_BOARD_MAX);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            board_max = responseMessage.getPerson_id();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return board_max;
    }
    /**
     * getBoardingMin
     * @return boardMin
     */
    public int getBoardingMin(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        int board_min = -1;
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(GET_BOARD_MIN);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            board_min = responseMessage.getPerson_id();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return board_min;
    }
    /**
     * getIsQueueEmpty
     * @return <li>True if is empty <li> False if not
     */
    public boolean getIsQueueEmpty(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        boolean queueEmpty = false;
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(GET_IS_QUEUE_EMPTY);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            queueEmpty = responseMessage.isCheck();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return queueEmpty;
    }
    /**
     * stillPassenger
     * @return <li>True if is empty <li> False if not
     */
    public boolean stillPassenger(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        boolean still_passenger = false;
        if (con.open()) {
            requestMessage = new DepartureAirpMessage(STILL_PASSENGER);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            still_passenger = responseMessage.isCheck();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return still_passenger;
    }

}