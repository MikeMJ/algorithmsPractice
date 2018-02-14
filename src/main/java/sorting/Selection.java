package sorting;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;


import java.awt.*;

public class Selection {

    private static final int ARRAY_ITEM_WIDTH = 10;

    public static void sort(Comparable[] array, boolean trace) {
        setupBars();
        int N = array.length;
        for (int i = 0; i < N; i++) {

            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j], array[min]))
                    min = j;
            }
            exchange(array, i, min);
            try {
                Thread.sleep(500);
            }catch (InterruptedException ex){}
            show(array);
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


    private static void setupBars(){
        StdDraw.setCanvasSize(800,500);
        StdDraw.setXscale(0,1000);
        StdDraw.setYscale(0,500);
        StdDraw.setPenColor(Color.orange);
        StdDraw.setPenRadius(10);
    }

    public static void main(String[] args) {
        Character[] array = {'Y', 'U', 'T', 'S', 'S', 'Q', 'O', 'N', 'I', 'E', 'E', 'A'};
//      Character[] array = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O','N'};
        Double[] doubles = new Double[50];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = StdRandom.uniform();
        }
        sort(doubles,true);

    }
}
