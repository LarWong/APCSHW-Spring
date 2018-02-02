//Team Walking in a Weiner Wongerland (Larry Wong, Joshua Weiner, Eric Wong)
//APCS pd8
//HW03 -- I Am Still Searching
//2018-02-02

/*
First, we check the four corner values. We check if our target value CAN exist
by checking if our target value is greater than or equal to the value at the top left and if our target is less than or equal to the value at the bottom. If our target does not lie within that range, we can return -1 without having to iterate through the array to find a value which cannot exist within it.
We also check the top right value to see if our target matches that. This eliminates the longest "worst case."

Then, if we have found that the target is in the array, we begin our
algorithm at the the lower left. If the value at this location is
lower than the target, we check the value to the right of it (towards the larger
values). If the value at this location is higher than the target, we check the
value above it (towards the smaller values). This process continues until the
target is found or the indices go out of bounds (meaning, the value does not
exist in the array).
*/
public class MatrixFinder
{
  public static String Finder(int[][] array, int target) {
    int nRows = array.length;
    int nCols = array[0].length;
    int curRow = nRows - 1;
    int curCol = 0;
    String retStr = "(";
    //checks if the value is within the boundaries of the array
    if(array[nRows-1][nCols-1] < target || array[0][0] > target) {
      return "(-1,-1)";
    }
    
    //checks if top right (worst case) is equal to the target
    else if(array[0][nCols -1] == target) {
      retStr += "0," + (nCols -1) + ")";
      return retStr;
    }
    
    else {
      while (curRow >= 0 && curCol < nCols) {
        /*Print statements for debugging --
	System.out.println(nRows);
        System.out.println(nCols);
        System.out.println(curRow);
        System.out.println(curCol);*/

        //checks if value at current postion is equal to the target
        if (array[curRow][curCol] == target) {
          retStr += curRow + "," + curCol + ")";
          return retStr;
        }
        //if current value is smaller than target, move to the right 1 unit
        else if(array[curRow][curCol] < target){
          curCol += 1;
        }
        //if current value is bigger than target, move up one unit
        else {
          curRow -= 1;
        }
      }
      }
    //will only return (-1, -1) if the search finishes and did not find the target within
    //the matrix. Thus, the target is not in the matrix.
    return "(-1,-1)";
    }
    
    public static void main(String[] args) {
      //ascending by 1 matrix
      int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
      System.out.println(Finder(test, 5));
      //2D array with 1 element
      int[][] test1 = {{1}};
      System.out.println(Finder(test1, 1));
      //testing when value is outside range of matrix
      int[][] test2 = {{1,2,3},{4,5,6},{7,8,9}};
      System.out.println(Finder(test, 15));
      //testing when value is within the bounds of the matrix, but doesn't exist
      //in the array
      int[][] test3 = {{2,5,7},{4,8,11},{7,12,13}};
      System.out.println(Finder(test3, 6));
      //testing a 1 element 2D array when the target is not the element
      int[][] test4 = {{3}};
      System.out.println(Finder(test4, 1));
      //testing when the target is smaller than the smallest value in the matrix
      int[][] test5 = {{2,5,7},{4,8,11},{7,12,13}};
      System.out.println(Finder(test5, 1));
      //testing a 4X4 array
      int[][] test6 = {{2,5,7,8},{4,8,11,14},{7,12,13,16},{8,14,16,20}};
      System.out.println(Finder(test6, 11));
      //5X5 array
      int[][] test7 = {{2,5,7,9,13},{4,8,11,12,17},{7,12,13,17,22},{9,15,16,20,25},{12,17,19,24,34}};
      System.out.println(Finder(test7, 34));
      //5X5 array (target not present)
      int[][] test8 = {{2,5,7,9,13},{4,8,11,12,17},{7,12,13,17,22},{9,15,16,20,25},{12,17,19,24,34}};
      System.out.println(Finder(test8, 3));

    }
  }
