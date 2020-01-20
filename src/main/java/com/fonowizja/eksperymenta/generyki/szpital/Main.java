package com.fonowizja.eksperymenta.generyki.szpital;

import com.fonowizja.eksperymenta.generyki.szpital.choroby.Choroba;
import com.fonowizja.eksperymenta.generyki.szpital.choroby.Grypa;
import com.fonowizja.eksperymenta.generyki.szpital.choroby.Zakazenie;

/**
 * @author krzysztof.kramarz
 */
class Main {

    public static void main(String[] args) {

        //po co jest wildcard
        Pacjent<Grypa> grrypaPacjent = new Pacjent<>();
        Grypa grypa = new Grypa();
        grypa.setZagrozenie(97);
        grrypaPacjent.setChoroba(grypa);

        Pacjent<Zakazenie> zakazeniePacjent = new Pacjent<>();
        Zakazenie zakazenie = new Zakazenie();
        zakazenie.setZagrozenie(34);
        zakazeniePacjent.setChoroba(zakazenie);


        System.out.printf("Zaraża bardziej %d \n\n", grrypaPacjent.ktoBardziejZaraza(zakazeniePacjent.getChoroba()));

        //próba użycia zamiast zwyczajowego typ<?>, to typ<T>
        //jest to na opak użyte w klasie PacjentDTO
        PacjentDTO pacjentDTO = new PacjentDTO();
        Pacjent<Grypa> tPacjent = new Pacjent<>();
        pacjentDTO.settPacjent(tPacjent);
        PacjentDTO.printDTOs(tPacjent);


    }


}
