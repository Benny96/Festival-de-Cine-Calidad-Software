package es.deusto.ingenieria.sd.auth.server;

import java.io.IOException;
import java.net.ServerSocket;

public class GoogleAuthServer {
	
	private static int numClients = 0;
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.err.println(" # Usage: GoogleAuthServer [PORT]");
			System.exit(1);
		}
		
		int serverPort = Integer.parseInt(args[0]);
		
		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) 
		{
			System.out.println(" - GoogleAuthServer: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");
			
			while (true) 
			{
				new GoogleAuthService(tcpServerSocket.accept());
				System.out.println(" - GoogleAuthServer: New client connection accepted. Client number: " + ++numClients);
			}
		} catch (IOException e) {
			System.err.println("# GoogleAuthServer: IO error:" + e.getMessage());
		}
	}
}