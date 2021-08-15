package Simulation.message;

import Simulation.message.struct.LoggerMessage;

/**
 * Methods of message
 */
public interface Message{
    /**
     * Get type of enum
     * @return type enum
     */
    public Enum getType();

    /**
     * Obtain String of enum
     * @return "Type:" + type
     */
    public String toString();
}