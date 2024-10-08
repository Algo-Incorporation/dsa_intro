public class Stack {
    int size;
    int[] stackArr;
    int topElement;

    public Stack(int size) {
        this.size = size;
        stackArr = new int[size]; 
        topElement = -1;
    }

    public void push(int value) {
        if (topElement == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArr[++topElement] = value;
        System.out.println(value + " pushed into the stack");

    }

    public void pop() {

    }

    public void top() {

    }

    public void isEmpty() {

    }
} 

