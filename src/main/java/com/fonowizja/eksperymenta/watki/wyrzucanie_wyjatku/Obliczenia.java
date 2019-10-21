package com.fonowizja.eksperymenta.watki.wyrzucanie_wyjatku;

/**
 * @author krzysztof.kramarz
 */
class Obliczenia
{

   Integer sumaOdZera(Integer gornaGranica) throws InterruptedException
   {

      Runnable wyjatekWInnymWatku = new WatekZWyjatkiem();

      new Thread(wyjatekWInnymWatku).start();

      Integer wynik = 0;

      for (int i = 0; i < gornaGranica; i++)
      {
         Thread.sleep(5);
         wynik += i;
         System.out.println(wynik);

      }
      return wynik;
   }
}

