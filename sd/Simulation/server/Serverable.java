package Simulation.server;

/**
 * Interface for the Shared Region Interfaces
 */
public interface Serverable
{
    public Message processAndReply (Message inMessage);
}
