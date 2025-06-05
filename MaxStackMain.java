class MaxStackMain{
	public static void main(String[] args){
		MaxStack ms = new MaxStack();
		ms.push(1);
		ms.push(4);
		ms.push(3);
		ms.pop();
		System.out.println("Top:"+ms.top());
		System.out.println("Max Element:"+ms.getMax());
	}
}
		