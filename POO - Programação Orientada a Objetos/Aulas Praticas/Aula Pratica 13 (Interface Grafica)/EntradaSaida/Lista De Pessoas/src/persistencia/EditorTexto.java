package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.LinkedList;

public class EditorTexto {
    public void gravaTexto(String caminho, List<String> dados){
        FileWriter arq;
        
        try{
            arq = new FileWriter(caminho);
            for(int i=0; i<dados.size(); i++){
                arq.write(dados.get(i)+"\n");
            }
            arq.close();
        }catch (Exception e){
            System.err.println("Erro ao manipular arquivo");
            System.exit(0);
        }
    }
    
    public void gravaTexto(String caminho, String linha){
        FileWriter arq;
        try{
            arq = new FileWriter(caminho, true);
            arq.write(linha+"\n");
            arq.close();
        }catch (Exception e){
            System.err.println("Erro ao manipular arquivo");
            System.exit(0);            
        }
    }
    
    public List<String> leTexto(String caminho){
        List<String> dados = new LinkedList<>();
        FileReader arq;
        BufferedReader lerArq;
        
        try{
            arq = new FileReader(caminho);
            lerArq = new BufferedReader(arq);
            String s = lerArq.readLine();
            
            while(s != null){
                dados.add(s);
                s = lerArq.readLine();
            }
            arq.close();

        }catch (Exception e){
            System.err.println("Erro ao manipular arquivo");
            System.exit(0);            
        }
        return dados;
    }

}
