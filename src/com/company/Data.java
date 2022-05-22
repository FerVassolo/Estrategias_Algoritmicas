package com.company;

import java.util.Random;

public class Data {
    static String[][] partidos_random(int cantidad_de_partidos, String[][] equipos){
        int min = 0;
        int max = equipos.length;

        String[][] partidos = new String[cantidad_de_partidos][2];
        for (int i = 0; i < cantidad_de_partidos; i++){
            Random random = new Random();
            int nro1 = random.nextInt(min + max);
            int nro2 = random.nextInt(min + max);
            while(nro1 == nro2){
                nro2 = random.nextInt(min + max);}
            partidos[i][0] = equipos[nro1][0];
            partidos[i][1] = equipos[nro2][0];
        }
        return partidos;
    }

    static void presentar_data(String[][] equipos, String[][] partidos){
        System.out.println(equipos.length + " " + partidos.length);
        for (int i = 0; i < equipos.length; i++){
            System.out.println(equipos[i][0] + " " + equipos[i][1]);
        }
        System.out.println("");
        System.out.println("Partidos:");
        for (String[] partido : partidos) {
            System.out.println(partido[0] + " " + partido[1]);
        }
    }
}
