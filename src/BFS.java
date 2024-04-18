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


}
