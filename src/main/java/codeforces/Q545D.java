package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Q545D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }

        Arrays.sort(t);
        long time = 0;
        int unhappyCount = 0;
        for (int i = 0; i < n; i++) {
            if (time <= t[i]) {
                // Happy
                time += t[i];
            } else {
                unhappyCount++;
            }
        }
        System.out.println(n - unhappyCount);
    }

}
