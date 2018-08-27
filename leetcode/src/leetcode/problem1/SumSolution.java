package leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

public class SumSolution {

	public int[] twoSum(int[] nums, int target) {
           for(int i = 0 ; i < nums.length ; i++){
        	     for( int j = i+1 ; j < nums.length ; j++){
        	    	   if(target - nums[i] == nums[j]){
        	    		   return new int[]{i,j};
        	    	   }
        	     }
           }
           throw new IllegalArgumentException("No two sum solution");
	}
	
	
	public int[] twoSumByHashmap(int[] nums, int target){
		Map<Integer,Integer> numMap = new HashMap<>();
		for(int i = 0 ; i < nums.length ; i++){
			numMap.put(nums[i], i);
		}
		for(int i = 0 ; i < nums.length ; i++){
			int tem = target - nums[i];
			if(numMap.containsKey(tem) && numMap.get(tem)!=i){
				return new int[]{i,numMap.get(tem)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] twoSumByHashMap2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	 public static void main(String[] args){
		int[] nums = new int[]{-1, -2, -3, -4,-5};
		SumSolution ss = new SumSolution();
		int[] res = ss.twoSum(nums, -8);
		System.out.println(res[0] + "   " + res[1]);
		
		int[] res1 = ss.twoSumByHashmap(nums, -8);
		System.out.println(res1[0] + "   " + res1[1]);
		
		
	 }

}
