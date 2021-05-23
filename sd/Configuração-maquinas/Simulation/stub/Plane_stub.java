package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.message.struct.PlaneMessage;


import java.util.ArrayList;

import static Simulation.message.struct.PlaneMessage.PlMessage.*;

public class Plane_stub
{
    /**
     *   Singleton reference to Array Transfer
     */
    private static Plane_stub plane_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     * @return Singleton ArrivalTransfer instance
     */
    public static Plane_stub getInstance()
    {
        if (plane_stub == null)
        {
            plane_stub = new Plane_stub();
        }

        return plane_stub;
    }

     //---------------------------------------------------/Pilot methods/-----------------------------------------------------//
     public void flyToDestinationPoint(){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PIL_FlY_TO_DEST);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    }
    
    public void setFlightId(int id){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PIL_SET_FLIGHT_ID,id);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
        System.out.print("PILOT: FLIGHT ID SET \n" );
    }
    

    public void announceArrival(){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PIL_AN_ARRIVAL);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    }
    
    public void flyToDeparturePoint(){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PIL_FLY_TO_DEP);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    }

    //---------------------------------------------------/Hostess methods/-----------------------------------------------------//
    public void waitBoarding(){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(HOS_WAIT_BOARDING);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }  
    }

    //---------------------------------------------------/Passenger methods/-----------------------------------------------------//
    public void boardThePlane(int person_id){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PASS_BOARD_PLANE,person_id);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    }
    
    public void waitForEndOfFlight(){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PASS_WAIT_END_FLIGHT);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    }
    
    public void leaveThePlane(int person_id){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new PlaneMessage(PASS_LEAVE_PLANE,person_id);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    }

    //---------------------------------------------------/getters/setters/-----------------------------------------------------//

    public int getCapacity(){
        ClientCom con = new ClientCom("l040101-ws02.ua.pt", 22351);
        PlaneMessage requestMessage, responseMessage;
        
        int current_capacity = -1;
        if (con.open())
        {
            requestMessage = new PlaneMessage(GET_CAPACITY);
            con.writeObject(requestMessage);
            responseMessage = (PlaneMessage) con.readObject();
            current_capacity = responseMessage.getId();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Plane");
            }
            con.close();
        }
    
        return current_capacity;
    
    
    }






}