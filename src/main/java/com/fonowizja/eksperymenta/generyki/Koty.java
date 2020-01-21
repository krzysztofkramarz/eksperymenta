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


    private static void printAllAnimals(List<? extends Animal> animals) {
        System.out.println("printAllAnimals");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        List<Animal> tylkoAnimalsy = new ArrayList<>();
        tylkoAnimalsy.add(new Cat());

        //działa b = a !!
        // animals może być List<B>
        animals = tylkoAnimalsy;
        animals.get(0);//nie boimy się, bo generyk juz zna hierarchie, wie ze moze dostać A,B,C ale
        //pozwalamy mu, bo animalsy są ugenerycznione hierarchią, więc nawet jak przekazaliśmy List<B>, to jest ok

        /*ale do deklaracji listy ugenerycznionej hierarchią <? xtends Animal>
        nie można dodać nic z tej hierarchi
        bo nie wiadomo, jak alista naprawdę przyjdzie*/
//        animals.add(new Animal());
//        animals.add(new Cat());
//        animals.add(new RedCat());
    }


    private static void insertAllAnimals(List<? super Animal> animalsOrHigher) {
        /*
        Gdy deklarowana lista jest parametryzowana <? super Animal> gdy poieramy element,
        musi byc najwyzszym typem, czyli Object.
        Nie możemy rzutowac więc listy na Animalsy ani na nic niższego niż Object.
         */
//        for (Animal cat : animalsOrHigher) { nie działa
        for (Object object : animalsOrHigher) { //działa
            System.out.println(object);
        }

        /*
        Możemy wstawiać wszystkie A i podklasy
         */
        animalsOrHigher.add(new Animal());
        animalsOrHigher.add(new Cat());
        animalsOrHigher.add(new RedCat());
        // nie możemy wstawiać nadklas, bo nie jesteśmy pewni, jaka lista przyjdzie,
        // ale możemy taką listę przekazać
//        animalsOrHigher.add(new Live());
//        animalsOrHigher.add(new Object())


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
        redCatList.add(new RedCat());

        //compile time error
        //can not add list of subclass Dog of Superclass Animal of Cat class
//        addCat(dogList, new Cat());
        dogList.add(new Dog());

        List<Live> livesList = new ArrayList<>();
        List<Object> objectsList = new ArrayList<>();


        List<A> listA = new ArrayList<A>();
        listA.add(new A());
        listA.add(new B());
        listA.add(new C());
        List<B> listB = new ArrayList<B>();
        listB.add(new B());
        //listB.add(new A()) nie działa!

        /*
        poniższe wymienne uzywanie typow uegnetycznionych typami w jakiejs wzajemnnej hierarchii niemożliwe.
        A czasmai to potrzebujemy, aby mic uniwersalne metody przyjmujace kolekcje jakichś tam obiektów.

        List<A> a =
        List<B> b =
1)                            a = b  --> jeśli a.add(A,C) wtedy z automatu b otrzymaloby A i C
2)                            b = a   --> jeśli b.get() wtedy z automatu b otrzymaloby to, co w A -> A,B,C
 ad. 1
        If you could make this assignment,
        listA = listB;
        it would be possible to insert A and C instances into the List<B> pointed to by listB.
        ponieważ referencja listA może przyjmować obiekty A,B,C.
        You could do that via the listA reference, which is declared to be of List<A>.
        Thus you could insert non-B objects into a list declared to hold B (or B subclass) instances.
        */
//        insertAllAnimals(catList); // nie działa, bo musi być co najmniej <Animals>
        insertAllAnimals(animalList);
        insertAllAnimals(livesList);
        insertAllAnimals(objectsList);
        /*
ad. 2
        In listA you can insert objects that are either instances of A, or subclasses of A (B and C).
        If you could do this:
        listB = listA;
        then you could risk that listA contains non-B objects.
        When you then try to take objects out of listB you could risk to get non-B objects out (e.g. an A or a C).
        That breaks the contract of the listB variable declaration.
        Aby to umozliwic, ugenerycczniamy metodę stosujemy konstrukcje <? extends Animal>.
        Wtedy mozemy przekazać szereg obiektów z danej hierarchi i rzutowac kazdy obiekt na A bo nie boimy się
        że dostaniemy ClassCast Exception, gdyż mamy zapewnione, że każdy "is Animal"
        */

        printAllAnimals(animalList);
        printAllAnimals(catList); //tu przekazujemy List<B>, a w metodzie zrobimy listB = listA;
        printAllAnimals(redCatList);
        printAllAnimals(dogList);


        // List<?>
        List<?> c = new ArrayList<>();
//        c.add(new Object()); // Compile time error
        c.add(null); // to zadziala! null is subtype of any Object
        Object o = c.get(0);// to zadziala, mimo deklaracji List<?>, bo na pewno jest tam jakis Object.class

    }
}

class Live {
}

class Animal extends Live {
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

