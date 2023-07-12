package Problem325;

import java.io.*;
import java.util.*;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        //System.out.println(8|4);
        long n = input.nextLong();
        long m = input.nextLong();
        long q = input.nextLong();
        List<PairMin> metricsMin = new ArrayList<>();
        List<PairMax> metricsMax = new ArrayList<>();// метрики
        for (int i = 0; i < n; i++) {
            metricsMin.add(new PairMin(0, i + 1 ));
        }
        for (int i = 0; i < n; i++) {
            metricsMax.add(new PairMax(0, i + 1));
        }
        List<Long> servers = new ArrayList<>(); // битовая маска включенных машин
        for (int i = 0; i < n; i++) {
            servers.add(0L);
        }
        List<Long> countOfServer = new ArrayList<>(); // количество включенных серверов
        for (int i = 0; i < n; i++) {
            countOfServer.add((long) m);
        }
        List<Long> countOfRestart = new ArrayList<>(); // количество перезапусков
        for (int i = 0; i < n; i++) {
            countOfRestart.add(0L);
        }
        List<Long> answer = new ArrayList<>();
        PriorityQueue<PairMin> minHeap = new PriorityQueue<>(metricsMin);
        PriorityQueue<PairMax> maxHeap = new PriorityQueue<>(metricsMax);

        for (int i = 0; i < q; i++) {
            String s = input.next();
            if (s.equals("GETMAX")) {
                //System.out.println(maxHeap);
                answer.add(maxHeap.peek().index);
            } else if (s.equals("GETMIN")) {
                //System.out.println(minHeap);
                answer.add(minHeap.peek().index);
            } else if (s.equals("RESET")) {
                int x = input.nextInt();
                x--;
                servers.set(x, 0L);
                countOfServer.set(x, (long) m);
                countOfRestart.set(x, countOfRestart.get(x) + 1);
                metricsMin.set(x, new PairMin((long) countOfRestart.get(x) * m, x+1));
                metricsMax.set(x, new PairMax((long) countOfRestart.get(x) * m, x+1));
                minHeap = new PriorityQueue<>(metricsMin);
                maxHeap = new PriorityQueue<>(metricsMax);
                //System.out.println(minHeap);
                //System.out.println(maxHeap);
            } else if (s.equals("DISABLE")) {
                int x = input.nextInt(); // дата центр
                long y = input.nextInt(); // сервер
                x--;
                y--;
                long t = 1L << y;
                if((servers.get(x) & t) != 0){
                    continue;
                }
                servers.set(x , servers.get(x) | t);
                countOfServer.set(x , countOfServer.get(x) - 1);
                metricsMin.set(x, new PairMin(countOfRestart.get(x) * countOfServer.get(x) , x+1));
                metricsMax.set(x, new PairMax(countOfRestart.get(x) * countOfServer.get(x), x+1));
                minHeap = new PriorityQueue<>(metricsMin);
                maxHeap = new PriorityQueue<>(metricsMax);
            }
        }
        for(Long x : answer){
            System.out.println(x);
        }

    }



    static class PairMax implements Comparable<PairMax> {
        long metrics;
        long index;

        public PairMax(long metrics, long index) {
            this.metrics = metrics;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "metrics=" + metrics +
                    ", index=" + index +
                    '}';
        }

        @Override
        public int compareTo(PairMax o) {
            if (this.metrics != o.metrics) {
                return Long.compare(o.metrics, this.metrics);
            } else {
                return Long.compare(this.index, o.index);
            }
        }
    }

    static class PairMin implements Comparable<PairMin> {
        long metrics;
        long index;

        public PairMin(long metrics, long index) {
            this.metrics = metrics;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "metrics=" + metrics +
                    ", index=" + index +
                    '}';
        }

        @Override
        public int compareTo(PairMin o) {
            if (this.metrics != o.metrics) {
                return Long.compare(this.metrics, o.metrics);
            } else {
                return Long.compare(this.index, o.index);
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


