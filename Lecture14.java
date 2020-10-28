import java.util.ArrayList;

public class Lecture14 {
	public static void main(String[] args) {
		int count= mazePath(0, 0, 2, 2,"");
		System.out.println();
		System.out.println(count);
		
		
	}
	public static int power(int x, int n) {
		
		//2->4 : 2*2*2*2
		//2->5 : 2*2*2*2*2

		if (n == 0) {
			return 1;
		}

		return (x*(power(x,n-1)));

	}

	public static ArrayList<String> findPermutations(String s)
	{
		//baseCase -> empty string
		if(s.length()==0)
		{
			ArrayList<String> basecase= new ArrayList<>();
			basecase.add("");//c-> c, b->b,
			return basecase;
		}
		
		//break the problem
		char characterAtHand = s.charAt(0); //a
		String restOfTheString= s.substring(1); //"bc"
		ArrayList<String> biggerResult= new ArrayList<>(); //final result arraylist
		
		 ArrayList<String> smallerResult= findPermutations(restOfTheString); //bc ke permutations--->"bc","cb" 
		 
		 for(String val: smallerResult)
		 {
			 for(int i=0;i<=val.length();i++)
			 {
				 //"bc" ->"bac"  //bca   
				 String ans= val.substring(0,i)+characterAtHand+val.substring(i);
				 biggerResult.add(ans); //c//b//a
			 }
		 }
		 
		 return biggerResult;
	}
	
	public static ArrayList<String> findSubsequences(String s)
	{
		//Empty string is a subsequence of all
		
		//Base Case
		if(s.length()==0)
		{
			ArrayList<String> basecase= new ArrayList<>();
			basecase.add("");//c-> c, b->b,
			return basecase;
		}
		
		
		//Break the Problem
		char characterAtHand = s.charAt(0); //a
		String restOfTheString= s.substring(1); //"bc"
		ArrayList<String> biggerResult= new ArrayList<>();
		
		ArrayList<String> smallerResult= findSubsequences(restOfTheString); //"",b,c,cb
		 for(String val: smallerResult)
		 {
			 biggerResult.add(val); //as it is
			 biggerResult.add(val+characterAtHand); //char ko add karo
		 }
		 
		 return biggerResult;
		
	}
	
	
	public static ArrayList<String> cointoss(int n) 
	{
		//baseCase
		if(n==0)
		{
			ArrayList<String> basecase= new ArrayList<>();
			basecase.add(""); //growth factor
			return basecase;
		}
		//breaking the problem
		ArrayList<String> smallerResult= cointoss(n-1);  //H,T
		ArrayList<String> biggerResult= new ArrayList<>();
		for(String val: smallerResult)
		{
			biggerResult.add(val+"H");
			biggerResult.add(val+"T");
		}
		
		return biggerResult;
	

	}
	public static int mazePath(int cr, int cc, int dr, int dc, String answer)
	{
		if(cr==dr && cc==dc)
		{
			System.out.print(answer+" ");
			return 1;
		}
		int count=0;
		//negative base case
		if(cr>dr || cc>dc)
			return 0;
		
		//3 padosiyon se pucho
		//answer-> forming from start to end
		//count-> taking from end to first
		count+=mazePath(cr, cc+1, dr, dc, answer+"H");
		count+=mazePath(cr+1, cc, dr, dc, answer+"V");
		count+=mazePath(cr+1, cc+1, dr, dc, answer+"D");
		
		return count;
		
	}


}
