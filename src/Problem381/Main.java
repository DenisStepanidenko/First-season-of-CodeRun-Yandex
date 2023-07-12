package Problem381;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Reader input = new Reader();
    public static void main(String[] args) {
        String s = input.nextLine();
        String[] split = s.split(" ");
        int days = Integer.parseInt(split[0]);
        String weekDay = split[1];

        Map<String, Integer> weekDays = new HashMap<>();
        weekDays.put("Monday", 1);
        weekDays.put("Tuesday", 2);
        weekDays.put("Wednesday", 3);
        weekDays.put("Thursday", 4);
        weekDays.put("Friday", 5);
        weekDays.put("Saturday", 6);
        weekDays.put("Sunday", 7);

        int numberOfDay = weekDays.get(weekDay);

        for (int i = 1; i < numberOfDay; i++) {
            System.out.print(".. ");
        }

        int number = 1;
        int transition = number + (7 - numberOfDay);
        for (int i = number; i <= days; i++) {
            if(transition == i){
                if(i / 10 == 0){
                    System.out.println("." + i);
                }
                else{
                    System.out.println(i);
                }
                transition = i + 7;
            }
            else{
                if(i / 10 == 0){
                    System.out.print("." + i + " ");
                }
                else{
                    System.out.print(i + " ");
                }
            }
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
