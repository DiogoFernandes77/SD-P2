package Simulation.server.LogPackage;
import Simulation.client.Hostess;
import Simulation.client.Passenger;
import Simulation.client.Pilot;
import Simulation.message.Message;
import Simulation.message.struct.LoggerMessage;
import Simulation.server.LogPackage.Logger_Class;
import Simulation.server.Proxy;
import Simulation.server.Serverable;

import java.util.ArrayList;

import static Simulation.message.struct.LoggerMessage.LG_Message.*;

public class Logger_Interface implements Serverable {
    private Logger_Class logger = null;

    public Logger_Interface(Logger_Class log) {
        this.logger = log;
    }

    @Override
    public Message processAndReply(Message inMessage) {
        Message response = null;
        Enum type = inMessage.getType();

        if(PASS_STATE.equals(type)){
            int id = ((LoggerMessage) inMessage).getId();
            Passenger.State ST_Passenger = ((LoggerMessage) inMessage).getST_Passenger();
            synchronized (Logger_Class.class){
                logger.setST_Passenger(id, ST_Passenger);
                logger.log_write("");
            }
        }else if(PASS_WAIT_QUEUE.equals(type) || PASS_ENTER_QUEUE.equals(type)){
            ArrayList<Integer> Q = ((LoggerMessage) inMessage).getQ();
            synchronized (Logger_Class.class){
                logger.setQ(Q);
            }
        }else if(PASS_IN_FL.equals(type)){
            ArrayList<Integer> IN_F = ((LoggerMessage) inMessage).getIN_F();
            synchronized (Logger_Class.class){
                logger.setIN_F(IN_F);
            }
        }else if (PASS_LEAVE_PLANE.equals(type)){
            ArrayList<Integer> ATL = ((LoggerMessage) inMessage).getATL();
            synchronized (Logger_Class.class){
                logger.setATL(ATL);
            }
        }else if (PIL_PARK_AT_TRANSFER_GATE.equals(type)){
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            synchronized (Logger_Class.class){
                logger.setST_Pilot(ST_Pilot);
                logger.log_write("Pilot is at transfer gate");
            }
        }else if (PIL_INFORM_PLANE_RDY_BOARD.equals(type)) {//boarding started
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            int FN = ((LoggerMessage) inMessage).getFN();
            String log = ((LoggerMessage) inMessage).getLog();
            synchronized (Logger_Class.class){
                logger.setST_Pilot(ST_Pilot);
                logger.setFN(FN);
                logger.board_start(log); //"\nFlight " + id_to_set + ": boarding started.\n"
            }
        } else if (PIL_WAIT_FOR_ALL_BOARDING.equals(type)){
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            synchronized (Logger_Class.class){
                logger.setST_Pilot(ST_Pilot);
                logger.log_write("Pilot is waiting for boarding");
            }
        } else if(PIL_FlY_TO_DEST.equals(type)){
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            synchronized (Logger_Class.class){
                logger.setST_Pilot(ST_Pilot);
                logger.log_write("Pilot is flying forward");
            }
        } else if (PIL_AN_ARRIVAL.equals(type)) {
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            int FN = ((LoggerMessage) inMessage).getFN();
            String log = ((LoggerMessage) inMessage).getLog();
            synchronized (Logger_Class.class) {
                logger.setST_Pilot(ST_Pilot);
                logger.setFN(FN);
                logger.board_start(log); //"\nFlight " + id_to_set + ": arrived.\n"
            }
        } else if (PIL_FLY_TO_DEP.equals(type)){
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            int FN = ((LoggerMessage) inMessage).getFN();
            String log = ((LoggerMessage) inMessage).getLog();
            synchronized (Logger_Class.class) {
                logger.setST_Pilot(ST_Pilot);
                logger.setFN(FN);
                logger.board_start(log); //"\nFlight " + id_to_set + ": returning.\n"
            }
        } else if (HOS_WAIT_NEXT_FLIGHT.equals(type)){
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
                logger.log_write("Hostess is waiting for next flight");
            }
        }else if (HOS_WAIT_BOARDING.equals(type)){
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
                logger.log_write("Hostess is waiting for next passenger");
            }
        }else if (HOS_WAIT_FOR_PASSENGER.equals(type)){
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
                logger.log_write("Hostess is waiting for next passenger");
            }
        }else if (HOS_CHECK_DOCUMENTS.equals(type)){
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
                logger.log_write("Hostess is checking documents of passengers");
            }
        }else if (HOS_INFORM_PLANE_TAKEOFF.equals(type)){
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
                logger.log_write("Hostess is informing pilot that he can fly");
            }
        } else if (DEPARTED.equals(type)){
            ArrayList<String> summ = ((LoggerMessage) inMessage).getSummary();

            synchronized (Logger_Class.class){
                for(int i = 0; i < summ.size(); i++){
                    logger.departed(summ.get(i));
                }
            }
        }else if (SHUT.equals(type)){
            ArrayList<String> summ = ((LoggerMessage) inMessage).getSummary();
            synchronized (Logger_Class.class){
                logger.summary(summ);
            }
            Logger_Server.waitConnection = false;
            (((Proxy) (Thread.currentThread())).getScon()).setTimeout(10);

        }
        return (Message) new LoggerMessage(SUCCESS);
    }
}
