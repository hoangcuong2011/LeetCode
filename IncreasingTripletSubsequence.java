public boolean increasingTriplet(int[] nums) {
        int head1 = 0, head2 = 0, middle = 0;
        if(nums.length>0) {
        head1 = nums[0];
        head2 = nums[0];
        middle = nums[0];
            }
        int specific_case = 0; //can be optimized here.
        /*specific_case: 0 -> head 1, not head 2, empty middle
        specific_case: 1 -> head 1, not head 2, not empty middle
          specific_case: 1 -> head 1, head 2, not empty middle
          note: head 2 is always less than head1
        */
        for(int i = 0; i < nums.length; i++) {
            switch(specific_case) {
                case 0:
                    if(nums[i]<=head1) {
                        head1 = nums[i];
                    } else {
                        middle = nums[i];
                        specific_case = 1;
                    }
                    break;
                case 1:
                    if(nums[i]>middle) {
                        return true;
                    } else {
                        if(nums[i]==middle) {
                            //do nothing
                        } else {
                            //nums[i]<middle
                            if(nums[i]>head1) {
                                middle = nums[i];
                            } else {
                                if(nums[i]==head1) {
                                    //do nothing
                                } else {
                                    head2 = nums[i];
                                    specific_case = 2;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if(nums[i]>middle) {
                        return true;
                    } else {
                        if(nums[i]==middle) {
                            head1 = head2;
                            specific_case = 1;
                        } else {
                            //if nums[i]<middle
                            if(nums[i]>head2) {
                            	System.out.println("head 2 " + head2 + nums[i]);
                                head1 = head2;
                                middle = nums[i];
                                specific_case = 1;
                            } else {
                                head2 = nums[i];
                            }
                        }
                    }
                    break;
            }           
        }
        return false;
    }
