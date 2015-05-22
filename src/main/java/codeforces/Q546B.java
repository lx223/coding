package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Q546B {
    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coolness = new int[n];
        while (n-- > 0) {
            coolness[n] = in.nextInt();
        }
        Arrays.sort(coolness);
        int increase = 0;
        for (int i = 1; i < coolness.length; i++) {
            if (coolness[i] <= coolness[i - 1]) {
                increase += coolness[i - 1] + 1 - coolness[i];
                coolness[i] = coolness[i - 1] + 1;
            }
        }
        System.out.println(increase);
    }
}
