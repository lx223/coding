package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanxiao on 08/05/15.
 */
public class Q207 {
    /*
    LeetCode Q207:
        https://leetcode.com/problems/course-schedule/
    Thinking process:
        This question immediately reads as a question to detect cycles in a directed graph
        1. convert it to directed graph
        2. detect directed cycles

        Another way is to use incoming and outgoing edges
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        List<List<Integer>> adjs = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[numCourses];
        while (numCourses-- > 0) adjs.add(new ArrayList<Integer>());
        for (int[] edge : prerequisites) adjs.get(edge[0]).add(edge[1]);
        return !hasCycle(adjs, visited);
    }

    private boolean hasCycle(List<List<Integer>> adjs, boolean[] visited) {
        boolean[] onStack = new boolean[visited.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                if (dfs(i, adjs, visited, onStack) == true) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adjs, boolean[] visited, boolean[] onStack) {
        visited[node] = true;
        onStack[node] = true;
        for (int to : adjs.get(node)) {
            if (visited[to] == false) {
                if (dfs(to, adjs, visited, onStack) == true) return true;
            } else if (onStack[to] == true) {
                return true;
            }
        }
        onStack[node] = false;
        return false;
    }
}
