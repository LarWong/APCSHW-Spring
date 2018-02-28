/*
Larry Wong
APCS2 pd8
HW10--[Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
2018-02-27
*/

/***
* class QueenBoard
* Generates solutions for N-Queens problem.
*/

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
  * precondition: board is filled with 0's only.
  * postcondition:
  * If a solution is found, board shows position of N queens,
  * returns true.
  * If no solution, board is filled with 0's,
  * returns false.
  */
  public boolean solve()
  {
    //goes through each column
    //backtracks if helper function returns a false
    int c = 0;
    while (c < _board.length){
      //DEBUGGING: to see what column it is currently on
      //System.out.println(c);
      if (solveH(c)){
        //true is a successful placement occured
        //either bc it is a empty column or moved queen down a row
        c++;
      } else {
        //false when no possible placement for a queen exists
        //goes back to previus column to remove and replace if possible
        c--;
        if (c < 0){
          //this means rhat no possible solution exists since it went through all possible combinations already
          //RULE: if column has no place for a queen, move back a column.
          //      if not more columns are available = no solution
          break;
        }
      }
    }

    //Checks to see if requirements are met
    //# of queens are correct
    int total = 0;
    for (int[] r : _board){
      for (int z : r){
        if (z == 1){
          total++;
        }
      }
    }
    if (total != _board.length){
      return false;
    }
    return true;
  }


  /**
  *Helper method for solve.
  */
  private boolean solveH( int col )
  {
    //for each column, you need to go through each row
    for (int r = 0; r < _board.length; r++){

      //if there is a queen there already
      //it means that the algorith could not place a queen in the next column
      //so removes the queen and moves down if possible
      if (_board[r][col] == 1){
        removeQueen(r,col);
        //Can queen move down?
        if (r+1 < _board.length){
          if (_board[r+1][col] == 0){
            addQueen(r+1,col);
            //DEBUGING: column was previously occupied & can add new one
            //System.out.println("back1");
            return true;
          }
        }
        //DEBUGING: column was previously occupied & cannot add new one
        //System.out.println("back2");
        return false;

      }


    }


    //if not queens exist, it means that ir is a brand new column
    //places a queen at the first empty square it meets
    for (int r = 0; r < _board.length; r++){
      if (_board[r][col] == 0){
        addQueen(r,col);
        //DEBUGING: empty column
        //System.out.println("new");
        return true;
      }
    }

    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
    Except:
    all negs and 0's replaced with underscore
    all 1's replaced with 'Q'
    */
    //converts and returns a string
    String solution = "";
    for (int[] r : _board ){
      for (int c : r){
        if (c == 1){
          solution += "Q\t";
        } else {
          solution += "_\t";
        }
      }
      solution += "\n";
    }
    System.out.println(solution);
  }



  //================= YE OLDE SEPARATOR =================

  /***
  * This function places a queens by changing a number in the maxtrix into a 1 and marks area where
  the queen can attack (ignoring the column it is in and the previous columns)
  * precondition: A nxn matrix
  * postcondition: Returns true if sqaure contains a 0, and fills diagonals and row  with -1
  Returns false if square conains a number other than 0
  */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
  * This function removes a queen from a swaure if there is a queen and reverses the actions in the
  previous function by adding 1 to all the squares the queen could have attacked.
  * precondition: a nxn matrix
  * postcondition: Returns true if a queen exists in the inputed square and adds one to all of the diagonals
  and row it attacked
  Returns false if queen does not exist there
  */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
  * Prints out the matrix by returning the matrix in a string form
  * precondition: a nxn matrix
  * postcondition: returns a string with all the information from the matrix
  */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    printSolution();
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {

    /*
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    */


    //solution not should exist
    QueenBoard b = new QueenBoard(2);
    System.out.println("2x2 board:");
    System.out.println(b);
    System.out.println("Exists? : " + b.solve());
    System.out.println(b);

    //solution not should exist
    QueenBoard c = new QueenBoard(3);
    System.out.println("3x3 board:");
    System.out.println(c);
    System.out.println("Exists? : " + c.solve());
    System.out.println(c);

    //solution should exist
    QueenBoard d = new QueenBoard(4);
    System.out.println("4x4 board:");
    System.out.println(d);
    System.out.println("Exists? : " + d.solve());
    System.out.println(d);

    //solution should exist
    QueenBoard e = new QueenBoard(5);
    System.out.println("5x5 board:");
    System.out.println(e);
    System.out.println("Exists? : " + e.solve());
    System.out.println(e);

    //solution should exist
    QueenBoard f = new QueenBoard(6);
    System.out.println("6x6 board:");
    System.out.println(f);
    System.out.println("Exists? : " + f.solve());
    System.out.println(f);
    //Cannot find for some reason. I have no idea why!!!

    //solution should exist
    QueenBoard g = new QueenBoard(7);
    System.out.println("7x7 board:");
    System.out.println(g);
    System.out.println("Exists? : " + g.solve());
    System.out.println(g);

    //solution should exist
    QueenBoard h = new QueenBoard(8);
    System.out.println("8x8 board:");
    System.out.println(h);
    System.out.println("Exists? : " + h.solve());
    System.out.println(h);

    //solution should exist
    QueenBoard i = new QueenBoard(9);
    System.out.println("9x9 board:");
    System.out.println(i);
    System.out.println("Exists? : " + i.solve());
    System.out.println(i);

    //solution could exist (i'm unsure)
    QueenBoard j = new QueenBoard(10);
    System.out.println("10x10 board:");
    System.out.println(j);
    System.out.println("Exists? : " + j.solve());
    System.out.println(j);

  }

}//end class
