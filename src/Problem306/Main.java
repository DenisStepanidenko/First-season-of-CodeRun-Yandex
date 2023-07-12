package Problem306;

import java.io.*;
import java.util.*;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> month = new HashMap<>();
        month.put("March", 1);
        month.put("April", 2);
        month.put("May", 3);
        month.put("June", 4);
        month.put("July", 5);
        month.put("August", 6);
        month.put("September", 7);
        month.put("October", 8);
        month.put("November", 9);
        month.put("December", 10);
        month.put("January", 11);
        month.put("February", 12);

        Map<Integer, String> allAnswer = new HashMap<>();
        allAnswer.put(0, "Sunday");
        allAnswer.put(1, "Monday");
        allAnswer.put(2, "Tuesday");
        allAnswer.put(3, "Wednesday");
        allAnswer.put(4, "Thursday");
        allAnswer.put(5, "Friday");
        allAnswer.put(6, "Saturday");

        while(true){
            String q = input.nextLine();
            if(q == null){
                break;
            }
            String[] s = q.split(" ");

            int d = Integer.parseInt(s[0]);
            int m = month.get(s[1]);
            int y = Integer.parseInt(s[2]);
            if(Objects.equals(s[1], "January") || Objects.equals(s[1], "February")){
                y--;
            }
            //System.out.println((int) (d + Math.floor((13 * m - 1) / 5) + y + Math.floor(y / 4) - Math.floor(y / 100) + Math.floor(y / 400)) % 7);
            System.out.println(allAnswer.get( (int) (d + Math.floor((13 * m - 1) / 5) + y + Math.floor(y / 4) - Math.floor(y / 100) + Math.floor(y / 400)) % 7));
//            if(input.next() == null){
//                break;
//            }
        }




        //System.out.println((d + Math.floor((13 * m - 1) / 5) + y + Math.floor(y / 4) - Math.floor(y / 100) + Math.floor(y / 400)) % 7);
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
