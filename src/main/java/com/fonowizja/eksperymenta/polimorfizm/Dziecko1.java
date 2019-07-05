package com.fonowizja.eksperymenta.polimorfizm;

/**
 * @author krzysztof.kramarz
 */
class Dziecko1 extends Rodzic {

    String kto = "Dziecko1";
    void porozmawiaj(){
        System.out.println("Nie mam czasu");
    }

    void placze(){
        System.out.println("AAaaaaa!");
    }
}
