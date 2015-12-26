package core;

/**
 * This class represents a contact (connection) of two routers in the network
 */

/**
 * @author Rodrigo
 * 
 */
public class Edge {
	/** The key identifier of the router on the first side of the contact */
	String router_Source;
	/** The key identifier of the router on the other side of the contact */
	String router_Dest;
	/** Distance among these nodes */
	Double value;
	/** Id of the destiny router */
	String destId;
	

	/**
	 * Constructor
	 * @return
	 */
	public Edge(String aSource, String aDest, Double aValue){
		this.router_Source = aSource;
		this.router_Dest = aDest;
		this.value = aValue;
		this.destId = aDest;
	}

	public String getDestId() {
		return destId;
	}

	public void setDestId(String destId) {
		this.destId = destId;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getRouter_Source() {
		return router_Source;
	}

	public void setRouter_Source(String router_Source) {
		this.router_Source = router_Source;
	}

	public String getRouter_Dest() {
		return router_Dest;
	}

	public void setRouter_Dest(String router_Dest) {
		this.router_Dest = router_Dest;
	}
}
