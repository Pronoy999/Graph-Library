public class Edge implements Comparable<Edge>{
    Vertex vertex1,vertex2;
    int weight;
    public Edge(Vertex vertex1,Vertex vertex2,int weight){
        this.vertex1=vertex1;
        this.vertex2=vertex2;
        this.weight=weight;
    }
    @Override
    public int compareTo(Edge o) {
        if(weight>o.weight)
            return 1;
        else if(weight<o.weight)
            return -1;
        return 0;
    }
}
