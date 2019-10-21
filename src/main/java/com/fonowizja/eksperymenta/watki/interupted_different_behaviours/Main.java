package com.fonowizja.eksperymenta.watki.interupted_different_behaviours;

/**
 * @author krzysztof.kramarz
 */
class Main
{

   public static void main(String[] args) throws InterruptedException
   {
      //
      // WatekZawszeSiePrzerwie watekZawszeSiePrzerwie = new WatekZawszeSiePrzerwie();
      // Thread threadZawszeSiePrzerwie = new Thread(watekZawszeSiePrzerwie);
      // threadZawszeSiePrzerwie.start();
      // // Thread.sleep(5000);
      // threadZawszeSiePrzerwie.interrupt();

      // WatekNigdySieNiePrzerwie watekNigdSienieprzerwie = new WatekNigdySieNiePrzerwie();
      // Thread threadNigdySieNiePrzerwie = new Thread(watekNigdSienieprzerwie);
      // threadNigdySieNiePrzerwie.start();
      // // Thread.sleep(5000);
      // threadNigdySieNiePrzerwie.interrupt();

      // WatekRobiWazneRzeczyAlePrzerwanyZakonczyPotem
      //
      // WatekRobiWazneRzeczyAlePrzerwanyZakonczyPotem watekRobiWazneRzeczyAlePrzerwanyZakonczyPotem = new WatekRobiWazneRzeczyAlePrzerwanyZakonczyPotem();
      // Thread threadRobiWazneRzeczyAlePrzerwanyZakonczyPotem = new Thread(watekRobiWazneRzeczyAlePrzerwanyZakonczyPotem);
      // threadRobiWazneRzeczyAlePrzerwanyZakonczyPotem.start();
      // // Thread.sleep(5000);
      // threadRobiWazneRzeczyAlePrzerwanyZakonczyPotem.interrupt();

   }

}

class WatekZawszeSiePrzerwie implements Runnable
{

   @Override
   public void run()
   {
      System.out.println("dzialam ale jak mni ustawisz interrupt, to się wyłożę");
      System.out.println("Flaga jak mi przerwano a przed netodą interrupt() :" + Thread.currentThread().isInterrupted());
      if (Thread.interrupted())
      {
         System.out.println("A teraz po interrupt() :" + Thread.currentThread().isInterrupted());

         System.out.println("Przerwano mi!");
         return;
      }

      System.out.println("To juz sie niewykona :(");
   }
}

class WatekNigdySieNiePrzerwie implements Runnable
{

   @Override
   public void run()
   {
      System.out.println("dzialam, obojetnie, czy mnie przerwiesz czy nie");
      System.out.println("Flaga jak mi przerwano a przed netodą interrupt() :" + Thread.currentThread().isInterrupted());
      while (true)
      {

         try
         {
            Thread.sleep(1_000);
         }
         catch (InterruptedException e)
         {
            System.out.println("Przerywasz mi, a ja jestm obrazony...");
         }
         if (Thread.interrupted())
         {
            System.out.println("A teraz po interrupt() :" + Thread.currentThread().isInterrupted());

            System.out.println("Moze i flaga przerwania jest true ale co z tego!");
         }

         System.out.println("Jestem przerwany, ale dalej dzialam i mam to w 4 literach");
      }
   }
}

class WatekRobiWazneRzeczyAlePrzerwanyZakonczyPotem implements Runnable
{

   @Override
   public void run()
   {
      System.out.println("Robie rozne rzeczy, ale jak bede interrapted, to zrobie tylko wazne");

      while (!Thread.currentThread().isInterrupted())
      {
         System.out.println("Robie zadanko 1");
         System.out.println("Flaga jak mi przerwano a przed netodą interrupt() :" + Thread.currentThread().isInterrupted());

         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
            System.out.println("Przerywasz mi, a ja jestm obrazony.... Ale j ai tak dokoncze");
            Thread.currentThread().interrupt();
         }

      }


      System.out.println("A teraz po interrupt() :" + Thread.currentThread().isInterrupted());

      System.out.println("UWAGA ROBIE WAŻNE RZECZY I ZARAZ ZMYKAM!!!");

      System.out.println("Nie bylem przerwany wiec teraz sa mniej wazne rzeczy , to robię je dalej");
   }
}