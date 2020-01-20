package com.fonowizja.eksperymenta.generyki.szpital;

import lombok.Getter;

import java.util.List;

/**
 * @author krzysztof.kramarz
 */
@Getter
class ListaChorob<T> {
    private List<?> listaChorob;

    void addChoroba(T cHoroba){
//        listaChorob.add(cHoroba);
    }
}
