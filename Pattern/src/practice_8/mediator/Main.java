package practice_8.mediator;

import java.util.*;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {

    }
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.putIfAbsent(road[0], new HashMap<>());
            map.get(road[0]).put(road[1], road[2]);
            map.putIfAbsent(road[1], new HashMap<>());
            map.get(road[1]).put(road[0], road[2]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        boolean[] visited = new boolean[n];
        int minim = 10001;
        while (!q.isEmpty()) {
            int x = q.poll();
            if (!visited[x - 1]) {
                for (int i : map.get(x).keySet()) {
                    minim = Math.min(minim, map.get(x).get(i));
                    q.add(i);
                }
                visited[x - 1] =true;
            }
        }
        return minim;
    }
}