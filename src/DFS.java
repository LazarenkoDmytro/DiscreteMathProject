public class DFS {
    private static void dfsUsingAdjacencyLists(Graph graph, int start, int vertex, boolean[] visited, int[][] reachabilityMatrix) {
        visited[vertex] = true;
        reachabilityMatrix[start][vertex] = 1;
        for (int adjVertex : graph.getAdjacencyLists().get(vertex)) {
            if (!visited[adjVertex]) {
                dfsUsingAdjacencyLists(graph, start, adjVertex, visited, reachabilityMatrix);
            }
        }
    }

    public static int[][] getReachabilityMatrixUsingAdjacencyLists(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            boolean[] visited = new boolean[graph.getVerticesNumber()];
            dfsUsingAdjacencyLists(graph, i, i, visited, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }

    private static void dfsUsingAdjacencyMatrix(Graph graph, int start, int vertex, boolean[] visited, int[][] reachabilityMatrix) {
        visited[vertex] = true;
        reachabilityMatrix[start][vertex] = 1;
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            if (graph.getAdjacencyMatrix()[vertex][i] == 1 && !visited[i]) {
                dfsUsingAdjacencyMatrix(graph, start, i, visited, reachabilityMatrix);
            }
        }
    }

    public static int[][] getReachabilityMatrixUsingAdjacencyMatrix(Graph graph) {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            boolean[] visited = new boolean[graph.getVerticesNumber()];
            dfsUsingAdjacencyMatrix(graph, i, i, visited, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }
}
