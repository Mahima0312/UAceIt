import java.util.Collections;
import java.util.PriorityQueue;

public class Lecture18 {
	
	public static void main(String[] args) {
		
		//any program -> analysed -> time complexity 
		//                        -> space complexity(extra space)
		
		//next greater element
		//questions clarify
		//2 4 5 6  ->brute force
		//stack --> optimized approach
		//time - space
		
		//prime-> 1->n 
		//36 -> 6
//		
//		for(int i=0;i*i<n;i++)
//		i^2<n
//		2<rootn
//		
		
		//Integer -> 73,156,6,0,1434,214,52,521,521156,2522 -> O(n)
				
		PriorityQueue<Integer> minq= new PriorityQueue<>(); //ascending order
		minq.add(73);
		minq.add(156);
		minq.add(6);
		//6,73,156
		System.out.println(minq.poll()); //O(logn)
		//w , theta
		//1 2 3 4
		
		//insertion -> O(n2) -> O(n)
		
		PriorityQueue<Integer> maxq= new PriorityQueue<>(Collections.reverseOrder());	
		maxq.add(73);
		maxq.add(156);
		maxq.add(6);
		System.out.println(maxq.poll());
		
		int[] arr= {2,3,56,32,57,89};
		System.out.println(KthLargest(3, arr));
		
		}
	
	public static int KthLargest(int k, int[] arr)
	{
		PriorityQueue<Integer> q= new PriorityQueue<>(k); // fixed size
		for(int i=0;i<arr.length;i++)
		{
			int number= arr[i];

			if(q.size()<k)
				q.add(number); // 56 57 89
			else if(q.peek()<number)
			{
				q.poll();
				q.add(number);
			}
		}
		return q.peek();
	}
	
	//1st largest-> maximum
	//2nd largest/kth largest-> priority queue
	

}
