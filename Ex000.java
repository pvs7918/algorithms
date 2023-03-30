public class Ex000 {
  public static void main(String[] args) {
    MyLinkedList mll = new MyLinkedList();
    mll.append(1);
  }
}

class Node {
  int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node(int value) {
    this.value = value;
  }
}

class MyLinkedList {
  Node head;

  public void append(int value) {
    Node node = new Node(value);
    if (this.head == null) {
      this.head = node;
    }
  }
}