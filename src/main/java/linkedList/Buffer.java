package linkedList;

import java.util.Iterator;

public class Buffer implements Iterable<Character>{

    Node activeNode;
    int itemCount;
    Node first;
    Node last;

    @Override
    public Iterator<Character> iterator() {
        return new BufferIterator();
    }

    class BufferIterator implements Iterator<Character>{
        Node nextNode=first;
        @Override
        public boolean hasNext() {
            return nextNode!=null;
        }

        @Override
        public Character next() {
            Character c=nextNode.value;
            nextNode=nextNode.next;
            return c;
        }
    }

    class Node {
        char value;
        Node next;
        Node prev;

        Node(char c) {
            this.value = c;
        }
    }


    public void insert(char c) {
        Node node = new Node(c);
        node.prev = activeNode;
        if (activeNode != null) {
            node.next = activeNode.next;
            activeNode.next = node;
        }
        activeNode = node;
        if (activeNode.prev == null)
            first = activeNode;
        if (activeNode.next == null)
            last = activeNode;
        itemCount++;
    }

    public char delete() {
        if (activeNode == null)
            throw new RuntimeException("No character at the cursor");
        char c = activeNode.value;
        if (activeNode.next != null)
            activeNode.next.prev = activeNode.prev;
        if (activeNode.prev != null)
            activeNode.prev.next = activeNode.next;
        if(activeNode.prev==null)
            first=activeNode.next;
        if(activeNode.next==null)
            last=activeNode.prev;
        activeNode = activeNode.prev;
        itemCount--;
        return c;
    }

    public void left(int k) {
        while (activeNode != null && k-- > 0) {
            activeNode = activeNode.prev;
        }
    }

    public void right(int k) {
        while (activeNode != null && k-- > 0) {
            activeNode = activeNode.next;
        }
    }

    public int size() {
        return itemCount;
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('M');
        buffer.insert('k');
        buffer.insert('a');
        buffer.insert('y');
        buffer.insert('i');
        buffer.insert('l');
        buffer.left(5);
        buffer.insert('i');
        buffer.right(5);
        buffer.insert(' ');
        buffer.insert('A');
        buffer.insert('b');
        buffer.insert('d');
        buffer.insert('u');
        buffer.insert('l');
        buffer.insert('l');
        buffer.insert('a');
        buffer.insert('h');
        buffer.left(8);
        buffer.insert('C');
        buffer.insert('a');
        buffer.insert('v');
        buffer.insert('a');
        buffer.insert('n');
        buffer.insert('s');
        buffer.insert('i');
        buffer.insert('r');
        buffer.insert(' ');
        System.out.println("|"+buffer.delete()+"|");
        System.out.println("|"+buffer.delete()+"|");
        buffer.left(13);
        System.out.println("|"+buffer.delete()+"|");
        for (Character character : buffer) {
            System.out.print(character);
        }

    }


}
