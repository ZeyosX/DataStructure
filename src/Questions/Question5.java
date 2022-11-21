package Questions;

//Array based queue
public final class Question5 {
    private int[] queue;
    private int front;
    private int back;
    private int size;
    private final boolean enLargeArrayWhenFull;

    public Question5(int size, boolean enLargeArrayWhenFull) {
        queue = new int[size];
        front = 0;
        back = 0;
        this.size = size;
        this.enLargeArrayWhenFull = enLargeArrayWhenFull;
    }

    public synchronized void enqueue(int value) {
        if (back == size) {
            if (enLargeArrayWhenFull) {
                enLargeArray();
            } else {
                throw new IllegalStateException("Queue is full");
            }
        }
        queue[back] = value;
        back++;
        size++;
    }

    private void enLargeArray() {
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
