package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.Scanner;

/**
 * @author krzysztof.kramarz
 */
// wait notify
class Lekcja8
{

   public static void main(String[] args) throws InterruptedException
   {
      Processor7 processor7 = new Processor7();

      Thread t1 = new Thread(() -> {
         try
         {
            processor7.producer();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }

      }, "producer");

      Thread t2 = new Thread(() -> {
         try
         {
            processor7.consumer();
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

class Processor7
{

   void producer() throws InterruptedException
   {
      synchronized (this)
      {

         System.out.println("Zaczynam produkować. To ja, " + Thread.currentThread().getName());
         //ątek apada w sen i oddaje monitor, wtedy drugi wątek wcchodzi do drugiejj metody
         wait();
         System.out.println("Czekałem ale znów pracuje");
         System.out.println("Kto mnie wybudził, ale nie oddał mi monitora dopóki nie skoczył swojej pracy. Tak twierdzi");
         System.out.println("To mówiłem ja, watek: " + Thread.currentThread().getName());
      }

   }

   void consumer() throws InterruptedException
   {
      System.out.println("Zaczynam konsumowac. To ja, " + Thread.currentThread().getName());

      Scanner scanner = new Scanner(System.in);
      System.out.println("nawet jakbym zasnał lub wykonał notify(), to i tak nie oddam monitora, dopóki nie skończe swoje roboty");
      Thread.sleep(2000);

      synchronized (this)
      {
         System.out.println("czekam na naciśnięcie enterka");
         scanner.nextLine();
         //wątek informuje żeby inny wątek wrócił do pracy, ale nie oddaje monitora dopóki nie skończy swojego
         notify();
         //nawet jak pójdzie spać to nie odda swojego
         System.out.println("To mówiłem ja, watek: " + Thread.currentThread().getName());
         System.out.println("------------------------------------------------------");
      }
   }
}