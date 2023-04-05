/*
 * Необходимо реализовать метод разворота связного списка
 * (двухсвязного или односвязного на выбор).
 */
package hw;

public class Hw3_1 {

    public static void main(String[] args) {
  
      MyList ml = new MyList();
      ml.addFirst("4", "2", "5", "1");
  
      var item = ml.head;
        System.out.println("Исходный список");
      while (item != null) {
        System.out.println(item);
        item = item.getNext();
      }

      ml.reverse(); //разворот двухсвязного списка

      System.out.println("\nСписок после разворота");

      item = ml.head;
      while (item != null) {
        System.out.println(item);
        item = item.getNext();
      }
 
    }
  }
  
  class MyList {
    Node head;
    Node tail;
  
    public void reverse() {
      //разворот двусвязного списка
      //меняем местами начало и конец двухсвязного списка
      Node temp = head;
      head = tail;
      tail = temp;
      
      Node node = head;

      do {
        //меняем местами ссылки на предыдущий и следующий элементы списка для узла
        temp = node.getNext();
        node.setNext(node.getPrev());
        node.setPrev(temp);
        //берем следующий узел, пока не достигнем конца списка
        node = node.getNext();
      } while(node!=null);
    }

    public void addFirst(String... values) {
      for (String string : values) {
        this.addFirst(string);
      }
    }
  
    public void addFirst(String value) {
      Node node = new Node(value);
  
      if (head != null) {
        node.setNext(head);
        head.setPrev(node);
      } else {
        tail = node;
      }
      head = node;
    }
  
    public void removeFirst() {
      if (head != null && head.getNext() != null) {
        head.getNext().setPrev(null);
        head = head.getNext();
      } else {
        head = null;
        tail = null;
      }
    }
  
    public boolean contains(String value) {
      Node node = head;
      while (node != null) {
        if (node.getValue().equals(value)) {
          return true;
        }
        node = node.getNext();
      }
      return false;
    }
  
    public void addLast(String value) {
      Node node = new Node(value);
  
      if (tail != null) {
        node.setPrev(tail);
        tail.setNext(node);
      } else {
        head = node;
      }
      tail = node;
    }
  
    public void removeLast() {
      if (tail != null && tail.getPrev() != null) {
        tail.getPrev().setNext(null);
        tail = tail.getPrev();
      } else {
        head = null;
        tail = null;
      }
    }
  }
  
  class Node {
  
    private Node next;
    private Node prev;
  
    String value;
  
    public Node(String value) {
      this.value = value;
    }
  
    public Node getPrev() {
      return prev;
    }
  
    public void setPrev(Node prev) {
      this.prev = prev;
    }
  
    public String getValue() {
      return value;
    }
  
    public Node getNext() {
      return next;
    }
  
    public void setNext(Node next) {
      this.next = next;
    }
  
    public Node(Node next, String value) {
      this.next = next;
      this.value = value;
    }
  
    @Override
    public String toString() {
      return value;
    }
  }
  