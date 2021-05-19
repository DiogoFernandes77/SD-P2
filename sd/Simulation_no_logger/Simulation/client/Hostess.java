/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */
package Simulation.client;

import Simulation.stub.Plane_stub;
import Simulation.stub.DepAirp_stub;


public class Hostess extends Thread{
    public enum State{
        WAIT_FOR_NEXT_FLIGHT,
        WAIT_FOR_PASSENGER,
        CHECK_PASSENGER,
        READY_TO_FLY
    }

    private State hostess_state;
    private boolean end_flag = false;
    public Hostess(){
        hostess_state = State.WAIT_FOR_NEXT_FLIGHT;
        // synchronized (Logger_Class.class)
        // {
        //     Logger_Class.getInstance().setST_Hostess(hostess_state);
        // }
    }

    //implementation of the method run which establishes the thread operativeness
    @Override
    public void run(){
        do{
            
            waitForNextFlight();
            prepareForPassBoarding();
            while(getCurrent_capacity() < getBoardingMin() || (getCurrent_capacity() < getBoardingMax() && !getIsQueueEmpty()) ){
                if(getPassenger_left() == 0){
                
                    System.out.println("LAST PASSENGER FLIGHT \n");
                    break;
                }
                waitForNextPassenger();
                checkDocuments(); 
            }
            System.out.print(" CHECK COMPLETE \n");
            
            while(getCurrent_capacity() != Plane_stub.getInstance().getCapacity()){//garantir que os passageiros estao todos dentro do aviao antes de levantar voo, é raro entrar aqui mas pode acontecer
                waitBoarding();
            }
            
            System.out.print(" BOARDING COMPLETE \n");
            informPlaneReadyToTakeOff();
        }while(stillPassenger());
        
        System.out.println("HOSTESS RUNS ENDED \n");
    }

    private void waitForNextFlight(){
        // synchronized (Logger_Class.class)
        // {
        //     Logger_Class.getInstance().setST_Hostess(hostess_state);
        //     Logger_Class.getInstance().log_write("Hostess is waiting for next flight");
        // }
        DepAirp_stub.getInstance().waitForNextFlight();
    }

    private void prepareForPassBoarding(){
        hostess_state = State.WAIT_FOR_PASSENGER;
        // synchronized (Logger_Class.class)
        // {
        //     Logger_Class.getInstance().setST_Hostess(hostess_state);
        //     Logger_Class.getInstance().log_write("Hostess is waiting for next passenger");
        // }
        DepAirp_stub.getInstance().prepareForPassBoarding();
    }

    private void waitForNextPassenger(){
        hostess_state = State.WAIT_FOR_PASSENGER;
        // synchronized (Logger_Class.class)
        // {
        //     Logger_Class.getInstance().setST_Hostess(hostess_state);
        //     Logger_Class.getInstance().log_write("Hostess is waiting for next passenger");
        // }
        DepAirp_stub.getInstance().waitForNextPassenger();
    }

    private void checkDocuments(){
        hostess_state = State.CHECK_PASSENGER;
        // synchronized (Logger_Class.class)
        // {
        //     Logger_Class.getInstance().setST_Hostess(hostess_state);
        //     Logger_Class.getInstance().log_write("Hostess is checking documents of passengers");
        // }
        DepAirp_stub.getInstance().checkDocuments();
    }

    private void waitBoarding(){
        Plane_stub.getInstance().waitBoarding();
   }
    
    private void informPlaneReadyToTakeOff(){
        hostess_state = State.READY_TO_FLY;
        // synchronized (Logger_Class.class)
        // {
        //     Logger_Class.getInstance().setST_Hostess(hostess_state);
        //     Logger_Class.getInstance().log_write("Hostess is ready to fly");
        // }
        DepAirp_stub.getInstance().informPlaneReadyToTakeOff();
    }
    private int getPassenger_left(){ return DepAirp_stub.getInstance().getPassenger_left(); }
    
    private boolean stillPassenger(){
        return DepAirp_stub.getInstance().stillPassenger();
    }
    private int getBoardingMin(){
        return DepAirp_stub.getInstance().getBoardingMin();
    }
    private int getBoardingMax(){
        return DepAirp_stub.getInstance().getBoardingMax();
    }
    private int getCurrent_capacity(){
        return DepAirp_stub.getInstance().getCurrent_capacity();
    }
    private boolean getIsQueueEmpty(){
        return DepAirp_stub.getInstance().getIsQueueEmpty();
    }

}