import java.util.LinkedList;
import java.util.Queue;

/**
 * Provides methods to perform Breadth-First Search (BFS) on a graph.
 */
public class BFS {
    /**
     * Performs BFS using adjacency lists and updates the reachability matrix.
     *
     * @param graph              The graph to be searched
     * @param start              The starting vertex for BFS
     * @param reachabilityMatrix Matrix to update the reachability from the start vertex
     */
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

    /**
     * Computes the reachability matrix using BFS with adjacency lists.
     *
     * @param graph The graph for which the matrix is computed
     * @return The reachability matrix
     */
    public static int[][] getReachabilityMatrixUsingAdjacencyLists(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            bfsUsingAdjacencyLists(graph, i, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }

    /**
     * Performs BFS using an adjacency matrix and updates the reachability matrix.
     *
     * @param graph              The graph to be searched
     * @param start              The starting vertex for BFS
     * @param reachabilityMatrix Matrix to update the reachability from the start vertex
     */
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

    /**
     * Computes the reachability matrix using BFS with an adjacency matrix.
     *
     * @param graph The graph for which the matrix is computed
     * @return The reachability matrix
     */
    public static int[][] getReachabilityMatrixUsingAdjacencyMatrix(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            bfsUsingAdjacencyMatrix(graph, i, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }
}
