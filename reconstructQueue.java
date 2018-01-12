#The problem: https://leetcode.com/problems/queue-reconstruction-by-height/



class Solution {
    class MyLinkedList {
        int height;
        int front;
        MyLinkedList next;
        public MyLinkedList(int h, int f) {
            this.height = h;
            this.front = f;
            this.next = null;
        }
    }
    public void printArray(int[][] people) {
        for(int i = 0; i < people.length; i++) {
            System.out.println(people[i][0]+"-"+people[i][1]);
        }        
    }
    
    public int[][] printLinkedList(MyLinkedList head, int length) {
    	int[][] results = new int[length][2];
    	//System.out.println("The list ..."); 
    	MyLinkedList tmp  = head;
    	int iterator = 0;
    	while(tmp!=null) {
    		//System.out.println(tmp.height+"-"+tmp.front);
    		results[iterator][0] = tmp.height;
    		results[iterator][1] = tmp.front;
    		tmp = tmp.next;
    		iterator++;
    	}
    	return results;
    	
    }
    public int[][] reconstructQueue(int[][] people) {
        //first I need to sort the array
        int order = 0;
        /*ok I sort the array - I do a simple sort and this can be improved*/
        printArray(people);
        for(int i = 0; i < people.length; i++) {
            for(int j = i+1; j < people.length; j++) {
                if((people[i][0]<people[j][0])||(people[i][0]==people[j][0]&&people[i][1]>people[j][1])) {
                    //swap:
                    int tmp = people[i][0];
                    people[i][0] = people[j][0];
                    people[j][0] = tmp;
                   
                    tmp = people[i][1];
                    people[i][1] = people[j][1];
                    people[j][1] = tmp;                    
                }
            }
        }
        //System.out.println("-----------------");
        //printArray(people);
        //System.out.println("-----------------");
        MyLinkedList mylist_head = null;
        
        if(people.length>0)
        	mylist_head = new MyLinkedList(people[0][0], people[0][1]);
        
       
        for(int i = 1; i < people.length; i++) {
            if(people[i][0]==people[0][0]) {
                //just add to the tail of the linkedlist
                MyLinkedList mylist_pointer = mylist_head;
                while(mylist_pointer.next!=null) {
                    mylist_pointer = mylist_pointer.next;
                }
                MyLinkedList tmp = new MyLinkedList(people[i][0], people[i][1]);
                mylist_pointer.next = tmp;
            } else {
                //I will walk from head to the tail to see where I should put it appropriately
                
                if(people[i][1]==0) {
                    //OK I put it on the head for sure.
                    MyLinkedList mylist_pointer = new MyLinkedList(people[i][0], people[i][1]);
                    mylist_pointer.next = mylist_head;
                    mylist_head = mylist_pointer; //update the head                    
                } else {
                    int tempFront = 0;
                    MyLinkedList mylist_pointer = mylist_head;
                    while(true) {
                        if(people[i][0]<=mylist_pointer.height)
                            tempFront++;
                        if(tempFront==people[i][1]) {
                            //two case: and the very tail and not
                            //if tail: easy:
                            if(mylist_pointer.next==null) {
                                MyLinkedList newNode = new MyLinkedList(people[i][0], people[i][1]);
                                mylist_pointer.next = newNode;                                
                            } else {
                                //thing is slightly more complicate
                                //MyLinkedList tmp = new MyLinkedList(mylist_pointer.next.height, mylist_pointer.next.front, mylist_pointer.next.next);                           
                            	
                                MyLinkedList newNode = new MyLinkedList(people[i][0], people[i][1]);
                                newNode.next = mylist_pointer.next;
                                mylist_pointer.next = newNode;                                
                            }                            
                            break;
                        }
                        mylist_pointer = mylist_pointer.next;
                    }
                }                
            }
            
        }
        
        return printLinkedList(mylist_head, people.length);
    }
    public static void main(String args[]) {
        Solution program = new Solution();
        //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        int people[][] = new int[0][2];

        program.reconstructQueue(people);
        
    	
    }
}
