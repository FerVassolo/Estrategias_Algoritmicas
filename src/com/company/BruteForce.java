package com.company;

import java.util.Arrays;
import java.util.Objects;

public class BruteForce {
    String[][] equipos;
    String[][] partidos;
    StaticQueue<Integer> queue = new StaticQueue<>(40);


    public BruteForce(String[][] equipos, String[][] partidos) {
        this.partidos = partidos;
        this.equipos = equipos;

    }

    public void combinaciones_posibles(int puntos, int partidos){
        Pila combinacion = new Pila();
        Pila[] posibles_combinaciones_del_equipo = new Pila[20];

        int k = 0;
        for (int i = 0; i < partidos; i++)
        {
            for (int j = 0; j <= partidos - i; j++)
            {
                for (int m = 0; m < i; m++)
                {
                    combinacion.apilar(3);
                }

                for (int l = 0; l < j; l++)
                {
                    combinacion.apilar(1);
                }

                for (int l = 0; l < partidos - (j + i); l++){
                    combinacion.apilar(0);
                }
                posibles_combinaciones_del_equipo[k] = combinacion;
                int tamanio = posibles_combinaciones_del_equipo[k].valorTope();
                combinacion = new Pila();
                k++;
            }
        }

        permutaciones(posibles_combinaciones_del_equipo, 4);
    }
    static int[][] permutaciones(Pila[] combinaciones, int n){
        // queremos mezclar n cuanta cantidad de partidos haya
        int[][] posibles_combinaciones_del_equipo = new int[20][combinaciones[0].valorTope()+1];

        int tamanio_cominaciones = combinaciones[0].valorTope() + 1;
        int i = 0;
        while(combinaciones[i] != null) {

                int tamanio = combinaciones[i].valorTope();
                for (int j = 0; j <= tamanio; j++) {
                    posibles_combinaciones_del_equipo[i][j] = combinaciones[i].verTope();
                    System.out.println(posibles_combinaciones_del_equipo[i][j]);
                    combinaciones[i].desapilar();
                }
                System.out.println("-----");
                i++;
            }

        return posibles_combinaciones_del_equipo;
    }
}


