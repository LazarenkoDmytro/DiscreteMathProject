import java.util.ArrayList;
import java.util.Arrays;
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

        adjMatrix[v1][v2] = 1;
    }

    public void listToMatrix() {
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(adjMatrix[i], 0);

            for (int vertex : adjList.get(i)) {
                adjMatrix[i][vertex] = 1;
            }
        }
    }

    public void matrixToList() {
        for (int i = 0; i < numVertices; i++) {
            adjList.get(i).clear();

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
    }
}
