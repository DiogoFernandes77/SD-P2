package Simulation.client;
/**
 * PilotClients is the class that instantiates the driver thread
 */
public class PilotClient{
    public static void main(String[] args)
    {
        Pilot pil = new Pilot();
        System.out.println("Starting Pilot Thread");
        pil.start();
        try
        {
            pil.join();
        }
        catch (InterruptedException ex)
        {
            System.out.println("Interrupter Exception Error - " + ex.toString());
        }
        System.out.println("Pilot Thread Ended");
    }
}
