package sorting;

import edu.princeton.cs.introcs.StdDraw;


import java.awt.*;

public class Selection {

    private static final int ARRAY_ITEM_WIDTH = 10;

    public static void sort(Comparable[] array, boolean trace) {
        if (trace)
            createTraceCap(array);
        int N = array.length;
        for (int i = 0; i < N; i++) {

            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j], array[min]))
                    min = j;
            }
            if (trace)
                trace(array, i, min);
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

    private static void createTraceCap(Object[] array) {
        int N = array.length;
        int maxY = ARRAY_ITEM_WIDTH + N * ARRAY_ITEM_WIDTH, maxX = maxY;
        StdDraw.setPenColor(Color.black);
        Font font = new Font("Consolas", Font.BOLD, 14);
        StdDraw.setFont(font);
        StdDraw.setScale(0, maxY);
        StdDraw.text(0, maxY, "i");
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY, "min");
        for (int i = 0; i < N; i++) {
            StdDraw.text(ARRAY_ITEM_WIDTH*2 + i * ARRAY_ITEM_WIDTH, maxY, String.valueOf(i));
            if (i == 0) {
                StdDraw.setPenColor(Color.RED);
                StdDraw.line(-ARRAY_ITEM_WIDTH/2, maxY - ARRAY_ITEM_WIDTH/2, maxX+ARRAY_ITEM_WIDTH/2, maxY - ARRAY_ITEM_WIDTH/2);
                StdDraw.setPenColor(Color.black);
            }
            StdDraw.text(ARRAY_ITEM_WIDTH*2 + i * ARRAY_ITEM_WIDTH, maxY - ARRAY_ITEM_WIDTH, array[i].toString());
        }

    }

    private static void trace(Object[] array, int i, int min) {
        int N = array.length;
        int maxY = ARRAY_ITEM_WIDTH*2 + N * ARRAY_ITEM_WIDTH, maxX = maxY;
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0, maxY - ARRAY_ITEM_WIDTH*3 - i * ARRAY_ITEM_WIDTH, String.valueOf(i));
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY - ARRAY_ITEM_WIDTH*3 - i * ARRAY_ITEM_WIDTH, String.valueOf(min));
        StdDraw.setPenColor(196, 197, 198);
        for (int j = 0; j < N; j++) {
            if (j >= i)
                StdDraw.setPenColor(Color.black);
            if (j == min)
                StdDraw.setPenColor(Color.red);
            StdDraw.text(ARRAY_ITEM_WIDTH*2 + j * ARRAY_ITEM_WIDTH, maxY - ARRAY_ITEM_WIDTH*3 - i * ARRAY_ITEM_WIDTH, array[j].toString());
        }

    }

    public static void main(String[] args) {
        Character[] array = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O','N'};
        sort(array,true);
        show(array);
    }
}
