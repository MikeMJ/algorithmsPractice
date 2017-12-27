package sorting;

public class Selection {
    public static void sort(Comparable[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j],array[min]))
                    min = j;
            }
            exchange(array, i, min);
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static void exchange(Comparable[] array, int x, int y) {
        Comparable temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static void show(Object[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 5, 4, 2, 7, 3, 8, 1, 9, 5, 4, 9, 3, 1, 2};
        sort(array);
        show(array);
    }
}
