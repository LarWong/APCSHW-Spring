/*
Larry Wong
APCS2 pd8
HW21c -- Rockin’ Through the Night
2018-03-19
*/
public class LList implements List{

  //instance vars
  private LLNode _train;
  private int _size;

  //default constructor
  public LList(){
    _size = 0;
  }

  //adds new node to the front of the llist by using an overloaded constructor of LLNode
  /*Overloaded constructor:   public LLNode(String car, LLNode cdr){
                                    this.cargo = car;
                                    this.nextNode = cdr;
                                  }

*/
public boolean add(String x){
  _train = new LLNode(x,_train);
  _size++;
  return true;
}

//loops through the nodes until a counter equals the index parameter
//returns the cargo of the LLNode the loop landed on
public String get(int i){
  try{
    int c = 0;
    LLNode holder = _train;

    while (c < i){
      holder = holder.getNext();
      c++;
    }

    return holder.getCargo();
  }
  catch(Exception e){
    return "Invaild Index";
  }

}

//loops through the nodes until a counter equals the index parameter
//sets the cargo of the node it landed on to the input
//returns the old cargo of the LLNode the loop landed on
public String set(int i, String x){

  try{
    int c = 0;
    LLNode holder = _train;

    while (c < i){
      holder = holder.getNext();
      c++;
    }
    String oldVal = holder.getCargo();
    holder.setCargo(x);
    return oldVal;

  }
  catch (Exception e){
    return "Invaild Index";
  }
}

//returns number of nodes in the llist
//add() update the var everytime a string is added, otherwise it is a default 0
public int size(){
  return _size;
}

public static void main(String[] args){

  //creating empty LList
  LList train = new LList();

  System.out.println(train.size());
  System.out.println(train._train);

  //adding nodes
  System.out.println("Adding Nodes:");
  train.add("cargo1");
  System.out.println(train.size());
  System.out.println(train._train);

  train.add("cargo2");
  System.out.println(train.size());
  System.out.println(train._train);

  train.add("cargo3");
  System.out.println(train.size());
  System.out.println(train._train);

  train.add("cargo4");
  System.out.println(train.size());
  System.out.println(train._train);

  //testing get()\
  System.out.println("Testing get():");
  System.out.println(train.get(0));
  System.out.println(train.get(1));
  System.out.println(train.get(3));

  //testing set()
  System.out.println("Testing set():");
  System.out.println(train.set(1,"coolCargo1"));
  System.out.println(train.set(3,"coolCargo4"));

  System.out.println(train._train);



}


}
