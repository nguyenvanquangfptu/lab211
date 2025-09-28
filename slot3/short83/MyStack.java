package com.mycompany.lab211.slot3.short83;

class MyStack {

    private int[] stackValues; // mảng chứa dữ liệu
    private int top;           // vị trí đỉnh stack
    private int capacity;      // sức chứa tối đa của stack

    // Constructor
    public MyStack(int capacity) {
        this.capacity = capacity;
        stackValues = new int[capacity];
        top = -1; // stack rỗng
    }

    // Hàm mở rộng dung lượng (gấp đôi)
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newStack = new int[newCapacity];

        // copy dữ liệu cũ sang mảng mới
        for (int i = 0; i < capacity; i++) {
            newStack[i] = stackValues[i];
        }

        stackValues = newStack;
        capacity = newCapacity;
    }

    // push(): thêm phần tử vào stack
    public void push(int value) {
        if (top == capacity - 1) {
            resize(); // nếu đầy thì tự động mở rộng
        }
        top++;
        stackValues[top] = value;
        System.out.println("Pushed: " + value);
    }

    // pop(): lấy phần tử ra khỏi stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot pop");
            return -1;
        }
        int value = stackValues[top];
        top--;
        System.out.println("Popped: " + value);
        return value;
    }

    // get(): xem phần tử ở đỉnh stack (không xóa)
    public int get() {
        if (top == -1) {
            System.out.println("Stack is empty! No top element");
            return -1;
        }
        return stackValues[top];
    }

    // In stack từ dưới lên
    public void printStack() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackValues[i] + " ");
        }
        System.out.println();
    }
}
