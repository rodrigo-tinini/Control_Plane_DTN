/**
 * This class represents the simulation of the network operation
 */
package core;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import messages.HelloMessage;
import messages.UpdateMessage;

/**
 * @author Rodrigo
 *
 */
public class Simulation {
/**Random number generator for the id's of the routers */
	static Random rand = new Random();
/** Number of routers to be in the topology */
	static int numberOfRouters = 5;
	/** General struct to keep all the routers generated - Out of the realistic aspect of the simulation, only for control and help */
	static Hashtable<String, Router> routersGen;
	/** Struct to keep the routers who will update their own structs - Needed for the simulation, not for the realistic environment */
	static Hashtable<String, Router> updatingRouters;
	static ArrayList<Router> toUpdate;
	static ArrayList<Router> previous;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Starts the simulation generating a specific number of routers
		routersGen = new Hashtable<String, Router>();
		toUpdate = new ArrayList<Router>();
		previous = new ArrayList<Router>();
		/*for(int i = 0; i < numberOfRouters; i++){
			Router router = new Router(Integer.toString(rand.nextInt(50)), 500.0, "Wi-Fi", 1000.0);
			routersGen.put(router.routerId, router);
		}*/
		
		
		
		/**
		Router router1 = new Router("A", 5000.0, "Wi-Fi", 1000000.0);
		Router router2 = new Router("B", 5000.0, "Wi-Fi", 1000000.0);
		Router router3 = new Router("C", 5000.0, "Wi-Fi", 1000000.0);
		Router router4 = new Router("D", 5000.0, "Wi-Fi", 1000000.0);
		Router router5 = new Router("E", 5000.0, "Wi-Fi", 1000000.0);
		
		System.out.println("Nodes created"); **/
		/**
		//Creating the edges and adding them to the routers' network knowledge list
		Edge ed1 = new Edge(router1.getRouterId(), router2.getRouterId(), 10.0);
		router1.setallConEdge(ed1);
		router1.setNeighbors(router2.getRouterId(), router2);
		Edge ed2 = new Edge(router2.getRouterId(), router1.getRouterId(), 10.0);
		Edge ed3 = new Edge(router2.getRouterId(), router3.getRouterId(), 20.0);
		Edge ed4 = new Edge(router2.getRouterId(), router4.getRouterId(), 25.0);
		router2.setallConEdge(ed2);
		router2.setallConEdge(ed3);
		router2.setallConEdge(ed4);
		router2.setNeighbors(router1.getRouterId(), router1);
		router2.setNeighbors(router3.getRouterId(), router3);
		router2.setNeighbors(router4.getRouterId(), router4);
		//router2.getEdges().add(ed2);
		router2.getEdges().add(ed3);
		router2.getEdges().add(ed4);
		Edge ed5 = new Edge(router3.getRouterId(), router2.getRouterId(), 20.0);
		router3.setallConEdge(ed5);
		router3.setNeighbors(router2.getRouterId(), router2);
		router3.getEdges().add(ed5);
		Edge ed6 = new Edge(router4.getRouterId(), router2.getRouterId(), 25.0);
		Edge ed7 = new Edge(router4.getRouterId(), router5.getRouterId(), 10.0);
		router4.setallConEdge(ed6);
		router4.setallConEdge(ed7);
		router4.setNeighbors(router2.getRouterId(), router2);
		router4.setNeighbors(router5.getRouterId(), router5);
		router4.getEdges().add(ed6);
		router4.getEdges().add(ed7);
		Edge ed8 = new Edge(router5.getRouterId(), router4.getRouterId(), 10.0);
		router5.setallConEdge(ed8);
		router5.setNeighbors(router4.getRouterId(), router4);
		router5.getEdges().add(ed8);
		
		routersGen.put(router1.getRouterId(), router1);
		routersGen.put(router2.getRouterId(), router2);
		routersGen.put(router3.getRouterId(), router3);
		routersGen.put(router4.getRouterId(), router4);
		routersGen.put(router5.getRouterId(), router5);
		
		System.out.println(router1.getEntry());
		System.out.println(router2.getEntry());
		System.out.println(router3.getEntry());
		System.out.println(router4.getEntry());
		System.out.println(router5.getEntry());
		
		Set<String> keys = routersGen.keySet();
		for(String key:keys){
			System.out.println(key);
		}
		System.out.println("Contacts of the network:");
		//Printing the edges
		
		router1.printEdges();
		router2.printEdges();
		router3.printEdges();
		router4.printEdges();
		router5.printEdges();
		System.out.println("Neighbors of each router:");
		//Printing the neighbors of each router
		router1.printNeighbors();
		router2.printNeighbors();
		router3.printNeighbors();
		router4.printNeighbors();
		router5.printNeighbors();
		int j = 0;
		//Sends the epidemic message, starting from router A
		HelloMessage hello = router1.generateHello();
		//HelloMessage hello2 = router2.generateHello();
		toUpdate = router1.newUpdate(hello, toUpdate);
		router1.printHelloRecv();
		//toUpdate = router2.newUpdate(hello2, toUpdate);
		**/
		
