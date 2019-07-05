package com.fonowizja.eksperymenta.polimorfizm;

/**
 * @author krzysztof.kramarz
 */
class Main {


    public static void main(String[] args) {

        Rodzic rodzic = new Rodzic();

//        Dziecko1 dziecko1 = (Dziecko1) rodzic;// ClassCastException, nie da się rzutowac w górę
//       dziecko1.placze();//nie da sie wykonac przz polimorfizm
        rodzic.porozmawiaj();




        Rodzic rodzic1 = (Rodzic) new Dziecko1();
        System.out.println(rodzic1.kto);
        rodzic1.porozmawiaj();

        Rodzic rodzic2 = new Dziecko2();
        rodzic2.porozmawiaj();

    }
}
