package com.fonowizja.eksperymenta.watki;

/**
 * @author krzysztof.kramarz
 */
class InterruptTest
{
static Thread spioch = new Thread(()->{

   System.out.println("chrapanie");
   try
   {
      Thread.sleep(4_000,1);

   }
   catch (InterruptedException e)
   {
      System.out.println("chwila kaszlu");
      e.printStackTrace();
   }
}, "spioch");
   public static void main(String[] args) throws InterruptedException
   {
      spioch.start();
      Thread.sleep(0,590);
      System.out.println(spioch.getState());
      spioch.interrupt();
   }
}
