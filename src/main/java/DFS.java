import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class DFS {

    public static ArrayList<Integer> DFS(Graph tree, int src) {

        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        return DFS(tree, src, visited, result);
    }

    private static ArrayList<Integer> DFS(Graph tree, int src, HashSet<Integer> visited, ArrayList<Integer> result){

        if (visited.contains(src)) return result;

        visited.add(src);
        result.add(src);

        for (int x: tree.adjListArray[src]) {
            DFS(tree, x, visited, result);
        }
        return result;
    }

    /**
     * Graph Class
     */
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
        public static void addEdge(Graph graph, int src, int dest) {
            // Add an edge from src to dest.
            graph.adjListArray[src].add(dest);

        }
    }

    public static void main(String[] args) {

       Graph g = new Graph(8);
        g.addEdge(g, 0, 1);
        g.addEdge(g, 0, 2);
        g.addEdge(g, 1, 3);
        g.addEdge(g, 1, 4);
        g.addEdge(g, 2, 5);
        g.addEdge(g, 2, 6);
        g.addEdge(g, 4, 7);
        g.addEdge(g, 5, 7);
        g.addEdge(g, 6, 5);
        g.addEdge(g, 5, 7);
        g.addEdge(g, 7, 4);
        g.addEdge(g, 4, 1);
        g.addEdge(g, 1, 0);

        System.out.println(DFS(g, 0));
        System.out.println(DFS(g, 6));


        /**
         *         0
         *       /   \
         *      1    2
         *     / \  / \
         *    3  4  5-6
         *        \/
         *        7
         */
    }
}
