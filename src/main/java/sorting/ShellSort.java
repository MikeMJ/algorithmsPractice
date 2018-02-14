package sorting;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShellSort {
    private static final int ARRAY_ITEM_WIDTH = 13;
    private static final int ITEM_HEIGHT = 15;
    private static int compares = 0;


    public static void sort(Comparable[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            compares = 0;
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exchange(array, j, j - h);
                }
            }
            System.out.println("Constant = " + compares / array.length);
            h /= 3;
        }

    }

    private static void show(Comparable[] array) {
        //StdDraw.setCanvasSize(800, 800);
        StdDraw.setPenColor(Color.red);
        StdDraw.filledRectangle(20, 20, 10, 100);
        StdDraw.filledCircle(1, 1, 28);
    }

    private static void trace(Object[] array, boolean drawLabel, int h, int min, List<Integer> indexes, int lineNumber) {
        int N = array.length;
        int maxY = N * 2 * ITEM_HEIGHT;
        if (drawLabel) {
            StdDraw.setPenColor(Color.red);
            StdDraw.text(ARRAY_ITEM_WIDTH, maxY - ITEM_HEIGHT * lineNumber * .7, h + "-sort");
        }
        for (int i = 0; i < N; i++) {
            if (i == min)
                StdDraw.setPenColor(Color.red);
            else if (indexes.contains(i))
                StdDraw.setPenColor(Color.black);
            else
                StdDraw.setPenColor(196, 197, 198);
            StdDraw.text(4 * ARRAY_ITEM_WIDTH + i * ARRAY_ITEM_WIDTH, maxY - lineNumber * .7 * ITEM_HEIGHT, array[i].toString());
        }

    }

    private static void createTraceCap(Object[] array) {
        int N = array.length;
        int maxY = N * 2 * ITEM_HEIGHT;
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setPenColor(Color.red);
        Font font = new Font("Consolas", Font.BOLD, 14);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, 4 * ARRAY_ITEM_WIDTH + N * ARRAY_ITEM_WIDTH);
        StdDraw.setYscale(0, maxY);
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY, "input");
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(Color.black);
            StdDraw.text(4 * ARRAY_ITEM_WIDTH + i * ARRAY_ITEM_WIDTH, maxY, array[i].toString());
        }
    }

    private static void createFooter(Object[] array, int lineNUmber) {
        int N = array.length;
        int maxY = N * 2 * ITEM_HEIGHT;
        StdDraw.setPenColor(Color.red);
        StdDraw.text(ARRAY_ITEM_WIDTH, maxY - ITEM_HEIGHT * lineNUmber * .7, "result");
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(Color.black);
            StdDraw.text(4 * ARRAY_ITEM_WIDTH + i * ARRAY_ITEM_WIDTH, maxY - ITEM_HEIGHT * lineNUmber * .7, array[i].toString());
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        compares++;
        return x.compareTo(y) < 0;
    }

    private static void exchange(Comparable[] array, int x, int y) {
        Comparable temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }



    public static void main(String[] args) {
        Comparable[] chars = {'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Double[] doubles = new Double[100];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = StdRandom.uniform();
        }



        StdDraw.filledRectangle(0,100,2,100);

    }

    public static boolean check(Comparable[] array) {
        Comparable[] copy = new Comparable[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i].compareTo(array[i + 1]) <= 0)) {
                boolean found = false;
                for (Comparable comparable : copy) {
                    if (array[i] == comparable) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    return false;
            } else
                return false;
        }
        return true;
    }
}
