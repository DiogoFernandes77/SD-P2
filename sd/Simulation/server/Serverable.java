package Simulation.server;

import Simulation.message.Message;

/**
 * Interface for the Shared Region Interfaces
 */
public interface Serverable
{
    public Message processAndReply (Message inMessage);
}
