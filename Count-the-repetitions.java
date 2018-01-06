# https://leetcode.com/problems/count-the-repetitions/description/ 

public class Interview {

    
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int maxRepeat = 0;
        int S1Length = s1.length()*n1;
        int j = 0;
        int k = 0;
        int i = 0;
        for(int count = 0; count < S1Length; count++) 
        {
            if(i>=s1.length())
                i = 0;
            if(s1.charAt(i)==s2.charAt(j)) {
                j++;
                if(j==s2.length()) {
                    k++;
                    if(k==n2) {
                        maxRepeat++;
                        k = 0;
                    }
                    j = 0;                    
                }
            }
            realIndex++;
        }
        return maxRepeat;
    }
    // Driver method to test the above function
    public static void main(String[] args) {
        System.out.println(new Interview().getMaxRepetitions("caahumeayllfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenazkycxaa", 
                1000000, "aac", 100));

    }
}


#Brute-force approach
