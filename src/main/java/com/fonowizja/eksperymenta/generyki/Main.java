package  com.fonowizja.eksperymenta.generyki;

/**
 * @author krzysztof.kramarz
 */
class Main {

    public static void main(String[] args) {

        Pacjent<String> stringPacjent = new Pacjent<>();
        stringPacjent.setIdentyfikaator("Marek");

        System.out.println(stringPacjent.getIdetyfikator());

        Pacjent<Integer> integerPacjent = new Pacjent<>();
        integerPacjent.setIdentyfikaator(23);

        System.out.println(integerPacjent.getIdetyfikator());

    }


}
