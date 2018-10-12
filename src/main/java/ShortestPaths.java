import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import sun.security.provider.certpath.Vertex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class ShortestPaths {


    /**
     * Return all possible paths from start node to destination node
     * sorted from shortest duration to longest.
     * function findShortestPaths(start, destination) {
     return []
     */

    private final static String INFO = "info";
    private final static String FROM = "from";
    private final static String TO = "to";
    private final static String DURATION = "duration";


    HashMap<Character, LinkedList<Node>> adjList;
    TreeMap<Integer, LinkedList<Node>> result;

    public ShortestPaths() {

        this.adjList = new HashMap<>();
        this.result = new TreeMap<>();
    }


    public void findShortestPaths(char start, char end) {

        for (Node node: adjList.get(start)) {
            LinkedList<Node> path = new LinkedList<>();
            int total = 0;
            System.out.println("Node of A: " + node.vert);
            dfs(node, end, total, path);
        }

        System.out.println("Result: ");

        for (int i: result.keySet()) {
            System.out.println(i);
            for (Node node: result.get(i)) {
                System.out.print(node.vert + " ");
            }
            System.out.println();
        }
   }

    private void dfs(Node node, char end, int total, LinkedList<Node> path) {

//        System.out.println("Checking node: " + node.vert);

        if (node == null) {
            return;
        }

        if (node.vert == end) {
            total += node.duration;
            path.add(node);
            result.put(total, path);
            return;
        }

        node.visited();
        total += node.duration;
        path.add(node);

        for (Node next: adjList.get(node.vert)) {
            if (next.visited == false) {
                dfs(next, end, total, path);
            }
        }
        node.reset();

//        System.out.println("Checking");
    }


    public void readJson(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            Gson gson = new Gson();
            String currentLine;
            JsonArray array;

            while ((currentLine = reader.readLine()) != null) {

                JsonObject object = gson.fromJson(currentLine, JsonObject.class);
                array = object.get(INFO).getAsJsonArray();

                for (JsonElement element: array) {
                    JsonObject route = (JsonObject) element;

                    char from = route.get(FROM).getAsCharacter();
                    char to = route.get(TO).getAsCharacter();
                    int duration = route.get(DURATION).getAsInt();
                    Node vertex = new Node(to, duration);

                    if (adjList.get(from) == null) {
                        LinkedList<Node> nodes = new LinkedList<>();
                        nodes.add(vertex);
                        adjList.put(from, nodes);
                    } else {
                        adjList.get(from).add(vertex);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class Node {

        char vert;
        int duration;
        boolean visited;
        private Node(char vert, int duration) {
            this.vert = vert;
            this.duration = duration;
            this.visited = false;
        }

        private void visited() {
            this.visited = true;
        }

        private void reset() {
            this.visited = false;
        }

    }


    public static void main(String[] args) {

        ShortestPaths sp = new ShortestPaths();

        sp.readJson("Paths.json");
//
        for (char c: sp.adjList.keySet()) {
            System.out.println("From: " + c);
            for (Node node: sp.adjList.get(c)) {
                System.out.println(node.vert);
            }
        }

        sp.findShortestPaths('A', 'H');
    }
}


