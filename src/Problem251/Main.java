package Problem251;

import java.io.*;
import java.util.*;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String s = input.nextLine();
        String c = input.nextLine();
        int answer = Integer.MAX_VALUE;
        int current = 0; // показывает, что мы нашли все элементы из c в подстроке s
        int start = 0, i = 0, matchLen = 0;
        int[] arr = new int[255];
        Arrays.fill(arr, 0);
        for (; i < s.length(); i++) {
            char currentSymbol = s.charAt(i);
            if(!c.contains(String.valueOf(currentSymbol))){
                Arrays.fill(arr , 0);
                matchLen = 0;
                start = i+1;
                continue;
            }
            else{

                if (arr[currentSymbol] == 0) {
                    matchLen++;
                }
                arr[currentSymbol]++;
                if (matchLen == c.length()) {
                    while (start < s.length() && (arr[s.charAt(start)] > 1)) {
                        arr[s.charAt(start)]--;
                        start++;
                    }

                    answer = Math.min(answer, i - start + 1);
                    if (answer == c.length()) {
                        break;
                    }
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
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
