//Larry Wong
//APCS2 pd8
//HW18 -- So So Quick
//2018-03-13t

/*****************************************************
* class QuickSort
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr):
1. Uses partition() with the starting index of set of values to be organized, the ending index of set of values to be organized and the index of the random element as the pivot.
2. Uses the index of the pivot point after partition() to divide the array into two parts: the left (smaller that pivot) and the right (larger than the pivot)
3. Repeat the first and second step with both of these parts
4. Algorithm stops once the starting index and the ending index overlap, in other words, it stops when the set of numbers to be partitioned has a size of one
*
* 2a. Worst pivot choice and associated runtime:
* The worst pivot choice occurs when the array is already sorted. If the algorithm calls for the right most element and the right most element is the largest, then it would not divide the array into one section (the rest of the array). Then, that section is to be quicksorted, but since the pivot point is the second largest element, the subarray is divided into one array (all the elements smaller than it). This repeats until the first and smallest element is reached. This means the tha program must go through each element while calling partition(). Otherwise, in an unsorted array, it is unknown if the elements follow in a similar fashion since the location of each element is not in any order, so there wouldn't be a worst pivot point.
The runtime is: O(n^2)
* 2b. Best pivot choice and associated runtime:
* The best pivot choice is a random pivot when the array. This means that the worst case would be less likely to occur and if it does occur, then there is a higher chance for the pivot point to be in somewhere in the middle, where two subarrays will be formed.
The runtime is: O(nlogn)
* 3. Approach to handling duplicate values in array:
THe partition algorithm takes care of the duplicates. After selecting a pivot point, all elements are rearranged in relation to the pivot. Duplicates move together in relation with the pivot point. When the array is divided to be quicksorted, either these duplicates will move together or they will be split apart by the dividion. If they split into separate quicksorts, they will be place next to each other by the end of the quicksorts. If they move together, then they will continue to move together until they get split by a partition.
*
*****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------

  /*****************************************************
  * int partition(arr,left,right,pvtPos)
  * @param arr initial array of integers
  * @param left starting index of set of values in arr to be organized
  * @param right ending index of set of values in arr to be organized
  * @param pvtPos index whose corresponding value is used to determine what
  Precondition: given a array, the LH bound, the RH bound and the position of the pivot element
  Postcondition: return the final position of the pivot element,
  array is rearranged so that all elements less than the pivot element are to the left of the pivot element and all the elements greater than the pivot element are to the right of the pivot elements
  (not in any order)
  *****************************************************/
  public static int partition(int[] arr, int left, int right, int pvtPos){

    int centerPoint = arr[pvtPos];
    swap(pvtPos,right,arr);

    int starPos = left;
    for (int i = left; i < right; i++){
      if (arr[i] < centerPoint){
        swap(starPos,i,arr);
        starPos += 1;
      }
    }
    swap(right,starPos,arr);

    return starPos;
  }

  /*****************************************************
  * void qsort(int[]) - wrapper method
  * @param d -- array of ints to be sorted in place
  Precondition: an unsroted array
  Postcondition: a sorted array
  *****************************************************/
  public static void qsort( int[] d )
  {
    qsortR(d, 0 , d.length-1);
  }

  /*****************************************************
  * void qsortR(int[],left,right)
  * @param d -- array of ints to be sorted in place
  * @param left -- the index of the left bound, starting index of set of values in d to be quicksorted
  * @param right -- the index of the right bound, ending index of set of values in d to be quicksorted
  Precondition: unsorted array, starting left bound and the starting right bound
  Postcondition: the array is sorted
  *****************************************************/
  public static void qsortR(int[] d, int left, int right){

    if (left < right){
      int pvtPos = partition(d,left,right,(left+(int)(Math.random()*(right-left+1))));
      qsortR(d,left,pvtPos-1);
      qsortR(d,pvtPos+1,right);
    }

  }

  //main method for testing
  public static void main( String[] args )
  {

    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/




    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
