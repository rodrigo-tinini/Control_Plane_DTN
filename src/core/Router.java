package core;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import messages.HelloMessage;
import messages.UpdateMessage;

/**
 * This class represents a router of the DTN network
 */

/**
 * @author Rodrigo
 * 
 */
public class Router {
	/* Id of this router */
	String routerId;
	/* Frequency of this router */
	Double heartz;
	/* Type of technology (3g, 4g, Wi-Fi) */
	String routerType;
	/* Buffer of this router */
	Double buffer;
	/** Edges of this router */
	ArrayList<Edge> edges;
	/* List of neighbors */
	Hashtable<String, Router> neighbors;
	/* Buffers of the other routers */
	Hashtable<String, Integer> neighborsBuffer;
	/* Connections of the network */
	ArrayList<Edge> allContacts;
	/** Random number generator */
	Random rand;
	/** The hello message received */
	HelloMessage hello;
	/** The update message received */
	UpdateMessage update;
	/** List of routers to receive a message */
    ArrayList<Router> toUpdate;
    	/** Messages received */
    ArrayList<HelloMessage> helloReceived;
    /** Messages received */
    ArrayList<UpdateMessage> updateReceived;
    /** Edges removed */
    ArrayList<Edge> edgesRemoved;
    

	/** Previous entry on the update list */
    int entry;
    /** Previous entries of routers to be update on a same message */
    ArrayList<Router> previous;
	
   

	
	/**
	 * Creates a new router
	 * 
	 * @param
	 */
	public Router(String aRouterId, Double aHeartz, String aRouterType,
			Double aBuffer) {
		this.routerId = aRouterId;
		this.heartz = aHeartz;
		this.routerType = aRouterType;
		this.buffer = aBuffer;
		rand = new Random();
		edges = new ArrayList<Edge>(); 
		neighbors = new Hashtable<String, Router>();
		neighborsBuffer = new Hashtable<String, Integer>();
		allContacts = new ArrayList<Edge>();
		toUpdate = new ArrayList<Router>();
        helloReceived = new ArrayList<HelloMessage>(); 
        updateReceived = new ArrayList<UpdateMessage>();
        edgesRemoved = new ArrayList<Edge>();
        /*for(int i = 0; i<100; i++){
        	HelloMessage aux = new HelloMessage("100");
        	helloReceived.add(i, aux);
        }*/
        previous = new ArrayList<Router>();
        this.entry = 0;
	}
	
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public ArrayList<Edge> getEdgesRemoved() {
		return edgesRemoved;
	}

	public void setEdgesRemoved(ArrayList<Edge> edgesRemoved) {
		this.edgesRemoved = edgesRemoved;
	}

	public ArrayList<UpdateMessage> getUpdateReceived() {
		return updateReceived;
	}

	public void setUpdateReceived(ArrayList<UpdateMessage> updateReceived) {
		this.updateReceived = updateReceived;
	}
	
	public ArrayList<Router> getPrevious() {
		return previous;
	}

