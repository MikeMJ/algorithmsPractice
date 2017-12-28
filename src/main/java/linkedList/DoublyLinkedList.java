package linkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new DoubleListIterator();
    }

    class DoubleListIterator implements Iterator<T> {
        DoubleNode nextNode = first;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T item = nextNode.item;
            nextNode = nextNode.next;
            return item;
        }
    }

    class DoubleNode {
        T item;
        DoubleNode next;
        DoubleNode prev;

        DoubleNode(T item) {
            this.item = item;
        }
    }

    int size;
    DoubleNode first;
    DoubleNode last;

    public boolean isEmpty() {
        return size == 0;
    }

    public void prepend(T item) {
        DoubleNode node = new DoubleNode(item);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
        }
        size++;
    }

    public void append(T item) {
        DoubleNode node = new DoubleNode(item);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    public void removeFromHead() {
        if (size == 0)
            return;
        if (size > 1)
            first.next.prev = null;
        first = first.next;
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
    }

    public void removeFromTail() {
        if (size == 0)
            return;
        if (size > 1)
            last.prev.next = null;
        last = last.prev;
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
    }

    public T previousOf(T item) {
        DoubleNode node = first;
        while (node != null) {
            if (node.item.equals(item) && node.prev != null) {
                return node.prev.item;
            }
            node = node.next;
        }
        return null;
    }

    public T nextTo(T item) {
        DoubleNode node = last;
        while (node != null) {
            if (node.item.equals(item) && node.next != null) {
                return node.next.item;
            }
            node = node.prev;
        }
        return null;
    }

    public void insertAfter(T item1, T item2) {
        DoubleNode currentNode = first;
        DoubleNode newNode = new DoubleNode(item2);
        while (currentNode != null) {
            if (currentNode.item.equals(item1)) {
                newNode.prev = currentNode;
                newNode.next = currentNode.next;
                if (last.equals(currentNode))
                    last = newNode;
                else
                    currentNode.next.prev=newNode;
                currentNode.next = newNode;
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void insertBefore(T item1, T item2) {
        DoubleNode currentNode = first;
        DoubleNode newNode = new DoubleNode(item2);
        while (currentNode != null) {
            if (currentNode.item.equals(item1)) {
                newNode.prev = currentNode.prev;
                newNode.next = currentNode;
                if (first.equals(currentNode))
                    first = newNode;
                else
                    currentNode.prev.next=newNode;
                currentNode.prev = newNode;
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void remove(T item){
        if(size==0)
            return;
        DoubleNode currentNode=first;
        while (currentNode!=null){
            if(currentNode.item.equals(item)){
                if(currentNode.next!=null)
                    currentNode.next.prev=currentNode.prev;
                if(currentNode.prev!=null)
                    currentNode.prev.next=currentNode.next;
                if(currentNode.equals(first))
                    first=first.next;
                if(currentNode.equals(last))
                    last=currentNode.prev;
                size--;
                return;
            }
            currentNode=currentNode.next;
        }
    }

    public DoubleNode getFirst() {
        return first;
    }

    public DoubleNode getLast() {
        return last;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<Integer>();
        ints.prepend(5);
        ints.prepend(4);
        ints.prepend(3);
        ints.prepend(2);
        ints.prepend(1);
        ints.prepend(0);
        ints.append(6);
        ints.append(7);
        ints.insertAfter(5,113);

        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
        ints.remove(113);
        System.out.println("-------------------------");
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
        ints.remove(0);
        System.out.println("-------------------------");
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }

        ints.remove(7);
        System.out.println("-------------------------");
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
        ints.remove(4);
        System.out.println("-------------------------");
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }


    }
}
