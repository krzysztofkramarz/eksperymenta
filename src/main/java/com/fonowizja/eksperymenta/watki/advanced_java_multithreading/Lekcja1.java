package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

/**
 * Podstawowe uruchamianie wątków
 *
 * @author krzysztof.kramarz
 */
class Lekcja1 {

    public static void main(String[] args) {
        ThreadRunner threadRunner1 = new ThreadRunner("threadRunner1");

        ThreadRunner threadRunner2 = new ThreadRunner("threadRunner2");
        threadRunner1.start();
        threadRunner2.start();

        Runner runner = new Runner();
//        new Thread(runner, "Runner").start();

        //poniżej tworzymy implementację interejsu funkcyjnego i przypisujemy do zmiennej
        //implementacja to method reference
       Biegajmy biegajmy = new Biegajmy();
        Runnable biegajmyBehaviourOfRun = biegajmy::biegajmy;
        //tutaj wywiłujemy tylko metodę run.
        biegajmyBehaviourOfRun.run();
        //tutej urucahamiamy wątek, przekazując obiekt typu runnable
        new Thread(biegajmyBehaviourOfRun, "Biegajmy").start();

    }

}

class ThreadRunner extends Thread {

    ThreadRunner(String runner1) {
        super(runner1);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(0, 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Witam, jestem z wątku: " + Thread.currentThread().getName() + "  " + i);
        }
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Witam, tu klasa Runner, jestem z wątku: " + Thread.currentThread().getName() + "  " + i);
        }
    }


}

class Biegajmy {
    void biegajmy() {
        System.out.println("uf uf uf uf uf, jestem z wątku: " + Thread.currentThread().getName());
    }
}
