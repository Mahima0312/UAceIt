
public class TreeClient {
	public static void main(String[] args) {
	
		
		Lecture16 tree= new Lecture16(); //make_tree
//		tree.preorder();
//		System.out.println();
//		tree.inorder();
//		System.out.println();
//		tree.postorder();
		//10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
//		System.out.println(tree.size());
//		System.out.println(tree.height());
//		System.out.println(tree.max());
//		System.out.println(tree.sum());
//		System.out.println(tree.find(100));
		System.out.println(tree.isbst());
		
		//8 true 3 true 1 false false true 6 true 4 false false true 7 false false true 10 false true 14 true 13 false false false
		
		int[] arr= {1, 3, 4, 6, 7, 8, 10, 13, 14};
		
		Lecture17 bst= new Lecture17(arr);
		
		
	}
	
	
	

}
