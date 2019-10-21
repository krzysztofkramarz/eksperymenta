package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue
 *
 * @author krzysztof.kramarz
 */

//PRODUCER CONSUER
class Lekcja7
{

   static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

   public static void main(String[] args)
   {

      new Thread(() -> {
         producer();

      }, "producer").start();

      new Thread(() -> {
         try
         {
            consumer();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }

      }, "consumer").start();
   }

   private static void producer()
   {
      Random random = new Random();
      while (true)
      {
         try
         {
            blockingQueue.put(random.nextInt(100));
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
   }

   private static void consumer() throws InterruptedException
   {
      Random random = new Random();

      while (true)
      {
         Thread.sleep(100);

         if (random.nextInt(10) == 0)
         {
            Integer take = blockingQueue.take();
            System.out.println("Pobieam watość = " + take + ", wielkosc listy = " + blockingQueue.size());
         }
      }
   }
}
