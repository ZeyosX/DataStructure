package Questions;

public final class StackInteger {

    private int[] stack;
    private int top;
    private int size;
    private final boolean enLargeWhenFull;

    public StackInteger(int size, boolean enLargeWhenFull) {
        this.size = size;
        stack = new int[size];
        top = -1;
        this.enLargeWhenFull = enLargeWhenFull;
    }

    public synchronized void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        } else {
            if (enLargeWhenFull && isFull()) {
                enLargeArray();
            }
            stack[++top] = value;
        }
    }

    private void enLargeArray() {
        var newStack = new int[size * 2];
        for (var i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        size *= 2;
    }

    public synchronized int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            return stack[top--];
        }
    }

    public synchronized int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public String toString() {
        var stringBuilder = new StringBuilder();
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            for (var i = top; i >= 0; i--) {
                stringBuilder.append(stack[i]);
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }
    }


}
