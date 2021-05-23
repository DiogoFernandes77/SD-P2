/**
 *  Log Class to produce log file each initiation
 *  @author António Ramos e Diogo Fernandes
 */

package Simulation.server.LogPackage;

import Simulation.States.*;

import java.io.*;
import java.util.ArrayList;

public class Logger_Class {
    //implements singleton for repository information about what happens in the simulation, gives output file

    private static String file_name; // name file
    private final static String directory_file = "./Simulation/server/LogPackage/"; // where output files is stored
    private final static String default_name = "Logger_"; //default name
    private final static String extension_file = ".txt"; //extension file

    private static int nPassenger;
    public ArrayList<String> Summary = new ArrayList<>(); // struct to save what happened in each file

    //auxiliar variables
    int FN; // number of flight
    public Passenger_State[] ST_Passenger; // State of the Passengers; save state of each passenger
    public Pilot_State ST_Pilot; // State of the Pilot
    public Hostess_State ST_Hostess; // State of the Hostess

    private ArrayList<Integer> Q; // State of the waiting queue
    private ArrayList<Integer> IN_F; // State of in flight
    private ArrayList<Integer> ATL; // State of number of passengers that have already arrived at their destination

    private static FileWriter fileWriter; // Write on file

    //pilot variables abbreviate
    public String[] Pilot_state = new String[] {"ATRG", "RDFB","WTFB", "FLFW", "DRPP", "FLBK"};

    //hostess variables abbreviate
    public String[] Hostess_state = new String[] {"WTFL", "WTPS", "CKPS", "RDTF"};

    //passenger variables abbreviate
    private String[] Passenger_state = new String[]{"GTAP", "INQE", "INFL", "ATDS"};
    StringBuilder struct_string;

    public Logger_Class(int nPassenger) {
        this.nPassenger = nPassenger;
        ST_Passenger = new Passenger_State[nPassenger];
        ST_Pilot =  Pilot_State.AT_TRANSFER_GATE;
        ST_Hostess = Hostess_State.WAIT_FOR_NEXT_FLIGHT;
        Q = new ArrayList<Integer>();
        IN_F = new ArrayList<Integer>();
        ATL = new ArrayList<Integer>();

        this.init();
    }

    //creation file
    public String createFile() {
       file_name = directory_file + default_name + extension_file; //output file
       File dir = new File(file_name);
       try {
           fileWriter = new FileWriter(file_name);
           fileWriter.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
        return file_name;
    }


    // start writing head of file
    public void init(){
        String file_name = createFile(); //creation of file
        add_struct(file_name, nPassenger);   //header file
    }

    //header file
    public void add_struct(String file_n, int n_passenger){
        try {
            fileWriter = new FileWriter(file_n);
            fileWriter.write("PT \t HT  ");
            for (int i = 0; i < n_passenger; i++) {
                if (i < 10)
                    fileWriter.write(" P0" + i + " ");
                else
                    fileWriter.write(" P" + i + " ");
            }
            fileWriter.write("\tInQ InF PTAL\n");
            fileWriter.write( Pilot_state[ST_Pilot.ordinal()]+ " " + Hostess_state[ST_Hostess.ordinal()] + " ");
            for(int i = 0; i < n_passenger; i ++){
                fileWriter.write(Passenger_state[0] + " ");
            }
            fileWriter.write("\t0\t0\t0\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // write on flight struct of Flight x: boarding started.
    // x is the number of the flight
    public void board_start(String text){
        try {
            fileWriter = new FileWriter(file_name, true);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add struct Flight x: passenger y checked.
    public void pass_check(String text){
        try {
            fileWriter = new FileWriter(file_name, true);
            fileWriter.write("\nFlight " + FN + text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void departed(int capacity){
        try {
            fileWriter = new FileWriter(file_name, true);
            fileWriter.write("\nFlight " + FN + " departed with " + capacity + " passengers.\n");
            Summary.add("Flight " + FN + " departed with " + capacity + " passengers.\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // summary of flights
    public void summary(){
        try {
            fileWriter = new FileWriter(file_name, true);
            fileWriter.write("\nAirlift sum up:\n");
            for (String s : Summary)
                fileWriter.write(s + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //when change main events
    public void log_write(String type){
        System.out.println(type);
        try {
            fileWriter = new FileWriter(file_name, true);
            struct_string = new StringBuilder();
            struct_string.append(Pilot_state[ST_Pilot.ordinal()]).append(" ");
            struct_string.append(Hostess_state[ST_Hostess.ordinal()]).append(" ");
            System.out.println(struct_string.toString());
            for (int i = 0; i < nPassenger; i ++){
                try{
                    struct_string.append(Passenger_state[ST_Passenger[i].ordinal()]).append(" ");
                }catch(NullPointerException e){
                    //struct_string.append("");
                }
            }
            try{
                struct_string.append("\t").append(Q.size()).append("\t").append(IN_F.size()).append("\t").append(ATL.size()).append("\n");
            }catch(NullPointerException e){
                //struct_string.append("");
            }
            fileWriter.write(struct_string.toString());
            fileWriter.close();

        } catch (IOException e){
            System.out.print(e);
            e.printStackTrace();
        }
        
    }

    // -------------------------- SETTERS ------------------------- //

    public void setFN(int FN) { this.FN = FN; }

    public void setST_Passenger(int id, Passenger_State ST_Passenger) { 
        
        this.ST_Passenger[id] = ST_Passenger; 
    
    }

    public void setST_Pilot(Pilot_State ST_Pilot) { 
        
        this.ST_Pilot = ST_Pilot; }

    public void setST_Hostess(Hostess_State st) { this.ST_Hostess = st; }

    public void setQ(ArrayList<Integer> q) { this.Q =  q; }

    public void setIN_F(ArrayList<Integer> IN_F) { this.IN_F = IN_F; }

    public void setATL(ArrayList<Integer> ATL) { this.ATL = ATL; }
}
