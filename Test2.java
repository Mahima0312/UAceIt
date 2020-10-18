import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		
		Scanner scn= new Scanner(System.in);
		String s1= scn.next();
		String s2= scn.next();
//		String str= scn.next();
//		plantingSaplings(str);
//		System.out.println(toggle(str));
//		System.out.println(sweetestCharacter(str));
		boolean ans= anagram(s1,s2);
		if(ans)
			System.out.println("True");
		else
			System.out.println("False");
				
	}
	
	public static void plantingSaplings(String str)
	{
		String even="";
		String odd="";
		for(int i=0;i<str.length();i++)
		{
			if(i%2==0)
				even+= str.charAt(i);
			else
				odd+=str.charAt(i);
		}
		System.out.println(even);
		System.out.println(odd);
	}
	
	public static String toggle(String str)
	{
		if(str== str.toLowerCase())
			return str.toUpperCase();
		else
			return str.toLowerCase();
	}
	
	
	public static char sweetestCharacter(String str)
	{
		
		HashMap<Character,Integer> hashmap= new HashMap<>();
		
		for(int i=0;i<str.length();i++)
		{
			char ch= str.charAt(i);
			if(hashmap.containsKey(ch))
			{
				int value = hashmap.get(ch);
				value++;
				hashmap.put(ch,value);
				
			}else {
				
				
				hashmap.put(ch,1);
			}
		}
		int max= Integer.MIN_VALUE;
		char maxchar =0;
	
		for(char key: hashmap.keySet())
		{
			if(hashmap.get(key)>max)
			{
				max= hashmap.get(key);
				maxchar= key;
			}
		}
		return maxchar;
		
	}
	
	public static boolean anagram(String s1, String s2)
	{
		HashMap<Character,Integer> map= new HashMap<>();
		for(int i=0;i<s1.length();i++)
		{
			if(map.containsKey(s1.charAt(i)))
			{
				map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
			}else {
				map.put(s1.charAt(i), 1);
			}
		}
		for(int i=0;i<s2.length();i++)
		{
			if(map.containsKey(s2.charAt(i)))
			{
				map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
			}else {
				return false;
			}
		}
		
		for(char key: map.keySet())
		{
			if(map.get(key)!=0)
				return false;
		}
	
		
		return true;

	}

}
