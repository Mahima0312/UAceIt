
public class Doubt_Class {
	public static void main(String[] args) {
		
		
		//decimal(10) : 5
		
		
		//            1 0 1   //2 //1   
		//.setBitCount()
		// binary(2): 4 2 1 
//		System.out.println(deciToBin(5));
//		System.out.println(deciToBin(11));
//		System.out.println(binToDec(1011));
		int[] arr= {3,3,2,1,3};
		System.out.println(isMirror(arr));
		
		//5    
		//  4   1
		//  2   0
		//  1   1
	}
	
	//11
	// 1011
	public static int deciToBin(int n)
	{
		
		int ans=0;
		int mult=1;
		while(n!=0)
		{
			int rem= n%2;
			ans+= rem*mult; 
			mult*=10;
			n/=2;
			
			
		}
		
		
		return ans;
	}
	
	public static int binToDec(int n)
	{
		int ans=0;
		int mult=1;
		while(n!=0)
		{
			int rem= n%10;
			ans+= rem*mult;
			mult*=2;
			n/=10;
		}
		return ans;
	}
	public static int findMin(int[] arr)
	{
		int min= Integer.MAX_VALUE;
		
		//1 2 3 4 5
		for(int val:arr)
		{
			if(min>val)
				min=val;
		}
		return min;
			
	}
	//count-sort
	
	
	//[4,0,1,1,3] ->ans
	
	//
	
	public static int[] findSmaller(int[] arr)
	{
		int[] count= new int[101];
		//0-100
		// 0 1 2 3 4 5  6 7 8 9 10-----100
		// 0 1 2 1 0 0  0 0 1
		// 0 1 3 4 4 4  4 4 5
		
		//prefix sum: all the values before index i
		// count : frequency of index i
		
		
		//4 0 1 1 3
		int[] prefixsum= new int[101];
		
		//filling count array
		////[8,1,2,2,3] ->ques
		for(int val:arr)
		{
			count[val]++;
		}
		//filling prefix sum array
		prefixsum[0]= count[0];
		for(int i=1;i<prefixsum.length;i++)
		{
			prefixsum[i]= prefixsum[i-1]+ count[i];
		}
		
		
		int[] ans= new int[arr.length];
		for(int i=0;i<ans.length;i++)
		{
			ans[i]= prefixsum[arr[i]]-count[arr[i]];
		}
		
		return ans;
		
		
	}
	public static int missingNumber(int[] arr)
	{
		//1,0,3 :3
		//sum: 1+2+3= 6
		//givensum: 1+0+3=4
		
		// 1,2 ,0, 3, 5 :5
		//11
		//1+2+3+4+5:15
		//4
		
		int arraysum=0;
		for(int val:arr)
			arraysum+=val;
		
		int sumtilln=0;
		for(int i=1;i<=arr.length;i++)
			sumtilln+=i;
		
		return sumtilln-arraysum;
		
	}
	
	//3 4 2 0 1
	//0 1 2 3 4 ..j
	
	//arr[i]=j
	
	public static boolean isMirror(int[] arr)
	{
		int[] inverseArr= new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			int newindex= arr[i];
			inverseArr[newindex]= i;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=inverseArr[i])
				return false;
		}
		return true;
	}
	

}
