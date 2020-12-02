
public class Lecture24 {
	public static void main(String[] args) {
		
	}
	
	public int numIslands(char[][] grid) {
		
		int count=0;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				//looking for 1-> land
				if(grid[i][j]=='1')
				{
					dfs(i,j,grid);
					//after you have visited all the lands connected to this particular land
					count++;
					
				}
			}
		}
		return count;
	
	}
	public void dfs(int i, int j, char[][] grid)
	{
		//you dont fall out of the grid or you have visited water
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
			return;
		
		grid[i][j]='0';
		
		dfs(i+1,j,grid);
		dfs(i-1,j,grid);
		dfs(i,j+1,grid);
		dfs(i,j-1,grid);
		
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		if(image==null || image[sr][sc]==newColor)
			return image;
		
		dfs(image,sr,sc,newColor,image[sr][sc]);
		
		return image;
	       
	}
	    
	public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor)
	{
		if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length)
			return;
		if(image[sr][sc]==oldColor)
		{
			
		
		image[sr][sc]= newColor;
		
		dfs(image,sr+1,sc,newColor,oldColor);
		dfs(image,sr-1,sc,newColor,oldColor);
		dfs(image,sr,sc+1,newColor,oldColor);
		dfs(image,sr,sc-1,newColor,oldColor);
		}
	}

     public boolean canFinish(int numCourses, int[][] prerequisites) {
    	 
    	 if(prerequisites==null || prerequisites.length==0)
    		 return true;
    	 boolean[][] adjacent= new boolean[numCourses][numCourses];
    	 //
    	 boolean[] visited= new boolean[numCourses];
    	 boolean[] explored= new boolean[numCourses];
    	 //[1,0]-> directed edge
    	 //filling edges
    	 for(int i=0;i<prerequisites.length;i++)
    	 {
    		 adjacent[prerequisites[i][0]][prerequisites[i][1]]= true;
    	 }
    	 
    	 for(int i=0;i<numCourses;i++)
    	 {
    		 if(!visited[i] && isCyclic(i,visited,explored,adjacent))
    			 return false;
    	 }
    	 return true;
	       
	        
	 }
	    
	 public boolean isCyclic(int i, boolean[] visited, boolean[] explored, boolean[][] adj)
	 {
	      visited[i]= true;
	      for(int j=0;j<adj.length;j++)
	      {
	    	  if(adj[i][j])
	    	  {
	    		  if(!visited[j] && isCyclic(j,visited,explored,adj))
	    			  return true;
	    		  else if(!explored[j])
	    			  return true;
	    	  }
	      }
	      
	      explored[i]= true;
	      return false;
		 
	 }

     public int numEnclaves(int[][] A) {
		     
    	 
    	 int count=0;
    	 for(int i=0;i<A.length;i++)
    	 {
    		 for(int j=0;j<A[0].length;j++)
    		 {
    			 //check for boundary
    			 if(i==0 || i==A.length-1 || j==0 || j==A[0].length-1)
    			 {
    				 if(A[i][j]==1)
    				 {
    					 dfs(A,i,j);
    				 }
    			 }
    		 }
    	 }
    	 
    	 for(int[] arr: A)
    	 {
    		 for(int val: arr)
    		 {
    			 if(val==1)
    				 count++;
    		 }
    	 }
    	 
    	 return count;
     }
     
     public void dfs(int[][] A, int i, int j)
     {
    	 if(i<0 || j<0 || i>=A.length || j>=A[0].length || A[i][j]!=1)
    		 return;
    	 //change
    	 A[i][j]=2;
    	 
    	 dfs(A,i+1,j);
    	 dfs(A,i-1,j);
    	 dfs(A,i,j+1);
    	 dfs(A,i,j-1);
    	 
     }
	

}
