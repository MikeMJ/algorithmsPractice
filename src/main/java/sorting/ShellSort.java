package sorting;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class ShellSort {
    private static final int ARRAY_ITEM_WIDTH = 17;
    private static final int ITEM_HEIGHT = 10;

    public static void sort(Comparable[] array) {
        createTraceCap(array);
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exchange(array, j, j - h);
                }
            }
            h /= 3;
        }

    }

    private static void trace(Object[] array, boolean drawLabel, int h){

    }
    private static void createTraceCap(Object[] array) {
        int N = array.length;
        int maxY = N * 2 * ITEM_HEIGHT;
        StdDraw.setPenColor(Color.red);
        Font font = new Font("Consolas", Font.BOLD, 14);
        StdDraw.setFont(font);
        StdDraw.setScale(0, maxY);
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY, "input");
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(Color.black);
            StdDraw.text(4*ARRAY_ITEM_WIDTH+i*ARRAY_ITEM_WIDTH,maxY,array[i].toString());
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

    public static void main(String[] args) {
        Comparable[] chars = {'E', 'A', 'S', 'Y', 'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        sort(chars);
        for (Comparable comparable : chars) {
            System.out.print(comparable);
        }
    }
}
