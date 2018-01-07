//The problem: https://leetcode.com/problems/find-the-duplicate-number/description/
class Solution {
    public int findDuplicate(int[] nums) {
        int max = -1;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i]>max) {
        		max = nums[i];
        	}
        }
        boolean flags[] = new boolean[max+1];
        for(int i = 0; i < nums.length; i++) {
        	if(flags[nums[i]]==true) {
        		return nums[i];
        	} else {
        		flags[nums[i]] = true;
        	}
        }
        return -1; //useless since the array always has duplicate number
    }
}
