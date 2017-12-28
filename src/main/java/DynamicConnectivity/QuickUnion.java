package DynamicConnectivity;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;

import java.awt.*;

public class QuickUnion {
    int[] array;
    int size;
    int arrayAccesses;
    int level;

    public QuickUnion(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        size = n;
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenColor(Color.ORANGE);
        //StdDraw.setPenRadius(0.1);
        StdDraw.filledCircle(10, 10, 2.0);
        StdDraw.filledCircle(20, 10, 2.0);
        //StdDraw.setPenColor(Color.GREEN);
        StdDraw.line(10, 10, 20, 10);

    }

    int find(int k) {
        arrayAccesses++;
        int localLevel = 1;
        while (k != array[k]) {
            k = array[k];
            arrayAccesses++;
            localLevel++;
        }
        if (localLevel > level)
            level = localLevel;
        return k;

    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot)
            return;
        array[pRoot] = array[qRoot];
        arrayAccesses += 2;

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Array acceses = " + arrayAccesses);
        arrayAccesses = 0;
        StdDraw.clear();
        for (int i = 0; i < size; i++) {
            //StdDraw.set
        }
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        while (!StdIn.isEmpty()) {
            String pair = StdIn.readString();
            String[] components = pair.split("-");
            int p = Integer.parseInt(components[0]);
            int q = Integer.parseInt(components[1]);
            if (quickUnion.connected(p, q)) continue;
            quickUnion.union(p, q);

        }
    }

}
