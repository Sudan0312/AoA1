import java.util.*;

public class SimpleDijkstra {

    public static void dijkstra(int graph[][], int source) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }

        System.out.println("Shortest distances from vertex " + source + ":");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable.");
            } else {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, 9, 2, 0, 0},
            {5, 0, 0, 0, 1, 0},
            {9, 0, 0, 0, 4, 0},
            {2, 0, 0, 0, 0, 7},
            {0, 1, 4, 0, 0, 3},
            {0, 0, 0, 7, 3, 0}
        };

        dijkstra(graph, 0);
    }
}
