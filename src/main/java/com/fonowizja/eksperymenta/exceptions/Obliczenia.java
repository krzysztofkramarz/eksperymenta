package com.fonowizja.eksperymenta.exceptions;

/**
 * @author krzysztof.kramarz
 */
class Obliczenia implements Runnable {
    private String valueOfMap;

    public Obliczenia(String valueOfMap) {
        this.valueOfMap = valueOfMap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.getMessage();
        }
//        try {
            String[] split = valueOfMap.split("-");
            System.out.println("___________________________");
            System.out.println("Wątek: " + Thread.currentThread().getName());
            System.out.println("Drukuje: " + split[0]);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
