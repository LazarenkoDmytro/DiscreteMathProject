public class DFS {
    private final Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    private void dfsUsingAdjacencyLists(int start, int vertex, boolean[] visited, int[][] reachabilityMatrix) {
        visited[vertex] = true;
        reachabilityMatrix[start][vertex] = 1;
        for (int adjVertex : graph.getAdjacencyLists().get(vertex)) {
            if (!visited[adjVertex]) {
                dfsUsingAdjacencyLists(start, adjVertex, visited, reachabilityMatrix);
            }
        }
    }

    public int[][] getReachabilityMatrixUsingAdjacencyLists() {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            boolean[] visited = new boolean[graph.getVerticesNumber()];
            dfsUsingAdjacencyLists(i, i, visited, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }

    private void dfsUsingAdjacencyMatrix(int start, int vertex, boolean[] visited, int[][] reachabilityMatrix) {
        visited[vertex] = true;
        reachabilityMatrix[start][vertex] = 1;
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            if (graph.getAdjacencyMatrix()[vertex][i] == 1 && !visited[i]) {
                dfsUsingAdjacencyMatrix(start, i, visited, reachabilityMatrix);
            }
        }
    }
}
