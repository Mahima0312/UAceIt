import java.util.ArrayList;
import java.util.Scanner;

public class PractiseContest1 {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n= scn.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]= scn.nextInt();
//		int item= scn.nextInt();
//		System.out.println(findElement(arr,item));
//		System.out.println(chocolates(arr));
//		System.out.println(topper(arr));
//		right_to_left(arr);
//		reverse(arr);
//		for(int val:arr)
//			System.out.print(val+" ");
//		int target= scn.nextInt();
//		
//		System.out.println(frequencies(arr,target));
//		int idx= scn.nextInt();
//		System.out.println(prefixsum(arr, idx));
		
		//for arraylist:
//		int size= scn.nextInt();
//		ArrayList<Integer> list= new ArrayList<>();
//		for(int i=0;i<size;i++)
//		{
//			list.add(scn.nextInt());
//		}
//		int i= scn.nextInt();
//		int j= scn.nextInt();
//		arraylist(list,i,j);
//		evenlist(list);
		int[] ans= inverse(arr);
		for(int val: ans)
			System.out.print(val+" ");
		
		
		
	}
	
	public static int findElement(int[] arr,int item)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==item)
				return i;
		}
		return -1;
	}
	
	public static int chocolates(int[] arr)
	{
		int sum=0;
		for(int val:arr)
			sum+=val;
		return sum;
	}
	public static int topper(int[] arr)
	{
		int max= Integer.MIN_VALUE;
		for(int val:arr)
			max= Math.max(max, val);
		return max;
	}
	
	public static void right_to_left(int[] arr)
	{
		for(int i=arr.length-1;i>=0;i--)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void reverse(int[] arr)
	{
		for(int i=0;i<arr.length/2;i++)
		{
			int temp= arr[i];
			arr[i]= arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
		}
	}
	public static int frequencies(int[] arr, int target)
	{
		int[] freq= new int[101];
		for(int val:arr)
		{
			freq[val]++;
		}
		return freq[target];
	}
	public static int prefixsum(int[] arr, int idx)
	{
		int[] presum= new int[arr.length];
		presum[0]= arr[0];
		for(int i=1;i<presum.length;i++)
		{
			presum[i]= arr[i]+presum[i-1];
		}
		
		return presum[idx];
	}
	public static void arraylist(ArrayList<Integer> list,int i, int j)
	{
		System.out.println(list.get(i));
		list.set(j, 5);
		for(int val:list)
			System.out.print(val+" ");
		System.out.println();
	}
	public static void evenlist(ArrayList<Integer> list)
	{
		ArrayList<Integer> evenlist= new ArrayList<>();
		for(int val:list)
		{
			if(val%2==0)
				evenlist.add(val);
		}
		for(int val:evenlist)
			System.out.print(val+" ");
		System.out.println();
	}
	public static int[] inverse(int[] arr)
	{
		int[] ans= new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			ans[arr[i]]=i;
		}
		return ans;
	}

}