		//*******************************BEGINNING OF THE FIRST SIMULATION***********************************
		/*
		//Router A sends its message
		for(int u = 0; u<toUpdate.size(); u++){
			System.out.println(toUpdate.get(u).routerId);
		}
		System.out.println(toUpdate.size());
		while(!toUpdate.isEmpty()){
			//Set<String> rtrKeys = toUpdate.keySet();
			for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
				System.out.println("Iteration: "+j);				
				Router auxRouter = toUpdate.get(j);
				System.out.println(auxRouter.getEntry());
				toUpdate = auxRouter.newUpdate(hello, toUpdate);
				System.out.println(auxRouter.getEntry());
				boolean removed = Simulation.toUpdate.remove(auxRouter);
				if(removed){
					System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
				}
				Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
				for(String key:rtrKeys){
					
					Router router = auxRouter.getNeighbors().get(key);
					if(router.getEntry()==0){
						toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
					}
				}
				
				for(int u = 0; u<toUpdate.size(); u++){
					System.out.println(toUpdate.get(u).routerId);
				}
				System.out.println(toUpdate.size());
				
				
				
			}
		
		}

		//router3.printHello();
		//router3.printHelloRecv();
		//router4.printHello();
		//router4.printHelloRecv();
		//router5.printHello();
		//router5.printHelloRecv();
		router1.printEdges();
		router2.printEdges();
		router3.printEdges();
		router4.printEdges();
		router5.printEdges();
	
		System.out.println("Finished Router A Generating the message");
		
		//Clean the entry parameter
		router1.setEntry(0);
		router2.setEntry(0);
		router3.setEntry(0);
		router4.setEntry(0);
		router5.setEntry(0);
		toUpdate.clear();
		
		//Router B sends its message
		HelloMessage hello2 = router2.generateHello();
		toUpdate = router2.newUpdate(hello2, toUpdate);
				for(int u = 0; u<toUpdate.size(); u++){
					System.out.println(toUpdate.get(u).routerId);
				}
				System.out.println(toUpdate.size());
				while(!toUpdate.isEmpty()){
					//Set<String> rtrKeys = toUpdate.keySet();
					for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
						System.out.println("Iteration: "+j);				
						Router auxRouter = toUpdate.get(j);
						System.out.println(auxRouter.getEntry());
						toUpdate = auxRouter.newUpdate(hello2, toUpdate);
						System.out.println(auxRouter.getEntry());
						boolean removed = Simulation.toUpdate.remove(auxRouter);
						if(removed){
							System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
						}
						Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
						for(String key:rtrKeys){
							
							Router router = auxRouter.getNeighbors().get(key);
							if(router.getEntry()==0){
								toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
							}
						}
						
						for(int u = 0; u<toUpdate.size(); u++){
							System.out.println(toUpdate.get(u).routerId);
						}
						System.out.println(toUpdate.size());
						
						
						
					}
				
				}
		
				router1.printEdges();
				router2.printEdges();
				router3.printEdges();
				router4.printEdges();
				router5.printEdges();
				System.out.println("Router B Finished");
				
				//Clean the entry parameter
				router1.setEntry(0);
				router2.setEntry(0);
				router3.setEntry(0);
				router4.setEntry(0);
				router5.setEntry(0);
				toUpdate.clear();
				
				//Router C sends its message
				HelloMessage hello3 = router3.generateHello();
				toUpdate = router3.newUpdate(hello3, toUpdate);
						for(int u = 0; u<toUpdate.size(); u++){
							System.out.println(toUpdate.get(u).routerId);
						}
						System.out.println(toUpdate.size());
						while(!toUpdate.isEmpty()){
							//Set<String> rtrKeys = toUpdate.keySet();
							for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
								System.out.println("Iteration: "+j);				
								Router auxRouter = toUpdate.get(j);
								System.out.println(auxRouter.getEntry());
								toUpdate = auxRouter.newUpdate(hello3, toUpdate);
								System.out.println(auxRouter.getEntry());
								boolean removed = Simulation.toUpdate.remove(auxRouter);
								if(removed){
									System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
								}
								Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
								for(String key:rtrKeys){
									
									Router router = auxRouter.getNeighbors().get(key);
									if(router.getEntry()==0){
										toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
									}
								}
								
								for(int u = 0; u<toUpdate.size(); u++){
									System.out.println(toUpdate.get(u).routerId);
								}
								System.out.println(toUpdate.size());
								
								
								
							}
						
						}
						
						router1.printEdges();
						router2.printEdges();
						router3.printEdges();
						router4.printEdges();
						router5.printEdges();
						System.out.println("Router C Finished");
						
						//Clean the entry parameter
						router1.setEntry(0);
						router2.setEntry(0);
						router3.setEntry(0);
						router4.setEntry(0);
						router5.setEntry(0);
						toUpdate.clear();
						
						//Router D sends its message
						HelloMessage hello4 = router4.generateHello();
						toUpdate = router4.newUpdate(hello4, toUpdate);
								for(int u = 0; u<toUpdate.size(); u++){
									System.out.println(toUpdate.get(u).routerId);
								}
								System.out.println(toUpdate.size());
								while(!toUpdate.isEmpty()){
									//Set<String> rtrKeys = toUpdate.keySet();
									for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
										System.out.println("Iteration: "+j);				
										Router auxRouter = toUpdate.get(j);
										System.out.println(auxRouter.getEntry());
										toUpdate = auxRouter.newUpdate(hello4, toUpdate);
										System.out.println(auxRouter.getEntry());
										boolean removed = Simulation.toUpdate.remove(auxRouter);
										if(removed){
											System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
										}
										Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
										for(String key:rtrKeys){
											
											Router router = auxRouter.getNeighbors().get(key);
											if(router.getEntry()==0){
												toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
											}
										}
										
										for(int u = 0; u<toUpdate.size(); u++){
											System.out.println(toUpdate.get(u).routerId);
										}
										System.out.println(toUpdate.size());
										
										
										
									}
								
								}
								
								router1.printEdges();
								router2.printEdges();
								router3.printEdges();
								router4.printEdges();
								router5.printEdges();
								System.out.println("Router D Finished");
								
								//Clean the entry parameter
								router1.setEntry(0);
								router2.setEntry(0);
								router3.setEntry(0);
								router4.setEntry(0);
								router5.setEntry(0);
								toUpdate.clear();
								
								//Router E sends its message
								HelloMessage hello5 = router5.generateHello();
								toUpdate = router5.newUpdate(hello5, toUpdate);
										for(int u = 0; u<toUpdate.size(); u++){
											System.out.println(toUpdate.get(u).routerId);
										}
										System.out.println(toUpdate.size());
										while(!toUpdate.isEmpty()){
											//Set<String> rtrKeys = toUpdate.keySet();
											for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
												System.out.println("Iteration: "+j);				
												Router auxRouter = toUpdate.get(j);
												System.out.println(auxRouter.getEntry());
												toUpdate = auxRouter.newUpdate(hello5, toUpdate);
												System.out.println(auxRouter.getEntry());
												boolean removed = Simulation.toUpdate.remove(auxRouter);
												if(removed){
													System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
												}
												Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
												for(String key:rtrKeys){
													
													Router router = auxRouter.getNeighbors().get(key);
													if(router.getEntry()==0){
														toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
													}
												}
												
												for(int u = 0; u<toUpdate.size(); u++){
													System.out.println(toUpdate.get(u).routerId);
												}
												System.out.println(toUpdate.size());
												
												
												
											}
										
										}
										
										router1.printEdges();
										router2.printEdges();
										router3.printEdges();
										router4.printEdges();
										router5.printEdges();
										System.out.println("Router E Finished");
										//Clean the entry parameter
										router1.setEntry(0);
										router2.setEntry(0);
										router3.setEntry(0);
										router4.setEntry(0);
										router5.setEntry(0);
										toUpdate.clear();
										
										//Now, modifying the topology and sending the update message after a change
										Edge newEd = new Edge("A", "D", 5.0);
										Edge newEd2 = new Edge("A", "E", 5.0);
										Edge newEd3 = new Edge("D", "A", 5.0);
										Edge newEd4 = new Edge("E", "A", 5.0);
										
										
										//Moving A away from the connection with B
										router1.getAllContacts().remove(ed1);
										router1.getAllContacts().remove(ed2);
										router1.getNeighbors().remove("B");
										router1.getEdgesRemoved().add(ed2);
										router1.getEdgesRemoved().add(ed1);
										//B removes this connection from its contacts list
										router2.getAllContacts().remove(ed2);
										router2.getAllContacts().remove(ed1);
										router2.getNeighbors().remove("A");
										router2.getEdgesRemoved().add(ed2);
										router2.getEdgesRemoved().add(ed1);
										//Sends an update message from router B and a Hello message from router A
										//First, the update message from B, we will consider that router A still haven't arrived at the contacts of D and E
										router1.printEdges();
										router2.printEdges();
										
										//Router B generates an update message
										UpdateMessage upDate = router2.generateUpdate();
										toUpdate = router2.sendUpdateMsg(upDate, toUpdate, router2.getEdgesRemoved());
										//falta o resto do while agora
										while(!toUpdate.isEmpty()){
											//Set<String> rtrKeys = toUpdate.keySet();
											for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
												System.out.println("Iteration: "+j);				
												Router auxRouter = toUpdate.get(j);
												System.out.println(auxRouter.getEntry());
												toUpdate = auxRouter.sendUpdateMsg(upDate, toUpdate, router2.getEdgesRemoved());
												System.out.println(auxRouter.getEntry());
												boolean removed = Simulation.toUpdate.remove(auxRouter);
												if(removed){
													System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
												}
												Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
												for(String key:rtrKeys){
													
													Router router = auxRouter.getNeighbors().get(key);
													if(router.getEntry()==0){
														toUpdate.add(router);
													}
												}
												
												for(int u = 0; u<toUpdate.size(); u++){
													System.out.println(toUpdate.get(u).routerId);
												}
												System.out.println(toUpdate.size());																										
											}
										
										}
										
										
										
										router1.printEdges();
										router2.printEdges();
										router3.printEdges();
										router4.printEdges();
										router5.printEdges();
										
										
										//Setting the new contacts of A, D and E
										router1.setallConEdge(newEd);
										router1.setallConEdge(newEd2);
										router4.setallConEdge(newEd3);
										router5.setallConEdge(newEd4);
										router1.getNeighbors().put(router4.getRouterId(), router4);
										router1.getNeighbors().put(router5.getRouterId(), router5);
										router4.getNeighbors().put(router1.getRouterId(), router1);
										router5.getNeighbors().put(router1.getRouterId(), router1);
										router1.getEdges().add(newEd);
										router1.getEdges().add(newEd2);
										//Clean the entry parameter
										router1.setEntry(0);
										router2.setEntry(0);
										router3.setEntry(0);
										router4.setEntry(0);
										router5.setEntry(0);
										toUpdate.clear();
										
										//Now, A sends a Hello message to its new neighbors, D and E
										HelloMessage newHello = router1.generateHello();
										toUpdate = router1.newUpdate(newHello, toUpdate);
												for(int u = 0; u<toUpdate.size(); u++){
													System.out.println(toUpdate.get(u).routerId);
												}
												System.out.println(toUpdate.size());
												while(!toUpdate.isEmpty()){
													//Set<String> rtrKeys = toUpdate.keySet();
													for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
														System.out.println("Iteration: "+j);				
														Router auxRouter = toUpdate.get(j);
														//System.out.println(auxRouter.getEntry());
														toUpdate = auxRouter.newUpdate(newHello, toUpdate);
														//System.out.println(auxRouter.getEntry());
														boolean removed = Simulation.toUpdate.remove(auxRouter);
														if(removed){
															System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
														}
														Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
														for(String key:rtrKeys){
															
															Router router = auxRouter.getNeighbors().get(key);
															if(router.getEntry()==0){
																toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
															}
														}
														
														for(int u = 0; u<toUpdate.size(); u++){
															System.out.println(toUpdate.get(u).routerId);
														}
														System.out.println(toUpdate.size());
														
														
														
													}
												
												}
												
												router1.printEdges();
												router2.printEdges();
												router3.printEdges();
												router4.printEdges();
												router5.printEdges();
												router1.printNeighbors();
												
												//Clean the entry parameter
												router1.setEntry(0);
												router2.setEntry(0);
												router3.setEntry(0);
												router4.setEntry(0);
												router5.setEntry(0);
												toUpdate.clear();
												
												//Now, D sends a Hello message to its new neighbors, D and E
												HelloMessage newHello2 = router4.generateHello();
												toUpdate = router4.newUpdate(newHello2, toUpdate);
														for(int u = 0; u<toUpdate.size(); u++){
															System.out.println(toUpdate.get(u).routerId);
														}
														System.out.println(toUpdate.size());
														while(!toUpdate.isEmpty()){
															//Set<String> rtrKeys = toUpdate.keySet();
															for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																System.out.println("Iteration: "+j);				
																Router auxRouter = toUpdate.get(j);
																//System.out.println(auxRouter.getEntry());
																toUpdate = auxRouter.newUpdate(newHello2, toUpdate);
																//System.out.println(auxRouter.getEntry());
																boolean removed = Simulation.toUpdate.remove(auxRouter);
																if(removed){
																	System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																}
																Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																for(String key:rtrKeys){
																	
																	Router router = auxRouter.getNeighbors().get(key);
																	if(router.getEntry()==0){
																		toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																	}
																}
																
																for(int u = 0; u<toUpdate.size(); u++){
																	System.out.println(toUpdate.get(u).routerId);
																}
																System.out.println(toUpdate.size());
																
																
																
															}
														
														}
														
														router1.printEdges();
														router2.printEdges();
														router3.printEdges();
														router4.printEdges();
														router5.printEdges();
														router1.printNeighbors();
														
														//Clean the entry parameter
														router1.setEntry(0);
														router2.setEntry(0);
														router3.setEntry(0);
														router4.setEntry(0);
														router5.setEntry(0);
														toUpdate.clear();
														
														//Now, E sends a Hello message to its new neighbors, D and E
														HelloMessage newHello3 = router5.generateHello();
														toUpdate = router5.newUpdate(newHello3, toUpdate);
																for(int u = 0; u<toUpdate.size(); u++){
																	System.out.println(toUpdate.get(u).routerId);
																}
																System.out.println(toUpdate.size());
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(newHello3, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){
																			
																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}
																		
																		for(int u = 0; u<toUpdate.size(); u++){
																			System.out.println(toUpdate.get(u).routerId);
																		}
																		System.out.println(toUpdate.size());
																		
																		
																		
																	}
																
																}
																
																router1.printEdges();
																router2.printEdges();
																router3.printEdges();
																router4.printEdges();
																router5.printEdges();
																router1.printNeighbors();
										
										

																//Now, creates a packet and routers it from router A to router B
																ArrayList<String> route;
																Packet packet = new Packet(router3.getRouterId());
																route = simpleRouting(router1,  packet);
																System.out.println("This is the route:");
																for(int i = 0; i<route.size(); i++){
																	System.out.println(route.get(i));
																}
																*/
		                                                        //**********************END OF THE FIRST SIMULATION******************
																int j = 0;
																
