import java.util.ArrayList;
public class Queue{
   ArrayList<Integer> queue;
   public Queue(){
      queue = new ArrayList();
   }
   public void enqueue(int value){
      queue.add(value);
	  System.out.println("Enqueued:" +value);
   }
   public void dequeue(){
      if(queue.isEmpty()){
		 System.out.println("Queue is empty!");		
	  }
	  int value = queue.remove(0);
	  System.out.println("Dequeued:"+value);
   }
   public int peek(){
      if(queue.isEmpty()){	
        System.out.println("Queue is empty");	  	
	  }
	  return queue.get(0);
   }
   public void display(){
      System.out.println("Queue:"+queue);
   }
}
