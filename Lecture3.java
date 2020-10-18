import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lecture3 {
	public static void main(String[] args) {
		
	//int[][] arr = new int[4][5];
		//int[] arr= new int[10];
		
		//Arrays.sort(arr)
		//Arrays.fill(1)
		
	//Dynamic Array:
		//ArrayList
		
	ArrayList<Integer> list= new ArrayList<>();
	
	//[]
	list.add(0); //0
	//[0]
	list.add(10); //1
	//[0,10]
	list.add(15); //2
	//[0,10,15]
	list.add(2,25);
	list.add(2,40);
	
//	list.remove(1);
//    list.remove((Integer)25);
//	System.out.println(list);
//	for(int val: list)
//	{
//		System.out.println(val);
//	}
//	list.size();//2
//	Collections.sort(list);
//	
		
  String[] arr= new String[3];
  arr[0]= "mahima";
  arr[1]= "dhruv";
  arr[2]= "prateek";
  
  ArrayList<String> names= new ArrayList<>();
  names.add("mahima");
  names.add("blah");
	
	//transpose of a matrix
  // 1 2 3 
  // 4 5 6
  // 7 8 9
  
  
  //transpose:
  // 1 4 7
  // 2 5 8
  // 3 6 9
	
  
//  for(int i=0;i<arr.length;i++)
//  {
//	  for(int j=0;j<arr[0].length();j++)
//	  {
//		  newarr[i][j]= arr[j][i];
//	  }
//  }
  
	}
	

	
	public static int binarySearch(int[] arr, int key)
	{
		Arrays.sort(arr); 
		int lo=0;
		int hi=arr.length-1;
	
		while(lo<=hi)
		{
			
			int mid=(lo+hi)/2;
			
			if(key>arr[mid])
			{
				lo=mid+1;
			}
			else if(key<arr[mid])
			{
				hi=mid-1;
			}
			else
			{
				return mid;
			}
			
		}
		return -1;
	}
	
	// bubble sort, selection sort, insertion sort
	// quick sort, merge sort
	
	
		
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int counter = 0; counter <= n - 2; counter++) {
			for (int i = 0; i <= n - counter - 2; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}
			}
		}
		//O(n2)
	}
	
	public static void selectionSort(int[] arr)
	{
		int n=arr.length;
		for(int counter=0;counter<n-1;counter++)
		{
			int min=counter;
			for(int i=counter+1;i<arr.length;i++)
			{
				if(arr[i]<arr[min])
				{
					min=i;
				}
			}
			
			int temp=arr[counter];
			arr[counter]=arr[min];
			arr[min]=temp;
			
		}
	}
	
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int counter = 1; counter < arr.length; counter++) {
			int temp = arr[counter];
			int j = counter - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	
	

}
