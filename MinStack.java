import java.util.Stack;
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()||val<=minStack.peek()){
            minStack.push(val);
        }else{
            minStack.push(minStack.peek());
        }
    }
    
    void pop() {
            stack.pop();
            minStack.pop();
    }
    
    int top() {

            return stack.peek();
    }
    
    int getMin() {
            return minStack.peek();
    }
}
