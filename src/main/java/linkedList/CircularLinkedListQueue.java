package linkedList;

public class CircularLinkedListQueue<Item> {
    class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    Node last;
    int size;

    public void enqueue(Item item) {
        Node node = new Node(item);
        if (size == 0) {
            last = node;
            last.next = last;
        } else {
            Node first = last.next;
            last.next = node;
            last = node;
            last.next = first;
        }
        size++;
    }

    public Item dequeue() {
        if (size == 0)
            throw new RuntimeException("No item in the queue");
        Node first = last.next;
        last.next = first.next;
        size--;
        if (size == 0)
            last = null;
        return first.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CircularLinkedListQueue<String> queue = new CircularLinkedListQueue<String>();
        queue.enqueue("Mikayil");
        queue.enqueue("Saida");
        queue.enqueue("Narmina");
        queue.enqueue("Nargiz");
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}
