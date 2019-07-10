package hierarchy;

/**
 * @author krzysztof.kramarz
 */
class Main
{
   public static void main(String[] args)
   {
      A a = new A();
      a.print();

      B b = new B();
      b.print(); //Jestem z B i mam: B

      A ab = new B();
      ab.print(); //Jestem z B i mam: B
       ((B) ab).print(); //rzutowanie w górę

      B ba = (B) new A();// rzutowanie w dół - ClassCastException
      ba.print();


   }
}
