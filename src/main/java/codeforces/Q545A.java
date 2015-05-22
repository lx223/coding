package codeforces;

import java.util.Scanner;

public class Q545A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        boolean[] badCars = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int collision = in.nextInt();
                if (i >= j) continue;
                if (collision == 1 || collision == 3) badCars[i] = true;
                if (collision == 2 || collision == 3) badCars[j] = true;
            }
            if (!badCars[i]) count++;
        }
        //for (boolean car : badCars) count = car ? count : count + 1;
        System.out.println(count);
        for (int i = 0; i < n; i++) {
            if (!badCars[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
