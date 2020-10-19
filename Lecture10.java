import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lecture10 {
	public static void main(String[] args) {
		
		Stack<Integer> stack= new Stack<>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		//5 4 3 2 
//		print(stack);
		
		Stack<Integer> result= reverse(stack);
	
//		print(result);
		
		//2 3 4 5
		
		Queue<Integer> q= new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
//		print2(q);
		
		
		print2(q);
		
		reverse2(q);
		
		print2(q);
		
		
		//displaying without popping
//		System.out.println(isBalanced("[((())(())(()(((((({{{{{{{{{)(){}]"));
			
		}
	
	//If you want to implement Queue using an ArrayList, while enqueuing just do list.add(item)(i.e addition at rear) 
	//and while dequeing just return list.remove(0) which will give removed element from index 0(removal at front)
	
	//Queue can also be implemented using following syntax:
//	 Queue<Integer> q= new ArrayDeque<>(); (implements a deque using arraylist)
	
	public static Stack<Integer> reverse(Stack<Integer> stack)
	{
		Stack<Integer> helper= new Stack<>();
		while(!stack.isEmpty())
		{
			int val= stack.pop();
			helper.push(val);
		}
		return helper;
		
	}
	public static void reverse2(Queue<Integer> q)
	{
		Stack<Integer> helper= new Stack<>();
		while(!q.isEmpty())
		{
			helper.push(q.remove());
			
		}
		while(!helper.isEmpty())
		{
			q.add(helper.pop());
		}
		
	}
	
	public static void rotate(Queue<Integer> q, int d)
	{
		if(d<0)
			d+=q.size();
	
		if(d>q.size())
			d=d%q.size();
		for(int i=0;i<d;i++)
		{
			q.add(q.remove());
		}
	}
	
		
	public static boolean isBalanced(String str){
		
		Stack<Character> stack= new Stack<>();
		//()A
		for(int i=0;i<str.length();i++)
		{
			char ch= str.charAt(i);
			//opening
			if(ch == '(' || ch== '{'|| ch== '[')
				stack.push(ch);
			//closing
			else {
				
				if(ch==')')
				{
					if(!stack.isEmpty() && stack.peek()=='(')
						stack.pop();
					else
					return false;
				}
				else if(ch=='}')
				{
					if(!stack.isEmpty() && stack.peek()=='{')
						stack.pop();
					else
						return false;
					
				}else if(ch==']')
				{
					if(!stack.isEmpty() && stack.peek()=='[')
						
						stack.pop();
					else
						return false;
				}
				else
					return false;
				
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
		
		
	}


	public static int[] nge(int[] arr)
	{
		//10 40 2 3 45 15
		//0  1  2 3  4 5
		//1  4   3 4 -1 -1
		
		
		//answer array should be : 40 45 3 45 -1 -1
		
		//stack: 4 5
		
		int[] ans= new int[arr.length];
		Stack<Integer> stack= new Stack<>();
		
		for(int i=0;i<arr.length;i++)
		{
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i])
			{
				ans[stack.peek()]=i;
				stack.pop();
			}
			//45
			
			
			stack.push(i);
		}
		
		//those which do not nge
		while(!stack.isEmpty())
			ans[stack.pop()]=-1;
		
		//answer array has indexes of nges
		//1  4   3 4 -1 -1
		for(int i=0;i<ans.length;i++)
		{
			if(ans[i]!=-1)
			System.out.print(arr[ans[i]]+" ");
			else
				System.out.print(-1+" ");
		}
		
		return ans;
		
		
		
	}
	//printing stack from top to bottom without emptying stack
	
	public static void print(Stack<Integer> stack)
	{
		
		Stack<Integer> helper= new Stack<>();
		while(!stack.isEmpty())
		{
			System.out.print(stack.peek()+" ");
			helper.push(stack.pop());
		}
		while(!helper.isEmpty())
			stack.push(helper.pop());
		System.out.println();
	}
	//printing queue from left to right without emptying it
	
	public static void print2(Queue<Integer> q)
	{
		
		Queue<Integer> helper= new LinkedList<>();
		while(!q.isEmpty())
		{
			System.out.print(q.peek()+" ");
			helper.add(q.remove());
		}
		while(!helper.isEmpty())
			q.add(helper.remove());
		System.out.println();
	}
	

}
