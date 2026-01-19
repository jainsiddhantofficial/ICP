class Stack
{
        int[] stack;
        int top = -1;
        Stack(int size) {
            stack = new int[size];
        }
        void push(int x) {
            if (top == stack.length - 1) return;
            stack[++top] = x;
        }
        int pop() {
            if (top == -1) return -1;
            return stack[top--];
        }
        int peek() {
            if (top == -1) return -1;
            return stack[top];
        }
        boolean isEmpty() {
            return top == -1;
        }
}
