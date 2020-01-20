package com.fonowizja.eksperymenta.generyki.szpital.choroby;

/**
 * @author krzysztof.kramarz
 */
public interface Choroba {

    Integer porownajZagrozenie(Choroba innaChoroba);

    Integer getZagrozenie();
}
