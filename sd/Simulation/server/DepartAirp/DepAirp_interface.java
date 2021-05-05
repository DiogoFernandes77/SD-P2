package Simulation.server.DepartAirp;

import Simulation.message.Message;
import Simulation.message.struct.DepartureAirpMessage;
import Simulation.server.Serverable;

import static Simulation.message.struct.DepartureAirpMessage.DpAirpMessage.*;
public class DepAirp_interface implements Serverable{

    private DepartAirport depAirp = null;

    public DepAirp_interface(DepartAirport depAirp){
        this.depAirp = depAirp;

    }

    @Overrride
    public Message processAndReply(Message requestMessage){
        Message response = null;
        Enum requestType = requestMessage.getType();

        if(PIL_INFORM_PLANE_RDY_BOARD.equals(requestType)){
            response = new DepartureAirpMessage(SUCESS);

            
        }



    }



}