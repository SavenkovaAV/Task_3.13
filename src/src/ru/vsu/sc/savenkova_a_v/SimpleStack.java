package src.ru.vsu.sc.savenkova_a_v;

import java.util.EmptyStackException;
import java.util.Stack;

public class SimpleStack<T> extends Stack<T> {
    int length = 0;
    Node<T> top = null;

    private class Node<T> {

        private T data;
        private Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T push(T data) {
        Node<T> tempNode = new Node<T>(data);
        tempNode.setNextNode(top);
        top = tempNode;
        length++;

        return top.getData();
    }

    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }

        Node<T> node = top;
        top = top.getNextNode();
        length--;

        return node.getData();
    }
}
