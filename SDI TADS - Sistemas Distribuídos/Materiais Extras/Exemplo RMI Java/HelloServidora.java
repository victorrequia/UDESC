import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import javax.swing.*;

//public class HelloServidora implements Hello{
  public class HelloServidora extends UnicastRemoteObject implements Hello{
    public HelloServidora() throws RemoteException{}

    public String imprimirOla(String msg) throws RemoteException{
        JOptionPane.showMessageDialog(null,msg,"Mensagem do Objeto Cliente",JOptionPane.INFORMATION_MESSAGE);
	return "S1:"+msg;
    }
}


/**************************************************************************
* Para o caso de não se poder derivar de UnicastRemoteObject a interface  *
* não sofre qualquer problema. Haverá, outrossim, alterações na aplicacao *
* servidora, para exportar (deixar apto a receber invocação remota) o     *
* objeto remoto                                                           *
***************************************************************************/

