// 1. Reverse a queue
// n+n time n space

package queue_problems;

import java.util.Stack;

public class QueueReversal {
    private Node front, rear;
    private int size;

    public QueueReversal() {
        front = rear = null;
        size = 0;
    }

    public static void main(String[] args) throws Exception {
        QueueReversal qr = new QueueReversal();
        qr.enqueue(1);
        qr.enqueue(2);
        qr.enqueue(3);
        qr.enqueue(4);
        qr.enqueue(5);
        System.out.println(qr.toString());
        qr = reverseQueue(qr);
        System.out.println(qr.toString());
    }

    // Reverse the linked list using stack
    public static QueueReversal reverseQueue(QueueReversal qr) throws Exception {
        if (qr == null)
            return null;

        Stack<Integer> stack = new Stack<Integer>();
        while (!qr.isEmpty())
            stack.push(qr.dequeue());
        while (!stack.empty())
            qr.enqueue(stack.pop());

        return qr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if (isEmpty())
            front = node;
        else
            rear.next = node;
        rear = node;
        size++;
    }

    public int dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty! ");
        int data = front.data;
        front = front.next;
        System.gc();
        size--;
        return data;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";
        StringBuilder strb = new StringBuilder("[ ");
        Node temp = front;
        while (temp != null) {
            strb.append(temp.data + " ");
            temp = temp.next;
        }
        return strb.append("]").toString();
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
