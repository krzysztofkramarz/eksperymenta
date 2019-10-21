package com.fonowizja.eksperymenta.watki;

/**
 * @author krzysztof.kramarz
 */
class Draka
{
   Thread krolewicz = new Thread(() -> {
      while (true)
      {
         try
         {
            System.out.println("Dobranoc!!");
            Thread.sleep(100);
            System.out.println("wstaje na siku");
         }
         catch (InterruptedException e)
         {
            System.out.println("Kto mnie obudzil???");

         }
      }
   }, "krolewicz");

   public static void main(String[] args)
   {
      Draka draka = new Draka();
      draka.krolewicz.start();
      new Thread(zlosliwyKrasnoludek("Gapcio", draka.krolewicz)).start();
      new Thread(zlosliwyKrasnoludek("Mędrek", draka.krolewicz)).start();
      new Thread(zlosliwyKrasnoludek("Nieśmiałek", draka.krolewicz)).start();
      // zlosliwyKrasnoludek2(draka.krolewicz);
   }

   // private static void zlosliwyKrasnoludek2(Thread krolewicz)
   // {
   //    Thread.State state = krolewicz.currentThread().getState();
   //    System.out.println(state);
   //    System.out.println("hej");
   //
   // }

   static Runnable zlosliwyKrasnoludek(String krasnal, Thread krolewicz)
   {
      return () -> {
         while (true)
         {
            if (krolewicz.getState() == Thread.State.TIMED_WAITING)
            {

               Thread.State state = krolewicz.getState();
               System.out.println(state);
               krolewicz.interrupt();
               System.out.println("Ja go obudziłem!: " + krasnal);
            } else {
               System.out.println("Ksiaze jeszcze spi");
            }

         }
      };
   }
}
