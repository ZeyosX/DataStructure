package Questions;

public final class Question5_arrayQueue {
    private int[] queue;
    private int front;
    private int back;
    private int size;
    private final boolean enlargeArrayWhenFull;

    public Question5_arrayQueue(int size, boolean enlargeArrayWhenFull) {
        if (size < 1) {
            throw new RuntimeException("Size must be greater than 0");
        }
        queue = new int[size];
        front = 0;
        back = 0;
        this.size = 0;
        this.enlargeArrayWhenFull = enlargeArrayWhenFull;
    }

    public synchronized void enqueue(int value) {
        if (front == back) {
            enqueueInternal(value);
        }
        if (isEmpty()) {
            if (enlargeArrayWhenFull) {
                enlargeArray();
            } else {
                throw new IllegalStateException("Queue is full");
            }
        }
        enqueueInternal(value);
    }

    private void enqueueInternal(int value) {
        queue[back] = value;
        back++;
        size++;
    }

    private void enlargeArray() {
        var temp = new int[size * 2];
        for (var i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    public synchronized int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        var value = queue[front];
        front++;
        size--;

        return value;
    }

    public int Size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int Front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public String toString() {
        var stringBuilder = new StringBuilder();
        for (int i = front; i < back; i++) {
            stringBuilder.append(queue[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
