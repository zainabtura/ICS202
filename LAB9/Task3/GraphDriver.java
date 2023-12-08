import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming Edge class and getEdge method are defined correctly
        List<Edge> edges = Arrays.asList(
                Edge.getEdge(0, 3), Edge.getEdge(1, 0),
                Edge.getEdge(1, 2), Edge.getEdge(1, 4),
                Edge.getEdge(2, 7), Edge.getEdge(3, 4),
                Edge.getEdge(3, 5), Edge.getEdge(4, 3),
                Edge.getEdge(4, 6), Edge.getEdge(5, 6),
                Edge.getEdge(6, 7)
        );

        int numVertices = 8;

        // Create a Graph object with the given vertices and edges
        Graph graph = new Graph(edges, numVertices);

        System.out.print("Enter source vertex [0 - 7]: ");
        int src = scanner.nextInt();

        System.out.print("Enter destination vertex [0 - 7]: ");
        int dest = scanner.nextInt();

        boolean reachable = graph.isReachable(src, dest);

        System.out.println("The vertex " + dest + " is " +
                (reachable ? "reachable" : "not reachable") +
                " from vertex " + src);
    }
}
