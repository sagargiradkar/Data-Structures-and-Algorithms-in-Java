import java.util.*;

public class GP_03_DFS {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Method to create a graph
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        //0 - Vertex
        graph[0].add(new Edge(0, 1, 5));

        //1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        //3 - Vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4 - vertex
        graph[4].add(new Edge(4, 2, 2));

        return graph;
    }

    // DFS method
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visit[]) {
        System.out.print(curr + " ");
        visit[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                dfs(graph, e.dest, visit);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<Edge>[] graph = createGraph(V); // Create and populate the graph

        System.out.println("Depth First Search traversal starting from vertex 0:");
        dfs(graph, 0, new boolean[V]); // Perform DFS on the graph
    }
}
