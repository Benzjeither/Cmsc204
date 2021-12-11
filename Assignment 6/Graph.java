import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The root interface in the graph hierarchy. A mathematical graph-theory graph
 * object G(V,E) contains a set V of vertices and a set
 * E of edges. Each edge e=(v1,v2) in E connects vertex v1 to vertex v2.
 *
 * Through generics, a graph can be typed to specific classes for vertices
 * V and edges E<T>. Such a graph can contain
 * vertices of type V and all sub-types and Edges of type
 * E and all sub-types.
 */

public class Graph implements GraphInterface<Town, Road> {

 
    Set<Town> towns = new HashSet<>();
    Set<Road> roads = new HashSet<>();
     
    private ArrayList<String> shortestPath = new ArrayList<>(); 
    private Town destination;
    private int end;
    
    
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        Road road = null;
        for (Road x : roads) {
            if (x.contains(sourceVertex) && x.contains(destinationVertex)) {
                road = x;
           }
        }
        return road;
    }


    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, 
            int weight, String description) throws IllegalArgumentException, NullPointerException
    {
        
        if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) { 
            throw new IllegalArgumentException();
        }
        if (sourceVertex == null) {
            throw new NullPointerException();
        }
        else if(destinationVertex == null) 
        	  throw new NullPointerException();

        
        Road road = new Road(sourceVertex, destinationVertex, weight, description);
        roads.add(road);
        
        return road;
    }

    
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    @Override
    public boolean addVertex(Town v) {
        
    	boolean flag = false;
        
        if (!towns.contains(v)) {
            towns.add(v);
            flag = true;
        }
        
        if (v == null) {
            throw new NullPointerException();
        }
        return flag;
    }

    
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
    	boolean flag = false;
    	
        for (Road x : roads) {
            if (x.contains(sourceVertex) && x.contains(destinationVertex)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    @Override
    public boolean containsVertex(Town v) {
        return towns.contains(v);
    }


    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    @Override
    public Set<Road> edgeSet() {
        return roads;
    }

    

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> edges = new HashSet<>();
        for (Road x : roads) {
            if (x.contains(vertex)) {
                edges.add(x);
            }
        }
        return edges;
    }

    
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, 
            int weight, String description) {
        
    	 Road road = null;
        if (sourceVertex == null) {
            throw new NullPointerException();
        }
        
        else if(destinationVertex == null) {
        	 throw new NullPointerException();
        }
        else if(description == null) {
        	throw new NullPointerException();

        }
        
        if (!towns.contains(sourceVertex)) { 
            throw new IllegalArgumentException();
        }
        
        else if(!towns.contains(destinationVertex)) {
        	 throw new IllegalArgumentException();
        }
 
        for (Road x : roads) {
            if (x.contains(sourceVertex) && x.contains(destinationVertex)) {
            	if(x.getWeight() == weight && x.getName().equals(description)) {
            		road = x;
            	}
            }
        }
        return roads.remove(road) ? road : null;
    }

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    @Override
    public boolean removeVertex(Town v) {
        return towns.remove(v);
    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
    @Override
    public Set<Town> vertexSet() {
        return towns;
    }

    
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   
    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        destination = destinationVertex;
        dijkstraShortestPath(sourceVertex);
        String path = "";
        int totalMiles = 0;
        for (int index = 0; index < shortestPath.size() - 1; index++) {
            Town town = new Town(shortestPath.get(index));
            Town destination = new Town(shortestPath.get(index + 1));
            Road road = getEdge(town, destination);
            //test
            if(road==null)
            	{
            	totalMiles = 0; 
            	path = "no path";
            	}
            else {
            totalMiles += road.getWeight();
            path += town + " via " + road.getName() + " to " + destination 
                    + " " + road.getWeight() + " mi;";
            }
        }
        shortestPath.clear();
        for (String step : path.split(";")) {
            shortestPath.add(step);
        }
        shortestPath.add("Total miles: " + totalMiles + " miles");
        return shortestPath;
    }

    
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
        shortestPath.clear();
        Town[] table = new Town[towns.size()];
        int y = 0;
        for (Town t : towns) {
            table[y] = new Town(t);
            y++;
        }        
        int[][] adjacent = new int[towns.size()][towns.size()];       
        for (int i = 0; i < adjacent.length; i++) {
            for (int j = 0; j < adjacent[i].length; j++) {
                if (i == j || !containsEdge(table[i], table[j])) {
                    adjacent[i][j] = 0;
                } else {
                    int weight = getEdge(table[i], table[j]).getWeight();
                    adjacent[i][j] = adjacent[j][i] = weight;
                }
            }
        }
        
        int start = 0;
        for (Town x : table) {
            if (!x.equals(sourceVertex)) {
                start++;
            } else {
                break;
            }
        }
        
        end = 0;
        for (Town t : table) {
            if (!t.equals(destination)) {
                end++;
            } else {
                break;
            }
        }
        
        int num = adjacent[0].length; 
        
        int[] weights = new int[num];
        
        boolean[] added = new boolean[num];
        
        for (int i = 0; i < num; i++) {
            weights[i] = Integer.MAX_VALUE;
            added[i] = false;
        }
        
        weights[start] = 0;
        
        int[] parents = new int[num];
        
        parents[start] = -1;
        
        for (int i = 1; i < num; i++) {
            int closest = -1;
            int smallestWeight = Integer.MAX_VALUE;
            for (int counter = 0; counter < num; counter++) {
                if (!added[counter] && 
                        weights[counter] < smallestWeight) {
                    closest = counter;
                    smallestWeight = weights[counter];
                }
            }
            added[closest] = true;
            for (int counter = 0; counter < num; counter++) {
                int distance = adjacent[closest][counter]; 
                
                if (distance > 0 && 
                        ((smallestWeight + distance) < weights[counter])) {
                    parents[counter] = closest;
                    weights[counter] = smallestWeight + distance;
                }
            }           
        }
        populatePathArrayList(end, parents); 
    }
    
    /**
     * Populate town with the order of towns to go from town to destination
     * @param currentVertex index of destination
     * @param parents indexes of towns in shortest path
     */
    private void populatePathArrayList(int currentVertex, int[] parents) {
        
        if (currentVertex == -1) { 
            return; 
        } 
        populatePathArrayList(parents[currentVertex], parents); 
        int townIdx = 0;
        for (Town t : towns) {
            if (townIdx == currentVertex) {
                shortestPath.add(t.getName()); 
            }
            townIdx++;
        }
    } 

}