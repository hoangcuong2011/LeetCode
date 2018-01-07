//The problem: https://leetcode.com/problems/maximum-binary-tree/description/
public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode head = null;
        head = constructMaximumBinaryTree(nums, 0, nums.length, head);
        return head;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex, TreeNode head) {
    	if(leftIndex==rightIndex)
    		return null;
        int max = -100000; //suboptimal code, should revise better
        int maxindex = -1;
        for(int i = leftIndex; i< rightIndex; i++) {
        	if(nums[i]>max){
        		max = nums[i];
        		maxindex = i;
        	}
        }
        //OK I got those values;
        head = new TreeNode(max);        
        head.left = null;
        head.right = null;
        head.left = constructMaximumBinaryTree(nums, leftIndex, maxindex, head.left);
        head.right = constructMaximumBinaryTree(nums, maxindex+1, rightIndex, head.right);
        return head;
    }
