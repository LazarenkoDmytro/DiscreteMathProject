import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjList;
    private final int[][] adjMatrix;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        this.adjMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);

        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }
}
