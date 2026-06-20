package Queue;

/*
front start pir hota ha and rear queue ka end pir
jab b push kry ga wo rear mai ho ga and jab pop kry ga wo front sa ho ga
 */
public class QueueImplUsingArray
{
    private int[] arr;
    int front, rear,capacity;

    public QueueImplUsingArray(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void add(int element)
    {
        if (arr.length == capacity - 1)
        {
            System.out.println("queue is full");
        }
        arr[++rear] = element;
    }

    public int remove()
    {
        if (front > rear)
        {
            System.out.println("queue is empty");
        }

        return arr[front--];
    }

    public int peek()
    {
        if (front > rear) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return arr[front];
    }

    public boolean isEmpty()
    {
        return front == rear;
    }

    public int size()
    {
        return rear + 1;
    }
    public void display()
    {
        if(front > rear)
        {
            System.out.println("Queue is empty!");
        }

        System.out.println("The elements in the queue are: ");
        for(int i= front;i<=rear;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImplUsingArray q = new QueueImplUsingArray(5);

        q.add(10);
        q.add(20);
        q.add(30);
        q.display(); // 10 20 30

        System.out.println("Dequeued: " + q.remove()); // 10
        q.display(); // 20 30

        System.out.println("Front element: " + q.peek()); // 20
    }
}
