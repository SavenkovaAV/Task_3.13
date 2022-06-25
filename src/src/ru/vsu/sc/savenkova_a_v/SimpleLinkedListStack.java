package src.ru.vsu.sc.savenkova_a_v;

public class SimpleLinkedListStack<T> extends SimpleLinkedList<T> {

    public void push(T value) {
        this.addFirst(value);
    }


    public T pop() throws Exception {
        T result = this.peek();
        this.removeFirst();
        return result;
    }


    public T peek() throws Exception {
        if (this.empty()) {
            throw new Exception("Stack is empty");
        }
        return this.getFirst();
    }


    public int count() {
        return super.size();
    }


    public boolean empty() {
        return this.count() == 0;
    }


}
