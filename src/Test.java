import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    int arr[][],num;
    String edges[];
    String startingVertex;
    public void input(){
        Scanner scanner=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of Edges:");
        num=scanner.nextInt();
        edges=new String [num];
        //arr=new int[num][num];
        System.out.println("Enter the Name of the Edges: ");
        int i,j;
        for (i=0;i<num;i++){
            try{
                edges[i]=br.readLine();
            }
            catch (IOException e){e.printStackTrace();}
        }
        arr=new int[][]{
                {0,4,0,0,0,0,0,8,0},
                {4,0,8,0,0,0,0,11,0},
                {0,8,0,7,0,4,0,0,2},
                {0,0,7,0,9,14,0,0,0},
                {0,0,0,9,0,10,0,0,0},
                {0,0,4,14,10,0,0,0,0},
                {0,0,0,0,0,2,0,1,6},
                {8,11,0,0,0,0,1,0,7},
                {0,0,2,0,0,0,6,7,0}
        };
        /*System.out.println("Enter the Adj Matrix: \n");
        for(i=0;i<num;i++){
            for(j=0;j<num;j++){
                if(i!=j){
                    System.out.println("Enter the value from "+edges[i]+" to "+edges[j]);
                    arr[i][j]=scanner.nextInt();
                }
                else arr[i][j]=0;
            }
        }*/
        /*System.out.println("Enter the Starting Vertex:");
        try{startingVertex=br.readLine();}
        catch (IOException ignored){}*/
    }
    public static void main(String a[]){
        Test test=new Test();
        test.input();
        Graph graph=new Graph(test.arr,test.num,test.edges);
        PriorityQueue<Vertex> queue=graph.setGraph();
        //String arr[]=graph.calculateBFS(queue,test.startingVertex);
        //String arr[]=graph.calculateDFS(queue);
        ArrayList<Edge> list=graph.MST_Krushkal(graph.edgeList);
        System.out.println("The visited Vertex are: ");
        for(Edge e:list){
            System.out.println(e.vertex1+":"+e.vertex2);
        }
        /*for(String e:arr){
            if(!e.equals(""))System.out.println(e);
        }
        System.out.println("The Distance of Each Vertex: ");
        for(int i=0;i<graph.distance.length;i++){
            System.out.println(test.edges[i]+" : "+graph.distance[i]);
        }*/
    }
}
