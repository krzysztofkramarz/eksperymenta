package generyki.lambdy;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author krzysztof.kramarz
 */
class Main
{
static int sumStatic = 12;
   public static void main(String[] args)
   {


      Supplier<Integer> wynik = () -> 123;
      Function<Integer, Boolean> pytanie = (n) -> (n % 2) == 0;

      System.out.println("aaa");
      System.out.println(wynik.get());
      System.out.println(pytanie.apply(13));

      TestCzynnikiczby<Integer, Integer> testowanie = (a, b) -> {
         if (false)
         {
            throw new Exception();
         }
         return (a % b) == 0;
      };

      DeklarujMnie deklarujMnie = (a, b) -> a.contains(b);
      // DeklarujMnie deklarujMnie = String::contains;
      System.out.println(deklarujMnie.testSkladniki("sedes", "s"));
      System.out.println(deklarujMnie.testSkladniki("sedes", "a"));

      int suma = 10;
      Odwracacz<String> odwracacz = (doOdwocenia) -> {
         if (doOdwocenia == null)
         {
            return "null!";
         }
         String result = "";
         for (int i = doOdwocenia.length() - 1; i >= 0; i--)
         {
            result = result + doOdwocenia.charAt(i);
         }
         int a = suma;
         // suma++;
         sumStatic = 2342;


         return result;
      };

      System.out.println(odwracacz.odwracanie("Domek"));

      StringOperator<String> upperKejsowiec = (doUpekejdosowania) -> {
         return doUpekejdosowania.toUpperCase();
      };

      System.out.println(działajNaStingu(upperKejsowiec, "Java ma wiele możliwości") + "  JAJA!! ");




   }

   interface TestCzynnikiczby<SkladnikJeden, SkladnikDwa>
   {

      boolean testSkladniki(SkladnikJeden skladnikJeden, SkladnikDwa skladikDwa) throws Exception;
   }

   interface DeklarujMnie
   {

      boolean testSkladniki(String skladnikJeden, String skladikDwa);
   }

   interface Odwracacz<CoODwrocic>
   {
      CoODwrocic odwracanie(CoODwrocic s);
   }

   private static String działajNaStingu(StringOperator<String> stringOperator, String doDziałania)
   {
      return stringOperator.stringOp(doDziałania);
   }
}
