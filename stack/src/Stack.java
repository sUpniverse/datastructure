public class Stack {

    private Object[] objects;
    private int size;
    private int front;

    public Stack(int size) {
        this.size = size;
        this.front = 0;
        this.objects = new Object[size];
    }

    public Stack() {
        this(10);
    }

    public void push(Object object) {
        if(front >= size-1) {
            throw new StackOverflowError();
        }
        objects[front++] = object;
        System.out.println("Push Data : " + object.toString());
    }

    public Object pop() {
        Object object = peek();
        objects[--front] = null;
        System.out.println("Pop Data : " + object.toString());
        return object;
    }

    public Object peek(){
        if(isEmpty()) {
            throw new NullPointerException();
        }
        return objects[front-1];
    }

    public boolean isEmpty(){
        return this.front <= 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("A");
        stack.push("B");
        stack.push("C");



        stack.pop();
        stack.pop();
        stack.pop();

    }

}
