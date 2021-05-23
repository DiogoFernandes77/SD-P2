/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */
package Simulation.client;

import Simulation.stub.Logger_stub;
import Simulation.stub.Plane_stub;
import Simulation.States.Hostess_State;
import Simulation.stub.DepAirp_stub;

/**
 *
 */
public class Hostess extends Thread{
    

    private Hostess_State hostess_state;
    private boolean end_flag = false;
    public Hostess(){
        hostess_state = Hostess_State.WAIT_FOR_NEXT_FLIGHT;
        Logger_stub.getInstance().hostess_state(hostess_state);
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
        Logger_stub.getInstance().shutdown();
        System.out.println("HOSTESS RUNS ENDED \n");
    }

    private void waitForNextFlight(){
        hostess_state = Hostess_State.WAIT_FOR_NEXT_FLIGHT;
        Logger_stub.getInstance().hostess_state_log(hostess_state, "Hostess is waiting for next flight");
        DepAirp_stub.getInstance().waitForNextFlight();
    }

    private void prepareForPassBoarding(){
        hostess_state = Hostess_State.WAIT_FOR_PASSENGER;
        Logger_stub.getInstance().hostess_state_log(hostess_state, "Hostess is waiting for passenger");
        DepAirp_stub.getInstance().prepareForPassBoarding();
    }

    private void waitForNextPassenger(){
        hostess_state = Hostess_State.WAIT_FOR_PASSENGER;
        Logger_stub.getInstance().hostess_state_log(hostess_state, "Hostess is waiting for passenger");
        DepAirp_stub.getInstance().waitForNextPassenger();
    }

    private void checkDocuments(){
        hostess_state = Hostess_State.CHECK_PASSENGER;
        Logger_stub.getInstance().hostess_state_log(hostess_state, "Hostess is checking documents of passengers");
        DepAirp_stub.getInstance().checkDocuments();
    }

    private void waitBoarding(){
        Plane_stub.getInstance().waitBoarding();
   }
    
    private void informPlaneReadyToTakeOff(){
        hostess_state = Hostess_State.READY_TO_FLY;
        Logger_stub.getInstance().hostess_state_log(hostess_state, "Hostess tell pilot that he can fly");
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