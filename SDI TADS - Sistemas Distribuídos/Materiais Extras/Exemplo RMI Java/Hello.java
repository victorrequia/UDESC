import java.rmi.*;

public interface Hello extends Remote{
    String imprimirOla(String msg) throws RemoteException;
}
