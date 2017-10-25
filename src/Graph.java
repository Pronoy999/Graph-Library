import java.util.*;

public class Graph {
    int graph[][],numberOfEdges;
    String edges[];
    PriorityQueue<Vertex> graphQueue;
    ArrayList<Vertex> vertices=new ArrayList<>();
    public Graph(int graph[][],int numberOfEdges,String edges[]){
        this.numberOfEdges=numberOfEdges;
        this.graph=graph;
        this.edges=edges;
        graphQueue=new PriorityQueue<>(numberOfEdges);
    }
    private void createVertexList(){
        int i;
        for(i=0;i<numberOfEdges;i++){
            vertices.add(new Vertex(edges[i]));
        }
        int pos=0;
        for(Vertex v : vertices){
            for(i=0;i<numberOfEdges;i++){
                if(graph[pos][i]!=-1){
                    Vertex vertex=getVertex(v.name);
                    v.connectedEdges.put(vertex,graph[pos][i]);
                }
            }
            graphQueue.add(v);
        }
    }
    private Vertex getVertex(String name){
        for(Vertex vertex:vertices){
            if(vertex.name.equals(name))
                return vertex;
        }
        return null;
    }
    public PriorityQueue setGraph(){
        createVertexList();
        return graphQueue;
    }
}
