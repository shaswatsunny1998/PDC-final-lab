import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PbookServer
{
    public PbookServer()
    {
    try
    {
    Registry reg=LocateRegistry.createRegistry(9999);
    reg.rebind("hi server",new PbookImpl());
    
    }
    catch(Exception e)
    {
    System.out.println("Server Error:"+e);
    }
    }
    public static void main(String args[])
    {
    new PbookServer();
    }
}
