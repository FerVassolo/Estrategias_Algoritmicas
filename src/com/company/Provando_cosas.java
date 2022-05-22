package com.company;

public class Provando_cosas {
    static <Int> StaticQueue<Integer> cola(){
        StaticQueue<Integer> cola = new StaticQueue<>(20);
        for (int i = 0; i < 20; i++){
            cola.enqueue(i);
        }
        return cola;
    }
}
