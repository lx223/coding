package leetcode.easy;

import java.util.BitSet;

/**
 * Created by lanxiao on 28/04/15.
 */
public class Q204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        BitSet compounds = new BitSet(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (compounds.get(i) == false) {
                count++;
                for (int j = i + i; j < n; j += i) compounds.set(j);
            }
        }
        return count;
    }

    static public void main(String[] args) {
        Q204 q204 = new Q204();
        System.out.println(q204.countPrimes(3));
    }
}
