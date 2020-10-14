
public class Lecture8 {
	
	//linkedlist.addAtLast(1);

		private class Node{
			
			
			int value; // data 
			  
			Node next;//next node's address
		}
		
		Node head=null;
		Node tail=null;
	   int size=0;
	   
	   public void addAtLast(int data)
	   {
		   //create a new Node
		   
		   Node newNode= new Node();
		   newNode.value= data;
		   newNode.next=null;
		   	   
		   //if empty
		   if(isEmpty()) {
			   head=newNode;
			   tail=newNode;
		   }else {
		   //linking part
		   tail.next=newNode;
		   tail= tail.next;
		   }
		   size++;
		   
	   }
	   
	   public void addAtFront(int data)
	   {
	      //create a new Node
		   Node newNode= new Node();
		   newNode.value= data;
		   newNode.next=null;
		   
		   //linking part
		   
		   newNode.next= head;
		   
		   if(isEmpty())
			   tail=newNode;
		   head= newNode;
		   	   
		   size++;
		   
	   }
	   //1 2 3
	   //
	   
	   public Node getAtIndex(int i) throws Exception 
	   {
		   //Exception
		   if (isEmpty()) {
				throw new Exception("Linked List is Empty!");

			}
			if (i < 0 || i >= size) {
				throw new Exception("invalid index!");

			}
			   
		   
		   Node temp=head;
		   for(int j=1;j<=i;j++)
			   temp=temp.next;
		   
		   
		   return temp;
	   }
	   
	   public void addAtIndex(int i, int data) throws Exception
	   {
		   Node prev= getAtIndex(i-1);
		   Node me= getAtIndex(i);
		   
		   //create a new Node
		   Node newNode= new Node();
		   newNode.value= data;
		   newNode.next=null;
		   
		   //linking
		   prev.next= newNode;
		   newNode.next=me;
		   
		   size++;
		   
		   
		   
	   }
	   
	   public boolean isEmpty()
	   {
		   return size==0;
	   }
	   
	   public int size()
	   {
		   return size;
		   
//		   Node temp=head;
//		   while(temp!=null)
//		   {
//			   temp=temp.next;
//			   count++;
//		   }
//		   return count;
		   
		    
	   }
	   
	   public Node getFirst() throws Exception
	   {
		   if (isEmpty()) {
				throw new Exception("Linked List is Empty!");

			}
		   return head;
	   }
	   
	   public Node getLast() throws Exception
	   {
		   if (isEmpty()) {
				throw new Exception("Linked List is Empty!");

			}
		   return tail;
//		   Node temp=head;
//		   while(temp.next!=null)
//		   {
//			   temp=temp.next;
//			  
//		   }
//		   return temp;
		   
	   }
	   
	   public void display()
	   {
		   Node temp= head;
		   while(temp!=null)
		   {
			   System.out.print(temp.value+" ");
			   temp=temp.next;
			   
		   }
		   
		   
		   
	   }
	   
	   public int removeFirst() throws Exception 
	   {
		   if (isEmpty()) {
				throw new Exception("Linked List is Empty!");
			}
		   
		   int val= head.value;
		   //1
		   
		   if(size==1)
		   {
			   head=null;
			   tail=null;
			   size=0;
		   }
		   
		   head=head.next;
		   size--;
		   return val;
		   
	   }
	   
	   public int removeAtLast() throws Exception
	   {
		   if (isEmpty()) {
				throw new Exception("Linked List is Empty!");
			}
		  
		  
		   int val= tail.value;
		   if(size==1)
		   {
			   head=null;
			   tail=null;
			   size=0;
		   }else {
		   
		   Node secondLast= getAtIndex(size-2);
		   secondLast.next=null;
		   tail=secondLast;
		   size--;
		   }
		   
		   return  val;
		   
		  
		   
	   }
	   
	   public int removeAtIndex(int i) throws Exception
	   {
		   if (isEmpty()) {
				throw new Exception("Linked List is Empty!");

			}
			if (i < 0 || i >= size) {
				throw new Exception("Invalid Index");
			}
			
			if(i==0)
				return removeFirst();
			else if(i==size-1)
				return removeAtLast();
			else {
		   
		   Node prev= getAtIndex(i-1);
		   int val= prev.next.value;
		   Node nextNode= getAtIndex(i+1);
		   prev.next=nextNode;
		   size--;
			
		   return val;
			}
		   
		   
		   
	   }
	   
	   
	   public void reverseData() throws Exception
	   {
		   if(isEmpty())
			   throw new Exception("Linked List is Empty!");
		   
		   for(int i=0;i<size/2;i++)
		   {
			   Node node1= getAtIndex(i);
			   Node node2= getAtIndex(size-i-1);
			   int temp= node1.value;
			   node1.value= node2.value;
			   node2.value= temp;
		   }
		   
	   }

	   
	   public void reversePointer()
	   {
		   Node prev= head;
		   Node curr= prev.next;
		   
		   while(curr!=null) {
		   Node ahead= curr.next;
		   
		   //links change
		   curr.next=prev;
		   prev=curr;
		   curr=ahead;
		   }
		   
		   Node temp= head;
		   head= tail;
		   tail=temp;
		   tail.next=null;
		   
		   
	   }
	   
	   
	   public int findMiddle()
	   {
		   Node slow= head;
		   Node fast= head;
		   
		   while(fast.next!=null && fast.next.next!=null)
		   {
			   slow= slow.next;
			   fast= fast.next.next;
		   }
		   
		   return slow.value;
	   }
	   
	   public int findkthFromLast(int k)
	   {
		   Node slow= head;
		   Node fast= head;
		   
		   for(int i=1;i<=k;i++)
		   {
			   fast= fast.next;
		   }
		   while(fast!=null)
		   {
			   slow=slow.next;
			   fast=fast.next;
		   }
		   
		   return slow.value;
		   
	   }
//	   
//	   public int YIntersect()
//	   {
//		   Node a= headA;
//		   Node b= headB;
//		   while(a!=b)
//		   {
//			   a= (a==null)? headB : a.next;
//			   b= (b==null)? headA: b.next;
//			   
//		   }
//		   
//		   return a.value;
//	   }
}
