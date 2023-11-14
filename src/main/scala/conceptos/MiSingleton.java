package com.curso.conceptos;

public class MiSingleton {

    private static volatile MiSingleton miInstancia;

    private MiSingleton(){
    }

    public static MiSingleton getInstancia() {
        if (miInstancia != null){
            synchronized (MiSingleton.class) {
                if (miInstancia != null) {
                    miInstancia = new MiSingleton();
                }
            }
        }
        return miInstancia;
    }
}
