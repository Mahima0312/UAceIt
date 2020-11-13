import java.util.Arrays;

public class Lecture20 {
	public static void main(String[] args) {
		
		System.out.println(WildCardMatch("abcaab", "a?*b*"));
		System.out.println(WildCardMatchTD("abcaab", "a?*b*", new int[7][6]));
		System.out.println(WildCardMatchBU("abcaab", "a?*b*"));
		int[] weights= {1,3,7,6};
		int[] profit= {60,45,100,12};
		int capacity=15;
		System.out.println(Knapsack(weights, profit, 0, capacity));
		int[][] strg=new int[weights.length+1][capacity+1];
		for(int[] arr: strg)
		{
			Arrays.fill(arr, -1);
		}
		System.out.println(KnapsackTD(weights, profit, 0, capacity,strg ));
		System.out.println(KnapsackBU(weights, profit, capacity));
		int[] denom= {1,2,3};
		System.out.println(CoinChange(denom, 0,4));
		int target=4;
		System.out.println(CoinChangeTD(denom, 0,target, new int[denom.length+1][target+1]));
		System.out.println(CoinChangeBU(denom, 0,4));
		
	
		
		
	}
	public static boolean WildCardMatch(String src, String pat) {
		
		if(src.length()!=0 && pat.length()==0)
		{
			return false;
			//src: abc
			//pat: ""
		}
		
		if(src.length()==0 && pat.length()!=0)
		{ //****** //*?a*
		  //""
			for(int i=0;i<pat.length();i++)
			{
				if(pat.charAt(i)!='*')
					return false;
			}
			return true;
			
			
		}
		if(src.length()==0 && pat.length()==0)
			return true;
		
		
		char ch1= src.charAt(0);
		char ch2= pat.charAt(0);
		String ros= src.substring(1);
		String rop= pat.substring(1);
		if(ch1==ch2 || ch2=='?')
		{
			return WildCardMatch(ros, rop);
		}else if(ch2=='*') {
			
			return WildCardMatch(src, rop) || WildCardMatch(ros, pat);
			
		}else {
			return false;
		}
		//a c->false
		
		

	}

	public static int WildCardMatchTD(String src, String pat, int[][] strg) {
		//0> answer is not filled
		//1->answer is false
		//2 -> answer is true
		
		if(src.length()!=0 && pat.length()==0)
		{
			return 1;
			//src: abc
			//pat: ""
		}
		
		if(src.length()==0 && pat.length()!=0)
		{ //****** //*?a*
		  //""
			for(int i=0;i<pat.length();i++)
			{
				if(pat.charAt(i)!='*')
					return 1;
			}
			return 2;
			
			
		}
		if(src.length()==0 && pat.length()==0)
			return 2;

		if(strg[src.length()][pat.length()]!=0)
		{
			return strg[src.length()][pat.length()];
		}
		
		
		char ch1= src.charAt(0);
		char ch2= pat.charAt(0);
		String ros= src.substring(1);
		String rop= pat.substring(1);
		int ans= 0;
		if(ch1==ch2 || ch2=='?')
		{
			if(WildCardMatchTD(ros, rop,strg)==2)
				ans=2;
			else if(WildCardMatchTD(ros, rop,strg)==1)
				
				ans=1;
		}else if(ch2=='*') {
			
			if( WildCardMatchTD(src, rop,strg) ==2 || WildCardMatchTD(ros, pat,strg)==2)
				ans=2;
			else
				ans=1;
			
		}else {
			ans= 1;
		}
		
		strg[src.length()][pat.length()]=ans;
		//a c->false
		return ans;

	}

