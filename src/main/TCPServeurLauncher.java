package main;

import server.TCPServer;

public class TCPServeurLauncher {
	// Delay, in milliseconds
	//private static final long DELAY = 1000 * 60 * 60; //Default : 1h000
	private static final long DELAY = 1000; //1 sec
	
	public static void main (String[] args) throws InterruptedException{
		long startTime = System.currentTimeMillis();
		Thread TCPServerThread = new Thread(TCPServer.getTCPServer());
		TCPServerThread.start();
		
		// loop until the delay
		/*for ( ;TCPServerThread.isAlive() ; ) {
			long t = System.currentTimeMillis();
			if ((t - startTime) > DELAY)
				TCPServerThread.stop();
			TCPServerThread.join() ;
		}*/
		
		long t = System.currentTimeMillis();
		while((t - startTime) < DELAY) {
			t = System.currentTimeMillis();
		};
		
		TCPServerThread.stop();
		
	}
}
