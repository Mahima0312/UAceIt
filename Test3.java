import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		String str= scn.next();
		
		System.out.println(superReducedString(str));
	}
	
	public static String superReducedString(String s) {
	       StringBuilder sb = new StringBuilder(s);
	        for(int i = 1; i < sb.length(); i++) {
	            if(sb.charAt(i) == sb.charAt(i-1)) {
	                sb.delete(i-1, i+1);
	                i = 0;
	            }
	        }
	        if(sb.length() == 0) return "Empty String";
	        else return sb.toString();
	    }

}
