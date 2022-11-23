package Questions;

public final class StackCharacter {
    private char[] stack;
    private int top;
    private int size;
    private final boolean enlargeWhenFull;

    public StackCharacter(int size, boolean enlargeWhenFull) {
        this.size = size;
        stack = new char[size];
        top = -1;
        this.enlargeWhenFull = enlargeWhenFull;
    }

    public synchronized void push(char value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        } else {
            if (enlargeWhenFull && isFull()) {
                enLargeArray();
            }
            stack[++top] = value;
        }
    }

    private void enLargeArray() {
        var newStack = new char[size * 2];
        for (var i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        size *= 2;
    }

    public synchronized char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            return stack[top--];
        }
    }

    public synchronized char peek() {
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
