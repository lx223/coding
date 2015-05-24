package codeforces;

import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Q546D {
    static public void main(String[] arg) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        // Solution here
        final int R = 5000000 + 1;
        int[] cumCount = new int[R];
        precompute(cumCount);

        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            out.println(cumCount[a] - cumCount[b]);
        }

        in.close();
        out.close();
    }

    static private void precompute(int[] cumCount) {
        BitSet visited = new BitSet(cumCount.length);
        for (int i = 2; i < cumCount.length; i = visited.nextClearBit(i)) {
            if (!visited.get(i)) {
                for (int j = i; j < cumCount.length; j += i) {
                    visited.set(j);
                    int tmp = j;
                    while (tmp % i == 0) {
                        tmp /= i;
                        cumCount[j]++;
                    }
                }
            }
        }
        for (int i = 1; i < cumCount.length; i++) {
            cumCount[i] += cumCount[i - 1];
        }
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



