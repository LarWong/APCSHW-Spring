/*****************************************************
* class LLNode
* Implements a node, for use in lists and other container classes.
* Stores its data as a String
*****************************************************/

public class DLLNode<T>
{
  //instance vars
  private T _cargo;    //cargo may only be of type T
  private DLLNode _nextNode; //pointer to next LLNode
  private DLLNode _prevNode; //pointer to prev LLNode

  // constructor -- initializes instance vars
  public DLLNode( T value, DLLNode prev, DLLNode next ) {
    _cargo = value;
    _prevNode = prev;
    _nextNode = next;

  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }

  public DLLNode getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo ) {
    T foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext ) {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev( DLLNode newPrev ) {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {



  }//end main

}//end class LLNode
