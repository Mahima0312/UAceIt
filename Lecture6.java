import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lecture6 {
	
	
	public static void main(String[] args) {
		//"java"
		
		//"java"
		
		
//		String s1= "java";
//		String s2= "java";
//		
//		String s3= new String("java");
//		int[] arr= new int[100];
//		
//		
//		System.out.println(s1==s2); //true
//		System.out.println(s1==s3); //false
//		
//		
//		System.out.println(s1.equals(s3));
//		
		
		
		//Immutable
//		StringBuilder sb= new StringBuilder();
//		sb.append("java");
//		
//		
//		sb.insert(2, "p");
		
		//"java"
		
		//"ilovejava"
		//"ijava"
		
//		
//		String str= "ilovejava";
////		str+="bkfw"
//	
//		String ans = str.substring(0,1)+str.substring(5);
//		System.out.println(ans);
//	
//		
//		//japva
//		sb.delete(2,4);
//		sb.dele
		//ilovegeeksforgeeks
//		System.out.println(sb.indexOf("pva"));
//		System.out.println(sb);
		
		
//		String myname= "name";
//		
//		StringBuilder mysb= new StringBuilder(myname);	
//		mysb.deleteCharAt(2);
//		System.out.println(myname);
//		System.out.println(mysb);
			
//		String myname= "mahima";
//		
//		
//		StringBuilder sb2= new StringBuilder();
//		sb2.append("java");
//		sb2.deleteCharAt(2);
		
		//mahima - {2,4,5,6,7};
		//prateek- {3,5,0,6,8};
		//simran - {4,7,8,9,3};
		
//		HashMap<String,ArrayList<Integer>> map= new HashMap<>();
		
		
		
		
		//map.put(key,value)
		//map.get()
		//map.containsKey('p');
		//map.isEmpty()
		
		
		
		frequency("mahima");
		
				
		
		//"java"
		//0 1 23 
		
		//japva
		
        //.addAt
		//"janananava"
		
		
	}
	//"mahima"
	
	public static void frequency(String str)
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
		//mahima
		//m->2
		//a->1
		//h->1
		//i->1
//		
//		for(char ch: map.keySet())
//		{
//			System.out.println(ch+" "+map.get(ch));
//			
//		}
//		List
//		ArrayList
//		Map
		
		for(Map.Entry<Character,Integer> entry: hashmap.entrySet())
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
//		
//		
//		for(int i=0;i<str.length();i++)
//		{
//			System.out.println(str.charAt(i)+" "+map.get(str.charAt(i)));
//			
//		
//		}
		
		
	}

}
