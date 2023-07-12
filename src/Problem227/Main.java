package Problem227;

import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        long k = Integer.parseInt(parts[0]);
        long m = Integer.parseInt(parts[1]);
        long d = Integer.parseInt(parts[2]);
        long answer = 0;
        long mustRead = 1;
        while (d != 1) {
            if (d < 6) {
                m += k;
            }
            m -= mustRead;
            if (m < 0) {
                break;
            } else {
                answer++;
                mustRead++;
                d = (d % 7) + 1;
            }
        }
        if (m < 0) {
            System.out.println(answer);
        } else {
            long sum = (mustRead + 3) * 7;
            long n = (long) ((49 - 2 * sum + 10 * k) + Math.sqrt(Math.pow(49 - 2 * sum + 10 * k, 2) + 392 * m)) / 98;
            answer += 7 * n;
            mustRead = mustRead + 7 * n;
            m = m + 5 * k * n - 49 * (((long) n * (n - 1)) / 2) - sum * n;
            while (m >= 0) {
                if (d < 6) {
                    m += k;
                }
                m -= mustRead;
                if (m < 0) {
                    break;
                } else {
                    answer++;
                    mustRead++;
                    d = (d % 7) + 1;
                }
            }
            System.out.println(answer);
        }
    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
