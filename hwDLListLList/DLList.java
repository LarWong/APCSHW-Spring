/*
Larry Wong
APCS2 pd8
HW24b -- On the DLL
2018-03-24
*/

/*****************************************************
* class LList
* Implements a linked list of DLLNodes, each containing String data
* new in v2: add-at-index, remove
*****************************************************/

public class DLList<T> implements List<T> //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail; //new pointer at end
  private int _size;

  // constructor -- initializes instance vars
  public DLList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( T newVal )
  {
    DLLNode tmp = new DLLNode( newVal, null, _head);
    //sets tail to the first element ever added, remains there
    if (_size == 0){
      _head = tmp;
      _tail = tmp;
    } else {
      //set the prev node of head to tmp
      _head.setPrev(tmp);
      _head = tmp;
    }
    _size++;
    return true;
  }


  public T get( int index )
  {
    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head;

    if (index == _size-1){
      tmp = _tail; //create alias to tail, prevents looping
    } else {
      tmp = _head; //create alias to head

      //walk to desired node
      for( int i=0; i < index; i++ )
      tmp = tmp.getNext();
    }

    //check target node's cargo hold
    T retVal = (T)tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode tmp;

    if (index == _size-1){
      tmp = _tail; //create alias to tail, prevents looping
    } else {
      tmp = _head; //create alias to head

      //walk to desired node
      for( int i=0; i < index; i++ )
      tmp = tmp.getNext();
    }

    //store target node's cargo
    T oldVal = (T)tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, T newVal ) {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode newNode = new DLLNode( newVal, null, null );
    DLLNode tmp = _head; //create alias to head

    //if index==0, insert node before head node
    if ( index == 0 ){
      add( newVal );
      return;
    }
    else if (index == _size-1) {
      tmp = _tail.getPrev();//prevents looping if target is at the end
    } else {
      //walk to node before desired node
      for( int i=0; i < index-1; i++ )
      tmp = tmp.getNext();
    }
    //insert new node
    newNode.setNext( tmp.getNext() );

    newNode.setPrev( tmp ); // setting prev node to tmp
    tmp.getNext().setPrev(newNode); // setting prev node of the next node to new node

    tmp.setNext( newNode );


    //increment size attribute
    _size++;
  }



  //remove node at pos index, return its cargo
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //set tail and head to null if nothing remains in the list
    if (_size == 1){
      _head = null;
      _tail = null;
    }
    //if index==0, remove head node
    if ( index == 0 ) {
      //check target node's cargo hold
      retVal = (T)_head.getCargo();

      //remove target node
      _head = _head.getNext();
    }
    else if (index == _size-1){
      //check target node's cargo hold
      retVal = (T)_tail.getCargo();
      //set tail to the 2nd to last node
      tmp = _tail.getPrev();

    }else{
      //walk to node before desired node
      for( int i=0; i < index-1; i++ )
      tmp = tmp.getNext();

      //check target node's cargo hold
      retVal = (T)tmp.getNext().getCargo();


    }

    //remove target node
    tmp.setNext( tmp.getNext().getNext() );
    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "NULL->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + "->";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {


  }

}//end class LList
