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
}
