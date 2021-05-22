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
                //logger.log_write("");
            }
        }else if(PASS_STATE_LOG.equals(type)){
          int id = ((LoggerMessage) inMessage).getId();
          Passenger.State ST_Passenger = ((LoggerMessage) inMessage).getST_Passenger();
          String log = ((LoggerMessage) inMessage).getLog();
          synchronized (Logger_Class.class){
              logger.setST_Passenger(id,ST_Passenger);
              logger.log_write(log);
          }
        }else if(PIL_STATE.equals(type)){
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            synchronized (Logger_Class.class){
                logger.setST_Pilot(ST_Pilot);
            }
        } else if(PIL_STATE_LOG.equals(type) ) {
            Pilot.State ST_Pilot = ((LoggerMessage) inMessage).getST_Pilot();
            int FN = ((LoggerMessage) inMessage).getFN();
            String log = ((LoggerMessage) inMessage).getLog();
            
            
            if (ST_Pilot.equals(Pilot.State.READY_FOR_BOARDING)){
                
                synchronized (Logger_Class.class){
                    
                    logger.setST_Pilot(ST_Pilot);
                    logger.board_start("\nFlight " + FN + ": boarding started.\n");
                }
            } else if (ST_Pilot.equals(Pilot.State.DEBOARDING)){
                synchronized (Logger_Class.class){
                    logger.setST_Pilot(ST_Pilot);
                    logger.board_start("\nFlight " + FN + ": arrived.\n");
                }
            
            
            } else if (ST_Pilot.equals(Pilot.State.FLYING_BACK)){
                synchronized (Logger_Class.class){
                    logger.setST_Pilot(ST_Pilot);
                    logger.board_start("\nFlight " + FN + ": returning.\n");
                }
            }else {
               
                synchronized (Logger_Class.class){
                    logger.setST_Pilot(ST_Pilot);
                    logger.log_write(log);
                }
                
            
            }
        }else if (HOS_STATE.equals(type)){
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
            }
        } else if (HOS_STATE_LOG.equals(type)){
            
            Hostess.State ST_Hostess = ((LoggerMessage) inMessage).getST_Hostess();
            String log = ((LoggerMessage) inMessage).getLog();
            synchronized (Logger_Class.class){
                logger.setST_Hostess(ST_Hostess);
                logger.log_write(log);
            }
        }else if (SHUT.equals(type)){
            ArrayList<String> summ = ((LoggerMessage) inMessage).getSummary();
            synchronized (Logger_Class.class){
                logger.summary(summ);
            }
            Logger_Server.waitConnection = false;
            (((Proxy) (Thread.currentThread())).getScon()).setTimeout(10);

        }
        response = new LoggerMessage(SUCCESS);  
        return response;
    }
}
