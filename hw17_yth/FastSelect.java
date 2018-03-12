/*
Larry Wong
APCS2 - pd8
HW17 -- So So Fast
2018-03-11
*/
public class FastSelect{

  /*
  swap()
  Precondition: array and the index of 2 elements to be swapped
  Postcondition: the elements are swapped in the arrays
  */
  public static void swap(int[] arr, int x, int y){
    int holder = arr[x];
    arr[x] = arr[y];
    arr[y] = holder;
  }

  /*
  partition()
  Precondition: given a array, the LH bound, the RH bound and the position of the pivot element
  Postcondition: return the final position of the pivot element,
                  array is rearranged so that all elements less than the pivot element are to the lrft of the pivot element and all the elements greater than the pivot element are to the right of the pivot elements
                  (not in any order)
  Runtime: O(n) - has to go through each element to determine if it is greater than for less than the pivot element
  */

  public static int partition(int[] arr, int left, int right, int pvtPos){
    int centerPoint = arr[pvtPos];

    swap(arr,pvtPos,right);

    int starPos = left;
    //begin rearrangement
    for (int i = left; i < right; i++){

      //move values smaller than point to one side
      if (arr[i] < centerPoint){
        swap(arr,starPos,i);
        starPos += 1;
      }
    }

    //move point back to original location
    swap(arr,right,starPos);

    //return the location of pivot element
    return starPos;
  }//end pointRearrangement

  /*
  fastSelect() - wrapper method
  Precondition: given an array, the ranking of the element that is sought after (yth element)
  Postcondition: return the yth smallest element, array is rearranged so that the yth element is the pivot point of the array
  */
  public static int fastSelect(int[] arr, int y){
    return fastSelectR(arr, y, 0, arr.length-1);
  }

  /*
  fastSelectR() - search method (Recursion)
  Precondition: given an array, the ranking of the element that is sought after (yth element), the left hand and right hand bounds
  Postcondition: return the yth smallest element, array is rearranged so that the yth element is the pivot point of the array

  Details:
  Uses partition() and chooses the middle element of the array to be the pivot point
  The integer, n, that is returned from partition() is the index of the pivot element, the index of the pivot point is the final location of the element. This means that the pivot element is the nth element of the array.
  Next, since the array is divided into two sections, with the pivot element being the divider, compare y with the index of the pivot elements.
  If y > pivot index, then the yth smallest element is to the right of the pivot, and if y < pivot index, then the yth smallest element is to the left of the pivot.
  Repeat partition() with updated parameters (int left and int right) that match the section to the left or to the right of the pivot (depending where y is).
  This repeats until the pivot index matches the y (the rank of the smallest integer).

  Runtime:
  - Best case: O(n) - the pivot element is the yth smallest number (runs partition() once)
  - Worst case: O(n^2) - looking for the 1st smallest in a sorted array (runs partition(), O(n), until pivot moves to the first element = n/2 times)
  */
  public static int fastSelectR(int[] arr, int y, int begin, int end){

    //used to count how many time method has run
    System.out.println("Run once");

    int s = partition(arr, begin, end, (end-begin)/2);

    //yth smallest element in a sorted array would be at index y-1
    if (s == y-1){
      return arr[s];
    } else if (s > y-1){
      //updates bounds: from pivot and before
      return fastSelectR(arr, y, begin, s-1);
    } else {
      //updates bounds: from pivot and after
      return fastSelectR(arr, y, s+1, end);
    }

  }

  public static void main(String[] args){
/*
//Test cases:
    int[] arr0 = {0};
    System.out.println(fastSelect(arr0, 1));//0

    int[] arr1 = {1,0};
    System.out.println(fastSelect(arr1, 1));//0

    int[] arr2 = {2,7,4};
    System.out.println(fastSelect(arr2, 2));//4

    int[] arr3 = {3,8,8,6,9};
    System.out.println(fastSelect(arr3, 2));//6

    int[] arr4 = {4,7,2,6,8,1};
    System.out.println(fastSelect(arr4, 6));//8

    int[] arr5 = {4,7,2,6,8,1,7};
    System.out.println(fastSelect(arr5, 1));//1
*/

    //BEST CASES: ONLY RUNS ONCE
    System.out.println("Best:");
    int[] best0 = {1,2,3};
    System.out.println(fastSelect(best0, 2));//2
    int[] best1 = {1,2,3,4,5};
    System.out.println(fastSelect(best1, 3));//3
    int[] best2 = {1,2,3,4,5,6,7};
    System.out.println(fastSelect(best2, 4));//4

    //WORST CASES: RUNS n/2 times
    System.out.println("Worst:");
    int[] worst0 = {1,2,3,4};
    System.out.println(fastSelect(worst0, 1));//2
    int[] worst1 = {1,2,3,4,5,6};
    System.out.println(fastSelect(worst1, 1));//2
    int[] worst2 = {1,2,3,4,5,6,7,8};
    System.out.println(fastSelect(worst2, 1));//2
  }
}
