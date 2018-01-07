#The problem: https://leetcode.com/problems/counting-bits/description/ 
#trivial solution

public int[] countBits(int num) {
		int counts[] = new int[num+1];
		for(int i = 0; i <= num; i++) {
			String binaryString = Integer.toBinaryString(i);
            //System.out.println(binaryString);	
			int count =0;
			for(int j = 0; j < binaryString.length(); j++) {
				if(binaryString.charAt(j)=='1')
					count++;
			}
			counts[i] = count;
			//System.out.println(Integer.toBinaryString(num));			
		}
        return counts;
	}


