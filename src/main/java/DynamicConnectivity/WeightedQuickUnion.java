package DynamicConnectivity;

import edu.princeton.cs.introcs.StdIn;

public class WeightedQuickUnion {
    int[] array;
    int count;
    int[] sizes;
    int arrayAccesses;

    public WeightedQuickUnion(int size) {
        this.count = size;
        array = new int[size];
        sizes=new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int k) {
        arrayAccesses++;
        while (k != array[k]) {
            k = array[k];
            arrayAccesses++;
        }
        return k;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if(sizes[p]>sizes[q]){
            sizes[p]+=sizes[q];
            array[rootQ]=rootP;
        }else {
            sizes[q]+=sizes[p];
            array[rootP]=rootQ;
        }
        arrayAccesses+=3;
        System.out.println("Array accesses = "+arrayAccesses);
        arrayAccesses=0;
    }

    public static void main(String[] args) {
        WeightedQuickUnion quickUnion = new WeightedQuickUnion(10);
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
