import java.util.ArrayList;
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

        Graph randomGraph = Graph.generateRandomGraph(10, 0.6);
        System.out.print(randomGraph);
    }
}