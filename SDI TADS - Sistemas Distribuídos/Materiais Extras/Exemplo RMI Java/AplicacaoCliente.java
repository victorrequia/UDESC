import java.rmi.*;
import javax.swing.*;

public class AplicacaoCliente{
    public static void main(String argv[]){
        Hello objetoRemoto;
        String dados;

        try{
            // [1] objetoRemoto = (Hello) Naming.lookup("//localhost///localhost/ObjetoServidor");
	    objetoRemoto = (Hello) Naming.lookup("//localhost/ObjetoServidor");
            dados = JOptionPane.showInputDialog(null,"Entre com o dado a ser impresso pelo Objeto Remoto","Entrada de Dados",JOptionPane.QUESTION_MESSAGE);
            System.out.println(objetoRemoto.imprimirOla(dados));
        }
        catch(RemoteException re){
            JOptionPane.showMessageDialog(null,"Erro Remoto: "+re.toString(),"Erro Remoto",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro Local: "+e.toString(),"Erro Local",JOptionPane.WARNING_MESSAGE);
        }
    }
}


/********************************************************************************************
*[1] Se a classe LocateRegistry foi utilizada na Aplicação Servidor para exportar o objeto  *
*  remoto (método rebind, ou bind) e na Aplicação Cliente for utilizada a classe Naming     *
*  para obter a referencia remota (método lookup), então deve-se utilizar o nome do objeto  *
*  conforme exportado na Aplicação Servidora, acrescido da localização de onde deve estar   *
*  executando, ou ter sido instanciado/exportado, o rmiregistry. Ou seja, a classe Naming   *
*  espera junto com o string que representa o nome do objeto remoto a localização do        *
*  rmiregistry no formato de url //<localização><:porta>, sendo que se não for informada a  *
*  porta, a porta default para o rmiregistry (1099) é utilizada                             *
********************************************************************************************/


/*
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;

public class AplicacaoCliente{
    public static void main(String argv[]){
        Hello objetoRemoto;
	Registry registry;
        String dados;

        try{
	    registry = LocateRegistry.getRegistry();
	    objetoRemoto = (Hello) registry.lookup("ObjetoServidor");
            dados = JOptionPane.showInputDialog(null,"Entre com o dado a ser impresso pelo Objeto Remoto","Entrada de Dados",JOptionPane.QUESTION_MESSAGE);
            System.out.println(objetoRemoto.imprimirOla(dados));
        }
        catch(RemoteException re){
            JOptionPane.showMessageDialog(null,"Erro Remoto: "+re.toString(),"Erro Remoto",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro Local: "+e.toString(),"Erro Local",JOptionPane.WARNING_MESSAGE);
        }
    }
}
*/
