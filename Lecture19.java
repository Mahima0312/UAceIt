import java.util.Arrays;

public class Lecture19 {
	//DP 
	
	public static void main(String[] args) {
		System.out.println(fibbo(5));
		System.out.println(fibboTopDown(5, new int[6]));
		System.out.println(fibboBottomUp(5));
		
		System.out.println(mazePath(0, 0, 2, 2));
		System.out.println(mazePathTopDown(0, 0, 2, 2, new int[3][3]));
		System.out.println(MazePathBottomUp(0, 0, 2, 2));
		System.out.println(LCS("abcdgh","aedfhr"));
		int[][] strg= new int[7][7];
		for(int i=0;i<strg.length;i++)
		{
			Arrays.fill(strg[i],-1);
		}
		System.out.println(LCSTD("abcdgh","aedfhr",strg));
		System.out.println(LCSBU("abcdgh", "aedfhr"));
	}
	
	//Recursive Programming
	public static int fibbo(int n)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
        return fibbo(n-1)+fibbo(n-2);
		
	}
	//Top Down Approach -> Recursion + Storage 
	//fibbo(5) 4,3
	// 3,2
	// 2,1
	// 1,0
	
	public static int fibboTopDown(int n, int[] strg) {
		//0->
		//1->
		//.....nth -> nth fibbonacci
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		//0 1 1 2 3 5 
		//fibbo(4)- fibbo(3), (2)
		//0 0 1 1
		if(strg[n]!=0)
		{
			return strg[n];
		}
		
		int result= fibboTopDown(n-1,strg)+ fibboTopDown(n-2,strg);
		
		strg[n]= result;
		
        return result;

	}
	
	//Not use Recursion-->Iterative
    // Bottom Up Approach
	public static int fibboBottomUp(int n) {
		int[] strg= new int[n+1]; //0-n
		strg[0]=0;
		strg[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			strg[i]= strg[i-1]+strg[i-2];
		}
		//O(N)
		return strg[n];
	}
	
	// Dp-> Recursive -> Top Down-> Bottom Up
	
	
	//Recursive 
	public static int mazePath(int cr, int cc, int dr, int dc)
	{
		if(cr==dr && cc==dc)
		{
			return 1;
		}
		int count=0;
		if(cr>dr || cc>dc)
			return 0;
		
		count+=mazePath(cr, cc+1, dr, dc);
		count+=mazePath(cr+1, cc, dr, dc);
		count+=mazePath(cr+1, cc+1, dr, dc);
		
		return count;
		
	}
	
	public static int mazePathTopDown(int cr, int cc, int dr, int dc, int[][] strg) {
		if(cr==dr && cc==dc)
		{
			return 1;
		}
		int count=0;
		if(cr>dr || cc>dc)
			return 0;
		
		if(strg[cr][cc]!=0)
			return strg[cr][cc];
		
		count+=mazePathTopDown(cr, cc+1, dr, dc,strg);
		count+=mazePathTopDown(cr+1, cc, dr, dc,strg);
		count+=mazePathTopDown(cr+1, cc+1, dr, dc,strg);
		
		strg[cr][cc]= count;
		
		return count;

	}

	public static int MazePathBottomUp(int cr, int cc, int er, int ec) {
		
		int[][] strg= new int[er+2][ec+2];
		for(int i= strg.length-2;i>=0;i--)
		{
			for(int j=strg[0].length-2;j>=0;j--)
			{
				if(i==er && j==ec)
				{
					strg[i][j]=1;
					continue;
				}
				strg[i][j]= strg[i+1][j]+ strg[i][j+1]+ strg[i+1][j+1];
				
				
			}
		}
		return strg[0][0];
		

	}
	public static int LCS(String s1, String s2) {
		if(s1.length()==0 || s2.length()==0)
			return 0;
		
		
		
		char ch1= s1.charAt(0); //a
		char ch2= s2.charAt(0); //b
		String ros1=s1.substring(1);
		String ros2= s2.substring(1);
		
		if(ch1==ch2)
		{
			return LCS(ros1,ros2)+1;
		}else
		{
			//abcd
			//bcda
			return Math.max(LCS(s1,ros2),LCS(ros1,s2));
			// abcd, cda->  cd (2)
			//bcd, bcda -> bcd(3)
		}
	
		
	}

	public static int LCSTD(String s1, String s2, int[][] strg) {
		//row-> length of string1
		//column -> length of string2
		if(s1.length()==0 || s2.length()==0)
			return 0;
		char ch1= s1.charAt(0); //a
		char ch2= s2.charAt(0); //b
		String ros1=s1.substring(1);
		String ros2= s2.substring(1);
		
		
		if(strg[s1.length()][s2.length()]!=-1)
			return strg[s1.length()][s2.length()];
		//abc
		//def
		//0
		
		
		int ans=0;
		if(ch1==ch2)
		{
			ans= LCS(ros1,ros2)+1;
		}else
		{
			//abcd
			//bcda
			ans= Math.max(LCS(s1,ros2),LCS(ros1,s2));
			// abcd, cda->  cd (2)
			//bcd, bcda -> bcd(3)
		}
		//5 
		//6->(0-5)
		strg[s1.length()][s2.length()]= ans;
		return ans;
	}

	public static int LCSBU(String s1, String s2) {
		//string -> 6 -> 0:6
		int[][] strg= new int[s1.length()+1][s2.length()+1];
		
		for(int i= s1.length()-1;i>=0;i--)
		{
			for(int j=s2.length()-1;j>=0;j--)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					strg[i][j]= strg[i+1][j+1]+1;
					
				}else {
					strg[i][j]= Math.max(strg[i][j+1], strg[i+1][j]);
				}
			}
		}
		
		return strg[0][0];
		
	}


}
