import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    int numOfVertices;
    LinkedList<Integer>[] adjList;
    Player playerA;
    Player playerB;

    Graph(int v) {
        numOfVertices = v;
        adjList = new LinkedList[v];

        // initializing linked list for each vertex
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<Integer>();

        // creating Player object
        System.out.println("Player 1:");
        playerA = new Player(numOfVertices);
        System.out.println("Player 2:");
        playerB = new Player(numOfVertices);
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);        // remove this line if graph is directed
    }

    public void dfs_iterative(int s) {
        int activePlayer = 0;               // 0 - playerA  1 - playerB

        playerA.stack.push(s);
        playerB.stack.push(s);

        for(int i = 0; !playerA.stack.empty() || !playerB.stack.empty(); i++) {

            //playerA
            if (activePlayer == 0) {
                int u = playerA.stack.peek();

                // if the node is not visited and not currently occupied by B
                if (i == 0 || (!playerA.visited[u] && playerB.occupied != u)) {
                    playerA.visited[u] = true;
                    playerA.occupied = u;
                    playerA.stack.pop();
                    System.out.println(playerA.name + ": " + u);

                } else if (playerB.occupied == u) {     // the peeked element is occupied by Player A
                    int temp = playerA.stack.pop();
                    if (playerA.stack.empty()) {
                        System.out.println(playerA.name + " chance skipped");   // stack is empty, chance skipped
                        continue;
                    }
                    u = playerA.stack.peek();

                    playerA.visited[u] = true;
                    playerA.occupied = u;
                    System.out.println(playerA.name + ": " + u);

                    playerA.stack.pop();
                    playerA.stack.push(temp);
                }

                for (int j : adjList[u]) {  // adding thr adjacent vertices in the stack
                    if (!playerA.visited[j]) {
                        playerA.stack.push(j);
                    }
                }
                activePlayer = 1;

                if(playerA.isWinning()) {
                    System.out.println(playerA.name + " has won!");
                    return;
                }

            }

            //playerB
            if (activePlayer == 1) {
                int u = playerB.stack.peek();
                // if the node is not visited and not currently occupied by A
                if (i == 0 || (!playerB.visited[u] && playerA.occupied != u)){
                    playerB.visited[u] = true;
                    playerB.occupied = u;
                    playerB.stack.pop();
                    System.out.println(playerB.name + ": " + u);

                } else if (playerA.occupied == u) {     // the peeked element is occupied by Player A
                    int temp = playerB.stack.pop();
                    if (playerB.stack.empty()) {
                        System.out.println(playerB.name + " chance skipped");
                        continue;
                    }
                    u = playerB.stack.peek();

                    playerB.visited[u] = true;
                    playerB.occupied = u;
                    System.out.println(playerB.name + ": " + u);

                    playerB.stack.pop();
                    playerB.stack.push(temp);
                }

                for (int j : adjList[u]) {      // adding thr adjacent vertices in the stack
                    if (!playerB.visited[j]) {
                        playerB.stack.push(j);
                    }
                }
                activePlayer = 0;

                if(playerB.isWinning()) {
                    System.out.println(playerB.name + " has won!");
                    return;
                }
            }

        }
    }

    public void printGraph() {
        System.out.println("Adjacency List of Graph");
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(" -> " + adjList[i].get(j));
            }
            System.out.println();
        }
    }
}