																//**********************The IPN simulation***************************
																
																//Creates the routers
																Router earthTerminal = new Router("Earth Terminal", 5000.0, "Wi-Fi", 1000000.0);
																Router earthSatellite = new Router("Earth Satellite", 5000.0, "Wi-Fi", 1000000.0);
																Router moonTerminal = new Router("Moon Terminal", 5000.0, "Wi-Fi", 1000000.0);
																Router moonSatellite = new Router("Moon Satellite", 5000.0, "Wi-Fi", 1000000.0);
																Router marsTerminal = new Router("Mars Terminal", 5000.0, "Wi-Fi", 1000000.0);
																Router marsSatellite = new Router("Mars Satellite", 5000.0, "Wi-Fi", 1000000.0);
																Router marsSatellite2 = new Router("Mars Satellite 2", 5000.0, "Wi-Fi", 1000000.0);
																
																//Now, creates the topology, based on the article Multipath Transmission Through Cooperative Network-Coded in
																//IPN Internet Based on Linear Block Codes
																//Earth and moon contacts
																Edge earthTerminal_earthSatellite = new Edge(earthTerminal.getRouterId(), earthSatellite.getRouterId(), 1000.0);
																Edge earthSatellite_earthTerminal = new Edge(earthSatellite.getRouterId(), earthTerminal.getRouterId(), 1000.0);
																Edge earthTerminal_moonSatellite = new Edge(earthTerminal.getRouterId(), moonSatellite.getRouterId(), 1000.0);
																Edge moonSatellite_earthTerminal = new Edge(moonSatellite.getRouterId(), earthTerminal.getRouterId(), 1000.0);
																Edge moonTerminal_moonSatellite = new Edge(moonTerminal.getRouterId(), moonSatellite.getRouterId(), 1000.0);
																Edge moonSatellite_moonTerminal = new Edge(moonSatellite.getRouterId(), moonTerminal.getRouterId(), 1000.0);
																Edge moonTerminal_earthSatellite = new Edge(moonTerminal.getRouterId(), earthSatellite.getRouterId(), 1000.0);
																Edge earthSatellite_moonTerminal = new Edge(earthSatellite.getRouterId(), moonTerminal.getRouterId(), 1000.0);																
																//Mars contacts
																Edge marsTerminal_marsSatellite = new Edge(marsTerminal.getRouterId(), marsSatellite.getRouterId(), 1000.0);
																Edge marsSatellite_marsTerminal = new Edge(marsSatellite.getRouterId(), marsTerminal.getRouterId(), 1000.0);
																Edge marsTerminal_marsSatellite2 = new Edge(marsTerminal.getRouterId(), marsSatellite2.getRouterId(), 1000.0);
																Edge marsSatellite2_marsTerminal = new Edge(marsSatellite2.getRouterId(), marsTerminal.getRouterId(), 1000.0);															
																//Earth, Moon, Mars direct contacts
																Edge earth_mars = new Edge(earthTerminal.getRouterId(), marsTerminal.getRouterId(), 5000.0);
																Edge mars_earth = new Edge(marsTerminal.getRouterId(), earthTerminal.getRouterId(), 5000.0);
																Edge moon_mars = new Edge(moonTerminal.getRouterId(), marsTerminal.getRouterId(), 5000.0);
																Edge mars_moon = new Edge(marsTerminal.getRouterId(), moonTerminal.getRouterId(), 5000.0);																
																//Sattelites contacts
																Edge earthS_marsS = new Edge(earthSatellite.getRouterId(), marsSatellite.getRouterId(), 5000.0);
																Edge marsS_earthS = new Edge(marsSatellite.getRouterId(), earthSatellite.getRouterId(), 5000.0);
																Edge moonS_marsS2 = new Edge(moonSatellite.getRouterId(), marsSatellite2.getRouterId(), 5000.0);
																Edge marsS2_moonS = new Edge(marsSatellite2.getRouterId(), moonSatellite.getRouterId(), 5000.0);
																
