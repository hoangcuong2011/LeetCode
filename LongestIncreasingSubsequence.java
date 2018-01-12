//The problem: https://leetcode.com/problems/longest-increasing-subsequence/description/

class Solution {    
    public int lengthOfLIS(int[] nums) {
        //step 1 - count the number of elements that are less then the current element.
        int previous_less_variable_counts[] = new int[nums.length];
        int maximumSeq[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j]<nums[i]) {
                    previous_less_variable_counts[i] = previous_less_variable_counts[i]+1;
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j]<nums[i]) {
                    if(maximumSeq[j]+1>max) {
                        max = maximumSeq[j]+1;
                    }
                }
            }
            maximumSeq[i] = max;            
        }
        
        //At the end we have an array of maximumSeq with max values, we simply get the maximum number
        int maxLength = -1;
        for(int i = 0; i < maximumSeq.length; i++) {
            //System.out.println(maximumSeq[i]);
            if(maximumSeq[i]>maxLength)
                maxLength = maximumSeq[i];
        }
        return maxLength+1;
    }
}
