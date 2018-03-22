https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

My own solution, but it is not as efficient as the algorithm presented in the link.


public class Enumeration {
    Set<String> Finalset = new HashSet<String>();
    public HashSet<Integer> deepCopy(HashSet<Integer> set) {
        //The goal is to create a deep copy for the set
        HashSet<Integer> dup = new HashSet<Integer>();
        for (int s : set) {
            dup.add(s);
        }
        return dup;
    }
    public void myEnumeration(HashSet<Integer> set, String str, String currentStr) {
        if(set.size()==0) {
        	System.out.println(currentStr);
            Finalset.add(currentStr);
        } else {
            for(int i : set) {
            	HashSet<Integer> tmp = deepCopy(set);
                char c = str.charAt(i);
                tmp.remove(i);
                myEnumeration(tmp, str, currentStr+c);
                
            }
        }
    }
    public static void main(String[] args) {
    	Enumeration program = new Enumeration();
        String str = "abcd";
        HashSet<Integer> root = new HashSet<Integer>();
        for(int i = 0; i < str.length(); i++) {
            root.add(i);
        }
        program.myEnumeration(root, "abcd", "");
    }
}
