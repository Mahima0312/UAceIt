import java.util.Scanner;

public class Lecture5 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Strings 
//		char ch= 'a';
		
		// STring pool
		
		String str = "mahima";
//		System.out.println(str);
//		String example= "exampleSTribg";
		
		String str2= new String();
		
	
		str2= "mahima";
		System.out.println(str2);
		System.out.println(str2.charAt(2));
		
		//scanning
//		char ch= scanner.next().charAt(0);
//		String ans= scanner.next();
		
		
		String name= "apple";
		
		String newstring= new String(name);
		String string2= "";
		
		
		for(int i=0;i<str2.length();i++)
		{
			string2= string2 + str2.charAt(i);
		}
		
		
		//1.pastA
		//2.pizza
		//3.coke
//		String item= scanner.next();
		
		
		
//		System.out.println((int)'a');
		
		//a-z
		//a
		
		String res= "mahima"+2;
		
		int ans= 'a'+2;
		int ans2= 'a';
		
		
//		String ans2= "mahima"+2;
		System.out.println(ans2);
//		"mahima"+a
//		System.out.print("abc"+3);
		
		//substring
		
		String name2= "prateek";
//		               01234567
		System.out.println(name2.substring(0,7));
		System.out.println(name2.substring(1));
		
		int num= Integer.parseInt("1234");
		System.out.println(num+2);
		//Long.parseLong()
		//"m ahima"
		
		System.out.println((char)257);
		char[] arr= name2.toCharArray();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public static int rainwater(int[] towers)
	{
		int[] lm = new int[towers.length];
		
		lm[0] = towers[0];
		
		
		for (int i = 1; i < lm.length; i++) {
			lm[i] = Math.max(towers[i], lm[i - 1]);
		}
		
		int[] rm = new int[towers.length];
		
		rm[rm.length - 1] = towers[towers.length - 1];
		for (int i = rm.length - 2; i >= 0; i--) {
			rm[i] = Math.max(towers[i], rm[i + 1]);
		}
		
		int sum = 0;
		for (int i = 0; i < towers.length; i++) {
			int collected = Math.min(lm[i], rm[i]);
			sum += collected - towers[i];
		}
		return sum;
		
	}
	
	public static int[] rotate(int[] arr, int k) {
		int[] newarr = new int[arr.length];
		
		
		if(k<0)
			k+=arr.length;
		k%=arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			int newindex= i+k;
			
			if(newindex>=arr.length)
				newindex-=arr.length;
			
			newarr[newindex]= arr[i];
			
			
		}
		return newarr;
	}


}
