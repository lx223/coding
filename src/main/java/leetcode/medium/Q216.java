package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/combination-sum-iii/">LeetCode Q216</>
 *
 * Thinking process:
 *
 * Combination always smells like backtracking. Since only 1 to 9 are valid inputs and each can only be used once,
 * therefore duplicates can be avoided by only trying inputs larger than the current one
 */
public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> solns = new ArrayList<>();
        solve(k, n, 0, 0, solns, new ArrayDeque<Integer>());
        return solns;
    }

    private void solve(int k, int n, int sum, int i, List<List<Integer>> solns, Deque<Integer> sol) {
        if (sol.size() == k) {
            if (sum == n) {
                solns.add(new ArrayList<>(sol));
            }
        } else {
            for (int j = i + 1; j <= 9; j++) {
                sol.offerLast(j);
                solve(k, n, sum + j, j, solns, sol);
                sol.removeLast();
            }
        }
    }
}
