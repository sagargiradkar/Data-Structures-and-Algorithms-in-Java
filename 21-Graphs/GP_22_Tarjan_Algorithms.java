
import java.util.ArrayList;

public class GP_22_Tarjan_Algorithms {

    static class Edge {

        int src;
        int dest;

        public Edge(int dest, int src) {
            this.dest = dest;
            this.src = src;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time) {

        vis[curr] = true;
        dt[curr] = low[curr] = time++;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            int neigh = e.dest;

            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.print("Bridge :" + curr + " ---- " + neigh);
                }
            } else {
                low[curr] = Math.max(low[curr], dt[neigh]);
            }
        }
    }

    public static void targenBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];

        int time = 0;

        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        targenBridge(graph, V);
    }
}
