package linkedList;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    class DoubleNode {
        Item item;
        Node next;
        Node prev;
    }

    class ListIterator implements Iterator<Item> {

        Node nextNode = first;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Item next() {
            Item item = nextNode.item;
            nextNode = nextNode.next;
            return item;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public void add(Item item) {
        Node node = new Node(item);
        if (size == 0) {
            first = node;
            last = first;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addToStart(Item item) {
        Node node = new Node(item);
        if (size == 0) {
            first = node;
            last = node;
        }else {
            node.next=first;
            first=node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeLastNode() {
        if (first != null)
            removeLastNode(first);
    }


    public void delete(int k) {
        if (k >= 0 && k < size) {
            if (k == 0) {
                first = first.next;
            } else {
                Node node = first;
                Node previous = first;
                for (int i = 0; i <= k; i++) {
                    if (i == k) {
                        previous.next = node.next;
                        if (node == last)
                            last = previous;
                    } else {
                        previous = node;
                        node = node.next;
                    }
                }
            }
            size--;
        }
    }

    private void removeLastNode(Node node) {
        if (node.next != null && node.next.next != null)
            removeLastNode(node.next);
        else {
            node.next = null;
            size--;
        }
    }


    public void removeAfter(Node node) {
        if (node != null && node.next != null) {
            if (node.next.next == null)
                last = node;
            node.next = node.next.next;
            size--;
        }
    }


    public void insertAfter(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            if (last == node1)
                last = node2;
            node2.next = node1.next;
            node1.next = node2;
            size++;
        }
    }

    public Node findLastNode(Node node) {
        Node nextNode = node;
        while (nextNode.next != null)
            nextNode = nextNode.next;
        return nextNode;
    }

    public void removeNodeWithItem(Item item) {
        if (first == null)
            return;
        Node node = first;
        Node previous = first;
        int n = size;
        for (int i = 0; i < n; i++) {
            if (node.item.equals(item)) {
                if (node == first)
                    first = first.next;
                if (node == last)
                    last = previous;
                previous.next = node.next;
                size--;
            }
            previous = node;
            node = node.next;
        }
    }

    public Node node(int k) {
        if (k >= 0 && k < size) {
            Node node = first;
            for (int i = 0; i < k; i++) {
                if (i == k)
                    return node;
                else
                    node = node.next;
            }
        }
        return null;
    }

    public Node node(Item item) {
        if (size > 0) {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (node.item.equals(item))
                    return node;
                else
                    node = node.next;
            }
        }
        return null;
    }

    public Node first() {
        return first;
    }

    public Item max(Node node) {
        Item max = node.item;
        while (node.next != null) {
            node = node.next;
            if (((Comparable) max).compareTo(node.item) < 0)
                max = node.item;
        }
        return max;
    }

    public Item maxRecursive(Node node) {
        Item max = node.item;
        if (node.next != null)
            max = maxRecursive(node.next, max);
        return max;
    }

    private Item maxRecursive(Node node, Item max) {
        if (((Comparable) node.item).compareTo(max) > 0)
            max = node.item;
        if (node.next != null)
            max = maxRecursive(node.next, max);
        return max;
    }

    public Node reverse(Node node) {
        Node reverse = null;
        Node first = node;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public void push(Item item) {

    }


    @Override
    public String toString() {
        Item[] items = (Item[]) new Object[size];
        Node nextNode = first;

        for (int i = 0; i < size; i++) {
            items[i] = nextNode.item;
            nextNode = nextNode.next;
        }
        String result = "";
        for (int i = 0; i < items.length; i++) {
            result += String.format("%s", items[i]);
        }
        return result;


    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Mikayil");
        list.add("Saida");
        list.add("Narmina");
        list.add("Nargiz");

        list.reverse(list.first());
        System.out.println(list);


    }

    private static boolean contains(LinkedList<String> list, String key) {
        for (String s : list) {
            if (s.equals(key))
                return true;
        }
        return false;
    }
}
