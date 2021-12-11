import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface{

    Graph graph = new Graph();

    /**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
 
    	boolean flag;
        if ((getTown(town1) != null||getTown(town2) != null)
        		&& !(graph.containsEdge(getTown(town1),getTown(town2))))
        {
            this.graph.addEdge(getTown(town1),getTown(town2),weight,roadName);
            flag = true;
        }
        else{
            flag = false;
        }
        
        return flag;
    }

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
    @Override
    public String getRoad(String town1, String town2) {
       if(graph.getEdge(getTown(town1),getTown(town2))==null){
    	   return "Not a road";
   
       }
       else{
    	   return graph.getEdge(getTown(town1),getTown(town2)).getName();
       }
    }
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
    @Override
    public boolean addTown(String v) {
    	Town town = new Town(v);
    	
		return graph.addVertex(town);


    }

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
    @Override
    public Town getTown(String name) {

        Town result = null;
        
        for(Town x: graph.towns){

            if(x.getName().equals(name)){
                result = x;
                break;
            }
            else{
                continue;
            }
        }
        return result;
    }

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
    @Override
    public boolean containsTown(String v) {
    	Town place = new Town(v);
		return graph.containsVertex(place);
    }

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return !this.getRoad(town1,town2).equals("Not a road");
    }
    
    public void populateTownGraph(File file) throws FileNotFoundException {

        Scanner keyboard = null;
        keyboard = new Scanner(file);

      ArrayList<String> input = new ArrayList<>();

      do {
    	  input.add(keyboard.nextLine());
    	  
      }while (keyboard.hasNextLine());

      keyboard.close();

      for(String x: input){

          String[] fullRoads = x.split(";");
          String[] roadInfo = fullRoads[0].split(",");

          String name = roadInfo[0].trim();
          int info = Integer.parseInt(roadInfo[1]);
          String source = fullRoads[1].trim();
          String destination = fullRoads[2].trim();

          if(source!= null && destination!=null ) {
        	  
        	  if(info>0 && name!= null) {
        		  addRoad(source, destination, info, name);
                  addTown(source);
                  addTown(destination);
        	  }
             
          }
      }
  }

    /**
     * This method creates an ArrayList of Strings representing all of the roads in the edge set by name
     * @return ArrayList</String>
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> Roads = new ArrayList<>();
        for(Road x: graph.edgeSet()){
            Roads.add(x.getName());
        }
        Collections.sort(Roads);
        return Roads;
    }

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {


        for (Road x: graph.roads){
            if(road!= null && !x.name.equalsIgnoreCase(road)){
                continue;
            }
            if(x.contains(getTown(town1)) && x.contains(getTown(town2))){
                graph.roads.remove(x);
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
    @Override
    public boolean deleteTown(String v) {
        Town toDelete = this.getTown(v);
        
        return graph.removeVertex(toDelete);
    }


	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> towns = new ArrayList<>();
        
        for(Town vertex: this.graph.vertexSet()){
            towns.add(vertex.getName());
        }
        Collections.sort(towns);
        return towns;
    }

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
    @Override
    public ArrayList<String> getPath(String town1, String town2) {

        return graph.shortestPath(getTown(town1),getTown(town2));
    }




}
