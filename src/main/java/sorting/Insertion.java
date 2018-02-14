package sorting;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

import java.awt.*;

public class Insertion {
    private static final int ARRAY_ITEM_WIDTH = 10;

    public static void sort(Comparable[] array, boolean trace) throws InterruptedException{
        setupBars();
        int N = array.length;
        for (int i = 1, j; i < N; i++) {
            for (j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
                show(array);
            }
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
        StdDraw.clear();
        int N = array.length;
        for (int i = 0; i < N; i++) {
            StdDraw.filledRectangle(0+i*20,100,5,(Double) array[i]*100);
        }
    }

    private static void setupBars(){
        StdDraw.setCanvasSize(800,500);
        StdDraw.setXscale(0,1000);
        StdDraw.setYscale(0,500);
        StdDraw.setPenColor(Color.orange);
        StdDraw.setPenRadius(10);
    }

    private static void createTraceCap(Object[] array) {
        int N = array.length;
        int maxY = ARRAY_ITEM_WIDTH + N * ARRAY_ITEM_WIDTH, maxX = maxY;
        StdDraw.setPenColor(Color.black);
        Font font = new Font("Consolas", Font.BOLD, 14);
        StdDraw.setFont(font);
        StdDraw.setScale(0, maxY);
        StdDraw.text(0, maxY, "i");
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY, "j");
        for (int i = 0; i < N; i++) {
            StdDraw.text(ARRAY_ITEM_WIDTH * 2 + i * ARRAY_ITEM_WIDTH, maxY, String.valueOf(i));
            if (i == 0) {
                StdDraw.setPenColor(Color.RED);
                StdDraw.line(-ARRAY_ITEM_WIDTH / 2, maxY - ARRAY_ITEM_WIDTH / 2, maxX + ARRAY_ITEM_WIDTH / 2, maxY - ARRAY_ITEM_WIDTH / 2);
                StdDraw.setPenColor(Color.black);
            }
            StdDraw.text(ARRAY_ITEM_WIDTH * 2 + i * ARRAY_ITEM_WIDTH, maxY - ARRAY_ITEM_WIDTH, array[i].toString());
        }

    }

    private static void createTraceFooter(Object[] array) {
        int N = array.length;
        int maxY = 2 * ARRAY_ITEM_WIDTH + N * ARRAY_ITEM_WIDTH, maxX = maxY;
        StdDraw.setPenColor(Color.black);
        for (int i = 0; i < N; i++) {
            StdDraw.text(ARRAY_ITEM_WIDTH * 2 + i * ARRAY_ITEM_WIDTH, 0, array[i].toString());
        }
    }

    private static void trace(Object[] array, int i, int j) {
        int N = array.length;
        int maxY = ARRAY_ITEM_WIDTH * 2 + N * ARRAY_ITEM_WIDTH, maxX = maxY;
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0, maxY - ARRAY_ITEM_WIDTH * 3 - (i - 1) * ARRAY_ITEM_WIDTH, String.valueOf(i));
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY - ARRAY_ITEM_WIDTH * 3 - (i - 1) * ARRAY_ITEM_WIDTH, String.valueOf(j));
        StdDraw.setPenColor(196, 197, 198);
        for (int x = 0; x < N; x++) {
            if (x == j)
                StdDraw.setPenColor(Color.red);
            else if (x > j && x <= i)
                StdDraw.setPenColor(Color.black);
            else
                StdDraw.setPenColor(196, 197, 198);

            StdDraw.text(ARRAY_ITEM_WIDTH * 2 + x * ARRAY_ITEM_WIDTH, maxY - ARRAY_ITEM_WIDTH * 3 - (i - 1) * ARRAY_ITEM_WIDTH, array[x].toString());
        }

    }

    public static void main(String[] args)throws InterruptedException {
        Character[] array = {'Y', 'U', 'T', 'S', 'S', 'Q', 'O', 'N', 'I', 'E', 'E', 'A'};
//        Character[] array = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        Double[] doubles = new Double[50];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = StdRandom.uniform();
        }
        sort(doubles, true);

    }
}