	public static boolean WildCardMatchBU(String src, String pat) {
		
		boolean[][] strg= new boolean[src.length()+1][pat.length()+1];
		
		for(int i= src.length();i>=0;i--)
		{
			for(int j=pat.length();j>=0;j--)
			{
				if(i==src.length() && j==pat.length())
				{
					strg[i][j]= true;
					continue;
				}
				if(j==pat.length())
				{
					strg[i][j]=false;
					continue;
				}
				if(i==src.length())
				{
					if(pat.charAt(j)=='*')
					{
						strg[i][j]= strg[i][j+1];
					}else {
						strg[i][j]=false;
					}
					continue;
				}
				char chs= src.charAt(i);
				char chp= pat.charAt(j);
				if(chs==chp || chp=='?')
				{
					strg[i][j]= strg[i+1][j+1];
				}else if(chp=='*')
				{
					strg[i][j]= strg[i+1][j] || strg[i][j+1];
				}else
					strg[i][j]= false;
				
			}
		}
		
		return strg[0][0];

	}
	
	public static int Knapsack(int[] weights, int[] profit, int idx, int capacity) {
		
		if(idx==weights.length)
			return 0;
		
		int exclude= Knapsack(weights, profit, idx+1, capacity); // daala nahi hai in sack
		
		
		int include= 0; //daal diya in sack
		if(capacity>=weights[idx])
		{
			include= Knapsack(weights, profit, idx+1, capacity-weights[idx])+ profit[idx];
		}
		
		return Math.max(include, exclude);

	}

	public static int KnapsackTD(int[] weights, int[] profit, int idx, int capacity, int[][] strg) {
		//idx, cap
		if(idx==weights.length)
			return 0;
		
		if(strg[idx][capacity]!=-1)
		{
			return strg[idx][capacity];
		}
		
		int exclude= KnapsackTD(weights, profit, idx+1, capacity,strg); // daala nahi hai in sack
		
		
		int include= 0; //daal diya in sack
		if(capacity>=weights[idx])
		{
			include= KnapsackTD(weights, profit, idx+1, capacity-weights[idx],strg)+ profit[idx];
		}
		
		 int ans= Math.max(include, exclude);
		 strg[idx][capacity]=ans;
		
		return ans;

		

	}

	public static int KnapsackBU(int[] wt, int[] price, int cap) {
		
		int[][] strg= new int[wt.length+1][cap+1];
		for(int i=wt.length-1;i>=0;i--)
		{
			for(int c=1;c<=cap;c++)
			{
				int exclude= strg[i+1][c];
				int include=0;
				if(c>=wt[i])
				{
					include= strg[i+1][c-wt[i]]+price[i];
				}
				int ans= Math.max(include,exclude);
				
				strg[i][c]=ans;
			}
		}
		
		return strg[0][cap];
		

	}

	public static int CoinChange(int[] denom, int vidx, int target) {
		
		if(target==0)
			return 1;
		if(vidx==denom.length )
			return 0;
		if(target<denom[vidx])
			return 0;
		
		int count=0;
		//when coin is selected
		count+= CoinChange(denom, vidx, target-denom[vidx]); //8, (2,5,3,8)
		
		//when coin is  not selected
		count+= CoinChange(denom, vidx+1, target); // 10, (5,3,8)
		
		return count;


	}

	public static int CoinChangeTD(int[] denom, int vidx, int target, int[][] strg) {
		//unlimited access of coins

		if(target==0)
			return 1;
		if(vidx==denom.length )
			return 0;
		if(target<denom[vidx])
			return 0;
		
		if(strg[vidx][target]!=0)
			return strg[vidx][target];
		
		int count=0;
		//when coin is selected
		count+= CoinChangeTD(denom, vidx, target-denom[vidx],strg); //8, (2,5,3,8)
		
		//when coin is  not selected
		count+= CoinChangeTD(denom, vidx+1, target,strg); // 10, (5,3,8)
		
		strg[vidx][target]=count;
		
		return count;


	}
	//minimum jumps reqd
	//staircase

	public static int CoinChangeBU(int[] denom, int vidx, int target) {
		
		int[] strg= new int[target+1];
		strg[0]=1; //base case
		for(int coin: denom)
		{
			for(int i=coin;i<strg.length;i++)
			{
				//target->4, coin->2 ,
				//target->5, coin->3
				strg[i]+= strg[i-coin];
			}
		}
		
		return strg[target];

	}

}