																//Now, put the edges in the neighbors list of each router
																earthTerminal.setallConEdge(earthTerminal_earthSatellite);
																earthSatellite.setallConEdge(earthSatellite_earthTerminal);
																earthTerminal.setallConEdge(earthTerminal_moonSatellite);
																moonSatellite.setallConEdge(moonSatellite_earthTerminal);
																moonTerminal.setallConEdge(moonTerminal_moonSatellite);
																moonSatellite.setallConEdge(moonSatellite_moonTerminal);
																moonTerminal.setallConEdge(moonTerminal_earthSatellite);
																earthSatellite.setallConEdge(earthSatellite_moonTerminal);
																marsTerminal.setallConEdge(marsTerminal_marsSatellite);
																marsSatellite.setallConEdge(marsSatellite_marsTerminal);
																marsTerminal.setallConEdge(marsTerminal_marsSatellite2);
																marsSatellite2.setallConEdge(marsSatellite2_marsTerminal);
																earthTerminal.setallConEdge(earth_mars);
																marsTerminal.setallConEdge(mars_earth);
																moonTerminal.setallConEdge(moon_mars);
																marsTerminal.setallConEdge(mars_moon);
																earthSatellite.setallConEdge(earthS_marsS);
																marsSatellite.setallConEdge(marsS_earthS);
																moonSatellite.setallConEdge(moonS_marsS2);
																marsSatellite2.setallConEdge(marsS2_moonS);
																
