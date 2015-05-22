package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        InputReader in = new StreamInputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        run(in, out);
    }

    public static void run(InputReader in, PrintWriter out) {
        Solver solver = new TaskB();
        solver.solve(1, in, out);
        Exit.exit(in, out);
    }
}

abstract class InputReader {
    private boolean finished = false;

    public abstract int read();

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public abstract void close();
}

class StreamInputReader extends InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar, numChars;

    public StreamInputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public void close() {
        try {
            stream.close();
        } catch (IOException ignored) {
        }
    }
}

class Exit {
    private Exit() {
    }

    public static void exit(InputReader in, PrintWriter out) {
        in.setFinished(true);
        in.close();
        out.close();
    }
}

interface Solver {
    public void solve(int testNumber, InputReader in, PrintWriter out);
}

class GeometryUtils {
    public static double epsilon = 1e-8;

}

class TaskB implements Solver {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int bottleCount = in.readInt();
        int volume = in.readInt();
        int friendCount = in.readInt();
        if (bottleCount < friendCount && bottleCount % (friendCount - bottleCount) != 0) {
            out.println("NO");
            return;
        }
        out.println("YES");
        int bottleIndex = 1;
        double remainingVolume = volume;
        double perFriend = (double) volume * bottleCount / friendCount;
        for (int i = 0; i < friendCount; i++) {
            double friendVolume = perFriend;
            boolean first = true;
            while (friendVolume > GeometryUtils.epsilon) {
                if (first)
                    first = false;
                else
                    out.print(" ");
                double currentVolume = Math.min(friendVolume, remainingVolume);
                friendVolume -= currentVolume;
                remainingVolume -= currentVolume;
                out.printf("%d %.10f", bottleIndex, currentVolume);
                if (remainingVolume < GeometryUtils.epsilon) {
                    bottleIndex++;
                    remainingVolume = volume;
                }
            }
            out.println();
        }
    }
}