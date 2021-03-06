package Simulation.server;

import Simulation.message.Message;
/**
 *   A comunicação baseia-se em passagem de mensagens sobre sockets usando o protocolo TCP.
 */

public class Proxy extends Thread
{
    /**
     *  Contador de threads lançados
     *
     *    @serialField nProxy
     */

    private static int nProxy;

    /**
     *  Canal de comunicação
     *
     *    @serialField sconi
     */

    private ServerCom sconi;

    /**
     *  Interface às localizações(plane,depAirp,destAirp)
     *
     *    @serialField Interface pretended
     */

    private Simulation.server.Serverable server;

    /**
     *  Instanciação do interface às localizações(plane,depAirp,destAirp)
     *
     *    @param sconi canal de comunicação
     *    @param server interface às localizações(plane,depAirp,destAirp)
     */

    public Proxy (ServerCom sconi, Serverable server)
    {
        super ("Proxy_" + getProxyId ());

        this.sconi = sconi;
        this.server = server;
    }

    /**
     *  Ciclo de vida do thread agente prestador de serviço.
     */

    @Override
    public void run ()
    {
        Message inMessage = null,                                      // mensagem de entrada
                outMessage = null;                      // mensagem de saída

        inMessage = (Message) sconi.readObject ();                     // ler pedido do cliente
        try
        {
            System.out.println(this.getName() + " received a Message: " + inMessage.toString());
            outMessage = server.processAndReply (inMessage);         // processá-lo
            
        }
        catch (Exception e)
        {   
            System.out.println("Thread " + getName () + ": " + e.getMessage () + "!");
            System.exit (1);
        }
        sconi.writeObject (outMessage);                                // enviar resposta ao cliente
        sconi.close ();                                                // fechar canal de comunicação
    }

    /**
     *  Geração do identificador da instanciação.
     *
     *    @return identificador da instanciação
     */

    private static int getProxyId ()
    {
        Class<Simulation.server.Proxy> cl = null;             // representação do tipo de dados ClientProxy na máquina
        //   virtual de Java
        int proxyId;                                         // identificador da instanciação

        try
        { cl = (Class<Simulation.server.Proxy>) Class.forName ("Simulation.server.Proxy");
        }
        catch (ClassNotFoundException e)
        { System.out.println("O tipo de dados ClientProxy não foi encontrado!");
            e.printStackTrace ();
            System.exit (1);
        }

        synchronized (cl)
        { proxyId = nProxy;
            nProxy += 1;
        }

        return proxyId;
    }

    /**
     *  Obtenção do canal de comunicação.
     *
     *    @return canal de comunicação
     */

    public ServerCom getScon ()
    {
        return sconi;
    }
}

