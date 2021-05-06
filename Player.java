
import java.util.Scanner;
import java.util.Stack;

public class Player {

    String name;
    boolean winning;
    int numOfVertices;
    int occupied = -1;
    Stack<Integer> stack = new Stack<Integer>();
    boolean[] visited;

    Player(int n) {
        numOfVertices = n;
        visited= new boolean[numOfVertices];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.next();
    }

    // check if the player has won
    public boolean isWinning() {
        for(boolean temp: visited) {
            if(temp == false)
                return false;
        }
        return true;
    }


}
