package Simulation.server.LogPackage;
import Simulation.message.Message;
import Simulation.server.LogPackage.Logger_Class;
import Simulation.server.Serverable;

public class Logger_Interface implements Serverable {
    private Logger_Class logger = null;

    public Logger_Interface(Logger_Class log) {
        this.logger = log;
    }

    @Override
    public Message processAndReply(Message requestMessage) {
        Message response = null;
        Enum requestType = requestMessage.getType();

        return response;
    }
}
