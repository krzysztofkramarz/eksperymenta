package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.LinkedList;

/**
 * @author krzysztof.kramarz
 */
class Lekcja9
{
   public static void main(String[] args) throws InterruptedException
   {

      Processor9 processor9 = new Processor9();

      Thread t1 = new Thread(() -> {
         try
         {
            processor9.producer();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }

      }, "producer");

      Thread t2 = new Thread(() -> {
         try
         {
            processor9.consumer();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }

      }, "consumer");

      t1.start();
      t2.start();

      t1.join();
      t2.join();
   }

}

class Processor9
{
   private LinkedList<Integer> list = new LinkedList<>();
   private final int MAX = 10;
   private Object lock = new Object();

   void producer() throws InterruptedException
   {

      int wartosc = 0;

      while (true)
      {
         System.out.println("sss");
         synchronized (lock)
         {
            if (list.size() == MAX)
            {
               lock.wait();
            }

            list.add(wartosc++);
            lock.notify();
         }
      }
   }

   void consumer() throws InterruptedException
   {
      while (true)
      {

         synchronized (lock)
         {
            if (list.isEmpty())
            {
               lock.wait();
            }
            System.out.print("Rozmiar tablicy: " + list.size());
            lock.notify();

            Integer integer = list.removeFirst();
            System.out.println("liczba to: " + integer);
         }
      }
   }
}
