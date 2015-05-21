package codeforces;


import java.util.Scanner;

public class Q545B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        final int n = a.length();
        int countOfDiff = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) countOfDiff++;
        }
        if (countOfDiff == 0) {
            System.out.println(a);
        } else if ((countOfDiff & 1) != 0) {
            System.out.println("impossible");
        } else {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == b.charAt(i) || count < countOfDiff / 2) {
                    sb.append(a.charAt(i));
                    if (a.charAt(i) != b.charAt(i)) count++;
                } else {
                    sb.append(b.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