	public void setPrevious(ArrayList<Router> previous) {
		this.previous = previous;
	}

	
	public Hashtable<String, Router> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Hashtable<String, Router> neighbors) {
		this.neighbors = neighbors;
	}

	public ArrayList<Edge> getAllContacts() {
		return allContacts;
	}

	public void setAllContacts(ArrayList<Edge> allContacts) {
		this.allContacts = allContacts;
	}

	public Hashtable<String, Integer> getNeighborsBuffer() {
		return neighborsBuffer;
	}

	public void setNeighborsBuffer(Hashtable<String, Integer> neighborsBuffer) {
		this.neighborsBuffer = neighborsBuffer;
	}

	public ArrayList<HelloMessage> getHelloReceived() {
		return helloReceived;
	}

	public void setHelloReceived(ArrayList<HelloMessage> helloReceived) {
		this.helloReceived = helloReceived;
	}
	

	/**
	 * Set a edge into allContacts
	 * @return
	 */
    public void setallConEdge(Edge aEdge){
    	this.allContacts.add(aEdge);
    }

    public ArrayList<Router> getToUpdate() {
    	return toUpdate;
    }

    public void setToUpdate(ArrayList<Router> toUpdate) {
    	this.toUpdate = toUpdate;
    }

    public HelloMessage getHello() {
    	return hello;
    }

	public void setHello(HelloMessage hello) {
		this.hello = hello;
	}

	public UpdateMessage getUpdate() {
		return update;
	}

	public void setUpdate(UpdateMessage update) {
		this.update = update;
	}

	

	/* getters e setters */
	public void setRouterId(String aRouterId) {
		this.routerId = aRouterId;
	}

	public String getRouterId() {
		return this.routerId;
	}
	
	 public int getEntry() {
			return entry;
		}

		public void setEntry(int entry) {
			this.entry = entry;
		}

	public void setHeartz(Double aHeartz) {
		this.heartz = aHeartz;
	}

	public Double getHeartz() {
		return this.heartz;
	}

	public void setRouterType(String aRouterType) {
		this.routerType = aRouterType;
	}

	public String getRouterType() {
		return this.routerType;
	}

	public void setBuffer(Double aBuffer) {
		this.buffer = aBuffer;
	}

	public Double getBuffer() {
		return this.buffer;
	}

	/**
	 * Sends a message to its neighbors
	 * 
	 * @param aMessage
	 *            The message to be sent
	 */
	public void sendMsg(Object obj) {

	}

	/**
	 * Update buffer after storing a message
	 * 
	 */
	public void updateBuffRecv() {
		this.buffer = this.buffer - 100000.0;
	}

	/**
	 * Update buffer after sending a message
	 * 
	 */
	public void updateBuffSend() {
		this.buffer = this.buffer + 100000.0;
	}

	/**
	 * Updates the neighbors list
	 */
	public void updateNeighbors() {
	}

	/**
	 * Updates the neighbors buffer list
	 */
	public void updateNeighBuff(HelloMessage aHello) {
	}

	/**
	 * Updates the list of all contacts in the network node by node based on the information
	 * received on the messages
	 */
	public ArrayList<Router> updateContacts(HelloMessage aHello, ArrayList<Router> aToUp, ArrayList<Router> aPrev) {
		this.setEntry(0);
		this.setHello(aHello);
		this.getHelloReceived().add(aHello);
		this.previous = aPrev;
		this.toUpdate = aToUp;
		/*Sends the message to each neighbor */
		Set<String> keys = this.neighbors.keySet();
		// Take each adjacent to send the message
		for(String auxKey: keys){
			//Take the router related to this key
			Router auxRouter = this.neighbors.get(auxKey);
			//Verify if it has an entry on the previous updates table
			if(!previous.contains(auxRouter)){
			auxRouter.setEntry(1);
			auxRouter.setHello(aHello);
			auxRouter.getHelloReceived().add(aHello);
			toUpdate.add(auxRouter);
			previous.add(auxRouter);
			}	
				
			}

		

		return toUpdate;
		
	}
	
	public void updateToUpdate(ArrayList<Router> toUpdate2){
		Set<String> keys = this.neighbors.keySet();
		for(String auxKey: keys){
			Router auxRouter = neighbors.get(auxKey);
			toUpdate2.add(auxRouter);
		}
	}

	/**
	 * Updates the neighbors buffer list
	 */
	public void updateNeighBuff(UpdateMessage aUpdate) {
	}

	/**
	 * Updates the list of all contacts in the network based on the information
	 * received on the messages
	 */
	public void updateContacts(UpdateMessage aUpdate) {
		/*Sends the message to each neighbor */
		Set<String> keys = this.neighbors.keySet();
		for(String auxKey: keys){
			Router auxRouter = neighbors.get(auxKey);
			auxRouter.setUpdate(aUpdate);
		}
	}
	
	/**Remove an old entry
	 * @param aEdges The old entry before the update of the network to be removed before a new entry correspondent to the new topology
	 */
	public void removeOldEntry(ArrayList<Edge> aEdges){
		//Search for a same entry on the table
				int i;
				for(i = 0; i<aEdges.size(); i++){
					if(this.allContacts.contains(aEdges.get(i))){
						this.allContacts.remove(i);
					}
				}
				
	}
	
	/** Verifies if the edges sent is on the entries of this router
	 * @param aEdges The edges sent by the previous neighbor to be update here
	 */
	public boolean compareEntries(ArrayList<Edge> aEdges){
		boolean contains = false;
		//Search for a same entry on the table
		int i;
		for(i = 0; i<aEdges.size(); i++){
			if(this.allContacts.contains(aEdges.get(i))){
				contains = true;
			}
		}
		if(contains){
			return false;
		}
		this.allContacts.add(aEdges.get(i));
		return true;
	}

	/**
	 * Generates a hello message to send to its neighbors
	 * 
	 */
	public HelloMessage generateHello() {
		HelloMessage hello = new HelloMessage(this.neighbors,
				this.neighborsBuffer, this.allContacts, this.routerId, Integer.toString(this.rand.nextInt(50)));
		return hello;
	}

	/**
	 * Generates an update message to send to its neighbors
	 * 
	 */
	public UpdateMessage generateUpdate() {
		UpdateMessage update = new UpdateMessage(this.neighbors,
				this.neighborsBuffer, this.allContacts, this.edgesRemoved);
		return update;
	}
	
	/**
	 * Set the neighbors
	 */
	public void setNeighbors(String aId, Router aRouter){
		this.neighbors.put(aId, aRouter);
	}
	
	/**
	 * Print the neighbors
	 */
	public void printNeighbors(){
		Set<String> keys = neighbors.keySet();
		System.out.println("This is router: "+this.getRouterId());
		for(String key:keys){
			System.out.println(neighbors.get(key).getRouterId());
		}
	}
	
	
		
	/**
	 * Print the message that this router is carrying
	 */
	public void printHello(){
		System.out.println("Generator router: "+this.getHello().getRouterIdent()+" Present node: "+this.getRouterId());
	}
	
	/**
	 * Print the edges
	 */
	public void printEdges(){
		int i = 0;
		System.out.println("This is router: "+this.getRouterId());
		for(i = 0; i<allContacts.size(); i++){
			System.out.println("Source: "+this.allContacts.get(i).getRouter_Source()+" Destiny: "+this.allContacts.get(i).getRouter_Dest()+" Value: " + this.allContacts.get(i).getValue());
		}
	}
	
	/**Print the hello messages received
	 * 
	 */
	public void printHelloRecv(){
		int i = 0;
		for(i = 0; i<this.helloReceived.size(); i++){
			
				System.out.println("This is Router: "+this.getRouterId()+" Id of the Hello Message: "+helloReceived.get(i).getMsgId()+" Received from Router: "+this.getHello().getRouterIdent());
			
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Router> newUpdate(HelloMessage aHello, ArrayList<Router> aUp){
		//this.setEntry(1);
		//Edge newa = new Edge("CERTOOO", "AEEEEE", 500.0);
		toUpdate = aUp;
		//Take all the adjacents from this router
		Set<String> keys = this.neighbors.keySet();
		//Update each adjacent
		for(String key:keys){
			Router auxRouter = this.neighbors.get(key);
			//System.out.println("AEEEEEEE "+auxRouter.getEntry());
			if(auxRouter.getEntry() == 0){
			//Sends the message
			auxRouter.setHello(aHello);
			auxRouter.getHelloReceived().add(aHello);
			//Put the neighbors to the neighbors' all contacts lists
			for(int i = 0; i<this.getAllContacts().size(); i++){
				if(!auxRouter.getAllContacts().contains(this.getAllContacts().get(i))){
					auxRouter.getAllContacts().add(this.getAllContacts().get(i));
				}
			}
			//Put this neighbors at the newighbors neigh's list
			//auxRouter.getAllContacts().add(newa);
			//Mark as updated
			auxRouter.setEntry(1);
			//Put in the to update table to update its neighbors
			toUpdate.add(auxRouter);
			//this.setEntry(true);
			}
			
		}
		return toUpdate;
	}
	
	public ArrayList<Router> sendUpdateMsg(UpdateMessage aUpdate, ArrayList<Router> aUp, ArrayList<Edge> aRemov){
		//this.setEntry(1);
				//Edge newa = new Edge("CERTOOO", "AEEEEE", 500.0);
		edgesRemoved = aRemov;		
		toUpdate = aUp;
				//Take all the adjacents from this router
				Set<String> keys = this.neighbors.keySet();
				//Update each adjacent
				for(String key:keys){
					Router auxRouter = this.neighbors.get(key);
					//System.out.println("AEEEEEEE "+auxRouter.getEntry());
					if(auxRouter.getEntry() == 0){
					//Sends the message
					auxRouter.setUpdate(aUpdate);
					auxRouter.getUpdateReceived().add(aUpdate);
					//Put the neighbors to the neighbors' all contacts lists and updates the removed entries - FAKTA FAZER ESSA ULTIMA PARTE
					/*for(int i = 0; i<this.getAllContacts().size(); i++){
						if(!auxRouter.getAllContacts().contains(this.getAllContacts().get(i))){
							auxRouter.getAllContacts().add(this.getAllContacts().get(i));
						}
					}*/
					for(int j =0; j<this.getEdgesRemoved().size(); j++){
						if(auxRouter.getAllContacts().contains(this.getEdgesRemoved().get(j))){
							auxRouter.getAllContacts().remove(this.getEdgesRemoved().get(j));
						}
					}
					//Put this neighbors at the newighbors neigh's list
					//auxRouter.getAllContacts().add(newa);
					//Mark as updated
					auxRouter.setEntry(1);
					//Put in the to update table to update its neighbors
					toUpdate.add(auxRouter);
					//this.setEntry(true);
					}
					
				}
				return toUpdate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
