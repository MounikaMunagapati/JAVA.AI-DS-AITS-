import java.util.Stack;
class MaxStack{
	Stack<Integer> stack;
	Stack<Integer> maxStack;
	MaxStack(){
		stack =  new Stack<>();
		maxStack = new Stack<>();
	}
	void push(int value){
		stack.push(value);
		if(maxStack.isEmpty()||value>=maxStack.peek()){
			maxStack.push(value);
		}else{
			maxStack.push(maxStack.peek());
	   }
	   System.out.println("Stack: "+stack);
	   System.out.println("MaxStack: "+maxStack);
	}
	void pop(){
		stack.pop();
		maxStack.pop();
		System.out.println("Stack: "+stack);
	   System.out.println("MaxStack: "+maxStack);
	}
	int top(){
		return stack.peek();
	}
	int getMax(){
		return maxStack.peek();
	}
}