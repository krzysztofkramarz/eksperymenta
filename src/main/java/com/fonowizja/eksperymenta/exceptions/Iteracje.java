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
    stringStringMap.put("e", "e");
    }

    void start(){
        Iterator<String> iterator = stringStringMap.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(stringStringMap.get(key));
        }

    }

}
