import java.rmi.*;

public class AplicacaoServidora{
    public static void main(String argv[]){
        HelloServidora objetoServidor;

        try{
            objetoServidor = new HelloServidora();
            Naming.rebind("//localhost/ObjetoServidor",objetoServidor);
            System.out.println("ObjetoServidor esta ativo!");
        }
        catch(RemoteException re){
            System.out.println("Erro Remoto: "+re.toString());
        }
        catch(Exception e){
            System.out.println("Erro Local: "+e.toString());
        }
    }
}


/***************************************************************************************************** 
*  Caso a classe remota HelloServidora não seja derivada de java.rmi.server.UnicastRemoteObject      *
*  há a necessidade de se exportar o objeto remoto instanciado, depois de criado seu stub. Para se   * 
*  criar o stub do objeto remoto instanciado é necessário utilizar a classe UnicastRemoteObject.     *
*  Para exportar o stub (proxy do objeto remoto), há necessidade de se usar os metodos da classe     *
*  Registry que está no pacote java.rmi.registry.                                                    *
*****************************************************************************************************/

/*
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class AplicacaoServidora{
    public static void main(String argv[]){
        HelloServidora objetoServidor;
	Hello stub;
	Registry registry;

        try{
            objetoServidor = new HelloServidora();
	    stub = (Hello) UnicastRemoteObject.exportObject(objetoServidor, 0); // 0 representa qualquer porta TCP escolhida pelo SO
	    registry = LocateRegistry.getRegistry();
            registry.rebind("ObjetoServidor",stub);
            System.out.println("ObjetoServidor esta ativo!");
        }
        catch(RemoteException re){
            System.out.println("Erro Remoto: "+re.toString());
        }
        catch(Exception e){
            System.out.println("Erro Local: "+e.toString());
        }
    }
}

*/
