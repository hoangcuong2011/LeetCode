//The problem: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

//Trivial solution

public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> list = new List<Integer>();
    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++) {
    		if(hm.containsKey(nums[i])) {
    			int value = hm.get(nums[i]);
    			hm.put(nums[i], value+1);
    			list.add(nums[i]);
    		} else {
    			hm.put(nums[i], 1);
    		}
    	}
    	return list;
    }
