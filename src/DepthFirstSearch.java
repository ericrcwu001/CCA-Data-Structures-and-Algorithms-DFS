import java.io.*;
import java.util.*;

public class DepthFirstSearch {


    public static void main(String[] args) {
        int[][] graph = {
                {7}, {2,3}, {1,5,7}, {1,7}, {7,8}, {2,7}, {7}, {0,2,3,4,5,6}, {4}
        };

        boolean[] visited = {false, false, false, false, false, false, false, false, false};

        dfsIterative(graph);
//        dfsRecursive(graph, visited, 0);
    }

    public static void dfsIterative(int[][] adjacencyList) {

        Stack<Integer> s = new Stack<Integer>();
        boolean[] visited = new boolean[9];
        s.push(0);

        while(!s.empty()) {
            int temp = s.pop();
            if (visited[temp]) continue;
            System.out.println(temp);
            visited[temp] = true;
            for (int i: adjacencyList[temp]) {
                if (!visited[i]) {
                    s.push(i);
                }
            }
        }
    }

    public static void dfsRecursive(int[][] graph, boolean[] visited, int currentNode) {
        visited[currentNode] = true;
        System.out.println(currentNode);
        for (int u : graph[currentNode]) {
            if (!visited[u]) {
                dfsRecursive(graph, visited, u);
            }
        }
    }

}
