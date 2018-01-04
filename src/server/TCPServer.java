package server;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import event.Event;
import sequensor.Sequensor;
import timer.BasicTimer;

public final class TCPServer implements Runnable {

	private final static int MSL = 20;
	private final Sequensor aSequensor;
	private final Set<Event> eventSet = new LinkedHashSet<Event>();
	private final Set<Event> eventSetToBeAdd = new LinkedHashSet<Event>();
	private final Set<Event> cmdASet = new LinkedHashSet<Event>();
	private final Set<String> tcpMsgC = new LinkedHashSet<String>();
	private final Set<String> tcpMsgS = new LinkedHashSet<String>();
	
	private long index_i = 0;
	private long numSeqC = 0;
	private long numSeqS = 0;
	public boolean timeOver = false;

	public final BasicTimer aBasicTimer;
	
	// Constructor section
	private TCPServer() {
		this.aBasicTimer = new BasicTimer(MSL, this);
		this.aSequensor = Sequensor.getSequensor(this);
	}

	// TCPServer Runnable section
	public void run(){
		/*cmdASet.add(new Event("Open"));
		eventSet.add(new Event("SYN"));
		eventSet.add(new Event("ACK"));
		eventSet.add(new Event("Close"));
		eventSet.add(new Event("ACK"));
		eventSet.add(new Event("END"));*/
		
		/*cmdASet.add(new Event("Open"));
		eventSet.add(new Event("SYN"));
		eventSet.add(new Event("Abort"));*/
		
		/*cmdASet.add(new Event("Open"));
		eventSet.add(new Event("SYN"));*/
		
		/*cmdASet.add(new Event("Open"));
		eventSet.add(new Event("SYN"));
		eventSet.add(new Event("ACK"));
		eventSet.add(new Event("Close"));
		eventSet.add(new Event("RST"));*/
		
		for(;true;) {
			//Update eventSet and cmdA
			this.receive();
			//Set the events to the sequensor
			
			Iterator<Event> iterator = cmdASet.iterator();
			while (iterator.hasNext()) {
			    Event event = iterator.next();
			    aSequensor.tryy(event);
			    iterator.remove();
			}
			
			iterator = eventSet.iterator();
			while (iterator.hasNext()) {
			    Event event = iterator.next();
			    aSequensor.tryy(event);
			    iterator.remove();
			}
			
			eventSet.addAll(eventSetToBeAdd);
			eventSetToBeAdd.clear();
		
			if(timeOver) {
				eventSet.add(new Event("TimeOver"));
				timeOver = false;
			}
		}
	}

	public void addEventInEventSet(Event e) {
		eventSetToBeAdd.add(e);
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
		System.out.println("Connection �tablie");
	}

	public void writeFIN() {
	}

	public void writeACK() {
	}

	public void writeSYN() {
	}

	public void writeMsg() {
	}
	
	public static TCPServer getTCPServer() {
		return new TCPServer();
	}
}
