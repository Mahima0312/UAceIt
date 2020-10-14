
public class Client {
	
	public static void main(String[] args) throws Exception {
		
		Lecture8 linkedlist= new Lecture8();
		linkedlist.addAtLast(2);
		linkedlist.addAtFront(3);
		linkedlist.addAtLast(4);
		linkedlist.addAtLast(5);
		linkedlist.addAtLast(6);
		linkedlist.addAtLast(7);
		linkedlist.addAtLast(8);
		linkedlist.addAtLast(9);
		System.out.println(linkedlist.findkthFromLast(2));
		//3 2 4 5 6 7
		//0 1 2 3 4 5
		//5/2: 2
		
		
//		int data= linkedlist.removeAtLast();
//		System.out.println(data);
		linkedlist.display();
//		System.out.println();
//		linkedlist.reversePointer();
//		System.out.println();
//		linkedlist.display();
//		System.out.println(linkedlist.findMiddle());
		
		
		
	}
	
	
	

}
