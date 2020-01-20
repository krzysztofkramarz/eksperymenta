package com.fonowizja.eksperymenta.generyki;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krzysztof.kramarz
 * wildcard bounded by superclass type
 */
class Koty {

    private static <T extends Cat> void addCat(List<? super Cat> catList, T item) {
        catList.add(item);
        System.out.println(String.format("Item of class: %s added", item.getClass()));
    }

    /*
    gdy ? super Animal, musi byc najwyzszy typ, czyli Object
    private static void printAllCats(List<? super Animal> catList) {
        for(Object cat : catList){

     */

    private static void printAllCats(List<? extends Animal> catList) {
        for (Animal cat : catList) {
            System.out.println(cat);
        }
    }

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<Animal>();
        List<Cat> catList = new ArrayList<>();
        List<RedCat> redCatList = new ArrayList<RedCat>();
        List<Dog> dogList = new ArrayList<>();

        //add list of super class Animal of Cat class
        // dodawanie kota lub podkota do listy animalsów
        addCat(animalList, new Cat());
        addCat(animalList, new RedCat());
        //addCat(animalList, new Dog()); // ograniczenie T

        //add list of Cat class
        addCat(catList, new Cat());
        addCat(catList, new RedCat());

        //compile time error
//        can not add list of subclass RedCat of Cat class
//        addCat(redCatList, new Cat());


        //compile time error
        //can not add list of subclass Dog of Superclass Animal of Cat class
//        addCat(dogList, new Cat());

        List<?> c = new ArrayList<>();
//        c.add(new Object()); // Compile time error
        c.add(null); // to zadziala! null is subtype of any Object
        Object o = c.get(0);// to zadziala, mimo deklaracji List<?>, bo na pewno jest tam jakis Object.class


        List<A> listA = new ArrayList<A>();
        List<B> listB = new ArrayList<B>();

        /*
        poniższe niemożliwe, bo sa ugerenycznione
        listA = listB;
        listB = listA;
        */

    }
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class RedCat extends Cat {
}

class A {
}

class B extends A {
}

class C extends A {
}

