/*
Larry Wong
APCS2 pd8
HW21b -- We Got a Little Ol’ Convoy...
2018-03-19
*/

/*****************************************************
* class LLNode
* Implements a node, for use in lists and other container classes.
* Stores its data as a String
*****************************************************/

public class LLNode
{
  //instance vars
  private String cargo;
  private LLNode nextNode;

  // constructor
  public LLNode(){
    this.cargo = null;
  }

  public LLNode(String car){
    this.cargo = car;
  }

  public LLNode(String car, LLNode cdr){
    this.cargo = car;
    this.nextNode = cdr;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return this.cargo;
  }

  public LLNode getNext()
  {
    return this.nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo(String newVal)
  {
    String oldVal = this.cargo;
    this.cargo = newVal;
    return oldVal;
  }

  public LLNode setNext(LLNode newVal)
  {
    LLNode oldVal = this.nextNode;
    this.nextNode = newVal;
    return oldVal;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return this.cargo + "," + this.nextNode;
  }


  //main method for testing
  public static void main( String[] args )
  {
    //PROTIP: try creating a few nodes: traversible, connected...
    //note anything notable as you develop and test...
    /*----------------LINKED NODES TOGETHER-----------------*/
    LLNode test1 = new LLNode("cargo1");
    System.out.println("List 1: " + test1);

    LLNode test2 = new LLNode("cargo2");
    test1.setNext(test2);
    System.out.println("List 2: " + test1);

    LLNode test3 = new LLNode("cargo3");
    test2.setNext(test3);
    System.out.println("List 3: " + test1);

    LLNode test4 = new LLNode("cargo4");
    test3.setNext(test4);
    System.out.println("List 4: " + test1);

    LLNode test5 = new LLNode("cargo5");
    test4.setNext(test5);
    System.out.println("List 5: " + test1);

    LLNode test6 = new LLNode("cargo6");
    test5.setNext(test6);
    System.out.println("List 6: " + test1);
    /*----------------LINKED NODES TOGETHER-----------------*/

    /*----------------Testing getCargo()--------------------*/
    System.out.println(test1.getCargo());
    System.out.println(test3.getCargo());

    System.out.println(test1.setCargo("coolCargo1"));
    System.out.println(test1.getCargo());


  }//end main

}//end class LLNode
