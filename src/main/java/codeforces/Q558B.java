package codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by lanxiao on 14/07/15.
 */
public class Q558B {
    static public void main(String[] arg) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        // Solution here

        int R = (int) 1E6;

        int n = in.nextInt();
        int[] a = new int[n];
        int[] maxIdx = new int[R];
        int[] minIdx = new int[R];
        Arrays.fill(minIdx, Integer.MAX_VALUE);
        int[] counts = new int[R];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() - 1;
            maxCount = Math.max(maxCount, ++counts[a[i]]);
            maxIdx[a[i]] = Math.max(maxIdx[a[i]], i);
            minIdx[a[i]] = Math.min(minIdx[a[i]], i);
        }

        int minRange = n;
        int l = 1, r = n;
        for (int i = 0; i < n; i++) {
            if (counts[a[i]] < maxCount) continue;
            int range = maxIdx[a[i]] - minIdx[a[i]] + 1;
            if (minRange > range) {
                l = minIdx[a[i]] + 1;
                r = maxIdx[a[i]] + 1;
                minRange = range;
            }
        }
        out.println(l + " " + r);
        in.close();
        out.close();
    }

    static private class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static private class GeometryUtils {
        public double epsilon = 1e-8;
    }
}
