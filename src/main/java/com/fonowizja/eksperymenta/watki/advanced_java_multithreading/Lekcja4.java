package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author krzysztof.kramarz
 */
class Lekcja4
{
   public static void main(String[] args)
   {
      new App().main();
   }
}

class App
{

   private List<Integer> list1 = new ArrayList<>();
   private List<Integer> list2 = new ArrayList<>();

   Random random = new Random();

   private Object lock1 = new Object();
   private Object lock2 = new Object();

    void stageOne()
   {
      try
      {
         Thread.sleep(1);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      synchronized (lock2)
      {
         list1.add(random.nextInt(100));
      }
   }

    void stageTo()
   {
      try
      {
         Thread.sleep(1);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      synchronized (lock2) //synchronizujemy po obiekie a nie na metodzie, bo wtedy dosstajemy w efekcie na this i drugi wątek nie może wejść
            //do drugiej metody i czas rośnie dwukrotnie
      {
         list2.add(random.nextInt(100));
      }
   }

   void proccess()
   {
      for (int i = 0; i < 1000; i++)
      {
         stageOne();
         stageTo();
      }
   }

   public void main()
   {
      System.out.println("Startuje...");

      long start = System.currentTimeMillis();
      Thread t1 = new Thread(() -> {
         proccess();
      }, "thread1");

      Thread t2 = new Thread(() -> {
         proccess();
      }, "thread2");

      t1.start();
      t2.start();

      try
      {
         t1.join();
         t2.join();
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }

      long stop = System.currentTimeMillis();
      System.out.println("Trwalo to: " + ((stop - start)));

      System.out.println("Lista 1: " + list1.size() + ". Lista 2: " + list2.size());
   }
}
