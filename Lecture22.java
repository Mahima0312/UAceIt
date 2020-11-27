
public class Lecture22 {
	
	public static void main(String[] args) {
		int[] arr1= {38,27,43,3,9,82,10};
		
		int[] res= mergesort(arr1, 0, arr1.length-1);
		
		int[] arr2= {10,80,30,70,40,50,90};
		
		quicksort(arr2,0, arr2.length-1);
		
		for(int val:res)
		{
			System.out.print(val+" ");
			
		}
		System.out.println();
		for(int val:arr2)
		{
			System.out.print(val+" ");
		}
		
	}
	public static int[] merge(int[] one, int[] two) {
		//1 2 3 4
		//5 6 7 8 9 10 11 12
		//1 2 3 4 5
		
		//(O(n))
		
		int[] answer= new int[one.length+two.length];
		int left=0;
		int right=0;
		int answerindex=0;
		
		while(left<one.length && right< two.length)
		{
			if(one[left]<two[right])
			{
				answer[answerindex++]=  one[left];
				left++;
			}else {
				answer[answerindex++]=two[right];
				right++;
			}
		}
		while(left<one.length)
		{
			answer[answerindex]= one[left];
			left++;
			answerindex++;
		}
		while(right<two.length)
		{
			answer[answerindex]= two[right];
			right++;
			answerindex++;
		}
		
		return answer;

	}
     //extra space required 
	public static int[] mergesort(int[] arr, int lo, int hi) {
		//base case-> single element array (lo==hi)
		//time complexity: O(nlogn)
		
		if(lo==hi)
		{
			int[] result= new int[1];
			result[0]= arr[lo];
			return result;
		}
		
		
		int mid= (lo+hi)/2;
		int[] leftans= mergesort(arr,lo,mid);
		int[] rightans= mergesort(arr,mid+1, hi);
		//logn
		//merge the sorted arrays
		return merge(leftans,rightans);
		
		
		
	}
	//inplace algorithm -> no extra space required,
	
	public static void quicksort(int[] arr, int lo, int hi) {
		
		//2 3 4 5 6
		//pivot:3
		//left:0
		//right:2
		//2 3 4
		//left:0
		//right:1
		//2 3 4 6
		//left:0
		//right:1
		
		
		
		//time complexity: O(nlogn)
		//worse complextiy: O(n2)
		int mid= (lo+hi)/2;
		int pivot= arr[mid];
		int left= lo;
		int right= hi;
		if(lo>=hi)
		{
			return;
		}
		
		while(right>=left)
		{
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			
			if(right>=left)
			{
				int temp= arr[left];
				arr[left]= arr[right];
				arr[right]= temp;
				left++;
				right--;
			}
		
			//recursion calls
			quicksort(arr,lo,right);  //0,2
			quicksort(arr,left,hi);  //0,4)
			//O(logn)
			//2^k
			//1 --n-1
			//O(n)

		}

 	
	}


}
