package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.message.struct.DepartureAirpMessage;
import Simulation.message.struct.DepartureAirpMessage.DpAirpMessage;

import java.util.ArrayList;

import static Simulation.message.struct.DepartureAirpMessage.DpAirpMessage.*;

public class DepAirp_stub
{
    /**
     *   Singleton reference to Array Transfer
     */
    private static DepAirp_stub depAirp_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     * @return Singleton ArrivalTransfer instance
     */
    public static DepAirp_stub getInstance()
    {
        if (depAirp_stub == null)
        {
            depAirp_stub = new DepAirp_stub();
        }

        return depAirp_stub;
    }




    //-------------------------------------------------------pilot------------------------------------------------------------------
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

    public void waitForAllInBoarding( ){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(PIL_WAIT_FOR_ALL_BOARDING);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    public void parkAtTransferGate(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(PIL_PARK_AT_TRANSFER_GATE);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }

    //-------------------------------------------------------Hostess------------------------------------------------------------------
    //Hostess gets ready and waits until first passenger
    public void prepareForPassBoarding(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(HOS_PREPARE_PASS_BOARDING);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
 
    //Hostess check documents of the passenger in queue
    public void checkDocuments(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
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

    //Hostess waits for the passengers
    public void waitForNextPassenger(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(HOS_WAIT_FOR_NEXT_PASSENGER);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
 
    //Hostess signals pilot that he can fly
    public void informPlaneReadyToTakeOff(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(HOS_INFORM_PLANE_TAKEOFF);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
 
    //Hostess waits until next flight
    public void waitForNextFlight(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(HOS_WAIT_NEXT_FLIGHT);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
    //-------------------------------------------------------Hostess------------------------------------------------------------------
    public void enterQueue(int person_id){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(PASS_ENTER_QUEUE, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
    
    //Passenger waits in the queue before showing docs
    public void waitInQueue(int person_id){   
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(PASS_WAIT_QUEUE, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }
    
    //Passenger shows documents
    public void showDocuments(int person_id){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(PASS_SHOW_DOCS, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    }


    public int getCurrent_capacity(){
        ClientCom con = new ClientCom("localhost", 4001);
        DepartureAirpMessage requestMessage, responseMessage;
        
        int current_capacity = -1;
        if (con.open())
        {
            requestMessage = new DepartureAirpMessage(GET_CURRENT_CAPACITY);
            con.writeObject(requestMessage);
            responseMessage = (DepartureAirpMessage) con.readObject();
            current_capacity = responseMessage.getPerson_id();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from DepartureAirport");
            }
            con.close();
        }
    
        return current_capacity;
    
    
    }






}