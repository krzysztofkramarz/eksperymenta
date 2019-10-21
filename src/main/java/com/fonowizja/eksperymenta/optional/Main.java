package com.fonowizja.eksperymenta.optional;

import java.util.Optional;
import java.util.Stack;

/**
 * @author krzysztof.kramarz
 */
class Main {

    private static final String mama = "mama";
    private static final String nullowy = null;

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        Optional<String> optionalMama = Optional.ofNullable(mama);
        Optional<String> optionalNullowy = Optional.ofNullable(nullowy);

        //coś zrobi, jeśli  w środku nie jest empty
        optionalMama.ifPresent((it)-> System.out.println(String.format("przejąłem optionala, bo nie jest empty i robie swoją akcję na nim. %s, wlasnie że tata", it)));

        //jesl w środku jest null, to zwróć co innego
        System.out.println(optionalNullowy.orElse(mama));



    }
}


//REZULTAT
//        przejąłem optionala, bo nie jest empty i robie swoją akcję na nim. mama, wlasnie że tata
//        mama