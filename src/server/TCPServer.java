package server;
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
	private final Set<Event> cmdASetToBeAdd = new LinkedHashSet<Event>();
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
		
		//int testNormal = 0;
		//int testAbort = 0;
		
		//testNormal();
		//testAbort();
		//testRST();
		testTimeOver();
		
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
			
			cmdASet.addAll(cmdASetToBeAdd);
			cmdASetToBeAdd.clear();
		
			if(timeOver) {
				eventSet.add(new Event("TimeOver"));
				timeOver = false;
			}
			
			/*if(testNormal == 0) {
				testNormalPart2();
				testNormal = 1;
			}*/
			
			/*if(testAbort == 0) {
				testAbortPart2();
				testAbort = 1;
			}*/
		}
	}

	public void addEventInEventSet(Event e) {
		eventSetToBeAdd.add(e);
	}
	
	public void addEventInCmdASet(Event e) {
		cmdASetToBeAdd.add(e);
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
		System.out.println("Connection établie");
	}

	public void writeFIN() {
		System.out.println("writeFIN");
	}

	public void writeACK() {
		System.out.println("writeACK");
	}

	public void writeSYN() {
		System.out.println("writeSYN");
	}

	public void writeMsg() {
		System.out.println("writeMsg");
	}
	
	public static TCPServer getTCPServer() {
		return new TCPServer();
	}
	
	private void testNormal() {
		cmdASet.add(new Event(Event.EVENT_OPEN_NAME));
		eventSet.add(new Event(Event.EVENT_SYN_NAME));
		eventSet.add(new Event(Event.EVENT_ACK_NAME));
	}
	
	private void testNormalPart2() {
		addEventInCmdASet(new Event(Event.EVENT_CLOSE_NAME));
		addEventInEventSet(new Event(Event.EVENT_ACK_NAME));
		addEventInEventSet(new Event(Event.EVENT_END_NAME));
	}
	
	
	private void testAbort() {
		cmdASet.add(new Event(Event.EVENT_OPEN_NAME));
		eventSet.add(new Event(Event.EVENT_SYN_NAME));
	}
	
	private void testAbortPart2() {
		addEventInCmdASet(new Event(Event.EVENT_ABORT_NAME));
	}
	
	private void testRST() {
		cmdASet.add(new Event(Event.EVENT_OPEN_NAME));
		eventSet.add(new Event(Event.EVENT_SYN_NAME));
		eventSet.add(new Event(Event.EVENT_RST_NAME));
	}
	
	private void testTimeOver() {
		cmdASet.add(new Event(Event.EVENT_OPEN_NAME));
		eventSet.add(new Event(Event.EVENT_SYN_NAME));
		eventSet.add(new Event(Event.EVENT_ACK_NAME));
		eventSet.add(new Event(Event.EVENT_CLOSE_NAME));
		eventSet.add(new Event(Event.EVENT_ACK_NAME));
	}
}
