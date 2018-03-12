/*
  Team Potato Couches (Larry Wong, Ying Xin Jiang)
  APCS2 pd8
  HW07 -- A Man, A Plan, A Canal: Panama!
  2018-02-13
*/

public class Resrever{

    //Goal: "stressed"  ->  "desserts"

    //O(n)
    //uses a for loop that goes through each character in the string
    //in the reverse order and puts it into a new string
    public static String reverseLinear(String str){

	String reverse = "";
	for (int i = str.length()-1; i >= 0; i--){
	    reverse += str.charAt(i);
	}// for loop
	return reverse;

	//O(n) because the loop touches each character in the String exactly once
	//and adds to  another string
    }//end reverseLinear

    //O(log2n)
    //uses recursion to switch the first half of the string
    //with the last half of the string
    //EX.           "abcd" -> "cdab"
    //By recursion: "ab" -> "ba"
    //              "cd" -> "dc"
    //Adding the String back together: "dcba"
    
    public static String reverseLog(String str){

	if (str.length() == 1){
	    return str;//basecase
	}else{
	    int length = str.length() / 2;//constant runtime time operation
	    return reverseLog(str.substring(length)) +
		reverseLog(str.substring(0,length));
	    //reversing order is a constant runtime operation
	    
	    //Reverses order of first half & second half of the String
	    //Within the halves, the order of the first half and the second half is reversed
	    //Repeats until length is 1
	    
	    //O(log2n) because the method is called log2n times for the number of elements n
	    //         Each call contains 2 constant runtime operations (getting half the length & reversing order)
	    // "ab" -> 1 call
	    // "abcd" -> 2 call
	}

    }//end reverseLog

    

    public static void main(String[] args){

	//Test cases

	//Testing reverseLinear()
	System.out.println("\nTesting the n method for functionality:");
	System.out.println(reverseLog("\nTesting the n method for functionality:"));
	System.out.println("Input: stressed \nOutput: " + reverseLinear("stressed"));//desserts
	System.out.println("Input: abc \nOutput: " + reverseLinear("abc"));//cba
	System.out.println("Input: tunnel \nOutput: " + reverseLinear("tunnel"));//lennut
	System.out.println("Input: sunlight \nOutput: " + reverseLinear("sunlight"));//thgilnus
	
	//Testing reverseLog()
	System.out.println("\nTesting the log2n method for functionality:");
	System.out.println(reverseLog("\nTesting the log2n method for functionality:"));
	System.out.println("Input: stressed \nOutput: " + reverseLog("stressed"));//desserts
	System.out.println("Input: run \nOutput: " + reverseLog("run"));//nur
	System.out.println("Input: potato \nOutput: " + reverseLog("potato"));//otatop
	System.out.println("Input: abcdefghi \nOutput: " + reverseLog("abcdefghi"));//ihgfedcba

    }//end main()

}//end class
