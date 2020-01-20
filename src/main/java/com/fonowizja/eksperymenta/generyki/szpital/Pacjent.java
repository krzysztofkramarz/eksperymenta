package com.fonowizja.eksperymenta.generyki.szpital;

import com.fonowizja.eksperymenta.generyki.szpital.choroby.Choroba;
import lombok.Data;

/**
 * @author krzysztof.kramarz
 */
@Data
class Pacjent<T extends Choroba> {

    T choroba;

    // Integer ktoBardziejZaraza(T innaChoroba ) { // tak sie nie da!! bo T już użyte w danej instancji
//    Integer ktoBardziejZaraza(? innaChoroba ) { // tak sie nie da!!
//   Integer ktoBardziejZaraza(Choroba innaChoroba) { // działa
    <S extends Choroba> Integer ktoBardziejZaraza(S innaChoroba ) {
        return choroba.porownajZagrozenie(innaChoroba);
    }
}

