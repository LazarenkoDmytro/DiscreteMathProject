import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static void bfsUsingAdjacencyLists(Graph graph, int start, int[][] reachabilityMatrix) {
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            reachabilityMatrix[start][vertex] = 1;
            for (int adjVertex : graph.getAdjacencyLists().get(vertex)) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    public static int[][] getReachabilityMatrixUsingAdjacencyLists(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            bfsUsingAdjacencyLists(graph, i, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }

    private static void bfsUsingAdjacencyMatrix(Graph graph, int start, int[][] reachabilityMatrix) {
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            reachabilityMatrix[start][vertex] = 1;
            for (int i = 0; i < graph.getVerticesNumber(); i++) {
                if (graph.getAdjacencyMatrix()[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static int[][] getReachabilityMatrixUsingAdjacencyMatrix(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            bfsUsingAdjacencyMatrix(graph, i, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }
}
