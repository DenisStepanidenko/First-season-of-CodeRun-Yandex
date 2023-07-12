package Problem317;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        long n = input.nextLong();
        long q1 = input.nextLong();
        long q2 = input.nextLong();
        long q3 = input.nextLong();

        long sum = ((long) n * (n + 1)) / 2;
        long sum2 = (n * (n + 1) * (2L * n + 1)) / 6;
        long sum3 = ((long) n * n * (n + 1) * (n + 1)) / 4;

        long a1 = sum - q1;
        long a2 = sum2 - q2;
        long a3 = sum3 - q3;

        // Найдём коэффициенты уравнения
        //x^3-x^2*a +x*p-q=0
        long p = (long) ((Math.pow(a1,2) - a2) / 2);
        long q = (long) ((a3 + 3 * p * a1 - Math.pow(a1,3)) / 3);

        List<Long> answer = new ArrayList<>();

        for (long i = 1; i <= Math.sqrt(q); i++) {
            if (q % i == 0) {
                if ( (long) (Math.pow(i, 3) - Math.pow(i, 2) * a1 + i * p - q) == 0) {
                    answer.add(i);
                    if (answer.size() == 3) {
                        break;
                    }
                    long delitel = q / i;
                    if(delitel == i){
                        continue;
                    }
                    else{
                        if( (long) (Math.pow(delitel, 3) - Math.pow(delitel, 2) * a1 + delitel * p - q) == 0){
                            answer.add(delitel);
                            if(answer.size() == 3){
                                break;
                            }
                        }
                    }
                }
            }
        }

        for(Long x : answer){
            System.out.print(x + " ");
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
