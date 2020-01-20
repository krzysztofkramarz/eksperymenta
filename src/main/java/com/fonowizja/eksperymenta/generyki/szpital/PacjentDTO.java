package com.fonowizja.eksperymenta.generyki.szpital;

import com.fonowizja.eksperymenta.generyki.szpital.choroby.Choroba;

/**
 * @author krzysztof.kramarz
 */
class PacjentDTO {
    //nie musimy dawac przy klasie <T> i działa
    private Pacjent<? extends Choroba>  tPacjent;

    public Pacjent<?> gettPacjent() {
        return tPacjent;
    }

    public void settPacjent(Pacjent<?> tPacjent) {
        this.tPacjent = tPacjent;
    }
//    static void printDTOs(Pacjent<?> tPacjent){ // działa
    static <T extends Choroba> void printDTOs(Pacjent<T> tPacjent){
        System.out.println(tPacjent);
    }

}
