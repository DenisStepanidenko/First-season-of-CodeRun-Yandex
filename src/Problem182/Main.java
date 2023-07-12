package Problem182;

import java.io.*;
import java.util.*;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) throws IOException {
        // System.out.println(isPrime(2));
        long x = input.nextLong(); // нод
        long y = input.nextLong(); // нок

        // p : x and q : x and y : p and y : q
        if (y % x != 0) {
            System.out.println(0);
        } else {
            long n = y / x;
            System.out.println((long) Math.pow(2,factorize(n)));

        }
    }
    public static Integer factorize(long x) {
        int answer = 0;
        int i = 2;
        while ((long) i * i <= x) {
            long r = x;
            while (x % i == 0) {

                x /= i;
            }
            if(x < r){
                answer++;
            }
            i++;
        }
        if (x > 1) {
            answer++;
        }
        return answer;
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