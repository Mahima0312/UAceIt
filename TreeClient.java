
public class TreeClient {
	public static void main(String[] args) {
		
		Lecture16 tree= new Lecture16(); //make_tree
		//10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println(tree.max());
		System.out.println(tree.sum());
		System.out.println(tree.find(100));
		
	}
	
	
	

}
