package how2do.injava;

import java.util.*;

public class Anagrams {

	public static void main(String[] args) {
		List<String> result = Arrays.asList("fakharm",  "code", "4444", "oecd", "mumtazbut", "right", "fakhmar", "mumtaz", "thgri");
		funWithAnagrams(result);
	}
	
	public static List<String> funWithAnagrams(List<String> text) {
	    // Write your code here
	       List<String> resultList = new ArrayList<>();
	       for(int i = 0 ; i < text.size(); i++) {
	    	   String s = text.get(i);
	    	   int sLen = s.length();
	    	   for(int j = i + 1; j < text.size() ; j++) {
	    		   String t = text.get(j);
	    		   int tLen = t.length();
	    		   System.out.println("("+i + ", " + j+")");
	    		   if(sLen == tLen ) {
	    			   String a = s; 
	    			   String b = t;
	    			   System.out.println(s + "" + t);
	    			   boolean f = true;
	    			   for (int k = 0; k < s.length() ; k++) {
	    				   Character c = s.charAt(k);
	    				   f = t.contains(c.toString()) && f;
	    				   if(f == false ) break ;	    				   
	    			   }
	    			   System.out.println(f);
	    				   
	    		   }
	    	   }
	       }

	       return resultList;
	    }
}
