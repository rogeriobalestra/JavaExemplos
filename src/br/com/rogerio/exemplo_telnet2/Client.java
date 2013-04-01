package br.com.rogerio.exemplo_telnet2;

import java.io.IOException;  
import java.io.PrintStream;  
import java.net.Socket;  
  
public class Client {  
  
    public static void main(String[] args){  
          
        //Declaro o socket cliente  
        Socket s = null;  
          
        //Declaro a Stream de saida de dados  
        PrintStream ps = null;  
          
        try{  
              
            int x = 20;  
            //Cria o socket com o recurso desejado na porta especificada  
            s = new Socket("127.0.0.1",7000);  
              
            //Cria a Stream de saida de dados  
            ps = new PrintStream(s.getOutputStream());  
              
            //Imprime uma linha para a stream de sa�da de dados  
            ps.println(x);  
              
        //Trata poss�veis exce��es  
        }  
        catch(IOException e) {  
            System.out.println("Algum problema ocorreu ao criar ou enviar dados pelo socket.");  
        } finally {  
              
            try {  
                  
                //Encerra o socket cliente  
                s.close();  
                  
            } catch(IOException e){}  
          
        }  
  
    }  
}  