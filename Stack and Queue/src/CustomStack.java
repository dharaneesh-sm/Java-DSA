public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }
    int ptr = -1;

    public boolean push(int value) {
        if(stackOverflow())
        {
            System.out.println("Stack Overflow");
            return false;
        }
        ptr++;
        data[ptr] = value;
        return true;
    }
    public boolean stackOverflow() {
        return ptr == (data.length - 1);
    }

    public int pop() throws StackException {
        if(stackUnderflow()) {
            throw new StackException("Stack Underflow, Stack is Empty!");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }
    public boolean stackUnderflow() {
        return ptr == -1;
    }

    public int peek() throws StackException{
        if(stackUnderflow()) {
            throw new StackException("Stack Underflow, Stack is Empty! Cannot Peek an Element");
        }
        return data[ptr];
    }
}
