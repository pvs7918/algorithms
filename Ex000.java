public class Ex000 {

  public static void main(String[] args) {
    Foo foo1 = new Foo(123);

    Foo foo2 = new Foo(123);
    remove(foo2);
  }

  static void remove(Foo item) {
  }

  static void remove(int value) {

  }

}

class Foo {
  int value;

  public Foo(int value) {
    this.value = value;
  }
}
