import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class BreadthFirstAdjacencyList {
    public static void main(String... args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 2);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 0);
        graph.addEdge(5, 1);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(6, 2);
        graph.addEdge(6, 3);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 3);
        graph.addEdge(7, 6);

        breadthFirstSearch(graph, 1);
    }

    private static void breadthFirstSearch(Graph graph, Integer source) {
        Queue<Vertex> searchQueue = new LinkedList<>();

        graph.vertices[source].visited = true;
        searchQueue.offer(graph.vertices[source]);
        while (searchQueue.peek() != null) {
            Vertex current = searchQueue.poll();
            System.out.println("Currently Visiting: " + current.id);
            for (Vertex neighbour : graph.adjacencyList[current.id]) {
                if (neighbour.visited == false) {
                    System.out.println("Adding " + neighbour.id + " to queue");
                    neighbour.visited = true;
                    searchQueue.offer(neighbour);
                }
            }
            System.out.println("--- * ---");
        }
    }
}

class Graph {
    public Vertex[] vertices;
    public List<Vertex> adjacencyList[];

    public Graph(int size) {
        this.vertices = new Vertex[size];
        this.adjacencyList = new List[size];

        for (int i = 0; i < size; i++) {
            this.vertices[i] = new Vertex(i);
            this.adjacencyList[i] = new ArrayList<Vertex>();
        }
    }


    // Works only for directed graphs
    public void addEdge(Integer u, Integer v) {
        this.adjacencyList[u].add(this.vertices[v]);
        // this.adjacencyList[v].add(this.vertices[u]); // For undirected graphs
    }
}

class Vertex {
    public Integer id;
    public boolean visited = false;

    public Vertex(Integer id) {
        this.id = id;
    }
}
