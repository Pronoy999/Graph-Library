import java.util.HashMap;

public class Vertex implements Comparable<Vertex> {
    /**
     * The Name of the Vertex.
     */
     String name;
    /**
     * The Connected edges with their weights from the current vertex.
     */
     HashMap<Vertex,Integer> connectedEdges;
    /**
     * The Constructor to initialize the Vertex object.
     * @param name: The name of the vertex.
     * @param connectedEdges: The name-weight pair for each vertex connected to the current vertex.
     */
    public Vertex(String name,HashMap<Vertex,Integer> connectedEdges){
        this.name=name;
        this.connectedEdges=connectedEdges;
    }

    /**
     * A Constructor to create a Vertex object only with the name.
     * @param name: The name of the vertex.
     */
    public Vertex(String name){
        this.name=name;
        connectedEdges=new HashMap<>();
    }

    @Override
    public int compareTo(Vertex o) {
        return o.name.compareTo(this.name);
    }
}
