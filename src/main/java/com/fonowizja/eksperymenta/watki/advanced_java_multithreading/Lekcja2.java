package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.Scanner;

/**
 * @author krzysztof.kramarz
 */

// wirująca blokada (spin-locck)

class Lekcja2
{
   public static void main(String[] args)
   {
      Processor processor = new Processor();
      Thread thread1 = new Thread(processor, "processor");
      thread1.start();

      System.out.println("Nacisnij enter aby wyjsc");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();

      processor.shutDown();

   }
}

class Processor implements Runnable
{
   //volatile może jest potrzbne
   //  Mamy dwa wątki , jest tylko jedna zmienna. Gdy java optymalizuje to jeden wątek może nie spodziewać
   // się , że inny wątek bdzie modyfikował zmienną, bo shutDown() jest w tym samym kodzie i w metodzie run nie ma wywołania zmiany zmiennej flaga.
   // Ten wątek będzie zakładał, że zmienna flaga nie zmieni się - nie martwmy się o tę zmienną
   // Trrzeba postawić barierę, aby zawsze wartość była wypłukiwana do RAMu.
// Jeśli chesz modyfikować jedną zmienną z innego wątku, a ten pierwwwszy wątek używa tej zmiennej do cczegoś, uzyj volatile
   boolean flaga = true;

   @Override
   public void run()
   {
      while (flaga)
      {

         try
         {
            Thread.sleep(500);
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
         System.out.println("Domek z wątku: " + Thread.currentThread().getName());

      }
   }

   void shutDown()
   {
      flaga = false;
      System.out.println("Koncze!!");
   }
}
