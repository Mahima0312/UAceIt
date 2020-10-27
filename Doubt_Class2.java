import java.util.HashMap;
import java.util.HashSet;

public class Doubt_Class2 {
	public static void main(String[] args) {
		
		int[] arr= {-2, -5, 6, -2, -3, 1, 5, -6};
		System.out.println(subarraysum(arr,0,arr.length-1));
		HashMap<Integer,Integer> map= new HashMap<>();
		HashSet<Integer> set= new HashSet<>();
		//unique qualities-> no repretition
		//[1,2,2,2,2,2,2,4,5,6,3,2,2,3,3,3,]
		//[1,2,4,5,6,3]
		//set.add()
		//set.contains
		
		
	}
//	 public static void deleteNode(ListNode node) {
//	       
//	       ListNode nextNode= node.next;
//	       node.val= nextNode.val;
//	       node.next= nextNode.next;
//	      
//	           
//	    }
	public static int subarraysum(int[] arr, int lo, int hi) {

		//recursion, divide and conquer
		//-2, -5, 6, -2, -3, 1, 5, -6
		// 1 2 3 4 5
		if (lo == hi) {
			return arr[lo];
		}
		int mid = (hi + lo) / 2;

		int leftsum = subarraysum(arr, lo, mid);//leftpart
		int rightsum = subarraysum(arr, mid + 1, hi); //rightpart
		int partition = findmaxleft(arr, lo, mid) + findmaxright(arr, mid + 1, hi);
		return Math.max(partition, Math.max(leftsum, rightsum));
		
		//left part
		//right part
		// middle element included

	}

	public static int findmaxleft(int[] arr, int lo, int hi) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = hi; i >= lo; i--) {
			sum += arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	public static int findmaxright(int[] arr, int lo, int hi) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = lo; i <= hi; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static int[] productExceptSelf(int[] nums) {
        
        int[] prodarr= new int[nums.length];
        for(int i=0;i<prodarr.length;i++)
            prodarr[i]=1;
        int temp=1;
        for(int i=1;i<nums.length;i++)
        {
            temp*=nums[i-1];
            prodarr[i]*=temp;
        }
        temp=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            temp*=nums[i+1];
            prodarr[i]*=temp;
        }
        return prodarr;
        
    }


}
