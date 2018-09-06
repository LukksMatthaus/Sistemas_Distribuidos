
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
public class TCPClient {
    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence; 
        // Criação da strem de entrada
        BufferedReader inFromUser = 
          new BufferedReader(new InputStreamReader(System.in)); 
        //criando socket cliente
        Socket clientSocket = new Socket("10.25.1.222", 8090); 
        //criação da stream de saida ligada ao socket
        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream()); 
        //cria stream de entrada ligada ao socket
        System.out.println("Type ur message:");
        BufferedReader inFromServer = 
          new BufferedReader(new
          InputStreamReader(clientSocket.getInputStream())); 

        sentence = inFromUser.readLine(); 
        // envia linha para o servidor
        outToServer.writeBytes(sentence + '\n'); 
        // Lê a linha do servidor 
        modifiedSentence = inFromServer.readLine(); 

        System.out.println("FROM SERVER: " + modifiedSentence); 

        clientSocket.close(); 


    }    
}
