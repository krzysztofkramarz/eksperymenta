package com.fonowizja.eksperymenta.exceptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author krzysztof.kramarz
 */
class Iteracje {

    private Map<String, String> stringStringMap;

     Iteracje() {
    stringStringMap = new HashMap<>();
    stringStringMap.put("a", "a");
    stringStringMap.put("b", "b");
    stringStringMap.put("c", "c");
    stringStringMap.put("d", "d");
    stringStringMap.put("e", null);
    stringStringMap.put("f", "jeszcze");
    }

    void start() throws InterruptedException {
        Iterator<String> iterator = stringStringMap.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            //jeśli iteracja ruszy w wielu wątkach, to jeśli poleci runtime exception to wywali się ten jeden watek , a reszta
            //w tym główny watek, będą dzialać dalej
            Thread thread = new Thread(new Obliczenia(stringStringMap.get(key)),  key);
            thread.start();
            thread.join();
            //jeśłi iteracja bedzie tylko wjednym wątku, to cały program sie wyłoży
//           new Obliczenia(stringStringMap.get(key)).run();
        }

        System.out.println("#### WĄTEK Główny działa dalej!!!!");

    }

}
