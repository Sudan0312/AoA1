import java.util.*;

class BellmanFord {
    private int V; // Number of vertices
    private List<Edge> edges; // List of edges

    // Edge class to store the graph edges
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    BellmanFord(int vertices) {
        this.V = vertices;
        edges = new ArrayList<>();
    }

    // Add an edge to the graph
    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Bellman-Ford Algorithm
    void bellmanFord(int src) {
        int[] dist = new int[V];
        int[] pred = new int[V];

        // Step 1: Initialize distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(pred, -1);
        dist[src] = 0;

        // Step 2: Relax edges (V-1) times
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.src, v = edge.dest, w = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pred[v] = u;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (Edge edge : edges) {
            int u = edge.src, v = edge.dest, w = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    // Main method
    public static void main(String[] args) {
        BellmanFord g = new BellmanFord(5);
        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3);

        g.bellmanFord(0); // Run Bellman-Ford from source vertex 0
    }
}