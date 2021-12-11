/**
 * @author John Mobarry
 * This class represents an town as a node of a graph. The Town class holds the name of the town and a list of adjacent towns,
 * and other fields as desired, and the traditional methods (constructors, getters/setters, toString, etc.).
 */

public class Town implements Comparable<Town>{

    String name = "";


    public Town(String n){

        name = n;
    }

 
    public Town(Town templateTown){
        name = templateTown.name;

    }

    @Override
    public int compareTo(Town o) {

       return name.compareTo(o.name);
    }


    public boolean equals(Object o) {
      return (this.name.equalsIgnoreCase(((Town) o).name));
    }


    public String getName(){
        return name;
    }


    public int hashCode(){
        return name.hashCode();
    }


    @Override
    public String toString() {
        return name;
    }

}