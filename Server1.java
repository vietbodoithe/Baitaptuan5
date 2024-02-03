
package baitaptuan5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server1 {
    public static void main(String[] args) {
        
        final int PORT=12346;
        try {
            ServerSocket serverSocket=new ServerSocket(PORT);
            System.out.println("Server dang cho ket noi tu Client.....");
            while (true) {                
                Socket clientSocket=serverSocket.accept();
                System.out.println("Client da ket noi" +clientSocket);
                Thread thread=new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    class ClientHandler implements Runnable{
        private Socket cliSocket;
    private final Socket clientSocket;
        public ClientHandler(Socket clientSocket){
            this.clientSocket=clientSocket;
        }
        
        @Override
        public void run(){
            try {
                BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
                String clientMessage;
                while ((clientMessage=in.readLine())!=null) {                    
                    System.out.println("Client gui:"+clientMessage);
                    out.println("Server nhan duoc:"+clientMessage);
                }
            } catch (Exception e) {
            }
        }
    }
