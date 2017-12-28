package ResizingArray;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Iterator;

public class RandomQueue<T> implements Iterable<T> {

    private int itemCount;
    private T[] array;
    private int last;

    public RandomQueue() {
        this.array = (T[]) new Object[1];
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomQueueIterator();
    }

    class RandomQueueIterator implements Iterator<T> {

        int leftForIteration=itemCount;

        @Override
        public boolean hasNext() {
            return leftForIteration>0;
        }

        @Override
        public T next() {
            int index=leftForIteration>1?StdRandom.uniform(0,leftForIteration-1):0;
            T temp=array[index];
            array[index]=array[--leftForIteration];
            return temp;
        }
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public void enqueue(T item) {
        if (itemCount++ > 0)
            last++;
        array[last] = item;
        if (itemCount == array.length)
            resize(array.length * 2);
    }

    public T dequeue() {
        if (itemCount == 0)
            throw new RuntimeException("No item in the list");
        int randomIndex = StdRandom.uniform(0,itemCount-1);
        T temp = array[randomIndex];
        array[randomIndex] = array[last];
        itemCount--;
        array[last]=null;
        last=itemCount-1;
        if(itemCount>0&&itemCount==array.length/4)
            resize(array.length/2);
        return temp;
    }

    public T sample() {
        if (itemCount == 0)
            throw new RuntimeException("No item in the list");
        int randomIndex = StdRandom.uniform(0,itemCount-1);
        return array[randomIndex];
    }




    private void resize(int toSize) {
        T[] newArray = (T[]) new Object[toSize];
        for (int i = 0; i < itemCount; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            RandomQueue<String> queue=new RandomQueue<String>();
            queue.enqueue("Mikayil");
            queue.enqueue("Saida");
            queue.enqueue("Narmina");
            queue.enqueue("Nargiz");
            queue.enqueue("Cavanshir");
            queue.enqueue("Firqet");
            queue.enqueue("Ramazan");
            queue.enqueue("Elnur");

            for (String s : queue) {
                System.out.println(s);
            }
            System.out.println("--------------------");
//
//            System.out.println(queue.sample());
//            System.out.println(queue.sample());
//            System.out.println(queue.sample());
//            System.out.println(queue.sample());
//            System.out.println("--------------------");
        }


    }


}
