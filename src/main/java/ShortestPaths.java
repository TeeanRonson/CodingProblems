import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.media.SubtitleTrack;
import sun.security.provider.certpath.Vertex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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


    HashMap<Character, HashMap<Character, Integer>> adjList;
    ArrayList<Path> result;

    public ShortestPaths() {
        this.adjList = new HashMap<>();
        this.result = new ArrayList<>();
    }


    public void findShortestPaths(Character start, Character end) {

        if (start == null || end == null || !this.adjList.containsKey(start) || !this.adjList.containsKey(end)) {
            return;
        }

        LinkedList<Character> currPath = new LinkedList<>();
        HashSet<Character> visited = new HashSet<>();
        dfs(start, end, 0, currPath, visited);

        System.out.println("Result: ");
        Collections.sort(this.result);
        for (Path p: result) {
            System.out.println(p);
        }
        System.out.println(this.result.size());

   }


    private void dfs(Character start, Character end, Integer total, LinkedList<Character> currPath, HashSet<Character> visited) {

        if (visited.contains(start)) {
            return;
        }

        currPath.add(start);
        visited.add(start);

        if (start == end) {
            result.add(new Path(total, new LinkedList<>(currPath)));
        } else {
            for (Map.Entry<Character, Integer> map: adjList.get(start).entrySet()) {
                dfs(map.getKey(), end, total + map.getValue(), currPath, visited);
            }
        }



        visited.remove(start);
        currPath.removeLast();

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

                    if (adjList.get(from) == null) {
                        HashMap<Character, Integer> dest = new HashMap<>();
                        dest.put(to, duration);
                        adjList.put(from, dest);
                    } else {
                        adjList.get(from).put(to, duration);
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
        private Node(char vert, int duration) {
            this.vert = vert;
            this.duration = duration;

        }
    }

    private class Path implements Comparable<Path> {

        int duration;
        List<Character> path;
        private Path(int duration, List<Character> path) {
            this.duration = duration;
            this.path = path;
        }

        @Override
        public int compareTo(Path o) {
            return this.duration - o.duration;
        }

        public String toString() {
            return "Duration: " + this.duration + " Path: " + this.path;

        }
    }


    public static void main(String[] args) {

        ShortestPaths sp = new ShortestPaths();

        sp.readJson("Paths.json");
//
        for (char c: sp.adjList.keySet()) {
            System.out.println("From: " + c);
            for (Map.Entry<Character, Integer> dests: sp.adjList.get(c).entrySet()) {
                System.out.println(dests.getKey() + " " + dests.getValue());
            }
        }

        sp.findShortestPaths('A', 'H');
        

    }
}


