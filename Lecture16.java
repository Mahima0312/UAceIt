import java.util.Scanner;

public class Lecture16 {
	static Scanner scn= new Scanner(System.in);

	
	private class Node{
		int data;
		Node left;
		Node right;
	}
	
	private Node root;
	
	//constructor
	public Lecture16(){
		root = make_tree(null,false);
	}
	
	private Node make_tree(Node parent, boolean isthisleftchild) {
		//making the root		
		if(parent==null)
		{
			System.out.println("Enter value for root: ");
		}else {
			//making child node
			if(isthisleftchild)
			{
				//its the left child
				System.out.println("Enter data for left child of "+ parent.data);
			}else {
				//its the right child
				System.out.println("Enter data for right child of "+ parent.data);
			}
		}
		
		Node newNode= new Node(); //20
		newNode.data= scn.nextInt(); //user input
	    System.out.println(newNode.data+" has left child?");
	    boolean hasleftchild= scn.nextBoolean();
	    if(hasleftchild)
	    {
	    	newNode.left= make_tree(newNode, true); //recursion
	    }
	    System.out.println(newNode.data+" has right child?");
	    boolean hasrightchild= scn.nextBoolean();
	    if(hasrightchild)
	    {
	    	newNode.right= make_tree(newNode, false); //recursion
	    }
		return newNode;		
	}
	
	private void display(Node node) {
		if (node == null)
			return;
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}
		str += "-> " + node.data + " <- ";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public void display() {

		display(root);

	}

	
	//Generic Tree-> Structure
	
	//10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
	
	private int size(Node node) {
		//base case
		if(node==null)
			return 0;
		
		int leftsize= size(node.left);
		int rightsize= size(node.right);
		int selfwork= 1;
		
		return leftsize+rightsize+selfwork;
		
	}

	public int size() {
		return size(root);
	}

	private int height(Node node) {
		//base case
		if(node==null)
			return -1;
		
		//Empty tree gives height as -1;

		//Single node gives height as 0;
		//Height is measured by max number of edges in any branch
		
		int lefth= height(node.left);
		int righth= height(node.right);
		int selfwork=1;
		return (Math.max(lefth,righth))+selfwork;
		
		
	}

	public int height() {
		return height(root);
	}

	private int max(Node node) {		
		
		if(node==null)
			return Integer.MIN_VALUE;
		
		int leftmax= max(node.left);
		int rightmax= max(node.right);
		
		
		return Math.max(node.data, Math.max(leftmax, rightmax));
	}

	public int max() {
		return max(root);
	}
	
	private int sum(Node node)
	{
		if(node==null)
			return 0;
		int leftsum= sum(node.left);
		int rightsum= sum(node.right);
		
		return leftsum+rightsum+node.data;
		
	}
	public int sum()
	{
		return sum(root);
	}

	private boolean find(int item, Node node) {
		if(node==null)
			return false;
		if(node.data==item)
			return true;
		
		
		boolean ispresentatleft= find(item,node.left);
		boolean ispresentatright= find(item,node.right);
		
		
		return ispresentatleft || ispresentatright;
	

	}

	public boolean find(int item) {
		return find(item, root);
	}


}
