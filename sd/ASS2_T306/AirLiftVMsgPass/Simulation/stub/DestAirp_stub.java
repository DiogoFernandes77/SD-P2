package Simulation.stub;

import Simulation.client.ClientCom;
import Simulation.message.struct.DestinationAirpMessage;


import java.util.ArrayList;

import static Simulation.message.struct.DestinationAirpMessage.DstAirpMessage.*;
/**
 * DestAirp_stub communication
 */
public class DestAirp_stub {
    /**
     * Singleton reference to Array Transfer
     */
    private static DestAirp_stub destAirp_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     *
     * @return Singleton ArrivalTransfer instance
     */
    public static DestAirp_stub getInstance() {
        if (destAirp_stub == null) {
            destAirp_stub = new DestAirp_stub();
        }
        return destAirp_stub;
    }

    /**
     * Adiciona um passageiro à lista de chegada ao destination
     * Manda uma Mensagem ao Logger_stub a informar o numero de pessoas que já sairam e faz set do array que se encontra no Logger_Class
     *
     * @param person_id
     */
    public void Passenger_death(int person_id) {
        ClientCom con = new ClientCom("localhost", 4003);
        DestinationAirpMessage requestMessage, responseMessage;

        if (con.open()) {
            requestMessage = new DestinationAirpMessage(PASS_DEATH, person_id);
            con.writeObject(requestMessage);
            responseMessage = (DestinationAirpMessage) con.readObject();
            if (responseMessage.getType() != SUCCESS) {
                System.out.println("Error receiving message from Destination Airport");
            }
            con.close();
        }
    }
}