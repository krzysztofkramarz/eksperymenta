package com.fonowizja.eksperymenta.generyki.szpital.choroby;

import lombok.Data;

/**
 * @author krzysztof.kramarz
 */
@Data
public class Zakazenie implements Choroba {

    private Integer zagrozenie;

    @Override
    public Integer porownajZagrozenie(Choroba innaChoroba) {
        return zagrozenie.compareTo(innaChoroba.getZagrozenie());
    }

}
