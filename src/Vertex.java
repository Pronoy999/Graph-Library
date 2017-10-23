import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Vertex {
    /**
     * The Name of the Vertex.
     */
    String name;
    /**
     * The Connected edges with their weights from the current vertex.
     */
    HashMap<String,Integer> connectedEdges;

    /**
     * The Constructor to initialize the Vertex object.
     * @param name: The name of the vertex.
     * @param connectedEdges: The name-weight pair for each vertex connected to the current vertex. 
     */
    public Vertex(String name,HashMap<String,Integer> connectedEdges){
        this.name=name;
        this.connectedEdges=connectedEdges;
    }
    public Vertex(String name, List<String> connectedEdges,List<Integer> connectedEdgesWeight){
        this.name=name;
        this.connectedEdges=new HashMap<>();
        Iterator iterator=connectedEdges.iterator();
        Iterator iterator1=connectedEdgesWeight.iterator();
        while(iterator.hasNext() && iterator1.hasNext()){
            this.connectedEdges.put(String.valueOf(iterator.next()),Integer.valueOf(String.valueOf(iterator1.next())));
        }
    }
}
