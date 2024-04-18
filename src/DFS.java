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
}
