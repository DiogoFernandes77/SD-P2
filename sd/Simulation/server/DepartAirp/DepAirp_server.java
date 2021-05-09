package Simulation.server.DepartAirp;

import Simulation.server.ServerCom;

import java.net.SocketTimeoutException;

import Simulation.server.Proxy;
public class DepAirp_server {

    public static boolean waitConnection;


    public static void main(String[] args){
        
        DepartAirport depAirp = new DepartAirport();

        DepAirp_interface dep_inter = new DepAirp_interface(depAirp);

        ServerCom scon = new ServerCom(4001);
        Proxy proxy;
        ServerCom sconi;
        scon.start();
        waitConnection = true;
        while(waitConnection){
            
            try{
                sconi = scon.accept();
                proxy = new Proxy(sconi, dep_inter);
                proxy.start();

            }catch (SocketTimeoutException e) {}



        }
        scon.end();
    }


}