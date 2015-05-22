package codeforces;

import java.util.Scanner;

public class Q546A {
    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int k = in.nextInt(), n = in.nextInt(), w = in.nextInt();
        long borrow = ((long) w + 1) * w / 2 * k - n;
        if (borrow > 0) System.out.println(borrow);
        else System.out.println(0);
    }
}