																//Now, set the neighbors
																earthTerminal.setNeighbors(earthSatellite.getRouterId(), earthSatellite);
																earthTerminal.setNeighbors(moonSatellite.getRouterId(), moonSatellite);
																earthSatellite.setNeighbors(earthTerminal.getRouterId(), earthTerminal);
																earthSatellite.setNeighbors(moonTerminal.getRouterId(), moonTerminal);
																moonTerminal.setNeighbors(moonSatellite.getRouterId(), moonSatellite);
																moonTerminal.setNeighbors(earthSatellite.getRouterId(), earthSatellite);
																moonSatellite.setNeighbors(moonTerminal.getRouterId(), moonTerminal);
																moonSatellite.setNeighbors(earthTerminal.getRouterId(), earthTerminal);
																marsTerminal.setNeighbors(marsSatellite.getRouterId(), marsSatellite);
																marsTerminal.setNeighbors(marsSatellite2.getRouterId(), marsSatellite2);
																marsSatellite.setNeighbors(marsTerminal.getRouterId(), marsTerminal);
																marsSatellite2.setNeighbors(marsTerminal.getRouterId(), marsTerminal);
																earthTerminal.setNeighbors(marsTerminal.getRouterId(), marsTerminal);
																marsTerminal.setNeighbors(earthTerminal.getRouterId(), earthTerminal);
																moonTerminal.setNeighbors(marsTerminal.getRouterId(), marsTerminal);
																marsTerminal.setNeighbors(moonTerminal.getRouterId(),moonTerminal);
																earthSatellite.setNeighbors(marsSatellite.getRouterId(), marsSatellite);
																marsSatellite.setNeighbors(earthSatellite.getRouterId(), earthSatellite);
																moonSatellite.setNeighbors(marsSatellite2.getRouterId(), marsSatellite2);
																marsSatellite2.setNeighbors(moonSatellite.getRouterId(), moonSatellite);
																
																
																//Printing the contacts information in each node
																earthTerminal.printNeighbors();
																earthTerminal.printEdges();
																earthSatellite.printNeighbors();
																earthSatellite.printEdges();
																moonTerminal.printNeighbors();
																moonTerminal.printEdges();
																moonSatellite.printNeighbors();
																moonSatellite.printEdges();
																marsTerminal.printNeighbors();
																marsTerminal.printEdges();
																marsSatellite.printNeighbors();
																marsSatellite.printEdges();
																marsSatellite2.printNeighbors();
																marsSatellite2.printEdges();
																
