/**
 * Provides methods to perform Depth-First Search (DFS) on a graph.
 */
public class DFS {
    /**
     * Performs DFS on a graph using adjacency lists, updating the reachability matrix.
     *
     * @param graph              The graph to be searched
     * @param start              The start vertex for DFS
     * @param vertex             The current vertex being visited
     * @param visited            Array to keep track of visited vertices
     * @param reachabilityMatrix Matrix to update the reachability from the start vertex
     */
    private static void dfsUsingAdjacencyLists(Graph graph, int start, int vertex, boolean[] visited, int[][] reachabilityMatrix) {
        visited[vertex] = true;
        reachabilityMatrix[start][vertex] = 1;
        for (int adjVertex : graph.getAdjacencyLists().get(vertex)) {
            if (!visited[adjVertex]) {
                dfsUsingAdjacencyLists(graph, start, adjVertex, visited, reachabilityMatrix);
            }
        }
    }

    /**
     * Computes the reachability matrix using adjacency lists.
     *
     * @param graph The graph for which the matrix is computed
     * @return The reachability matrix
     */
    public static int[][] getReachabilityMatrixUsingAdjacencyLists(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            boolean[] visited = new boolean[graph.getVerticesNumber()];
            dfsUsingAdjacencyLists(graph, i, i, visited, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }

    /**
     * Performs DFS on a graph using adjacency matrix, updating the reachability matrix.
     *
     * @param graph              The graph to be searched
     * @param start              The start vertex for DFS
     * @param vertex             The current vertex being visited
     * @param visited            Array to keep track of visited vertices
     * @param reachabilityMatrix Matrix to update the reachability from the start vertex
     */
    private static void dfsUsingAdjacencyMatrix(Graph graph, int start, int vertex, boolean[] visited, int[][] reachabilityMatrix) {
        visited[vertex] = true;
        reachabilityMatrix[start][vertex] = 1;
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            if (graph.getAdjacencyMatrix()[vertex][i] == 1 && !visited[i]) {
                dfsUsingAdjacencyMatrix(graph, start, i, visited, reachabilityMatrix);
            }
        }
    }

    /**
     * Computes the reachability matrix using an adjacency matrix.
     *
     * @param graph The graph for which the matrix is computed
     * @return The reachability matrix
     */
    public static int[][] getReachabilityMatrixUsingAdjacencyMatrix(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            boolean[] visited = new boolean[graph.getVerticesNumber()];
            dfsUsingAdjacencyMatrix(graph, i, i, visited, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }
}
