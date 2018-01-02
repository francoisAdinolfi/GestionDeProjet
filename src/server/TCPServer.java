package server;
import java.util.LinkedHashSet;
import java.util.Set;

import event.Event;
import sequensor.Sequensor;
import timer.BasicTimer;

public final class TCPServer implements Runnable {

	private final static int MSL = 20;
	private final Sequensor aSequensor;
	private final Set<Event> eventSet = new LinkedHashSet<Event>();
	private final Set<Event> cmdASet = new LinkedHashSet<Event>();
	private final Set<String> tcpMsgC = new LinkedHashSet<String>();
	private final Set<String> tcpMsgS = new LinkedHashSet<String>();
	
	private long index_i = 0;
	private long numSeqC = 0;
	private long numSeqS = 0;

	public final BasicTimer aBasicTimer = new BasicTimer(MSL);
	
	// Constructor section
	public TCPServer() {
		this.aSequensor = new Sequensor(this);
	}

	// TCPServer Runnable section
	public void run(){
		for(;true;) {
			//Update eventSet and cmdA
			this.receive();
			//Set the events to the sequensor
			for(Event e : cmdASet) {
				this.aSequensor.tryy(e);
				cmdASet.remove(e);
				}
			for(Event e : eventSet) {
				this.aSequensor.tryy(e);
				eventSet.remove(e);
			}
		}
	}

	public void addEventInEventSet(Event e) {
		eventSet.add(e);
	}
	
	private int receive() {
		return 0;
	}

	public String read() {
		return "";
	}

	public int write(String anApplicationData) {
		return 0;
	}

	public void resetAll() {
		index_i = 0;
		numSeqC = 0;
		numSeqS = 0;
		eventSet.clear();
		cmdASet.clear();
		tcpMsgC.clear();
		tcpMsgS.clear();
	}

	public void inc_I() {
		index_i = index_i + 1;
	}

	public void writeRST() {
		System.out.println("Connection reset par peer");
	}

	public void writeSYNACK() {
		System.out.println("Connection établie");
	}

	public void writeFIN() {
	}

	public void writeACK() {
	}

	public void writeSYN() {
	}

	public void writeMsg() {
	}
}
