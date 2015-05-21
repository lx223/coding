package codeforces;

import java.util.Scanner;

public class Q1A {

    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), a = in.nextInt();
        int t1 = n / a, t2 = m / a;
        if (t1 * a < n) t1++;
        if (t2 * a < m) t2++;
        System.out.println((long) t1 * t2);
    }
}
