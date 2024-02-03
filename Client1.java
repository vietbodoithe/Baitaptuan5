
package baitaptuan5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "192.168.1.26";
        final int PORT = 12346;
        
        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  // added 'true' for autoflush
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Client da ket noi voi server");
            
            String userInputLine = "";
            while ((userInputLine = userInput.readLine()) != null) {  // corrected the loop condition
                out.println(userInputLine);
                String response = in.readLine();
                System.out.println("Server phan hoi: " + response);
            }
        } catch (Exception e) {
        }
    }
}