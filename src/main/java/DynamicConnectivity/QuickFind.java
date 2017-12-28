package DynamicConnectivity;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdIn;

public class QuickFind {
    int[] array;
    int size;

    public QuickFind(int n){
        array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=i;
        }
        size=n;
    }
    int find(int k){
        return array[k];
    }

    boolean connected(int p, int q){
        return array[p]==array[q];
    }

    void union(int p, int q){
        int pRoot=array[p];
        int qRoot=array[q];
        if(qRoot==pRoot)
            return;
        int arrayAccesses=2;
        for (int i = 0; i < size; i++) {
            arrayAccesses++;
            if(array[i]==pRoot) {
                array[i] = qRoot;
                arrayAccesses++;
            }
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("Array acceses = "+arrayAccesses);
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        while (!StdIn.isEmpty()){
            String pair = StdIn.readString();
            String[] components= pair.split("-");
            int p = Integer.parseInt(components[0]);
            int q = Integer.parseInt(components[1]);
            if(quickFind.connected(p,q)) continue;
            quickFind.union(p,q);

        }
    }


}
