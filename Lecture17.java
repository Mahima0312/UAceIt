public class Lecture17 {
	
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	
	public Lecture17()
	{
		
	}
	
	public Lecture17(int[] in)
	{
		root= construct(in,0, in.length-1);
	}
	// 1 3 4 6 7 8 10 13 14
	private Node construct(int[] in, int lo, int hi)
	{
		
		if(lo>hi)
			return null;
		int mid= (lo+hi)/2;
		Node newNode= new Node();
		newNode.data= in[mid];
		newNode.left= construct(in,lo,mid-1);
		newNode.right= construct(in,mid+1,hi);
		
		
		return newNode;
	}
	//display()
	
	//size-> same
	//height-> same
	//sum -> same
	//max -> right subtree se maximum
	//find -> try yourself
	
	private int max(Node node) {

		if (node.right == null)
			return node.data;
		return max(node.right);
	}

	public int max() {
		return max(root);
	}

	private boolean find(int item, Node node) {
		if (node == null)
			return false;

		if (item < node.data) {
			return find(item, node.left);
		} else if (item > node.data)
			return find(item, node.right);
		else
			return true;

	}

	public boolean find(int item) {
		return find(item, root);
	}
	
	public void add(int item) {
		add(root, item);
	}

	private void add(Node node, int item) {
		
		if(item<=node.data)
		{
			if(node.left==null) {
			Node newNode= new Node();
			node.left= newNode;
			newNode.data= item;
			return;
			}else {
						
			add(node.left,item);
			
			}
		}else {
			if(node.right==null)
			{
				Node newNode= new Node();
				newNode.data=item;
				node.right= newNode;
				return;
			}else {
				add(node.right,item);
			}
			
		}

	}
	
	public void remove(int item) {
		remove(null, root, item);
	}


	private void remove(Node parent, Node node, int item) {
		
		if(item<node.data)
		{
			remove(node,node.left,item);
		}else if(item> node.data)
		{
			remove(node,node.right,item);
		}else {
			//you are here --> remove this node
			
			//case 1: leaf Node
			if(node.right==null & node.left==null)
			{
				if(node.data<=parent.data)
				{
					parent.left=null;
				}else {
					parent.right=null;
				}
			}
			//case 2: left not null and right null
			else if(node.left!=null && node.right==null)
			{
				if(node.data<=parent.data)
				{
					parent.left= node.left;
				}else {
					parent.right= node.left;
				}
			}
			//case 3: left null and right not null
			
			else if(node.left==null && node.right!=null)
			{
				if(node.data<=parent.data)
				{
					parent.left= node.right;
				}else {
					parent.right= node.right;
				}
			}else {
				//case 4: both are not null
				
				int temporary= max(node.left); // maximum of left subtree
				remove(node,node.left,temporary);
				node.data= temporary;
				
				
				
			}
			
			
			
			
			

		}
		
		
	}

	

	

}
