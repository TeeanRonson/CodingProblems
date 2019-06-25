import java.util.LinkedList;

public class BFS {

    public static void bfs(Graph g, int src) {

        boolean[] visited = new boolean[g.V];

        visited[src] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            System.out.println(curr);
            for (int x: g.adjListArray[curr]) {
                if (visited[x] == false) {
                    queue.add(x);
                    visited[x] = true;
                }
            }

        }

    }

    public static boolean findConnection(Graph g, int src, int dst) {

        if (src == dst) return true;
        boolean[] visited = new boolean[g.V];
        visited[src] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            for (int x: g.adjListArray[curr]) {
                if (visited[x] == false) {
                    if (x == dst) {
                        return true;
                    } else {
                        visited[x] = true;
                        queue.add(x);
                    }
                }
            }
        }
        return false;

    }

    public static boolean findConnection1(Graph g, int src, int dst) {

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[g.V];
        queue.add(src);
        visited[src] = true;

        System.out.println(queue);

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            for (int i: g.adjListArray[curr]) {
                if (visited[i] == true) {
                    continue;
                }
                if (i == dst) {
                    return true;
                }
                queue.add(i);
                visited[i] = true;
            }
        }
        return false;
    }


    static class Graph {
        int V;
        LinkedList<Integer> adjListArray[];

        // constructor
        Graph(int V) {
            this.V = V;
            // define the size of array as
            // number of vertices
            adjListArray = new LinkedList[V];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }


        // Adds an edge to an undirected graph
        static void addEdge(Graph graph, int src, int dest) {
            // Add an edge from src to dest.
            graph.adjListArray[src].add(dest);

        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(g, 0, 1);
        g.addEdge(g, 1, 2);
        g.addEdge(g, 1, 3);
        g.addEdge(g, 2, 1);
        g.addEdge(g, 3, 1);
        g.addEdge(g, 4, 5);
        g.addEdge(g, 3, 5);
        g.addEdge(g, 5, 4);


//        bfs(g, 0);
        System.out.println(findConnection(g, 0, 4));

        System.out.println(findConnection1(g, 0, 4));


        System.out.println(findConnection(g, 2, 4));

        System.out.println(findConnection1(g, 2, 4));

    }

}





