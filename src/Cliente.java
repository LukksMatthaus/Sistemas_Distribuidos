/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20171014040004
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
        
       System.out.println("Estabelecendo conexão...");
       Socket socket = new Socket("10.25.1.222",8090);
       System.out.println("Conexão estabelecida");
        
       ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
       ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
       
       while(true){
            System.out.print(">>:");
            String mensagem = sc.nextLine();
            output.writeUTF(mensagem);
            output.flush();
            if(mensagem.equalsIgnoreCase("close"))
                break;
            String resposta = input.readUTF();
            System.out.println("Servidor:" + resposta);
       }
       input.close();
       output.close();
       socket.close();
        
    }
    
}

