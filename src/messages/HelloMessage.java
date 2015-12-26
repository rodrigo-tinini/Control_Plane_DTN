package messages;

import java.util.ArrayList;
import java.util.Hashtable;


import core.Edge;
import core.Router;

/**
 * 
 */

/**
 * @author Rodrigo
 * 
 */
public class HelloMessage {
	/** Id of the message */
	String msgId;	
	/** Id of the sending router */
	String routerIdent;
	/* List of neighbors */
	Hashtable<String, Router> neighborsHello;
	/* Buffers of the other routers */
	Hashtable<String, Integer> neighborsBufferHello;
	/* Connections of the network */
	ArrayList<Edge> allContactsHello;
	
	
	/**
	 * Constructor
	 * 
	 */
	public HelloMessage(Hashtable<String, Router> neighbors,
			Hashtable<String, Integer> aNeighborsBufferHello,
			ArrayList<Edge> aAllContactsHello, String aId, String aMsgId) {
		
		
		this.neighborsHello = neighbors;
		this.neighborsBufferHello = aNeighborsBufferHello;
		this.allContactsHello = aAllContactsHello;
		this.routerIdent = aId;
		this.msgId = aMsgId;
		
	}
	
	/**
	 * Constructor
	 * 
	 */
	public HelloMessage(String aMsgId) {
		
		
		this.neighborsHello = new Hashtable<String, Router>();
		this.neighborsBufferHello = new Hashtable<String, Integer>();
		this.allContactsHello = new ArrayList<Edge>();
		this.routerIdent = "Teste";
		this.msgId = aMsgId;
		
	}

	public Hashtable<String, Router> getNeighborsHello() {
		return neighborsHello;
	}

	public void setNeighborsHello(Hashtable<String, Router> neighborsHello) {
		this.neighborsHello = neighborsHello;
	}

	public Hashtable<String, Integer> getNeighborsBufferHello() {
		return neighborsBufferHello;
	}

	public void setNeighborsBufferHello(
			Hashtable<String, Integer> neighborsBufferHello) {
		this.neighborsBufferHello = neighborsBufferHello;
	}

	public ArrayList<Edge> getAllContactsHello() {
		return allContactsHello;
	}

	public void setAllContactsHello(ArrayList<Edge> allContactsHello) {
		this.allContactsHello = allContactsHello;
	}
	
	public String getRouterIdent() {
		return routerIdent;
	}

	public void setRouterIdent(String routerIdent) {
		this.routerIdent = routerIdent;
	}
	
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	

}
