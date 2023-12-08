import java.util.*;

public class Graph {
    int numVertices;
    LinkedList<String>[] adjacencyList;
    String[] labels;

    Graph(int numVertices, String[] labels) {
        this.numVertices = numVertices;
        this.labels = labels;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addDirectedEdge(int v, int w) {
        adjacencyList[v].add(labels[w]); // Map integer vertex to label and add to list
    }

    void addUndirectedEdge(int v, int w) {
        adjacencyList[v].add(labels[w]); // Map integer vertex to label and add to list
        adjacencyList[w].add(labels[v]); // Add both ways for undirected edge
    }

    void displayGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println(labels[i] + " ----> " + adjacencyList[i]);
        }
        System.out.println();
    }
}


