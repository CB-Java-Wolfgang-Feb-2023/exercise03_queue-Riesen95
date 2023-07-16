public class MyQueue {
    private final int maxSize;
    private final int[] queueArray;
    private final int frontIndex;
    private int rearIndex;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        frontIndex = 0;
        rearIndex = -1;
    }

    public boolean isFull() {
        return rearIndex == maxSize - 1;
    }

    public boolean isEmpty() {
        return rearIndex == -1;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        queueArray[++rearIndex] = element;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int temp = queueArray[frontIndex];

        System.arraycopy(queueArray, 1, queueArray, 0, rearIndex--);

        return temp;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return queueArray[frontIndex];
    }

    public int getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return queueArray[rearIndex];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "MyQueue is empty";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("MyQueue elements from front to rear: ");

        for (int i = frontIndex; i <= rearIndex; i++) {
            sb.append(queueArray[i]);

            if (i < rearIndex) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
