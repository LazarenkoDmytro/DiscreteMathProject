import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class to test graph processing algorithms including DFS and BFS.
 */
public class Main {
    public static void main(String[] args) {
        int[] verticesNumbers = {40, 80, 120, 160, 200};
        double[] densities = {0.1, 0.3, 0.5, 0.7, 0.9};
        int graphsNumber = 100;
        List<String> results = new ArrayList<>();

        // Header for TSV
        results.add("Vertices\tDensity\tDFS Adj List Time (ms)\tDFS Adj Matrix Time (ms)\tBFS Adj List Time (ms)\tBFS Adj Matrix Time (ms)");

        // Iterates through different configurations of graphs and measures algorithm performance
        for (int verticesNumber : verticesNumbers) {
            for (double density : densities) {
                Graph[] graphs = generateGraphs(verticesNumber, density, graphsNumber);

                double dfsAdjListTime = getTimeSpentDFSAdjacencyLists(graphs);
                double dfsAdjMatrixTime = getTimeSpentDFSAdjacencyMatrix(graphs);
                double bfsAdjListTime = getTimeSpentBFSAdjacencyLists(graphs);
                double bfsAdjMatrixTime = getTimeSpentBFSAdjacencyMatrix(graphs);

                // Storing results in a list
                results.add(verticesNumber + "\t" + density + "\t" + dfsAdjListTime + "\t" + dfsAdjMatrixTime + "\t" + bfsAdjListTime + "\t" + bfsAdjMatrixTime);
            }
        }

        // Write results to a TSV file
        writeResultsToTSV("experiment_results.tsv", results);
    }

    /**
     * Writes the collected experiment results to a TSV (Tab-Separated Values) file.
     *
     * @param fileName  The name of the file to which the results will be written.
     * @param dataLines A list of strings, each representing a line of data to be written to the file.
     */
    private static void writeResultsToTSV(String fileName, List<String> dataLines) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : dataLines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
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
