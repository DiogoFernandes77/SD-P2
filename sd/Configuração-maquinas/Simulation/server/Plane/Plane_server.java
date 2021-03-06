package Simulation.server.Plane;

import Simulation.server.ServerCom;

import java.net.SocketTimeoutException;

import Simulation.server.Proxy;
public class Plane_server {

    public static boolean waitConnection;


    public static void main(String[] args){
        
        Plane plane = new Plane();

        Plane_interface plane_inter = new Plane_interface(plane);

        ServerCom scon = new ServerCom(22351);
        Proxy proxy;
        ServerCom sconi;
        scon.start();
        waitConnection = true;
        while(waitConnection){
            
            try{
                sconi = scon.accept();
                proxy = new Proxy(sconi, plane_inter);
                proxy.start();

            }catch (SocketTimeoutException e) {}



        }
        scon.end();
    }


}