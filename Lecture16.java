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

	public void preorder()
	{
		preorder(root);
	}
	
	private void preorder(Node node)
	{
		if(node==null)
			return;
		//DLR
		System.out.print(node.data+" "); //self work
		preorder(node.left);		
		preorder(node.right);
		
	}
	
	public void inorder()
	{
		inorder(root);
	}
	
	private void inorder(Node node)
	{
		if(node==null)
			return;
		//LDR
		inorder(node.left);	
		System.out.print(node.data+" "); //self work			
		inorder(node.right);
		
	}
	
	public void postorder()
	{
		postorder(root);
	}
	
	private void postorder(Node node)
	{
		if(node==null)
			return;
		//LRD
		postorder(node.left);				
		postorder(node.right);
		System.out.print(node.data+" "); //self work	
		
	}
	
	private class balancedPair{
		
		boolean isBalanced= true;
		int height =-1; 
		
	}
	
	public boolean isbalanced() {
	
		return isbalanced(root).isBalanced;
	}

	private balancedPair isbalanced(Node node) {
		
		if(node==null)
		{
			return new balancedPair();
			//creating an empty node
		}
		
		balancedPair leftpair=isbalanced(node.left); //left subtree will give you two things (lh, isbalanced)
		balancedPair rightpair= isbalanced(node.right); //right subtree will give you two (rh, isblanced)
		
		
		int lh= leftpair.height;
		int rh= rightpair.height;
		
		int bf = lh-rh;
		
		balancedPair selfpair = new balancedPair();
		selfpair.height= Math.max(lh, rh)+1; // khud ki height
		
		selfpair.isBalanced = leftpair.isBalanced && rightpair.isBalanced && (bf==1 || bf==-1 || bf==0);
		
		return selfpair;
		

	}
	
	private class bsttriplet{
		int maximum = Integer.MIN_VALUE;
		int minimum = Integer.MAX_VALUE;
		boolean isbst =true;	
	}
	

	public boolean isbst() {
		
		return isbst(root).isbst;
		
	}

	private bsttriplet isbst(Node node) {
		
		if(node==null)
		{
			return new bsttriplet();
		}
		
		bsttriplet left= isbst(node.left);
		bsttriplet right= isbst(node.right);
		
		bsttriplet st= new bsttriplet();
		
		
		st.maximum= Math.max(node.data, Math.max(left.maximum,right.maximum));
		st.minimum=Math.min(node.data, Math.min(left.minimum,right.minimum));
		st.isbst= left.isbst && right.isbst && ((node.data> left.maximum) && (node.data< right.minimum));
		
		return st;
		
	}

	
}