																System.out.println("Without: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("Without: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("Without: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("Without: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("Without: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("Without: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("Without: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());

																//Sends the Hello message

																//Earth Terminal sends its Hello Message
																HelloMessage earthHello = earthTerminal.generateHello();
																//Send to its neighbors
																toUpdate = earthTerminal.newUpdate(earthHello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(earthHello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																//Printing the contacts information in each node
																earthTerminal.printNeighbors();
																earthTerminal.printEdges();
																earthSatellite.printNeighbors();
																earthSatellite.printEdges();
																moonTerminal.printNeighbors();
																moonTerminal.printEdges();
																moonSatellite.printNeighbors();
																moonSatellite.printEdges();
																marsTerminal.printNeighbors();
																marsTerminal.printEdges();
																marsSatellite.printNeighbors();
																marsSatellite.printEdges();
																marsSatellite2.printNeighbors();
																marsSatellite2.printEdges();
																
																System.out.println("First Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("First Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("First Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("First Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("First Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("First Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("First Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																//Earth Satellite sends its hello message
																HelloMessage earthSHello = earthSatellite.generateHello();
																//Send to its neighbors
																toUpdate = earthSatellite.newUpdate(earthSHello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(earthSHello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																
																System.out.println("2 Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("2 Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("2 Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("2 Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("2 Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("2 Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("2 Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																//Moon terminal sends its hello message
																HelloMessage moonHello = moonTerminal.generateHello();
																//Send to its neighbors
																toUpdate = moonTerminal.newUpdate(moonHello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(moonHello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																
																System.out.println("3 Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("3 Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("3 Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("3 Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("3 Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("3 Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("3 Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																//Moon satellite sends its hello message
																HelloMessage moonSHello = moonSatellite.generateHello();
																//Send to its neighbors
																toUpdate = moonSatellite.newUpdate(moonSHello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(moonSHello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																
																System.out.println("4 Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("4 Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("4 Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("4 Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("4 Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("4 Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("4 Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																//Mars terminal sends its hello message
																HelloMessage marsHello = marsTerminal.generateHello();
																//Send to its neighbors
																toUpdate = marsTerminal.newUpdate(marsHello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(marsHello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																
																System.out.println("5 Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("5 Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("5 Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("5 Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("5 Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("5 Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("5 Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																//Mars Satellite sends its hello message
																HelloMessage marsSHello = marsSatellite.generateHello();
																//Send to its neighbors
																toUpdate = moonTerminal.newUpdate(marsSHello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(marsSHello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																
																System.out.println("6 Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("6 Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("6 Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("6 Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("6 Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("6 Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("6 Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																//Mars Satellite 2 sends its hello message
																HelloMessage marsS2Hello = marsSatellite2.generateHello();
																//Send to its neighbors
																toUpdate = moonTerminal.newUpdate(marsS2Hello, toUpdate);
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		//System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		//System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.newUpdate(marsS2Hello, toUpdate);
																		//System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			//System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){

																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);//AQUI!!! TENHO QUE CRIAR UM MÉTODO ESPECIFICO PARA ADD OS VIZINHOS!!! AQUI ELE ADD SENDO 1 OU 0 A ENTRY!!!!!!!
																			}
																		}

																		for(int u = 0; u<toUpdate.size(); u++){
																			//System.out.println(toUpdate.get(u).routerId);
																		}
																		//System.out.println(toUpdate.size());



																	}

																}
																
																System.out.println("7 Cicle: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("7 Cicle: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("7 Cicle: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("7 Cicle: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("7 Cicle: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("7 Cicle: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("7 Cicle: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Printing the contacts information in each node
																earthTerminal.printNeighbors();
																earthTerminal.printEdges();
																earthSatellite.printNeighbors();
																earthSatellite.printEdges();
																moonTerminal.printNeighbors();
																moonTerminal.printEdges();
																moonSatellite.printNeighbors();
																moonSatellite.printEdges();
																marsTerminal.printNeighbors();
																marsTerminal.printEdges();
																marsSatellite.printNeighbors();
																marsSatellite.printEdges();
																marsSatellite2.printNeighbors();
																marsSatellite2.printEdges();
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																
																
																System.out.println("Changing the topology due to orbital movements!!!");
																System.out.println("Changing the topology due to orbital movements!!!");
																System.out.println("Changing the topology due to orbital movements!!!");
																System.out.println("Changing the topology due to orbital movements!!!");
																System.out.println("Changing the topology due to orbital movements!!!");
																
																//Lost of contacts by the moon elements - Moon and its satellite moving
																moonTerminal.getAllContacts().remove(moon_mars);
																moonTerminal.getNeighbors().remove(marsTerminal.getRouterId());
																moonTerminal.getAllContacts().remove(mars_moon);
																moonTerminal.getEdgesRemoved().add(mars_moon);
																moonTerminal.getEdgesRemoved().add(moon_mars);
																//moonSatellite.getAllContacts().remove(marsS2_moonS);
																//moonSatellite.getNeighbors().remove(marsSatellite2.getRouterId());
																//moonSatellite.getAllContacts().remove(moonS_marsS2);
																//moonSatellite.getEdgesRemoved().add(moonS_marsS2);
																//moonTerminal.getAllContacts().remove(moonTerminal_earthSatellite);
																//moonTerminal.getNeighbors().remove(earthSatellite.getRouterId());
																//moonTerminal.getAllContacts().remove(earthSatellite_moonTerminal);
																//moonTerminal.getEdgesRemoved().add(earthSatellite_moonTerminal);
																//moonTerminal.getEdgesRemoved().add(moonTerminal_earthSatellite);
																//moonSatellite.getEdgesRemoved().add(marsS2_moonS);
																
																//Lost of contacts by the earth elements
																//earthSatellite.getAllContacts().remove(earthSatellite_moonTerminal);
																//earthSatellite.getNeighbors().remove(moonTerminal.getRouterId());
																//earthSatellite.getEdgesRemoved().add(earthSatellite_moonTerminal);
																//earthSatellite.getAllContacts().remove(moonTerminal_earthSatellite);
																//earthSatellite.getEdgesRemoved().add(moonTerminal_earthSatellite);
																
																//Lost of contacts by mars elements
																marsTerminal.getAllContacts().remove(mars_moon);
																marsTerminal.getNeighbors().remove(moonTerminal.getRouterId());
																marsTerminal.getEdgesRemoved().add(mars_moon);
																marsTerminal.getAllContacts().remove(moon_mars);
																marsTerminal.getEdgesRemoved().add(moon_mars);
																//marsTerminal.getEdgesRemoved().add(moon_mars);
																//marsSatellite2.getAllContacts().remove(marsS2_moonS);
																//marsSatellite2.getNeighbors().remove(moonSatellite.getRouterId());
																//marsSatellite2.getEdgesRemoved().add(marsS2_moonS);
																//marsSatellite2.getAllContacts().remove(moonS_marsS2);
																//marsSatellite2.getEdgesRemoved().add(moonS_marsS2);
																
																//Lost of contacts by mars moving
																//marsSatellite.getAllContacts().remove(marsS_earthS);
																//marsSatellite.getNeighbors().remove(earthSatellite.getRouterId());
																//marsSatellite.getAllContacts().remove(earthS_marsS);
																//marsSatellite.getEdgesRemoved().add(earthS_marsS);
																//marsSatellite.getEdgesRemoved().add(marsS_earthS);
																//earthSatellite.getAllContacts().remove(earthS_marsS);
																//earthSatellite.getNeighbors().remove(marsSatellite.getRouterId());
																//earthSatellite.getEdgesRemoved().add(earthS_marsS);
																//earthSatellite.getAllContacts().remove(marsS_earthS);
																//earthSatellite.getEdgesRemoved().add(marsS_earthS);
																
																//Earth and mars lost contacts
																earthTerminal.getAllContacts().remove(earth_mars);
																earthTerminal.getAllContacts().remove(mars_earth);
																earthTerminal.getNeighbors().remove(marsTerminal);
																earthTerminal.getEdgesRemoved().add(earth_mars);
																earthTerminal.getEdgesRemoved().add(mars_earth);
																marsTerminal.getAllContacts().remove(mars_earth);
																marsTerminal.getAllContacts().remove(earth_mars);
																marsTerminal.getNeighbors().remove(earthTerminal);
																marsTerminal.getEdgesRemoved().add(earth_mars);
																marsTerminal.getEdgesRemoved().add(mars_earth);
																
																//Printing the contacts information in each node
																earthTerminal.printNeighbors();
																earthTerminal.printEdges();
																earthSatellite.printNeighbors();
																earthSatellite.printEdges();
																moonTerminal.printNeighbors();
																moonTerminal.printEdges();
																moonSatellite.printNeighbors();
																moonSatellite.printEdges();
																marsTerminal.printNeighbors();
																marsTerminal.printEdges();
																marsSatellite.printNeighbors();
																marsSatellite.printEdges();
																marsSatellite2.printNeighbors();
																marsSatellite2.printEdges();
																
																//The nodes sends the hello messages informing the change
																//First, mars terminal, mars satellite 2, earth satellite
																
																UpdateMessage marsT = marsTerminal.generateUpdate();
																toUpdate = marsTerminal.sendUpdateMsg(marsT, toUpdate, marsTerminal.getEdgesRemoved());
																//falta o resto do while agora
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.sendUpdateMsg(marsT, toUpdate, marsTerminal.getEdgesRemoved());
																		System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){
																			
																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);
																			}
																		}
																		
																		for(int u = 0; u<toUpdate.size(); u++){
																			System.out.println(toUpdate.get(u).routerId);
																		}
																		System.out.println(toUpdate.size());																										
																	}
																
																}
																
																//Printing the contacts information in each node
																earthTerminal.printNeighbors();
																earthTerminal.printEdges();
																earthSatellite.printNeighbors();
																earthSatellite.printEdges();
																moonTerminal.printNeighbors();
																moonTerminal.printEdges();
																moonSatellite.printNeighbors();
																moonSatellite.printEdges();
																marsTerminal.printNeighbors();
																marsTerminal.printEdges();
																marsSatellite.printNeighbors();
																marsSatellite.printEdges();
																marsSatellite2.printNeighbors();
																marsSatellite2.printEdges();
																
																System.out.println("After Update: "+earthTerminal.getRouterId()+" "+earthTerminal.getAllContacts().size());
																System.out.println("After Update: "+earthSatellite.getRouterId()+" "+earthSatellite.getAllContacts().size());
																System.out.println("After Update: "+moonTerminal.getRouterId()+" "+moonTerminal.getAllContacts().size());
																System.out.println("After Update: "+moonSatellite.getRouterId()+" "+moonSatellite.getAllContacts().size());
																System.out.println("After Update: "+marsTerminal.getRouterId()+" "+marsTerminal.getAllContacts().size());
																System.out.println("After Update: "+marsSatellite.getRouterId()+" "+marsSatellite.getAllContacts().size());
																System.out.println("After Update: "+marsSatellite2.getRouterId()+" "+marsSatellite2.getAllContacts().size());
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																
																/*UpdateMessage marsST2 = marsSatellite2.generateUpdate();
																toUpdate = marsSatellite2.sendUpdateMsg(marsST2, toUpdate, marsSatellite2.getEdgesRemoved());
																//falta o resto do while agora
																while(!toUpdate.isEmpty()){
																	//Set<String> rtrKeys = toUpdate.keySet();
																	for( j = 0; j<toUpdate.size(); j++){ //TALVEZ NAO TENHA NECESSIDADE DESSE FOR
																		System.out.println("Iteration: "+j);				
																		Router auxRouter = toUpdate.get(j);
																		System.out.println(auxRouter.getEntry());
																		toUpdate = auxRouter.sendUpdateMsg(marsST2, toUpdate, marsSatellite2.getEdgesRemoved());
																		System.out.println(auxRouter.getEntry());
																		boolean removed = Simulation.toUpdate.remove(auxRouter);
																		if(removed){
																			System.out.println("Removed! "+auxRouter.getRouterId()+" Last "+toUpdate.size());
																		}
																		Set<String> rtrKeys = auxRouter.getNeighbors().keySet();
																		for(String key:rtrKeys){
																			
																			Router router = auxRouter.getNeighbors().get(key);
																			if(router.getEntry()==0){
																				toUpdate.add(router);
																			}
																		}
																		
																		for(int u = 0; u<toUpdate.size(); u++){
																			System.out.println(toUpdate.get(u).routerId);
																		}
																		System.out.println(toUpdate.size());																										
																	}
																
																}
																
																//Printing the contacts information in each node
																earthTerminal.printNeighbors();
																earthTerminal.printEdges();
																earthSatellite.printNeighbors();
																earthSatellite.printEdges();
																moonTerminal.printNeighbors();
																moonTerminal.printEdges();
																moonSatellite.printNeighbors();
																moonSatellite.printEdges();
																marsTerminal.printNeighbors();
																marsTerminal.printEdges();
																marsSatellite.printNeighbors();
																marsSatellite.printEdges();
																marsSatellite2.printNeighbors();
																marsSatellite2.printEdges();
																
																//Cleaning the entry field and the to update list
																earthTerminal.setEntry(0);
																earthSatellite.setEntry(0);
																moonTerminal.setEntry(0);
																moonSatellite.setEntry(0);
																marsTerminal.setEntry(0);
																marsSatellite.setEntry(0);
																marsSatellite2.setEntry(0);
																toUpdate.clear();
																*/
																
																
																
																
																
	}
	
	
	
	
	

}
