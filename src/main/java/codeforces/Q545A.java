package codeforces;

import java.util.Scanner;

public class Q545A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        boolean[] badCars = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int collision = in.nextInt();
                if (i != j && (badCars[i] == false || badCars[j] == false)) {
                    if (collision == 3) {
                        badCars[i] = true;
                        badCars[j] = true;
                    }
                    if (collision == 2) badCars[j] = true;
                    if (collision == 1) badCars[i] = true;
                }
            }
        }
        int count = 0;
        for (boolean badCar : badCars) {
            if (badCar == false) count++;
        }
        System.out.println(count);
        for (int i = 0; i < n; i++) {
            if (badCars[i] == false) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
