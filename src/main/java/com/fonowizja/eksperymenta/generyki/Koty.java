package com.fonowizja.eksperymenta.generyki;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krzysztof.kramarz
 * wildcard bounded by superclass type
 * PECS jest skrótem od producent nadrzędny, konsument bazowy (ang. producer-
 * -extends, consumer-super).
 * Naftalin i Wadler nazywają ją zasadą Get i Put
 */
class Koty {
    // PRODUCENT (Bloch, 31)  Supplier T get()
    // covariance  KOWARIANCJA wnioskownanie typu bardziej szczegółowego
    // możemy przekazywać różne podtypy Animal i rzutować na Animal (nie tylko na Live czy Object)
    private static void printAllAnimals(List<? extends Animal> animals) {
        System.out.println("printAllAnimals");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        Animal animalFromList = animals.get(0);
//        Cat catFromList = animals.get(0); nie działa, bo nie wiadomo jaki będzie tyl pochodny
        Live liveFromList = animals.get(0); // OK, nadtyp można pobrać
        Object objectFromList = animals.get(0);

        // nie działa, bo nie wiadomo jaka lista przyjdzie
//        animals.add(new Cat());
//        animals.add(new Animal()); nie działa

        //działa  <? super > = a !!
        List<? extends Animal> kowariante;
        List<Animal> tylkoAnimalsy = new ArrayList<>();
        kowariante = tylkoAnimalsy;
        Animal animal = kowariante.get(1);
        //  kowariante.add(new Cat()); nie da się dodać, konsumer nie działa

        animals = tylkoAnimalsy;
        animals.get(0);//można, bo zmienna animals jest ugeneryczniona hierarchią, dlatego będą pasować
        // wszystkie obiekty Animals i jej postypy
        // generyk juz zna hierarchie, wie ze moze dostać A,B,C więc nawet jak przekazaliśmy List<B>, to jest ok

        /*ale do deklaracji listy ugenerycznionej hierarchią <? xtends Animal>
        nie można dodać nic z tej hierarchi
        bo nie wiadomo, jaka lista naprawdę przyjdzie*/
//        animals.add(new Animal());
//        animals.add(new Cat());
//        animals.add(new RedCat());
    }

    // KONSUMER (Bloch, 31) Consumer accept(T t)
    // contravariance KONTRAWARIANCJA wnioskowanie typu bardziej uogólnionego
    private static void insertAllAnimals(List<? super Animal> animalsOrHigher) {
        /*
        Gdy deklarowana lista jest parametryzowana <? super Animal> gdy pobieramy element,
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

        //nie działa <? super > = b !!
        //działa  <? super > = a !!
        List<? super Animal> kontrawariantne;
        List<Animal> tylkoAnimalsy = new ArrayList<>();
        kontrawariantne = tylkoAnimalsy;

        List<Cat> tylkoCaty = new ArrayList<>();
//        kontrawariantne = tylkoCaty;nie działa

        // Animal animal = kontrawariantne.get(1);  nie da się pobrać, konsumer nie działa
        kontrawariantne.add(new Cat());
    }

    //taka metoda dla podsumowania
    private static <T extends Cat> void addCat(List<? super Cat> catList, T item) {
        catList.add(item);
        System.out.println(String.format("Item of class: %s added", item.getClass()));
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
        //addCat(dogList, new Cat());
        dogList.add(new Dog());

        List<Live> livesList = new ArrayList<>();
        List<Object> objectsList = new ArrayList<>();

        List<? extends Animal> listExtendsAnimal= new ArrayList<>();
//        listExtendsAnimal.add(new Cat()); nie działa nic nie wsadzimy, ani ANimal ani Cat ani Object
//        Animal animal = listExtendsAnimal.get(0); IndexOutOfBoundsException:
        List<? super Animal> listSuperAnimal= new ArrayList<>();
        Object o1 = listSuperAnimal.get(0);
        listSuperAnimal.add(new Cat());

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
        insertAllAnimals(listSuperAnimal);
//        insertAllAnimals(listExtendsAnimal); nie działa
        /*
ad. 2
        In listA you can insert objects that are either instances of A, or subclasses of A (B and C).
        If you could do this:
        listB = listA;
        then you could risk that listA contains non-B objects.
        When you then try to take objects out of listB you could risk to get non-B objects out (e.g. an A or a C).
        That breaks the contract of the listB variable declaration.
        Aby umozliwić takie elastyczne przypisanie, ugenerycczniamy metodę stosujemy konstrukcje <? extends Animal>.
        Wtedy mozemy przekazać szereg obiektów z danej hierarchi i rzutowac kazdy obiekt na A lub nadtyp bo nie boimy się
        że dostaniemy ClassCast Exception, gdyż mamy zapewnione, że każdy "is Animal"
        */


        printAllAnimals(animalList);
        printAllAnimals(catList); //tu przekazujemy List<B>, a w metodzie zrobimy listB = listA;
        printAllAnimals(redCatList);
        printAllAnimals(dogList);
//        printAllAnimals(listSuperAnimal); nie działa
        printAllAnimals(listExtendsAnimal);


        // List<?>
        List<?> c = new ArrayList<>();
//        c.add(new Object()); // Compile time error
        c.add(null); // to zadziala! null is subtype of any Object
        Object o = c.get(0);// to zadziala, mimo deklaracji List<?>, bo na pewno jest tam jakis Object.class


//proby z A,B,C
        List<Object> objects = new ArrayList<>();
        List<A> listA = new ArrayList<>();
        listA.add(new A());
        listA.add(new B());
        listA.add(new C());

        List<B> listB = new ArrayList<>();
        listB.add(new B());
        //listB.add(new A()) nie działa!

//        listA=listB; nie działa

        List<? extends A> extendsA = new ArrayList<>();
        extendsA = listA;
        extendsA = listB;

//        listA = extendsA; nie działa
//        listB = extendsA; nie działa
//        extendsA = objects;  nie działa
//        objects = extendsA;  nie działa


        List<? super A> superA = new ArrayList<>();
        superA = listA;
//      superA = listB; nie działa
        superA = objects;
//      objects = superA;  nie działa
//      listA = superA;  nie działa
//      listB = superA;  nie działa

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
