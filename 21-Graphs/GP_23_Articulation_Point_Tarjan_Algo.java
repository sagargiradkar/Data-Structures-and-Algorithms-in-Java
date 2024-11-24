
import java.util.ArrayList;

public class GP_23_Articulation_Point_Tarjan_Algo {

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

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean vis[], boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (par == neigh) {
                continue;
            } else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (par != -1 && dt[curr] <= low[neigh]) {
                    //System.out.print("AP :: " + curr);
                    ap[curr] = true;
                }
                children++;
            }
        }

        if (par == -1 && children > 1) {
            ap[curr] = true;
            // System.out.print("AP ::" + curr);
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (!ap[i]) {
                System.out.println("AP ::" + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}
