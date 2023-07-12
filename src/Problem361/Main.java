package Problem361;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if(b>=a && b<=c || (b>=c && b<=a)){
            System.out.println(b);
        }
        else if(a>=b && a<=c ||(a>=c && a<=b)){
            System.out.println(a);
        }
        else {
            System.out.println(c);
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
