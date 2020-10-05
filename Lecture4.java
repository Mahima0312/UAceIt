import java.util.ArrayList;

public class Lecture4 {
	public static void main(String[] args) {
		
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiral(arr);
		//1 2 3 4
		// 5 6 7 8
		// 9 10 11 12
		// 13 14 15 16
		
		
		
	}
		
	public static void spiral(int[][] arr)
	{
		int minCol=0;
		int minRow=0;
		int maxCol= arr[0].length-1;
		int maxRow= arr.length-1;
		
		int numberofelements= arr.length*arr[0].length;
		int count=0;
		//33
		//count=30
		while(count<numberofelements) {
			
		
		//first row
		for(int c=minCol;c<=maxCol && count<numberofelements;c++)
		{
			System.out.print(arr[minRow][c]+" ");
			count++;
		}
		minRow++;
		
		//last column
		for(int r= minRow;r<=maxRow && count<numberofelements;r++)
		{
			System.out.print(arr[r][maxCol]+" ");
			count++;
		}
		maxCol--;
		//last row
		for(int c= maxCol;c>=minCol && count<numberofelements;c--)
		{
			System.out.print(arr[maxRow][c]+" ");
			count++;
		}
		maxRow--;
		
		//first column
		for(int r=maxRow;r>=minRow && count<numberofelements;r--)
		{
			System.out.print(arr[r][minCol]+" ");
			count++;
		}
		minCol++;
		
		}
		
		
				
	}
	
	public static int[] talkInCodes(int[] arr)
    {
        
        ArrayList<Integer> list= new ArrayList<>();
        //1 2 3 4
        //1 2  // 3 4 // 5 6
        //3 2 3 5
        //2 2 2 5 5 5
       
        for(int i=0;i<=arr.length-2;i+=2)
        {
            int freq= arr[i];
            int val= arr[i+1];
            while(freq-->0)
            {
               list.add(val);
                
            }
            
        }
         int[] ans= new int[list.size()];
        for(int i=0;i<list.size();i++)
            ans[i]= list.get(i);
        
        
        //set and get
        // arr[i]-> acces
        //list.get() list.set()
        //temp
        //list.get(i)
        //list.set(i,val)
        return ans;
        
    }
	
	public static int luckyNumber(int[] arr)
	{
		int[] freq= new int[101];
		
		//1 2 2 3 3 3
		//0 1 2 3 4 5
		
		
		//0 1 2 3 4 5 6 7 8 9 10----100
		//  1 2 3
		
		
		for(int i=0;i<arr.length;i++)
		{
			freq[arr[i]]++;
			
		}
		
		int max= Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++)
		{
			int val= arr[i];
			
			if(freq[val]==val)
			{ 
				max= Math.max(max, val);
				
			}
		}
		if(max==Integer.MIN_VALUE)
            max=-1;
		
		return max;
		
	}
	
	//a b k
	//n*3
	// 1 2 3
	// 4 5 6
	// 7 8 9
	//
	//
	//
	  static long arrayManipulation(int n, int[][] queries) {
	        long[] arr= new long[n];
	        for(int i=0;i<queries.length;i++)
	        {
	            int[] query= queries[i];
	            //queries[i][0]
	            int a= query[0]-1;
	            int b= query[1]-1;
	            int k= query[2];
	            arr[a]+=k;
	            if(b+1<arr.length)
	                arr[b+1]-=k;
	            
	        }
	        
	        long max=Long.MIN_VALUE;
	        for(int i=1;i<arr.length;i++)
	        {
	            arr[i]=arr[i]+arr[i-1];
	        }
	        for(int i=0;i<arr.length;i++)
	        {
	            max=Math.max(max, arr[i]);
	        }
	            
	        return max;


	    }


}
