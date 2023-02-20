import java.util.*;
public class BreadthFirstSearch {
    public static void main(String[] args) {
        int[][] graph = {
                {7}, {2,3}, {1,5,7}, {1,7}, {7,8}, {2,7}, {7}, {0,2,3,4,5,6}, {4}
        };

        boolean[] visited = {false, false, false, false, false, false, false, false, false};
        Queue<Integer> q = new LinkedList<>();

        bfsIterative(graph);
        q.add(0);
        visited[0] = true;
        bfsRecursive(graph, visited, q);
    }

    public static void bfsIterative(int[][] adjacencyList) {

        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[9];
        q.add(0);

        while(!q.isEmpty()) {
            int temp = q.poll();
            if (visited[temp]) continue;
            System.out.println(temp);
            visited[temp] = true;
            for (int i: adjacencyList[temp]) {
                if (!visited[i]) {
                    q.add(i);
                }
            }
        }
    }

    public static void bfsRecursive(int[][] adjacencyList, boolean[] visited, Queue<Integer> q) {
        if (q.isEmpty()) return;

        int temp = q.poll();
        System.out.println(temp);

        for (int u : adjacencyList[temp]) {
            if (!visited[u]) {
                visited[u] = true;
                q.add(u);
            }
        }
        bfsRecursive(adjacencyList, visited, q);
    }
}
