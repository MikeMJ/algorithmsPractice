package linkedList;

public class GeneralizedQueue<T> {
    int itemCount;
    Node first;
    Node last;

    class Node {
        T item;
        Node next;

        Node(T item) {
            this.item = item;
        }
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public GeneralizedQueue() {
        super();
    }

    public void insert(T item) {
        Node node = new Node(item);
        if (itemCount == 0)
            first = node;
        else
            last.next = node;
        last = node;
        itemCount++;
    }

    public T delete(int k) {
        if (k > itemCount)
            throw new RuntimeException("Index out of bounds");
        Node node = first;
        Node previous=null;
        for (int i = 0; i < itemCount - k; i++) {
            previous=node;
            node = node.next;
        }
        if(previous!=null)
            previous.next=node.next;
        itemCount--;
        return node.item;
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> q=new GeneralizedQueue<Integer>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        System.out.println(q.delete(3));
        System.out.println(q.delete(4));
        q.insert(7);
        System.out.println(q.delete(2));



    }
}
