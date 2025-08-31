import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public class StackUsingQueue {
    public static void main(String ...args) {
        CustomStack<Integer> myStack = new CustomStack<>(new ConcurrentLinkedDeque<>());
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        myStack.print();
    }
}

class CustomStack<T> {
    private final Deque<T> doubleEndedQueue;

    public CustomStack(Deque<T> implementation) {
        this.doubleEndedQueue = implementation;
    }

    public void push(T element) {
        doubleEndedQueue.push(element);
    }

    public T pop() {
        return doubleEndedQueue.pop();
    }

    public void print() {
        this.print(System.out::println);
    }

    public void print(Consumer<T> logger) {
        doubleEndedQueue.forEach(logger);
    }
}
