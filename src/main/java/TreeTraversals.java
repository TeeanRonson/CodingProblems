import org.omg.PortableInterceptor.INACTIVE;
import sun.awt.image.ImageWatched;

import java.net.InetAddress;
import java.util.*;

public class TreeTraversals {


    public static void preOrderRecursive(Node node) {

        if (node == null) return;
        System.out.print(node.key + " ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);

    }

    public static void preOrderIterative(Node node) {

        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.key + " ");

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

    }

    public static void inOrderRecursive(Node node) {

        if (node == null) return;
        inOrderRecursive(node.left);
        System.out.print(node.key + " ");
        inOrderRecursive(node.right);

    }

    public static void inOrderIterative(Node node) {

        if (node == null) return;

        Stack<Node> stack = new Stack<>();

        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.print(node.key + " ");
            node = node.right;

        }

    }

    public static void postOrderRecursive(Node node) {

        if (node == null) return;
        postOrderRecursive(node.left);
        postOrderRecursive(node.right);
        System.out.print(node.key + " ");

    }

    public static void postOrderIterative(Node node) {

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);

        while (!stack1.isEmpty()) {

            Node curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }

        while(!stack2.isEmpty()) {
            System.out.print(stack2.pop().key + " ");
        }

    }

    /**
     * DFS Recursion
     * @param graph
     * @param src
     * @return
     */
    public static ArrayList<Integer> dfsRecursive(Graph graph, int src) {

        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        return dfsRecursive(graph, src, visited, result);
    }

    /**
     * DFS Helper
     * @param graph
     * @param src
     * @param visited
     * @param result
     * @return
     */
    private static ArrayList<Integer> dfsRecursive(Graph graph, int src, HashSet<Integer> visited, ArrayList<Integer> result) {

        if (visited.contains(src)) return result;

        result.add(src);
        visited.add(src);

        for (Integer x: graph.adjListArray[src]) {
            dfsRecursive(graph, x, visited, result);
        }


        return result;
    }

    /**
     * DFS Iterative
     * @return
     */
    public static ArrayList<Integer> dfsIterative(Graph graph, int src) {

        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        return dfsIterative(graph, src, visited, result);
    }

    private static ArrayList<Integer> dfsIterative(Graph graph, int src, HashSet visited, ArrayList result) {

        Stack<Integer> stack = new Stack();
        stack.push(src);

        while(!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited.contains(curr)) {
                result.add(curr);
            }

            for (int i = graph.adjListArray[curr].size() - 1; i >= 0; i--) {
                stack.push(graph.adjListArray[curr].get(i));
            }

        }

        return result;

    }

    public static ArrayList<Integer> bfs(Graph graph, int src) {

        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            result.add(curr);
            visited.add(curr);

            for (int i: graph.adjListArray[curr]) {
                if (!visited.contains(i)) {
                    queue.add(i);
                }
            }
        }

        return result;
    }

    /**
     * Find the integer thats furthest away from the src
     * @param graph
     * @param src
     * @return
     */
    public static LinkedList<Integer> findShortestPath(Graph graph, int src, int dest) {

        HashMap<Integer, Integer> paths = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        paths.put(src, -1);

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            if (curr == dest) break;
            for (int i: graph.adjListArray[curr]) {
                if (!paths.containsKey(i)) {
                    queue.add(i);
                    paths.put(i, curr);
                }
            }
        }

        if (paths.get(dest) == null) return null;

        int curr = dest;
        LinkedList<Integer> result = new LinkedList<>();
        while (curr != -1) {
            result.add(0, curr);
            curr = paths.get(curr);
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

    /**
     * Node class
     */
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        // Root of Binary Tree
        Node root;

        BinaryTree() {
            root = null;
        }
    }


    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Graph g = new Graph(8);
        g.addEdge(g, 0, 1);
        g.addEdge(g, 0, 2);
        g.addEdge(g, 1, 3);
        g.addEdge(g, 1, 4);
        g.addEdge(g, 2, 5);
        g.addEdge(g, 2, 6);
//        g.addEdge(g, 6, 7);
        g.addEdge(g, 4, 7);

        /**
         *         0
         *       /   \
         *      1    2
         *     / \  / \
         *    3  4  5  6
         *      /
         *     7
         */



//        System.out.println("Recursive PreOrder");
//        preOrderRecursive(tree.root);
//        System.out.println("\nIterative PreOrder");
//        preOrderIterative(tree.root);
//
//        System.out.println("\nRecursive Inorder ");
//        inOrderRecursive(tree.root);
//        System.out.println("\nIterative InOrder");
//        inOrderIterative(tree.root);
//
//        System.out.println("\nPostorder traversal of binary tree is ");
//        postOrderRecursive(tree.root);
//        System.out.println("\nIterative PostOrder");
//        postOrderIterative(tree.root);

//        System.out.println("DFS Recursion Rong");
//        for (int i: dfsRecursive(g, 0)) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\nDFS Iterative Rong");
//        for (int i: dfsIterative(g, 0)) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\nGeeksForGeeks DFS");
//        g.DFS(0);
//
//        System.out.println("\nBFS Iterative Rong");
//        for (int i: bfs(g, 0)) {
//            System.out.print(i + " ");
//        }

        System.out.println("\nFind distances");
        for (int i: findShortestPath(g, 0, 7)) {
            System.out.print(i + " ");
        }

    }
}
