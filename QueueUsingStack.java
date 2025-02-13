import java.util.Stack;

public class QueueUsingStack {
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public void insert(int element) {
        stack1.push(element);
    }

    public int remove() throws Exception {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new Exception("Stack is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        QueueUsingStack queue = new QueueUsingStack();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        System.out.println(queue.remove());
        queue.insert(4);
        queue.insert(5);
        System.out.println(queue.remove());
        ;
    }
}
