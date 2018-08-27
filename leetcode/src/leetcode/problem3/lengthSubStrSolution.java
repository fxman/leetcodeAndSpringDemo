package leetcode.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Character;
public class lengthSubStrSolution {
	 public int lengthOfLongestSubstring(String s) {
		 char[] sChar = s.toCharArray();
		 Map<String ,List<Integer>> map = new HashMap<>();
		 int maxLength = 0;
	        for(int i = 0 ; i < sChar.length ; i++){
	        	if(map.containsKey(Character.toString(sChar[i]))){
	        		map.get(Character.toString(sChar[i])).add(i);
	        	}else{
	        		List list = new ArrayList<Integer>();
	        		list.add(i);
	        		map.put(Character.toString(sChar[i]), list);
	        	}
	        }
	        
	       if(map.size() == sChar.length)
	    	   return sChar.length;
	       for(String temp : map.keySet()){
	    	   List<Integer> indexList =  map.get(temp);
	    	      if(indexList.size() == 1 && maxLength == 0){
	    	    	  maxLength = 1;
	    	      }
	    	      for(int i = 1 ; i < indexList.size() ; i++){
	    	    	  int a = indexList.get(i-1);
	    	    	  int b = indexList.get(i);
	    	    	  if (b-a > maxLength ){
	    	    		  maxLength = b - a;
	    	    	  }
	    	      }
	    	    
	       }
		 return maxLength;
	 }
	 
	 public static void main(String[] args){
		 String s = "aab";
		 lengthSubStrSolution so = new  lengthSubStrSolution();
		 System.out.println(so.lengthOfLongestSubstring(s));
	 }
}
