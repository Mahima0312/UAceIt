
public class Lecture9b {
	
	//properties
	private int[] array;
	private int front;
	private int size;


	//constructor
	public Lecture9b() {
		array= new int[5];
		front=0;
		size=0;
			
	}

	public Lecture9b(int capacity){
		array= new int[capacity];
		front=0;
		size=0;
		

	}
    public int size() {
    	return size;
		
	}

	public boolean isEmpty() {
		return size==0;
		
	}

	public boolean isFull() {
		
		return size== array.length;
		
	}


	public void enqueue(int item) throws Exception {
		
		if(isFull())
		{
			throw new Exception("Queue is Full!");
		}
		
		int index= (front+size)% array.length;
		//alternatively, if you dont want to save space index= size;
		array[index]=item;
		size++;
	}

	public int dequeue() throws Exception {
		
		if(isEmpty())
			throw new Exception("Queue is Empty!");
		
		int value= array[front];
	
		array[front]=0;
		size--;
		front= (front+1)%array.length;
		//alt : front++;
		return value;
		
		
	}

	public int getfront() throws Exception{
		if(isEmpty())
			throw new Exception("Queue is Empty!");
		
		int value= array[front];
	
		return value;
		
		
		
	}

	
	public void display() {
		
		//7 8 3 4 5 6
		//i=4
		//f= 2
		//3 4 5 6 7 8
		
		for(int i=0;i<size;i++)
		{
			int index= (i+front)%array.length;
			System.out.print(array[index]+" ");
		}
		System.out.println();
		
	}


}
