import java.util.Scanner;

public class Lecture2 {
	
	//Function Overloading
	//same name-- diff arguments/paramaters---NEVER on basis of return type
	
	
	
	public static void main(String[] args) {
		
		Scanner scn= new Scanner(System.in);
//		int n= scn.nextInt();
//		char ch= scn.next().charAt(0);
//		// 3: pasta
//		// 4: oil
//		switch(ch)
//		{
//		case 'a': System.out.println("Add Pasta");
//		break;
//		case 'b': System.out.println("Add oil");
//		break;
//		default:
//			System.out.println("Add valid input");
//			break;
//		int j=0;
//		while(j!=5)
//		{
//			System.out.println(j);
//			j++;
//		}
//		
		
		
		
		int price_dal=10;
		int price_rice= 20;
		int price_wafers=30;
		
		int[] prices= new int[500]; //memory
		
		// int -> 4 bytes
		
		//500*4= 2000
		

		int[] details= new int[15];
		
	
		
		//contiguous memory allocation
		
		
		//array definition
		
		
		int[] items=new int[5];
		
		//5---- 0:4
		
		//n ----> n-1
		int[] items2= items;
		
		// 1 2 3 4 5
		// 1 2 3 4 6
		
		for(int i=0;i<items.length;i++)
		{
			items[i]= scn.nextInt();
		}
//		
		
		
		for(int i=0;i<5;i++)
		{
			System.out.println(items[i]);
		}
		
		items2[4]= 6;
		for(int i=0;i<5;i++)
		{
			System.out.println(items[i]);
		}
		
		//for each loop
		
		for(int value: items2)
		{
			System.out.print(value+" ");
		}
		
		int[][] arr= new int[10][10]; // dibbe ke andar dibba

		for(int i=0;i<arr.length;i++)
		{
//			if(i%2==0) {
//			for(int j=0;j<arr[0].length;j++)
//			{
//				System.out.println(arr[i][j]);
//			}
//			}
//			
//			else {
//				
//			}
		}
		
		for(int[] arr2: arr)
		{
			for(int val: arr2)
			{
				System.out.println(val+" ");
			}
		}
		
		int[][] a= new int[4][4];
//		a= {{1,2,3,4},
//		{5,6,7,8},
//		{9,10,11,12},
//		{13,14,15,16},
//		};
//		
		}
		
		// 1 2 3 4  ----0
		// 5 6 7 8------1
		// 9 10 11 12---2
		
		
		
		//2 dimentional : arrays inside arrays
		
		
		
		
	
	
	
	public static int add(double x, double y,double z)
	{
		return 0;
	}
	
//	public static int add(int x, int y, int z)
//	{
//		return 1;
//	}
//	
	
//Switch


	
	//while
    
	
}
//Arrays

