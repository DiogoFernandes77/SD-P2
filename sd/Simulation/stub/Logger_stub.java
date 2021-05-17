package Simulation.stub;

public class Logger_stub {
    /**
     *   Singleton reference to Array Transfer
     */
    private static Logger_stub logger_stub = null;

    /**
     * Creates a singleton for Arrival Transfer.
     * @return Singleton ArrivalTransfer instance
     */
    public static Logger_stub getInstance()
    {
        if (logger_stub == null)
        {
            logger_stub = new Logger_stub();
        }

        return logger_stub;
    }

}