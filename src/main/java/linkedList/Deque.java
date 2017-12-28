package linkedList;

import java.util.Iterator;

public class Deque<T> implements Iterable<T> {

    DoubleNode first;
    DoubleNode last;
    int size;

    class DoubleNode {
        T item;
        DoubleNode next;
        DoubleNode prev;

        DoubleNode(T item) {
            this.item = item;
        }
    }

    @Override
    public Iterator iterator() {
        return new DequeIterator();
    }

    class DequeIterator implements Iterator<T> {
        DoubleNode nextNode = last;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T item = nextNode.item;
            nextNode = nextNode.prev;
            return item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushLeft(T item) {
        DoubleNode node = new DoubleNode(item);
        if (size == 0) {
            last = node;
        } else {
            first.prev = node;
            node.next = first;
        }
        first = node;
        size++;
    }

    public void pushRight(T item) {
        DoubleNode node = new DoubleNode(item);
        if (size == 0) {
            first = node;
        } else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        size++;
    }

    public T popLeft() {
        if (size == 0) throw new RuntimeException("No item in the list");
        T item=first.item;
        if(size==1){
            first=null;
            last=null;
        }else {
            first=first.next;
            first.prev=null;
        }
        size--;
        return item;
    }

    public T popRight() {
        if (size == 0) throw new RuntimeException("No item in the list");
        T item=last.item;
        if(size==1){
            first=null;
            last=null;
        }else {
            last=last.prev;
            last.next=null;
        }
        size--;
        return item;
    }


    public static void main(String[] args) {
        Deque<Integer> list = new Deque<Integer>();
        list.pushLeft(3);
        list.pushRight(4);
        list.pushLeft(2);
        list.pushRight(5);
        list.pushLeft(1);
        list.pushRight(6);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------------");
        list.popLeft();
        list.popRight();
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
