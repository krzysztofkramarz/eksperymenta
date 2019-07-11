package com.fonowizja.eksperymenta.kolekcje;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author krzysztof.kramarz
 */
class ZlozonoscOperacji {

    public static void main(String[] args) {


//        operacje interesujące nas:
//        add
//        get
//        remove
//        contains
        // *************  ARRAY LIST ************


        ArrayList<String> arrayLista = new ArrayList<>(20);
        //metody dodawania złożoność:
        //lista  ma size ale i initial capacity. size = aktualna wielkość, capacity - zarezerwowana wielkość.
        //Object[] elementData zawiera elementy listy
        //add(element) - dodaje na koniec listy, jesli dojdzie do końca elementaData.length (startowo 10),
        // to tablica bedzie powiększona o 50 %, nie więcej niż int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;, c
        // chyba że minimumSize (żądana wielkość). Złożoność jest więc O(1), chyba, ze musi przepisac tablicę
        // jak musi przepisać tablicę, to wtedy złożoność O(n)
        //
        //


        //add(index, element) - złożoność O(n) (jest zawsze  System.arraycopy)


        System.out.println("AAAA");
        System.out.println("Size is: " + arrayLista.size());
        arrayLista.add("ja");
        arrayLista.add("ty");
        arrayLista.add("on");
        arrayLista.add("ona");

        System.out.println("przed dodaniem");
        arrayLista.forEach(System.out::println);

        arrayLista.add(0, "my");
        System.out.println("po dodaniu");
        arrayLista.forEach(System.out::println);

        //usuwanie - 0(n) lub O(2n)  -  remove.(index) - arrayCopy, remove.(object) po equals i arraycopy

        System.out.println("Size is: " + arrayLista.size());
        arrayLista.remove("ja");//O(2n) najpierw equals, potem arraycopy
        arrayLista.remove(1);
        System.out.println("Size is: " + arrayLista.size());

        //operacja get ma złożóność O(1)
        System.out.println(arrayLista.get(2));


        //contains O(n) - poprzez equals

        System.out.println(arrayLista.contains("ja"));

        // *************  LINKED LIST ************
        //metody add(element) oraz add(index, element) mają złożoność 0(1)
        System.out.println("BBBB");
        LinkedList<String> linkedLista = new LinkedList<>();
        System.out.println("Size is: " + linkedLista.size());
        linkedLista.add("ja");
        linkedLista.add("ty");
        linkedLista.add("on");
        linkedLista.add("ona");
        linkedLista.add(1, "ona");
        System.out.println("Size is: " + linkedLista.size());
        System.out.println(linkedLista.size());

        //remove (object) złożoność O(n) - jedzie przez wszystkie elementy po equals
        //remove (index) złożoność O(1/2 * n) -nie zna indexu, po prostu iteruja aż licznkik iteracji zgodzi się z indeksem
        //        // albo od początku do połowy albo od końca do połowy
        linkedLista.remove("ty");
        linkedLista.remove(3);
        System.out.println("Size is: " + linkedLista.size());
        System.out.println(linkedLista.size());


        System.out.println("po dodaniu");
        linkedLista.forEach(System.out::println);

        //operacja get ma złożóność mniej więcej O(1/2 * n) - nie zna indexu, po prostu iteruja aż licznkik iteracji zgodzi się z indeksem
        // albo od początku do połowy albo od końca do połowy

        System.out.println("get(index = 2)");
        System.out.println(linkedLista.get(2));

        //contains O(n) - poprzez equals
        System.out.println(linkedLista.contains("my"));
    }
}
