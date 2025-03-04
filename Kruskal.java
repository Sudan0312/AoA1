import java.util.*;

class Kruskal {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
                else if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
                else { parent[rootY] = rootX; rank[rootX]++; }
            }
        }
    }

    static void kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();
        
        for (Edge edge : edges) {
            int u = edge.src, v = edge.dest;
            if (ds.find(u) != ds.find(v)) {
                mst.add(edge);
                ds.union(u, v);
            }
        }

        System.out.println("Edge \tWeight");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + "\t" + edge.weight);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        kruskalMST(V, edges);
    }
}
