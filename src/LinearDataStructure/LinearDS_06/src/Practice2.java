package LinearDataStructure.LinearDS_06.src;// Practice2
// 배열을 이용한 기본 스택 직접 구현

import java.util.Arrays;

class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (top == arr.length - 1) {
            return true;
        }

        return false;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }

        top++;
        arr[top] = data;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = arr[top];
        top--;

        return data;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        return arr[top];
    }

    public void printStack() {
        System.out.print("[");
        for (int i = 0; i < top; ) {
            System.out.print(arr[i] + ", ");
            if (++i > top - 1) {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyStack2 myStack = new MyStack2(5);
        myStack.isEmpty();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.printStack();               // 1, 2, 3, 4, 5

        System.out.println(myStack.peek()); // 5
        myStack.printStack();               // 1, 2, 3, 4, 5

        System.out.println(myStack.pop());  // 5
        System.out.println(myStack.pop());  // 4
        myStack.printStack();               // 1, 2, 3

        System.out.println(myStack.pop());  // 3
        System.out.println(myStack.pop());  // 2
        System.out.println(myStack.pop());  // 1
        myStack.printStack();
    }
}
