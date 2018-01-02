package main;

import server.TCPServer;

public class TCPServeurLauncher {
	// Delay, in milliseconds
	private static final long DELAY = 1000 * 60 * 60; //Default : 1h000
	
	public static void main (String[] args) throws InterruptedException{
		long startTime = System.currentTimeMillis();
		Thread TCPServerThread = new Thread(new TCPServer());
		TCPServerThread.start();
		
		// loop until the delay
		for ( ;TCPServerThread.isAlive() ; ) {
			long t = System.currentTimeMillis();
			if ((t - startTime) > DELAY)
				TCPServerThread.interrupt();
			TCPServerThread.join() ;
		}
	}
}
