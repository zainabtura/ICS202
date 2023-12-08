public class Graph {
      private boolean adjacencyMatrix[][];
      private int numberOfVertices;

      public Graph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
      }

      public void addEdge(int i, int j) {
            adjacencyMatrix[i][j] = true; // Add edge from i to j
            adjacencyMatrix[j][i] = true; // Add edge from j to i, since the graph is undirected
      }


      public void removeEdge(int i, int j) {
           adjacencyMatrix[i][j] = false; // Remove edge from i to j
           adjacencyMatrix[j][i] = false; // Remove edge from j to i
      }


      public boolean isEdge(int i, int j) {
           return adjacencyMatrix[i][j]; // Check if the edge i to j exists
      }

      
      public void displayGraph(){
        System.out.printf("%10s", " ");
        for(int i = 0; i < numberOfVertices; i++)
          System.out.printf("%10s", i);
          System.out.println();
        for(int i = 0; i < numberOfVertices; i++){
          System.out.printf("%10s", i);
          for(int j = 0; j < numberOfVertices; j++){
            System.out.printf("%10s", adjacencyMatrix[i][j]);
           }
           System.out.println();
       }
       
   }
 }
