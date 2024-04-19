import java.util.*;

/**
 * Represents an oriented graph using both adjacency lists and matrix representations.
 */
public class Graph {
    private final int verticesNumber;
    private final List<List<Integer>> adjacencyLists;
    private final int[][] adjacencyMatrix;

    /**
     * Constructs a new Graph using the number of vertices, initializing both representations.
     *
     * @param verticesNumber the number of vertices in the graph
     */
    public Graph(int verticesNumber) {
        this.verticesNumber = verticesNumber;

        this.adjacencyLists = new ArrayList<>(verticesNumber);
        for (int i = 0; i < verticesNumber; i++) {
            adjacencyLists.add(new ArrayList<>());
        }

        this.adjacencyMatrix = new int[verticesNumber][verticesNumber];
    }

    /**
     * Constructs a Graph from a list of adjacency lists.
     *
     * @param adjacencyLists initial adjacency lists
     */
    public Graph(List<List<Integer>> adjacencyLists) {
        this.verticesNumber = adjacencyLists.size();

        this.adjacencyLists = adjacencyLists;

        this.adjacencyMatrix = new int[verticesNumber][verticesNumber];
        for (int i = 0; i < verticesNumber; i++) {
            for (int vertex : adjacencyLists.get(i)) {
                adjacencyMatrix[i][vertex] = 1;
            }
        }
    }

    /**
     * Constructs a Graph from an adjacency matrix.
     *
     * @param adjacencyMatrix initial adjacency matrix
     */
    public Graph(int[][] adjacencyMatrix) {
        this.verticesNumber = adjacencyMatrix.length;

        this.adjacencyLists = new ArrayList<>();
        for (int i = 0; i < verticesNumber; i++) {
            adjacencyLists.add(new ArrayList<>());
            for (int j = 0; j < verticesNumber; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    adjacencyLists.get(i).add(j);
                }
            }
        }

        this.adjacencyMatrix = adjacencyMatrix;
    }

    // Getter methods provide read-only access to the graph's properties
    public int getVerticesNumber() {
        return verticesNumber;
    }

    public List<List<Integer>> getAdjacencyLists() {
        return adjacencyLists;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * Adds an edge between two vertices in both list and matrix representations.
     *
     * @param vertex1 the start vertex
     * @param vertex2 the end vertex
     */
    public void addEdge(int vertex1, int vertex2) {
        adjacencyLists.get(vertex1).add(vertex2);

        adjacencyMatrix[vertex1][vertex2] = 1;
    }

    /**
     * Generates a random graph with specified vertex count and density of edges.
     *
     * @param verticesNumber number of vertices in the graph
     * @param density        the probability of an edge between any two vertices
     * @return a randomly generated graph
     */
    public static Graph generateRandomGraph(int verticesNumber, double density) {
        Graph graph = new Graph(verticesNumber);
        int maxEdgesNumber = verticesNumber * (verticesNumber - 1);
        int edgesNumber = (int) (maxEdgesNumber * density);

        Random random = new Random();
        while (edgesNumber > 0) {
            int vertex1 = random.nextInt(verticesNumber);
            int vertex2 = random.nextInt(verticesNumber);

            if (vertex1 != vertex2 && graph.adjacencyMatrix[vertex1][vertex2] == 0) {
                graph.addEdge(vertex1, vertex2);

                edgesNumber--;
            }
        }

        return graph;
    }

    /**
     * Provides a string representation of the graph showing both list and matrix forms.
     *
     * @return formatted string of the graph's adjacency list and matrix
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Adjacency Lists:\n");
        for (int i = 0; i < verticesNumber; i++) {
            stringBuilder.append("Г(").append(i).append(") = ").append(adjacencyLists.get(i)).append("\n");
        }
        stringBuilder.append("\n");

        stringBuilder.append("Adjacency Matrix:\n");
        for (int[] row : adjacencyMatrix) {
            stringBuilder.append(Arrays.toString(row)).append("\n");
        }

        stringBuilder.append("\n").append("-".repeat(50)).append("\n".repeat(2));

        return stringBuilder.toString();
    }
}
