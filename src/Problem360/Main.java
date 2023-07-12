package Problem360;

import java.io.*;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            if (numbers.containsKey(x)) {
                numbers.put(x, numbers.get(x) + 1);
            } else {
                numbers.put(x, 1);
            }
        }
        int countMax = -1;
        int numberMax = 0;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > countMax){
                countMax = value;
                numberMax = key;
            }
            else if(value == countMax){
                if(key > numberMax){
                    numberMax = key;
                }
            }
        }
        System.out.println(numberMax);
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
