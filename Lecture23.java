import java.util.Iterator;
import java.util.LinkedList;

public class Lecture23 {
	private int V; //4 ->0,1,2,3
    private LinkedList<Integer> adjacent[]; 
//    [ll1]
//    [ll2]
    		
 
  //initialize
    Lecture23(int v) 
    { 
        V = v; 
        adjacent = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adjacent[i] = new LinkedList<>(); 
    } 
   //0,3
    void addEdge(int v,int u) 
    { 
        adjacent[v].add(u); 
    } 
  
    void BFS(int source) 
    { 
      
    	boolean visited[] = new boolean[V]; //keep track 
    	LinkedList<Integer> queue= new LinkedList<Integer>();
    	visited[source]= true;
    	queue.add(source);
    	while(queue.size()!=0)
    	{
    		int get= queue.poll();
 
    		System.out.print(get+" ");
    		Iterator<Integer> i= adjacent[get].listIterator();
    		while(i.hasNext())
    		{
    			int item= i.next();
    			if(!visited[item])
    			{
    				visited[item]= true;
    				queue.add(item);
    			}
    		}
    		
    	}
    } 
    
    void DFS(int source)
    {
    	//DFS-> Recursion
    	boolean visited[]= new boolean[V];
    	DFShelper(source,visited);
    }
    void DFShelper(int u, boolean visited[])
    {
        visited[u]= true;
        System.out.print(u+" ");
        Iterator<Integer> i= adjacent[u].listIterator();
        while(i.hasNext())
        {
        	int item= i.next();
        	if(!visited[item])
        	{
        		DFShelper(item,visited); //recursively
        	}
        }
     
    }
    boolean isCyclic()  
    { 
    	boolean[] visited= new boolean[V];
    	boolean[] explored= new boolean[V];
    	for(int i=0;i<V;i++)
    	{
    		if(isCyclichelper(i,visited,explored))
    			return true;
    	}
    	return false;
    	
    } 
    boolean isCyclichelper(int i, boolean[] visited, boolean[] explored)  
    { 
    	if(explored[i])
    		return true; // there is cycle
    	if(visited[i])
    		return false;
    	
    	visited[i]= true;
    	
    	explored[i]= true;
    	//1
    	//3,4,2
    	//2->1
    	LinkedList<Integer> i_neighbours= adjacent[i];
    	for(int neighbour : i_neighbours)
    	{
    		if(isCyclichelper(neighbour,visited,explored))
    		{
    			return true;
    		}
    	}
    	explored[i]= false;
    	
    	return false;
    
    }
    void connectedComponents()
    {
    	//0 2 3
    	// 1 5 6
       boolean[] visited= new boolean[V];
       for(int i=0;i<V;i++)
       {
    	   if(!visited[i])
    	   {
    		   DFShelper(i,visited);
    		   //count++
    		   System.out.println();
    		   
    	   }
       }
    }

}
