package codeforces;

import java.util.Scanner;

public class Q545C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = Integer.MIN_VALUE, px = Integer.MIN_VALUE, count = 0;
        while (n-- > 0) {
            int x = in.nextInt();
            int h = in.nextInt();
            if (b >= x) {
                count--;
                b = px;
            }
            count++;
            if (x - h > b) {
                b = x;
            } else {
                b = x + h;
            }
            px = x;
        }
        System.out.println(count);
    }
}
