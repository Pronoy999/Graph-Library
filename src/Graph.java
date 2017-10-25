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
                    Vertex vertex=getVertex(edges[i]);
                    v.connectedEdges.put(vertex,graph[pos][i]);
                }
            }
            pos++;
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
    public PriorityQueue<Vertex> setGraph(){
        createVertexList();
        return graphQueue;
    }
    private int getIndex(String vertexName){
        int i,l=edges.length;
        for(i=0;i<l;i++){
            if(edges[i].equals(vertexName))
                return i;
        }
        return -1;
    }
    public String[] calculateBFS(PriorityQueue<Vertex> graphQueue,String sourceVertex){
        return getBFS(graphQueue,getVertex(sourceVertex));
    }
    private String[] getBFS(PriorityQueue<Vertex> graphQueue,Vertex sourceVertex){
        char WHITE='W',GREY='G',BLACK='B';int pos=0;
        String visitedVertex[]=new String[numberOfEdges];
        char color[]=new char[numberOfEdges];
        for(Vertex v :graphQueue){
            color[getIndex(v.name)]=WHITE;
        }
        color[getIndex(sourceVertex.name)]=GREY;
        SupportQueue<Vertex> queue=new SupportQueue<>();
        queue.add(sourceVertex);
        visitedVertex[pos++]=sourceVertex.name;
        try {
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                for (HashMap.Entry<Vertex, Integer> map : vertex.connectedEdges.entrySet()) {
                    if (color[getIndex(map.getKey().name)] == WHITE) {
                        color[getIndex(map.getKey().name)] = GREY;
                        queue.add(map.getKey());
                        visitedVertex[pos++] = map.getKey().name;
                    }
                }
                color[getIndex(vertex.name)] = BLACK;
            }
        }
        catch (NoSuchElementException ignored){}
        return visitedVertex;
    }
}
