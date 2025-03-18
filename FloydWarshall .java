import java.util.Arrays;

class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        // Replace -1 with Integer.MAX_VALUE for no path and set diagonal to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1 && i != j) matrix[i][j] = Integer.MAX_VALUE;
                if (i == j) matrix[i][j] = 0;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        // Convert Integer.MAX_VALUE back to -1 for no path
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) matrix[i][j] = -1;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {-1, 2, -1, 3},
            {1, -1, 3, 5},
            {-1, -1, -1, -1},
            {3, 5, 4, -1}
        };

        FloydWarshall fw = new FloydWarshall();
        fw.shortest_distance(matrix);

        // Print the result
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
