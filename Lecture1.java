import java.util.Scanner;

public class Lecture1 {
	
	
	
	//Functions in Java(methods) --> Actions
	
	//modularity
	
	//local variables
	//global variables
	
	//function overloading
	static int bada_don=0;

	
	public static int add(int x, int y, int z)
	{
		return 0;
	}
	
	
	public static int add(int x,int y)
	{
		int sum=0;
		
		sum= x+y;
		bada_don=5;
		
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		int answer = add(2,4);
		System.out.println(answer);
		
		//ways to scan
//		Scanner scn= new Scanner(System.in);
		
//		int x= scn.nextInt();
//		
//		String str= scn.next();
//		char ch= scn.next().charAt(0);
		
//		System.out.println(ch);
		
		roots(1, 5, 6);
		
			
	}
	
	public static void roots(int a, int b, int c)
	{
		//ax2+bx+c
		//x2-4x+4
		double r1=0,r2=0;
		int d= (b*b) - (4*a*c);
		double sqrtd= Math.sqrt(d);
		
		r1=(-b + sqrtd)/(2*a);
		r2=(-b - sqrtd)/(2*a);

		System.out.println(r1+ " "+ r2);
		
	}
	
	
	
	
}
