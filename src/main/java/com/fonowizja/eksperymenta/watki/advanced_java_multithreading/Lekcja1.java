package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

/**
 * @author krzysztof.kramarz
 */
class Lekcja1
{

   public static void main(String[] args)
   {
      ThreadRunner threadRunner1 = new ThreadRunner("threadRunner1");

      ThreadRunner threadRunner2 = new ThreadRunner("threadRunner2");
      threadRunner1.start();
      threadRunner2.start();

      //TODO dlaczego tak mozna
      // Runner runner = new Runner();
      // Runnable biegajmy = runner::biegajmy;
      // biegajmy.run();

   }

}

class ThreadRunner extends Thread
{

   ThreadRunner(String runner1)
   {
      super(runner1);
   }

   @Override
   public void run()
   {
      for (int i = 0; i < 20; i++)
      {
         try
         {
            Thread.sleep(0,600);
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
         System.out.println("Witam, jestem z wątku: " + Thread.currentThread().getName() + "  " + i);
      }
   }
}

class Runner implements Runnable
{

   @Override
   public void run()
   {
      for (int i = 0; i < 20; i++)
      {
         System.out.println("Witam, jestem z wątku: " + Thread.currentThread().getName() + "  " + i);
      }
   }

   void biegajmy()
   {
      System.out.println("uf uf uf uf uf");
   }

}
