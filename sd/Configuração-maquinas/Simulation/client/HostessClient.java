package Simulation.client;
/**
 * HostessClient is the class that instantiates the driver thread
 */
import Simulation.client.Hostess;

public class HostessClient{
    public static void main(String[] args)
    {
        Hostess hos = new Hostess();
        System.out.println("Starting Hostess Thread");
        hos.start();
        try
        {
            hos.join();
        }
        catch (InterruptedException ex)
        {
            System.out.println("Interrupter Exception Error - " + ex.toString());
        }
        System.out.println("Hostess Thread Ended");
    }
}
