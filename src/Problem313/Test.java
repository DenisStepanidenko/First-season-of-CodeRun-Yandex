package Problem313;

import java.util.TreeSet;
public class Test {
    // Function to print the running median
    // for the array arr[]
    public static void printRunningMedian(int[] arr, int n) {
        // Multiset is used to handle duplicates
        // Multiset g for storing upper half
        // (ascending order)
        // The first element will be the smallest)
        TreeSet<Integer> g = new TreeSet<Integer>();

        // Multiset s for storing lower half
        // (descending order). The first element
        // will be the largest
        TreeSet<Integer> s = new TreeSet<Integer>((a, b) -> (b - a));

        s.add(arr[0]);

        // Initialise median with the first element
        int med = arr[0];
        System.out.print(med + " ");

        for (int i = 1; i < n; i++) {
            // Only add elements to upper half if
            // its size less than the size of the
            // lower half (maintain only difference
            // of 1)
            if (s.size() > g.size()) {
                if (arr[i] < med) {
                    int temp = s.first();
                    s.remove(s.first());
                    g.add(temp);
                    s.add(arr[i]);
                } else {
                    g.add(arr[i]);
                }
                //median = first element/begin of set with larger
                // size = g.first or s.first
                med = s.first() > g.first() ? g.first() : s.first();
            }
            // Only add elements to lower half if
            // it's size less than the size of the
            // upper half (maintain only difference
            // of 1)
            else if (s.size() < g.size()) {
                if (arr[i] > med) {
                    int temp = g.first();
                    g.remove(g.first());
                    s.add(temp);
                    g.add(arr[i]);
                } else {
                    s.add(arr[i]);
                }
                //median = first element/begin of set with
                //larger size = g.first or s.first
                med = s.first() > g.first() ? g.first() : s.first();
            }

            // If sizes are same
            else {
                if (arr[i] > med) {
                    g.add(arr[i]);
                    //median = first element/begin of g
                    med = g.first();
                } else {
                    s.add(arr[i]);
                    //median = first element/begin of s
                    med = s.first();
                }
            }

            System.out.print(med + " ");
        }

        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { -10, 14, 11, -5, 7 };
        int n = arr.length;
        printRunningMedian(arr, n);
    }
}
