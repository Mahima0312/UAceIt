
public class Lecture9a {
	//properties
	private int[] array;
	private int tos;
	
// 9
	//0-8
	//9

	//constructor
	

	public Lecture9a() {
		array= new int[5];
		tos=-1;
		
	}

	public Lecture9a(int capacity) {
		array= new int[capacity];
		tos=-1;
		
	}
	public int size()
	{
		//tos= tos+1;
		
		return tos+1;
		
	}
	public boolean isFull()
	{
		return size()==array.length;
	}
	
	public boolean isEmpty()
	{
		return size()==0;
		
	}

	public void push(int item) throws Exception {
		
		if(isFull())
			throw new Exception("Stack is Full!");
		
		tos++;
		array[tos]= item;
		

	}

	public int pop() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is Empty!");
		
		//fetching
		int value= array[tos];
		
		//removing
		array[tos]=0;
		tos--;
		
		return value;
		
	

	}

	public int peek() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is Empty!");
		
		int value= array[tos];
		
		
		return value;
		
		
	}


	public void display() {
		
		for(int i=tos;i>=0;i--)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
	}

}
