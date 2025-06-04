public class QueueMain{
   public static void main(String[] args){
      Queue q = new Queue();
	  q.enqueue(11);
	  q.enqueue(22);
	  q.enqueue(33);
	  q.enqueue(44);
	  q.enqueue(55);
	  q.display();
	  q.dequeue();
	  q.dequeue();
	  q.display();
	  System.out.println("The first element of Queue is:"+q.peek());
   }
}