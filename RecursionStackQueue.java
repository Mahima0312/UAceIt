import java.util.Queue;
import java.util.Stack;

public class RecursionStackQueue {
	
	public static void main(String[] args) {
		
		//Test codes here
		
	}
	
	//Reversing a stack from lines 11- 39
	public static void reverseStack(Stack<Integer> stack){

	        if(stack.isEmpty()==false){

	            //pop out all the items from the stack and store it in function stack
	            int x = stack.pop();
	            reverseStack(stack);

	            //now insert the items into stack in reversed order
	            //last item popped from the stack
	            insert_at_bottom(stack, x);
	        }
	    }

	 public static void insert_at_bottom(Stack<Integer> stack, int x){

	        //check if stack is empty
	        if(stack.isEmpty()){
	            stack.push(x);
	            return;
	        }
	        //take out the existing items in stack and keep it in function stack
	        int y = stack.pop();
	        //push x to the bottom
	        insert_at_bottom(stack, x);

	        //push back all the items from function stack to stack
	        stack.push(y);
	    }

	    //Reversing a queue from lines 42-59
	 public static Queue<Integer> reverseQueue(Queue<Integer> q) 
	    { 
	        // Base case 
	        if (q.isEmpty()) 
	            return q; 
	      
	        // Dequeue current item (from front)   
	        int data = q.peek(); 
	        q.remove(); 
	      
	        // Reverse remaining queue   
	        q = reverseQueue(q); 
	      
	        // Enqueue current item (to rear)   
	        q.add(data); 
	              
	        return q; 
	    } 
	 public static Stack<Integer> sortingStack(Stack<Integer> original) {

	        if(original.size()>0){

	            ////pop out all the items from the stack and store it in function stack
	            int x = original.pop();
	            sortingStack(original);

	            //now insert the items into stack in sorted order
	            sortHelp(original, x);
	        }

	        return original;
	    }

	 public static void sortHelp(Stack<Integer> stack, int x){

	        //if stack is empty OR top of stack element is greater than the element x
	        //push item to stack, this will maintain the sorted order.
	        if(stack.size()==0 || stack.peek()>x){
	            stack.push(x);
	            return;
	        }
	        //if here means insertion of new element is breaking the sorted order,
	        //so pop it out for so that element x can be pushed to its right position

	        int y = stack.pop();
	        sortHelp(stack, x);

	        //once element x is placed then push y back to stack
	        stack.push(y);
	    }
	  
}
