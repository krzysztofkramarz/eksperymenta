package com.fonowizja.eksperymenta.watki.wyrzucanie_wyjatku;

/**
 * @author krzysztof.kramarz
 */
class WatekZWyjatkiem implements Runnable
{
   @Override
   public void run()
   {
      try
      {
         Thread.sleep(2_000);
         System.out.println("Wyjatek!!");
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      throw new ArrayIndexOutOfBoundsException();
   }
}
