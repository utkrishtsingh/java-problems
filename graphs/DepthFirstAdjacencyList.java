import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class DepthFirstAdjacencyList {
    public static void main(String... args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);
        graph.addEdge(5, 5);
        depthFirstSearch(graph);
    }

    private static void depthFirstSearch(Graph graph) {
        for (Vertex v : graph.vertices) {
            if (v.visited == false) {
                visitVertex(v, graph.adjacencyList);
            }
        }
    }

    private static void visitVertex(Vertex v, List<Vertex> adjacencyList[]) {
        System.out.println("Visiting Vertex " + v.vertex);
        v.visited = true;
        for (Vertex neighbour : adjacencyList[v.vertex]) {
            if (neighbour.visited == false) {
                visitVertex(neighbour, adjacencyList);
            }
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
    public void addEdge(int u, int v) {
        this.adjacencyList[u].add(this.vertices[v]);
        // this.adjacencyList[v].add(this.vertices[u]); // For undirected graphs
    }
}

class Vertex {
    public Integer vertex;
    public boolean visited = false;

    public Vertex(Integer vertex) {
        this.vertex = vertex;
    }
}
