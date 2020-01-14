package com.fonowizja.eksperymenta.generyki;

/**
 * @author krzysztof.kramarz
 */
class Pacjent<Idetyfikator> {

    Idetyfikator idetyfikator;

    Idetyfikator getIdetyfikator() {
        return idetyfikator;
    }

    void setIdentyfikaator(Idetyfikator idetyfikator) {
        this.idetyfikator = idetyfikator;
    }

    <T extends Ryzyko> void obliczWskaznikZdrowia(T wspolczynnikRyzyka) {
    }


}

interface Ryzyko {

}

