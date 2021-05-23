package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.message.struct.DestinationAirpMessage;


import java.util.ArrayList;

import static Simulation.message.struct.DestinationAirpMessage.DstAirpMessage.*;

public class DestAirp_stub {
    /**
     *   Singleton reference to Array Transfer
     */
    private static DestAirp_stub destAirp_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     * @return Singleton ArrivalTransfer instance
     */
    public static DestAirp_stub getInstance()
    {
        if (destAirp_stub == null)
        {
            destAirp_stub = new DestAirp_stub();
        }

        return destAirp_stub;
    }

    public void Passenger_death(int person_id){
        ClientCom con = new ClientCom("l040101-ws03.ua.pt", 22352);
        DestinationAirpMessage requestMessage, responseMessage;
        
        if (con.open())
        {
            requestMessage = new DestinationAirpMessage(PASS_DEATH,person_id);
            con.writeObject(requestMessage);
            responseMessage = (DestinationAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS)
            {
                System.out.println("Error receiving message from Destination Airport");
            }
            con.close();
        }
    
    
    }













}