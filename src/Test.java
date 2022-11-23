import Questions.Question5_arrayQueue;

public final class Test {

    public static void main(String[] args) {
        var queue = new Question5_arrayQueue(5, true);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.printf("Queue's values: %s\n", queue);
        System.out.printf("Dequeued value: %s\n", queue.dequeue());
        System.out.printf("Queue's values: %s\n", queue);
        System.out.printf("Queue's front value: %s\n", queue.Front());
        System.out.printf("Queue's size: %s\n", queue.Size());
        System.out.printf("Queue's is empty: %s\n", queue.isEmpty());
    }
}