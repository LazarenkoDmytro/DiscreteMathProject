/**
 * Main class to test graph processing algorithms including DFS and BFS.
 */
public class Main {
    public static void main(String[] args) {
        int[] verticesNumbers = {40, 80, 120, 160, 200};
        double[] densities = {0.1, 0.3, 0.5, 0.7, 0.9};
        int graphsNumber = 20;

        // Iterates through different configurations of graphs and measures algorithm performance
        for (int verticesNumber : verticesNumbers) {
            for (double density : densities) {
                Graph[] graphs = generateGraphs(verticesNumber, density, graphsNumber);

                System.out.println("Graph with " + verticesNumber + " vertices, " + density + " density");
                System.out.println("DFS adjacency lists time: " + getTimeSpentDFSAdjacencyLists(graphs) + " ms");
                System.out.println("DFS adjacency matrix time: " + getTimeSpentDFSAdjacencyMatrix(graphs) + " ms");
                System.out.println("BFS adjacency lists time: " + getTimeSpentBFSAdjacencyLists(graphs) + " ms");
                System.out.println("BFS adjacency matrix time: " + getTimeSpentBFSAdjacencyMatrix(graphs) + " ms\n");
            }
        }
    }

    /**
     * Generates an array of random graphs based on specified parameters.
     *
     * @param vertices     The number of vertices in each graph
     * @param density      The density of edges in each graph
     * @param graphsNumber The number of graphs to generate
     * @return An array of randomly generated graphs
     */
    private static Graph[] generateGraphs(int vertices, double density, int graphsNumber) {
        Graph[] graphs = new Graph[graphsNumber];
        for (int i = 0; i < graphsNumber; i++) {
            graphs[i] = Graph.generateRandomGraph(vertices, density);
        }

        return graphs;
    }

    /**
     * Measures the time spent by DFS using adjacency lists across multiple graphs.
     *
     * @param graphs Array of graphs to process
     * @return Average time spent in milliseconds
     */
    private static double getTimeSpentDFSAdjacencyLists(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            DFS.getReachabilityMatrixUsingAdjacencyLists(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }

    /**
     * Measures the time spent by DFS using adjacency matrices across multiple graphs.
     *
     * @param graphs Array of graphs to process
     * @return Average time spent in milliseconds
     */
    private static double getTimeSpentDFSAdjacencyMatrix(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            DFS.getReachabilityMatrixUsingAdjacencyMatrix(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }

    /**
     * Measures the time spent by BFS using adjacency lists across multiple graphs.
     *
     * @param graphs Array of graphs to process
     * @return Average time spent in milliseconds
     */
    private static double getTimeSpentBFSAdjacencyLists(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            BFS.getReachabilityMatrixUsingAdjacencyLists(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }

    /**
     * Measures the time spent by BFS using adjacency matrices across multiple graphs.
     *
     * @param graphs Array of graphs to process
     * @return Average time spent in milliseconds
     */
    private static double getTimeSpentBFSAdjacencyMatrix(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            BFS.getReachabilityMatrixUsingAdjacencyMatrix(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }
}
