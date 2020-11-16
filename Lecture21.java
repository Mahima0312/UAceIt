import java.util.ArrayList;
import java.util.Arrays;

public class Lecture21 {
	public static void main(String[] args) {
//		int[] arr= {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int[] arr= {9, 6, 5, 1};
		System.out.println(findMin2(11, arr));
		System.out.println(findMin(11, arr)); //greedy
		
	}
	//Recursion
	public static int MinimumjumpsRequired(int[] arr, int idx) {
		//1 2 3 4 5
		//base case
		if(idx==arr.length-1)
			return 0;
		
		int answer=0;
		int minanswer=Integer.MAX_VALUE;
		for(int step=1;step<=arr[idx];step++)
		{
			if(idx+step<arr.length)
			answer= MinimumjumpsRequired(arr, idx+step); 
			minanswer= Math.min(minanswer, answer);
		}
		
		return minanswer+1; //plus one is for your own jump

	}

	public static int MinimumJumpsRequiredTD(int[] arr, int idx, int[] strg) {
		if(idx==arr.length-1)
			return 0;
		
		int answer=0;
		if(strg[idx]!=-1)
			return strg[idx];
		int minanswer=Integer.MAX_VALUE;
		for(int step=1;step<=arr[idx];step++)
		{
			if(idx+step<arr.length)
			answer= MinimumJumpsRequiredTD(arr, idx+step,strg); 
			minanswer= Math.min(minanswer, answer);
		}
		strg[idx]= minanswer+1;
		
		return minanswer+1; //plus one is for your own jump

	}

	//Bottom up
	public static int MinimumJumpsRequiredBU(int[] arr) {
		int[] strg= new int[arr.length];
		for(int i=strg.length-2;i>=0;i--)
		{
			int min= Integer.MAX_VALUE;
			for(int step=1;step<=arr[i];step++)
			{
				int ans=0;
				if(i+step<arr.length)
					ans= strg[i+step];
				min= Math.min(min, ans);
			}
			strg[i]= min+1;
		}
		return strg[0];

	
	}
	//GREEDY 
	//Activity Selection
	 public static int findMin(int target, int[] denom){ 
	   Arrays.sort(denom); //increasing
	   ArrayList<Integer> list= new ArrayList<>();
	   for(int i=denom.length-1;i>=0;i--)
	   {
		   while(target>=denom[i])
		   {
			   target-=denom[i]; //150
			   list.add(denom[i]);
			   //50
		   }
	   }
//	   for(int val: list)
//		   System.out.println(val+" ");
	   
	   return list.size();  
	 } 
	 
	 //DYNAMIC PROGRAMMING -> Bottom Up approach
	 public static int findMin2(int target, int[] denom)
	 {
		 int[] strg= new int[target+1];
		 Arrays.fill(strg,Integer.MAX_VALUE);
		 //target:0 -> ans: 0
		 strg[0]=0; //base case
		 
		 for(int i=1;i<=target;i++)
		 {
			 for(int j=0;j<denom.length;j++)
			 {
				 if(denom[j]<=i)
				 {
					 //target: 5, denom[i]=3
					 //strg[2]
					 int ans= strg[i-denom[j]];
					 if(ans!=Integer.MAX_VALUE && ans+1<strg[i])
						 strg[i]= ans+1;
					 
				 }
			 }
		 }
		 
		 return strg[target];
	 }
	 //Fractional Knapsack 
	 //10 -> 2,3,5,7,10
	 //      25 25 25,25,50
	 //10 -> 50
	 //Dp: always correct -> 
	 //Greedy fail
}
