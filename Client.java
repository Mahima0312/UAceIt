import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
//		Lecture8 linkedlist= new Lecture8();
//		//size
//		linkedlist.addAtLast(2);
//		linkedlist.addAtFront(3);
//		linkedlist.addAtLast(4);
//		linkedlist.addAtLast(5);
//		linkedlist.addAtLast(6);
//		linkedlist.addAtLast(7);
//		linkedlist.addAtLast(8);
//		linkedlist.addAtLast(9);
//		//size
//		System.out.println(linkedlist.findkthFromLast(2));
		//3 2 4 5 6 7
		//0 1 2 3 4 5
		//5/2: 2
		
//		if(n>0)
//		{
//			n=2
//		}else {
//			n=4
//			
//		}
//		
//		n= (n>0)? 2 : 4;
//		int data= linkedlist.removeAtLast();
//		System.out.println(data);
//		linkedlist.display();
//		System.out.println();
//		linkedlist.reversePointer();
//		System.out.println();
//		linkedlist.display();
//		System.out.println(linkedlist.findMiddle());
		
		
		//Stack
		
//		Lecture9a stack= new Lecture9a(10);
//		System.out.println(stack.size());
//		stack.push(4);
//		stack.push(5);
//		stack.push(6);
//		stack.push(7);
//		stack.pop(); //7
//		stack.pop();  //6
//		stack.display();
//		stack.pop();
//		stack.display();
////		System.out.println(stack.size());
//		
//		Lecture9b queue = new Lecture9b(6);
//		queue.enqueue(1);
//		queue.enqueue(2);
//		queue.enqueue(3);
//		queue.enqueue(4);
//		queue.enqueue(5);
//		queue.enqueue(6);
//		queue.display();
//		queue.dequeue();
//		queue.dequeue();
//		queue.display();
//		queue.enqueue(7);
//		queue.enqueue(8);
//		queue.display();
//		
//		
		
		
		//Stack & Queue
		
		Stack<Integer> stack= new Stack<>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.pop(); //6
		stack.pop(); //5
		
		
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
			//4 3 2
		}
		
		Queue<Integer> queue= new LinkedList<>();
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.remove(); //2
		queue.remove(); //3
		
		
		while(!queue.isEmpty())
			System.out.print(queue.remove()+" ");
	  // 4 5 6 7

		
	}


}
