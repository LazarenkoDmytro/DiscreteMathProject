import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 1, 0},
                {1, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
        Graph adjacencyMatrixGraph = new Graph(adjacencyMatrix);
        System.out.print(adjacencyMatrixGraph);

        DFS adjacencyMatrixGraphDFS = new DFS(adjacencyMatrixGraph);
        System.out.println("Reachability matrix using DFS: " + Arrays.deepToString(adjacencyMatrixGraphDFS.getReachabilityMatrixUsingAdjacencyLists()));
        System.out.println("Reachability matrix using DFS: " + Arrays.deepToString(adjacencyMatrixGraphDFS.getReachabilityMatrixUsingAdjacencyMatrix()));
        System.out.println();

        List<List<Integer>> adjacencyLists = new ArrayList<>();
        adjacencyLists.add(new ArrayList<>());
        adjacencyLists.add(new ArrayList<>());
        adjacencyLists.add(new ArrayList<>());
        adjacencyLists.add(new ArrayList<>());

        adjacencyLists.getFirst().add(1);
        adjacencyLists.getFirst().add(2);

        adjacencyLists.get(1).add(0);

        adjacencyLists.get(2).add(1);
        adjacencyLists.get(2).add(3);

        adjacencyLists.get(3).add(0);
        adjacencyLists.get(3).add(2);

        Graph adjacencyListsGraph = new Graph(adjacencyLists);
        System.out.print(adjacencyListsGraph);

        DFS adjacencyListsGraphDFS = new DFS(adjacencyListsGraph);
        System.out.println("Reachability matrix using DFS: " + Arrays.deepToString(adjacencyListsGraphDFS.getReachabilityMatrixUsingAdjacencyLists()));
        System.out.println("Reachability matrix using DFS: " + Arrays.deepToString(adjacencyListsGraphDFS.getReachabilityMatrixUsingAdjacencyMatrix()));
        System.out.println();

        Graph randomGraph = Graph.generateRandomGraph(10, 0.2);
        System.out.print(randomGraph);

        DFS randomGraphDFS = new DFS(randomGraph);
        System.out.println("Reachability matrix using DFS: " + Arrays.deepToString(randomGraphDFS.getReachabilityMatrixUsingAdjacencyLists()));
        System.out.println("Reachability matrix using DFS: " + Arrays.deepToString(randomGraphDFS.getReachabilityMatrixUsingAdjacencyMatrix()));
        System.out.println();
    }
}