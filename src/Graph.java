import java.util.*;

class Graph {
    private int graph[][],numberOfEdges;
    private String edges[];
    /**
     * The Array to Store the distance of individual vertex from the source.
     */
    int distance[];
    /**
     * The Priority queue to store the graph.
     */
    private PriorityQueue<Vertex> graphQueue;
    /**
     * The List of the Vertex of the graph.
     */
    private ArrayList<Vertex> vertices=new ArrayList<>();

    /**
     * The Parameterized constructor of the class.
     * @param graph: The Adjacency Matrix of the graph.
     * @param numberOfEdges: The total number of edges of the graph.
     * @param edges: The name of the edges of the graph.
     */
    public Graph(int graph[][],int numberOfEdges,String edges[]){
        this.numberOfEdges=numberOfEdges;
        this.graph=graph;
        this.edges=edges;
        graphQueue=new PriorityQueue<>(numberOfEdges);
        distance=new int[numberOfEdges];
    }
    private void createVertexList(){
        int i;
        for(i=0;i<numberOfEdges;i++){
            vertices.add(new Vertex(edges[i]));
        }
        int pos=0;
        for(Vertex v : vertices){
            for(i=0;i<numberOfEdges;i++){
                if(graph[pos][i]>0){      //Negative edge is opposite directed.
                    Vertex vertex=getVertex(edges[i]);
                    v.connectedEdges.put(vertex,graph[pos][i]);
                }
            }
            pos++;
            graphQueue.add(v);
        }
    }

    /**
     * Method to get the Vertex Object with the name.
     * @param VertexName: The name of the vertex in string whose object is required.
     * @return The Vertex object of the vertex name.
     */
    private Vertex getVertex(String VertexName){
        for(Vertex vertex:vertices){
            if(vertex.name.equals(VertexName))
                return vertex;
        }
        return null;
    }
    public PriorityQueue<Vertex> setGraph(){
        createVertexList();
        return graphQueue;
    }

    /**
     * @param vertexName: The Name of the Vertex whose index is required.
     * @return The Index of the Vertex from the list of the vertices.
     */
    private int getIndex(String vertexName){
        int i,l=edges.length;
        for(i=0;i<l;i++){
            if(edges[i].equals(vertexName))
                return i;
        }
        return -1;
    }

    /**
     * Method to Calculate the BFS.
     * @param graphQueue: The Graph on which on the BFS is performed.
     * @param sourceVertex: The starting vertex.
     * @return The list vertex visited.
     */
    String[] calculateBFS(PriorityQueue<Vertex> graphQueue,String sourceVertex){
        return getBFS(graphQueue,getVertex(sourceVertex));
    }

    /**
     * Test
     * Method to calculate the Breadth First Search Algorithm.
     * @param graphQueue: The Graph.
     * @param sourceVertex: The starting vertex.
     * @return List of the Vertex visited.
     */
    private String[] getBFS(PriorityQueue<Vertex> graphQueue,Vertex sourceVertex){
        char WHITE='W',GREY='G',BLACK='B';
        int pos=0;
        String visitedVertex[]=new String[numberOfEdges];
        char color[]=new char[numberOfEdges];
        for(Vertex v :graphQueue){
            color[getIndex(v.name)]=WHITE;
        }
        color[getIndex(sourceVertex.name)]=GREY;
        distance[getIndex(sourceVertex.name)]=0;
        SupportQueue<Vertex> queue=new SupportQueue<>();
        queue.add(sourceVertex);
        visitedVertex[pos++]=sourceVertex.name;
        try {
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                for (HashMap.Entry<Vertex, Integer> map : vertex.connectedEdges.entrySet()) {
                    if (color[getIndex(map.getKey().name)] == WHITE) {
                        color[getIndex(map.getKey().name)] = GREY;
                        distance[getIndex(map.getKey().name)]=distance[getIndex(vertex.name)]+1;
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