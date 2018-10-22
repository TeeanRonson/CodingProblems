import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class FindPaths {
    /**
     *
     */

    private Map<String, Map<String, Integer>> graph;

    public FindPaths() {
        graph = new HashMap<>();
    }

    private class Path implements Comparable<Path> {
        int dis;
        List<String> path;
        public Path(int dis, List<String> path) {
            this.dis = dis;
            this.path = path;
        }

        @Override
        public int compareTo(Path p2) {
            return this.dis - p2.dis;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Path is: ");
            for (String node : path) {
                sb.append(node);
            }
            sb.append(System.lineSeparator());
            sb.append("Distance = " + dis + System.lineSeparator());
            return sb.toString();
        }
    }

    public void readFile(String file) { // Build the map
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(file))) {
            JsonParser jsonParser = new JsonParser();
            String line;
            try {
                while ((line = bf.readLine()) != null) {
                    JsonObject jObj = (JsonObject)jsonParser.parse(line);
                    String from = jObj.get("from").getAsString();
                    String to = jObj.get("to").getAsString();
                    int duration = jObj.get("duration").getAsInt();
                    if (!graph.containsKey(from)) {
                        graph.put(from, new HashMap<>());
                    }
                    graph.get(from).put(to, duration);
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("File does not exist: " + file);
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public List<Path> findPath(String start, String end) {
        List<Path> res = new ArrayList<>();
        if (start == null || end == null || !this.graph.containsKey(start) || !this.graph.containsKey(end)) return res;
        Set<String> visited = new HashSet<>();
        findAllPath(graph, res, new ArrayList<>(), start, end, visited, 0);
        Collections.sort(res);
        return res;
    }

    public void findAllPath(Map<String, Map<String, Integer>> graph, List<Path> paths, List<String> tmpPath, String start, String end, Set<String> visited, int curDis) {
        if (!visited.add(start)) return;

        tmpPath.add(start);

        if (start.equals(end)) {
            paths.add(new Path(curDis, new ArrayList<>(tmpPath)));
        } else{
            for (Map.Entry<String, Integer> nodeToDis : graph.get(start).entrySet()) {
                findAllPath(graph, paths, tmpPath, nodeToDis.getKey(), end, visited, curDis + nodeToDis.getValue());
            }
        }



        tmpPath.remove(tmpPath.size() - 1);
        visited.remove(start);
    }


    public static void main(String[] args) {
        FindPaths sr = new FindPaths();
        sr.readFile("routes.json");
        List<Path> res = sr.findPath("A", "B");
        System.out.println(res);
        System.out.println(res.size());
    }
}