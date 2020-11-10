public class Queue {

    private Object[] array;
    private int front;
    private int rear;
    private int size;


    public Queue(int size) {
        this.front = 0;
        this.rear = 0;
        this.size = size;
        this.array = new Object[size];
    }

    public Queue() {
        this(10);
    }

    public void enqueue(Object object){
        if(isFull()){
            throw new StackOverflowError();
        }
        array[rear++] = object;
        System.out.println("Enqueue Data :" + object.toString());
    }

    public Object dequeue() {
        if(isEmpty()){
            throw new StackOverflowError();
        }
        Object object = array[front];
        array[front++] = null;
        return object;
    }

    public boolean isEmpty() {
        if(front == rear){
            front = 0;
            rear = 0;
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if(front >= array.length-1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
