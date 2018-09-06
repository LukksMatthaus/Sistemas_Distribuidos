
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20171014040027
 */
public class TCPServer {
    public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String capitalizedSentence; 
      //cria socket  de aceitação na porta 6789
      ServerSocket welcomeSocket = new ServerSocket(6789); 
  
      while(true) { 
          // espera por contato do cliente
            Socket connectionSocket = welcomeSocket.accept(); 

           BufferedReader inFromClient = 
              new BufferedReader(new
            // cria stream de entrada 
            InputStreamReader(connectionSocket.getInputStream())); 
           
           DataOutputStream  outToClient = 
             new DataOutputStream(connectionSocket.getOutputStream()); 
           // lê oq foi enviado do cliente
           clientSentence = inFromClient.readLine(); 

           capitalizedSentence = clientSentence.toUpperCase() + '\n'; 
           //envia a resposta para o cliente
           outToClient.writeBytes(capitalizedSentence); 
           System.out.println(capitalizedSentence);
        } 
    } 

}
