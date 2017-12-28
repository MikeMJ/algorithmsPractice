package ResizingArray;


import java.util.Iterator;

public class ResizingArrayDeque<T> implements Iterable<T> {
    int itemCount;
    T[] array;
    int leftMost;
    int rightMost;

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public ResizingArrayDeque() {
        array = (T[]) new Object[1];
    }

    class ArrayIterator implements Iterator<T> {

        T nextItem = array[leftMost];
        int counter=0;

        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        @Override
        public T next() {
            T currentItem = nextItem;
            int index = (leftMost + (++counter))%array.length;
            nextItem = array[index];
            return currentItem;
        }
    }

    public boolean isEmpty(){
        return itemCount==0;
    }

    public int size(){
        return itemCount;
    }

    public void pushLeft(T item) {
        if (itemCount > 0)
            leftMost = leftMost - 1 < 0 ? array.length - 1 : leftMost - 1;
        array[leftMost] = item;
        itemCount++;
        if (itemCount == array.length) {
            resize(itemCount * 2);
        }
    }

    public void pushRight(T item) {
        if (itemCount > 0)
            rightMost = (rightMost + 1)%array.length;
        array[rightMost] = item;
        itemCount++;
        if (itemCount == array.length) {
            resize(itemCount * 2);
        }
    }

    public T popLeft() {
        if (itemCount == 0)
            throw new RuntimeException("No item in the list");
        T item = array[leftMost];
        leftMost = (leftMost + 1)%array.length;
        itemCount--;
        if (itemCount > 0 && itemCount == array.length / 4) {
            resize(itemCount * 2);
        }
        return item;
    }

    public T popRight() {
        if (itemCount == 0)
            throw new RuntimeException("No item in the list");
        T item = array[rightMost];
        array[rightMost] = null;
        rightMost = (rightMost - 1)%  array.length ;
        itemCount--;
        if (itemCount > 0 && itemCount == array.length / 4) {
            resize(itemCount * 2);
        }
        return item;
    }

    private void resize(int toSize) {
        T[] newArray = (T[]) new Object[toSize];
        for (int i = 0; i < itemCount; i++) {
            int index =  (leftMost+i)%array.length;
            newArray[i] = array[index];
        }
        leftMost = 0;
        rightMost = itemCount - 1;
        array = newArray;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<Integer>();
        deque.pushLeft(3);
        deque.pushRight(4);
        deque.pushLeft(2);
        deque.pushRight(5);
        deque.pushLeft(1);
        deque.pushRight(6);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
        System.out.println("Item count="+deque.itemCount);
        for (int i = 0; !deque.isEmpty(); i++) {
            System.out.println("-----------------");
            if(i%2==0)
                deque.popLeft();
            else
                deque.popRight();
            for (Integer integer : deque) {
                System.out.println(integer);
            }
        }



    }
}
