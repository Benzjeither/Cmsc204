/**
 * The class Road that can represent the edges of a Graph of Towns. The class must implement Comparable.
 * The class stores references to the two vertices(Town endpoints), the distance between vertices, and a name,
 * and the traditional methods (constructors, getters/setters, toString, etc.), and a compareTo, which compares two
 * Road objects. Since this is a undirected graph, an edge from A to B is equal to an edge from B to A.
 * @author John Mobarry
 */
public class Road implements Comparable<Road>{

    Town source;
    Town destination;
    int weight;
    String name;

 
    public Road(Town source, Town destination, int degrees, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = degrees;
        this.name = name;
    }


    public Road(Town source, Town destination, String name){
        this(source, destination, 1, name);
    }

    @Override
    public int compareTo(Road o) {
        return this.weight - o.weight;
    }

  
    public boolean contains(Town t) {
        return this.source.equals(t) || this.destination.equals(t);
    }


    public boolean equals(Object r) {
        return (this.source.equals(((Road) r).source) && this.destination.equals(((Road) r).destination) ||
                this.source.equals(((Road) r).destination) && this.destination.equals(((Road) r).source));
    }

    public Town getSource() {
        return this.source;
    }

    public Town getDestination() {
        return this.destination;
    }

 
    public int getWeight() {
        return this.weight;
    }

  
    public String toString(){
        return this.name+ " ["+source + "," + destination+"] " +weight;
    }

    public String getName() {
        return this.name ;
    }
    public int hashCode(){
        return this.name.hashCode();
    }

}