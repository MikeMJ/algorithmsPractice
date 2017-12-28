package ResizingArray;

public class RingBuffer<T> {

    T[] array;
    int itemCount;
    int first;
    int last;

    public RingBuffer(int size) {
        this.array = (T[]) new Object[size];
    }

    public void enque(T item) {
        if (itemCount > 0)
            last = (last + 1) % array.length;
        array[last] = item;
        if (++itemCount > array.length) {
            itemCount = array.length;
            first = (first + 1) % array.length;
        }
    }

    public T dequeue() {
        if (itemCount == 0)
            throw new RuntimeException("No item in the list");
        T item = array[first];
        array[first] = null;
        first = (first + 1) % array.length;
        if (--itemCount == 0) {
            last = 0;
            first=0;
        }

        return item;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<Integer>(5);
        buffer.enque(1);
        buffer.enque(2);
        buffer.enque(3);
        buffer.enque(4);
        buffer.enque(5);
        buffer.enque(6);
        buffer.enque(7);
        System.out.println(buffer.dequeue());
        System.out.println(buffer.dequeue());
        System.out.println(buffer.dequeue());
        System.out.println(buffer.dequeue());
        //System.out.println(buffer.dequeue());
        buffer.enque(8);
        System.out.println(buffer.dequeue());


    }
}
