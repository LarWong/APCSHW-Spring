/*
Larry Wong
APCS2 pd8
HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
2018-02-06
*/

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:

  ======================================*/

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int[] merged = new int[ a.length + b.length ]; // creates a new array for holding
	
	int aIndex = 0; // keeps index for a
	int bIndex = 0; // keeps index for b
	int mIndex = 0; // keeps index for merged 

	while(aIndex < a.length && bIndex < b.length){
	    if (a[aIndex] < b[bIndex]){
		merged[mIndex] = a[aIndex];
		aIndex++;
	    } else {
		merged[mIndex] = b[bIndex];
		bIndex++;
	    }
	    mIndex++;

	}//merges in order until all elements in at least one array is in merged
	
	while(aIndex < a.length){
	    merged[mIndex] = a[aIndex];
	    mIndex++;
	    aIndex++;
	}// for any left over items in a 

	while(bIndex < b.length){
	    merged[mIndex] = b[bIndex];
	    mIndex++;
	    bIndex++;
	}// for any left over items in b
	
      
	return merged;
    }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/

    public static int[] sort( int[] arr )
    {
	if (arr.length == 1){
	    return arr; // basecase: array w/ 1 item is sorted
	}else{
	    //splitting array into 2 subarrays
	    int firstHalf = arr.length/2;
	    int secondHalf = arr.length - firstHalf;
	  
	    int[] a1 = new int[firstHalf];
	    for (int f = 0; f < firstHalf; f++){
		a1[f] = arr[f];
	    } 
	  
	    int[] a2 = new int[secondHalf];
	    for (int s = firstHalf; s < arr.length; s++){
		a2[s-firstHalf] = arr[s];
	    }

	    
	    return merge( sort(a1) , sort(a2) );// return merged array of sorted subarrays
	}
    }//end sort()
 



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

    
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 ); // returns an array with all zeros, mess() directly alters the items

	  System.out.println("\nMerging arr1 and arr0: ");
	  printArray( merge(arr1,arr0) ); // input arrays are sorted

	 
	  System.out.println("\nMerging arr4 and arr6: ");
	  printArray( merge(arr4,arr6) ); // input arrays are not sorted


	   
	  System.out.println("\nSorting arr4-7...");
	  printArray( sort( arr4 ) );
	  printArray( sort( arr5 ) );
	  printArray( sort( arr6 ) );
	  printArray( sort( arr7 ) );
	  /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
