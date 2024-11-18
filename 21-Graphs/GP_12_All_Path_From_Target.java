import java.util.ArrayList;

public class GP_12_All_Path_From_Target {
      static class Edge {
            int src;
            int dest;
    
            public Edge(int src, int dest) {
                this.src = src;
                this.dest = dest;
            }
        }
    
        // Method to create a graph
        public static ArrayList<Edge>[] createGraph(int V, int example) {
            @SuppressWarnings("unchecked")
            ArrayList<Edge>[] graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>();
            }
    
            // Example graphs
            if (example == 1) {
                graph[0].add(new Edge(0, 1));
                graph[1].add(new Edge(1, 2));
                graph[2].add(new Edge(2, 3));
                graph[3].add(new Edge(3, 0)); // Cycle here
            } else if (example == 2) {
                graph[0].add(new Edge(0, 1));
                graph[1].add(new Edge(1, 2));
                graph[2].add(new Edge(2, 3));
            } else if (example == 3) {
                graph[0].add(new Edge(0, 1));
                graph[1].add(new Edge(1, 2));
                graph[2].add(new Edge(2, 4));
                graph[4].add(new Edge(4, 1)); // Cycle here
            } else if (example == 4) {
                graph[0].add(new Edge(0, 1));
                graph[1].add(new Edge(1, 2));
                graph[2].add(new Edge(2, 3));
                graph[3].add(new Edge(3, 4));
            } else if (example == 5) {
                graph[0].add(new Edge(0, 1));
                graph[1].add(new Edge(1, 2));
                graph[3].add(new Edge(3, 4));
                graph[4].add(new Edge(4, 5));
            }
    
            return graph;
        }

        public static void printAllPath(ArrayList<Edge> [] graph,int src,int dest,String path)
        {
            if(src == dest){
                System.out.println(path+dest);
                return;
            }
            for(int i=0; i<graph[src].size(); i++){
                Edge e = graph[src].get(i);
                printAllPath(graph, e.dest, dest, "");
            }
        }
    public static void main(String[] args) {
        int V = 10;
    
            // Test Case 1: Graph with a cycle
            System.out.println("Test Case 1 (Cycle Present):");
            int src = 5,dest = 1;
            ArrayList<Edge>[] graph1 = createGraph(V, 1);
            printAllPath(graph1,src,dest,"0"); // Expected: No meaningful order due to cycle
    
            // // Test Case 2: Graph without a cycle
            // System.out.println("Test Case 2 (No Cycle):");
            // ArrayList<Edge>[] graph2 = createGraph(V, 2);
            // printAllPath(graph2); // Expected: Topological order
    
            // // Test Case 3: Graph with a cycle
            // System.out.println("Test Case 3 (Cycle Present):");
            // ArrayList<Edge>[] graph3 = createGraph(V, 3);
            // printAllPath(graph3); // Expected: No meaningful order due to cycle
    
            // // Test Case 4: Linear graph without a cycle
            // System.out.println("Test Case 4 (No Cycle):");
            // ArrayList<Edge>[] graph4 = createGraph(V, 4);
            // printAllPath(graph4); // Expected: 0 -> 1 -> 2 -> 3 -> 4
    
            // // Test Case 5: Complex graph
            // System.out.println("Test Case 5 (No Cycle):");
            // ArrayList<Edge>[] graph5 = createGraph(V, 5);
            // printAllPath(graph5); // E
    }
}
