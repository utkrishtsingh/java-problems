import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstAdjacencyMatrix {
    public static void main(String ...args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);

        breadthFirstSearch(graph, 5);
    }

    private static void breadthFirstSearch(Graph graph, int sourceVertex) {
        graph.visitVertex(sourceVertex);
        Queue<Integer> searchQueue = new LinkedList<>();
        searchQueue.offer(sourceVertex);
        while(searchQueue.peek() != null) {
            int currentVertex = searchQueue.poll();
            System.out.println("Currently Visiting: " + currentVertex);
            for(int i = 0; i < graph.size; i++) {
                if(graph.adjacencyMatrix[currentVertex][i] != 0) {
                    System.out.println("Adding " + i + " to queue");
                    graph.visitVertex(i);
                    searchQueue.offer(i);
                }
            }
            System.out.println("--- * ---");
        }
    }
}

class Graph {
    public int size;
    public int[][] adjacencyMatrix;

    private Graph() {
        throw new AssertionError("Graph needs number of nodes to initialize");
    }
    public Graph(int size) {
        this.size = size;
        this.adjacencyMatrix = new int[size][size];
    }

    public void addEdge(int u, int v) {
        this.adjacencyMatrix[u][v] = 1;
        this.adjacencyMatrix[v][u] = 1;
    }

    public void visitVertex(int u) {
        for(int i = 0; i < size; i++) {
            adjacencyMatrix[i][u] = 0;
        }
    }
}
