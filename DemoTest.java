import java.util.Scanner;

public class DemoTest {
	
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
//		Question 1
		int item_number= scn.nextInt();
		RecipeFun(item_number);
		
//		Question 2
		int number= scn.nextInt();
		boolean ans= isPrime(number);
		if(ans)
			System.out.println("The student is a loner");
		else
			System.out.println("The student is not a loner");
		
		//Question 3
		int weight= scn.nextInt();
		int days= scn.nextInt();
		System.out.println(DietPlan(weight,days));
		
		
	}
	
	public static void RecipeFun(int item_number)
	{
		if(item_number==1)
		{
			System.out.println("Add Pasta!");
		}else if(item_number==2)
		{
			System.out.println("Add Oil!");
		}else if(item_number==3)
		{
			System.out.println("Add Oregano!");
		}else {
			
			System.out.println("Add Tomato Sauce!");
		}
		
	}
	public static boolean isPrime(int number)
	{
		if(number==1)
			return false;
		for(int i=2;i*i<=number;i++)
		{
			if(number%i==0)
				return false;
		}
		
		return true;
	}
	
	public static int DietPlan(int W, int D)
	{
		for(int i=1;i<=D;i++)
		{
			if(i%2!=0)
			{
				W-=(3*i);
			}else
			{
				W+=(2*i);
			}
		}
		return W;
			
	}

}
