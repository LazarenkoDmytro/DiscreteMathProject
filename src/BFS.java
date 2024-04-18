import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private final Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    private void bfsUsingAdjacencyLists(int start, int[][] reachabilityMatrix) {
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

    public int[][] getReachabilityMatrixUsingAdjacencyLists() {
        int[][] reachabilityMatrix = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        for (int i = 0; i < graph.getVerticesNumber(); i++) {
            bfsUsingAdjacencyLists(i, reachabilityMatrix);
        }

        return reachabilityMatrix;
    }

    private void bfsUsingAdjacencyMatrix(int start, int[][] reachabilityMatrix) {
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            reachabilityMatrix[start][vertex] = 1;
            for (int j = 0; j < graph.getVerticesNumber(); j++) {
                if (graph.getAdjacencyMatrix()[vertex][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
