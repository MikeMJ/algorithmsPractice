package linkedList;

import java.util.Iterator;

public class BufferWithStack implements Iterable<Character>{

    Stack<Character> mainStack = new Stack<Character>();
    Stack<Character> secondStack = new Stack<Character>();
    int itemCount;

    public void insert(char c) {
        itemCount++;
        mainStack.push(c);
    }

    public char delete() {
        itemCount--;
        return mainStack.pop();
    }

    public void left(int k) {
        while (!mainStack.isEmpty() && k > 0) {
            secondStack.push(mainStack.pop());
        }
    }

    public void right(int k) {
        while (!secondStack.isEmpty() && k > 0)
            mainStack.push(secondStack.pop());
    }

    public int size() {
        return mainStack.size();
    }

    public static void main(String[] args) {
        BufferWithStack buffer = new BufferWithStack();
        buffer.insert('M');
        buffer.insert('k');
        buffer.insert('a');
        buffer.insert('y');
        buffer.insert('i');
        buffer.insert('l');
        buffer.left(5);
        buffer.insert('i');
        System.out.println(buffer.toString());
    }

    @Override
    public Iterator<Character> iterator() {
        return null;
    }

    class BufferWithStackIterator implements Iterator<Character>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Character next() {
            return null;
        }
    }
}
