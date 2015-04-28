package leetcode.medium;

import java.util.*;

/**
 * Created by lanxiao on 28/04/15.
 */
public class Q46 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //permute(num, new BitSet(num.length), new ArrayDeque<>(), ans);
        List<Integer> permutation = new ArrayList<Integer>();
        for (int n : num) permutation.add(n);
        permute2(permutation, 0, ans);
        return ans;
    }

    private void permute(int[] num, BitSet visited, Deque<Integer> permutation, List<List<Integer>> ans) {
        if (permutation.size() == num.length) {
            ans.add(new ArrayList<Integer>(permutation));
        } else {
            for (int i = 0; i < num.length; i++) {
                if (visited.get(i) == false) {
                    permutation.push(num[i]);
                    visited.set(i);
                    permute(num, visited, permutation, ans);
                    visited.clear(i);
                    permutation.pop();
                }
            }
        }
    }

    private void permute2(List<Integer> permutation, int begin, List<List<Integer>> ans) {
        if (begin >= permutation.size()) {
            ans.add(new ArrayList<Integer>(permutation));
        } else {
            for (int i = begin; i < permutation.size(); i++) {
                Collections.swap(permutation, begin, i);
                permute2(permutation, begin + 1, ans);
                Collections.swap(permutation, begin, i);
            }
        }
    }

    static public void main(String[] args) {
        int[] test = new int[]{1, 2, 3};
        Q46 q46 = new Q46();
        System.out.println(q46.permute(test));
    }
}
