/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Forms.Authentication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author codingharry
 */
public class Server {
    public static void main(String[] args) throws Exception {

        
        ArrayList<String> clients = new ArrayList<String>();
        
        
        int port;
	ServerSocket server_socket;
	BufferedReader input;
	
	try { 
	    port = Integer.parseInt(args[0]);
	}
	catch (Exception e) {
	    System.out.println("port = 1500 (default)");
	    port = 1500;
	}
	try {
	    
	    server_socket = new ServerSocket(port);
	    System.out.println("Server waiting for client on port " + 
			       server_socket.getLocalPort());
	    
            
	    // server infinite loop
	    while(true) {
		Socket socket = server_socket.accept();
		System.out.println("New connection accepted " +
				   socket.getInetAddress() +
				   ":" + socket.getPort());
input = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
// Only if the client is connected, the Form will open
            
            
		// print received data 
		try {
		    while(true) {
			String message = input.readLine();
			if (message==null) break;
			System.out.println(message);
		    }
		}
		catch (IOException e) {
		    System.out.println(e);
		}
		
		// connection closed by client
		try {
		    socket.close();
		    System.out.println("Connection closed by client");
		}
		catch (IOException e) {
		    System.out.println(e);
		}
		
	    }
	    	    
	}
	
	catch (IOException e) {
	    System.out.println(e);
	}
    }
    
    
    
}




    
        

