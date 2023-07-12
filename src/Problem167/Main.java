package Problem167;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static Reader input = new Reader();

    public static void main(String[] args) {
//        for(int i =0; i <49;i++){
//            System.out.print(1 + " ");
//        }
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        boolean flag1 = false;
        List<Integer> answer = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            if (x == 1) {
                flag1 = true;
            }
            arr[i] = x;
        }

        if (m == 0) {
            int currentSize = 0;
            boolean flag3 = false;
            for (int i = 0; i < n; i++) {
                if(arr[i] == 0){
                    flag3 = true;
                    currentSize++;
                    answer.add(i+1);
                    if(currentSize == k){
                        break;
                    }
                }
                else{
                    if(currentSize == k-1 && flag3){
                        answer.add(i+1);
                        break;
                    }
                    else if(currentSize < k-1){
                        currentSize++;
                        answer.add(i+1);
                    }
                }

            }
            for (Integer integer : answer) {
                System.out.print(integer + " ");
            }
        }
        else {
            int mask = 0;
            boolean flag = true;
            if (k == 1) {
                for (int i = 0; i < n; i++) {
                    if (arr[i] == m) {
                        System.out.println(i + 1);
                        break;
                    }
                }
            }
            else if(m == 1){
                int currentSize = 0;
                for(int i =0; i < n;i++){
                    if(arr[i] == 1){
                        currentSize++;
                        answer.add(i+1);
                        if(currentSize == k){
                            break;
                        }
                    }
                }
                for (Integer integer : answer) {
                    System.out.print(integer + " ");
                }
            }else {
                while (flag) {
                    answer = printPermutation(flag1, mask, arr, m, k);
                    if (answer.isEmpty()) {
                        mask++;
                    } else {
                        flag = false;
                    }

                }
                for (Integer integer : answer) {
                    System.out.print(integer + " ");
                }
            }
        }
    }

    static List<Integer> printPermutation(boolean flag1, int mask, int[] arr, int m, int k) {
        boolean flagNew = true;
        int x = 1, currentSize = 0;
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if ((mask & (1 << i)) != 0) {
                if (arr[i] == 0) {
                    if (m != 0) {
                        flagNew = false;
                        break;
                    } else {
                        x = 0;
                        current.add(i + 1);
                        currentSize++;
                        if (currentSize >= k) {
                            break;
                        }
                    }
                } else {
                    if (arr[i] > m || ((m % arr[i]) != 0) || (arr[i] == m && k > 1 && !flag1)) {
                        flagNew = false;
                        break;

                    } else {
                        x *= arr[i];
                        currentSize++;
                        current.add(i + 1);
                        if (currentSize >= k) {
                            break;
                        }
                    }
                }
            }
        }
        if (currentSize < k || !flagNew) {
            //System.out.println("hello");
            return new ArrayList<>();
        } else {
            if (x == m) {
                //System.out.println("heloi");
                return current;
            } else {
                return new ArrayList<>();
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
