public class Main {
    public static void main(String[] args) {
        int[] verticesNumbers = {40, 80, 120, 160, 200};
        double[] densities = {0.1, 0.3, 0.5, 0.7, 0.9};

        int graphsNumber = 20;

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

    private static Graph[] generateGraphs(int vertices, double density, int graphsNumber) {
        Graph[] graphs = new Graph[graphsNumber];
        for (int i = 0; i < graphsNumber; i++) {
            graphs[i] = Graph.generateRandomGraph(vertices, density);
        }

        return graphs;
    }

    private static double getTimeSpentDFSAdjacencyLists(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            DFS.getReachabilityMatrixUsingAdjacencyLists(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }

    private static double getTimeSpentDFSAdjacencyMatrix(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            DFS.getReachabilityMatrixUsingAdjacencyMatrix(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }

    private static double getTimeSpentBFSAdjacencyLists(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            BFS.getReachabilityMatrixUsingAdjacencyLists(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }

    private static double getTimeSpentBFSAdjacencyMatrix(Graph[] graphs) {
        double startTime = System.currentTimeMillis();

        for (Graph graph : graphs) {
            BFS.getReachabilityMatrixUsingAdjacencyMatrix(graph);
        }

        double finishTime = System.currentTimeMillis();

        return (finishTime - startTime) / graphs.length;
    }
}