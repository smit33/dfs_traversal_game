import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main{

    public static void main(String[] args) {
        int numOfVertices;
        Scanner sc = new Scanner(System.in);

    //        System.out.print("Enter the number of vertices: ");
    //        numOfVertices = sc.nextInt();
    //        Graph G = new Graph(numOfVertices);

    // For your reference, a sample graph with edges added is commented below

    // example 1
    //        G.addEdge(0,1);
    //        G.addEdge(0,3);
    //        G.addEdge(1,2);
    //        G.addEdge(3,2);
    //        G.addEdge(3,4);

        // example 2
        Graph G = new Graph(9);

        G.addEdge(0,1);
        G.addEdge(0,3);
        G.addEdge(0,8);
        G.addEdge(1,7);
        G.addEdge(8,4);
        G.addEdge(3,4);
        G.addEdge(3,2);
        G.addEdge(7,2);
        G.addEdge(2,5);
        G.addEdge(5,6);

        G.printGraph();     //printing adjacency list of graph

        G.dfs_iterative(0);     // DFS traversal of graph

    }
}

