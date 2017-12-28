package linkedList;

import java.util.Iterator;

public class Steque<T> implements Iterable<T> {
    int size;
    Node first;
    Node last;

    class Node {
        T item;
        Node next;

        Node(T item) {
            this.item = item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StequeIterator();
    }

    class StequeIterator implements Iterator<T> {
        Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        Node node = new Node(item);
        if (size == 0)
            last = node;
        node.next = first;
        first = node;
        size++;
    }

    public T pop(){
        if(size==0)throw new RuntimeException("No item in the stack");
        T item=first.item;
        first=first.next;
        size--;
        return item;
    }

    public void enque(T item){
        Node node=new Node(item);
        if(size!=0)
            last.next=node;
        last=node;
        size++;
    }

    public static void main(String[] args) {
        Steque<Integer> steque=new Steque<Integer>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.push(4);
        steque.push(5);
        steque.push(6);
        steque.enque(7);
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());

    }
}
