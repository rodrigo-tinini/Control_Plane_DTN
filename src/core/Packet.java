/**
 * 
 */
package core;

/**
 * @author Rodrigo
 *
 */
public class Packet {
	//Destiny of this packet
	String id;
	//Size of this packet
	Double size = 100000.0;
	
	public Packet(String id) {
		this.id = id;
		//this.size = size;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	
	
	


}
