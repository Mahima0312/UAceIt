import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class PractiseContest2 {
	//by making Scanner static, you can use scanner inside other functions other than main as well!
	static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
	
//		String s1= scn.next();
//		String s2= scn.next();	
//		compareMe(s1,s2);
//		compareMe2(s1,s2);
//		if(isSubstring(s1, s2))
//			System.out.println("True");
//		else
//			System.out.println("False");
//		int n= scn.nextInt();
//		String[] cars= new String[n];
//		int[] fine= new int[n];
//		for(int i=0;i<n;i++) {
//			
//			cars[i]= scn.next();
//		}
//		for(int i=0;i<n;i++) {
//	
//			fine[i]= scn.nextInt();
//			
//		}	
//		System.out.println(findChallan(n, cars, fine));
//		String s= scn.next();
//		System.out.println(pairReverse(s));
//		hashBash();
//		statistics();
//		int n= scn.nextInt();
//		LinkedList<Integer> list= new LinkedList<>();
//		for(int i=0;i<n;i++)
//			list.add(scn.nextInt());
//		LinkMe(list);
		int n= scn.nextInt();
		LinkedList<Character> list= new LinkedList<>();
		for(int i=0;i<n;i++)
			list.add(scn.next().charAt(0));
		int k= scn.nextInt();
		removek(list,k);
		
	}
	public static void compareMe(String s1, String s2)
	{
		if(s1.length()==s2.length())
			System.out.println("EQUAL STRINGS");
		String ans= ""; int diff=0;
		if(s1.length()>s2.length())
		{
			ans= "STRING 1";
			diff= s1.length()-s2.length();
		}else {
			ans= "STRING 2";
			diff= s2.length()-s1.length();
		}
		
		System.out.println(ans+"IS GREATER BY "+diff+" UNITS");

	}
	public static void compareMe2(String s1, String s2)
	{
		int ans= s1.compareTo(s2);
		if(ans==0)
			System.out.println("SAME STRINGS");
		else {
			if(ans>0)
				System.out.println("S1 IS LEXICOGRAPHICALLY GREATER");
			else {
				System.out.println("S2 IS LEXICOGRAPHICALLY GREATER");
			}
		}
	}
	
	public static boolean isSubstring(String s, String t) 
	{
		//one way is to use s.substring() function and find all substrings and 
		//check if any is equal to t, or else use two pointer approach:
		int i=0;
		int j=0;
		while(i<s.length() && j<t.length())
		{
			if(s.charAt(i)!=t.charAt(j))
				i++;
			else {
				i++;
				j++;
			}
		}
		if(j==t.length())
			return true;
		return false;
		
	}
	
	public static int findChallan(int n, String[] cars, int[] fine)
	{
		int challan=0;
		for(int i=0;i<n;i++)
		{
			if(isPalindrome(cars[i]))
				challan+= fine[i];
				
		}
		return challan;
	}
	public static boolean isPalindrome(String s)
	{
		int i=0;int j=s.length()-1;
		while(i<=j)
		{
			if(s.charAt(i)!=s.charAt(j))
					return false;
			i++;
			j--;
			
		}
		return true;
	}
	public static String pairReverse(String s)
	{
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<s.length()-1;i+=2)
		{
			sb.append(s.charAt(i+1));
			sb.append(s.charAt(i));
		}
		 if(s.length()%2!=0)
		sb.append(s.charAt(s.length()-1));
		
		return sb.toString();
	}
	public static void hashBash()
	{
		int n= scn.nextInt();
		ArrayList<String> items= new ArrayList<>();
		for(int i=0;i<n;i++)
			items.add(scn.next());
		ArrayList<ArrayList<Integer>> sizes= new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> size_list= new ArrayList<>();
			int no_of_sizes= scn.nextInt();
			for(int j=0;j<no_of_sizes;j++)
				size_list.add(scn.nextInt());
			sizes.add(size_list);			
		}
		int noq= scn.nextInt();
		ArrayList<String> queries= new ArrayList<>();
		for(int i=0;i<noq;i++)
			queries.add(scn.next());
		
		HashMap<String,ArrayList<Integer>> map= new HashMap<>();
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> list= new ArrayList<>();
			int number= sizes.get(i).size();
			for(int j=0;j<number;j++)
			{
				list.add(sizes.get(i).get(j));
			}
			map.put(items.get(i),list);
		}
		for(int i=0;i<noq;i++)
		{
			String ans="{";
			ArrayList<Integer> list= map.get(queries.get(i));
			for(int j=0;j<list.size();j++) {
				ans+=list.get(j);
				if(j!=list.size()-1)
				ans+=",";
			}
			ans+="}";
			System.out.println(queries.get(i)+" is available in following sizes:"+ans);
		}
		
		
	}
	public static void statistics()
	{
		int n= scn.nextInt();
		int[] years= new int[n];
		for(int i=0;i<n;i++)
			years[i]= scn.nextInt();
		int[] stats= new int[n];
		for(int i=0;i<n;i++)
			stats[i]= scn.nextInt();
		
		HashMap<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<n;i++)
		{
			map.put(years[i], stats[i]);
		}
		int noq= scn.nextInt();
		int[] queries= new int[n];
		for(int i=0;i<noq;i++)
			queries[i]= scn.nextInt();
		for(int i=0;i<noq;i++)
		{
			if(map.containsKey(queries[i]))
				System.out.println(map.get(queries[i]));
			else
				System.out.println("No stats");
		}
		
	}

	public static void frequencies()
	{
		int r= scn.nextInt();
		int c= scn.nextInt();
		String[][] matrix= new String[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				matrix[i][j]= scn.next();
			}
		}
		HashMap<String,Integer> map= new HashMap<>();
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(map.containsKey(matrix[i][j]))
				{
					map.put(matrix[i][j], map.get(matrix[i][j])+1);
				}else {
					map.put(matrix[i][j],1);
				}
			}
		}
		int noq= scn.nextInt();
		for(int i=0;i<noq;i++)
		{
			String q= scn.next();
			System.out.print(q+"="+map.get(q));
		}
			
	}
	public static void LinkMe(LinkedList<Integer> list)
	{
	
		LinkedList<Integer> evenlist= new LinkedList<>();
		LinkedList<Integer> oddlist= new LinkedList<>();
		
		for(int i=0;i<list.size();i++)
		{
		  if(list.get(i)%2==0)
			  evenlist.add(list.get(i));
		  else
			  oddlist.add(list.get(i));
		}
		for(int val:evenlist)
		{
			System.out.print(val+" ");
		}
		System.out.println();
		for(int val:oddlist)
		{
			System.out.print(val+" ");
		}
			
	}
	public static void removek(LinkedList<Character> list, int k)
	{
		while(k!=0 && list.size()!=0)
		{
			list.remove(list.size()-1);
			k--;
		}
		for(char val:list)
			System.out.print(val+" ");
	}
}
