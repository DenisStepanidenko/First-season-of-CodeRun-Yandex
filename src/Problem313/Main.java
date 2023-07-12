package Problem313;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {

        int n = input.nextInt();
        long answer = 0;
        int[] arr = new int[n+1];
        arr[0]  = 0;
        for (int i = 1; i < n + 1 ; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }
        TreeSet<Integer> g = new TreeSet<>();
        TreeSet<Integer> s = new TreeSet<>((a,b) -> (b-a));
        s.add(arr[1]);
        int med = arr[1];
        answer+=med;
        for (int i = 2; i < n + 1; i++) {
            if(s.size() == g.size()){
                if(arr[i] > med){
                    g.add(arr[i]);
                    med = g.first();
                    answer+=med;
                }
                else{
                    s.add(arr[i]);
                    answer+=med;
                }
            }
            else if(s.size() < g.size()){
                if(arr[i] > med){
                    int temp = g.first();
                    s.add(temp);
                    g.remove(g.first());
                    g.add(arr[i]);
                    med = s.first();
                    answer+=med;
                }
                else{
                    s.add(arr[i]);
                    med = s.first();
                    answer+=med;
                }
            }
            else{
                // s.size()>g.size()
                if(arr[i] > med){
                    g.add(arr[i]);
                    answer+=med;

                }
                else{
                    int temp = s.first();
                    g.add(temp);
                    s.remove(s.first());
                    s.add(arr[i]);
                    med = s.first();
                    answer+=med;
                }
            }
        }
        System.out.println(answer);
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


