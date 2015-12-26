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
public class UpdateMessage {
	/** Id of the sending router */
	String routerIdent;
	/* List of neighbors */
	Hashtable<String, Router> neighborsUpdate;
	/* Buffers of the other routers */
	Hashtable<String, Integer> neighborsBufferUpdate;
	/* Connections of the network */
	ArrayList<Edge> allContactsUpdate;
	/** Entries removed */
	ArrayList<Edge> removed;

	/**
	 * Constructor
	 * 
	 */
	public UpdateMessage(Hashtable<String, Router> neighbors,
			Hashtable<String, Integer> aNeighborsBufferUpdate,
			ArrayList<Edge> aAllContactsUpdate, ArrayList<Edge> aRemoved) {
		this.neighborsUpdate = neighbors;
		this.neighborsBufferUpdate = aNeighborsBufferUpdate;
		this.allContactsUpdate = aAllContactsUpdate;
		this.removed = aRemoved;
	}

	public Hashtable<String, Router> getNeighborsUpdate() {
		return neighborsUpdate;
	}

	public void setNeighborsUpdate(Hashtable<String, Router> neighborsUpdate) {
		this.neighborsUpdate = neighborsUpdate;
	}

	public Hashtable<String, Integer> getNeighborsBufferUpdate() {
		return neighborsBufferUpdate;
	}

	public void setNeighborsBufferUpdate(
			Hashtable<String, Integer> neighborsBufferUpdate) {
		this.neighborsBufferUpdate = neighborsBufferUpdate;
	}

	public ArrayList<Edge> getAllContactsUpdate() {
		return allContactsUpdate;
	}

	public void setAllContactsUpdate(ArrayList<Edge> allContactsUpdate) {
		this.allContactsUpdate = allContactsUpdate;
	}

	public String getRouterIdent() {
		return routerIdent;
	}

	public void setRouterIdent(String routerIdent) {
		this.routerIdent = routerIdent;
	}

}
