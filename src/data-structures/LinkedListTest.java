class LinkedList<T> {
  // First node in a LinkedList
  Node root;

  // Node class
  class Node {
    T value;
    Node nextNode;

    public Node(T val) {
      value = val;
      nextNode = null;
    }  
  } 
  
}



// Test class
public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList();
    LinkedList<String>.Node test = new LinkedList.Node("Hello World");
    ll.root = test;
    System.out.println(ll.root.value);
  }
}
