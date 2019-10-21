package com.fonowizja.eksperymenta.watki;

/**
 * @author krzysztof.kramarz
 */
class ZrzucenieWatku
{
   public static void main(String[] args) throws InterruptedException
   {
      Thread.sleep(30_000);
      new Thread(() -> {
         System.out.println("sd");
         try
         {
            Thread.sleep(30000);
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }, "moj watek");
   }
}
