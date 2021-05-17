package Simulation.server.LogPackage;
// initiate Logger server
import Simulation.server.LogPackage.Logger_Class;
import Simulation.server.LogPackage.Logger_Interface;
import Simulation.server.ServerCom;
import Simulation.server.Proxy;
import java.net.SocketTimeoutException;

public class Logger_Server {
    public static boolean waitConnection;

    public static void main(String[] args){
        Logger_Class logger_class = new Logger_Class();
        Logger_Interface logger_int = new Logger_Interface(logger_class);

        ServerCom scon = new ServerCom (4004);
        scon.start();

        ServerCom sconi;
        Simulation.server.Proxy proxy;

        waitConnection = true;
        while (waitConnection) {
            try {
                sconi = scon.accept();
                proxy = new Proxy(sconi, logger_int);
                proxy.start();
            }
            catch (SocketTimeoutException e) {}
        }
        scon.end();
    }
}