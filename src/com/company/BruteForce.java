package com.company;

import java.util.Arrays;
import java.util.Objects;

public class BruteForce {

    String[][] partidos;
    String[][] equipos;

    public BruteForce(String[][] equipos, String[][] partidos) {
        this.partidos = partidos;
        this.equipos = equipos;
        int[][] lista_de_combinaciones = new int[cantidad_de_permutaciones(partidos.length)][partidos.length];
        int[] primer_array = new int[partidos.length];
        for (int i = 0; i < partidos.length; i++)
        {
            primer_array[i] = 0;
        }
        lista_de_combinaciones[0] = primer_array;
        combinaciones_posibles(primer_array, 1,  lista_de_combinaciones);
    }

    public int cantidad_de_permutaciones(int n){
        return (int) Math.pow(3, n);
    }

    public void combinaciones_posibles(int[] ultimo_array, int n,  int[][] lista_de_combinaciones){

        int i = partidos.length-1;
        while (i >= 0) {
            if (ultimo_array[i] != 2) {
                ultimo_array[i] = ultimo_array[i] + 1;
                break;
            } else {
                ultimo_array[i] = 0;
                i--;
            }
        }
        lista_de_combinaciones[n] = ultimo_array;
        n++;

        if(n < cantidad_de_permutaciones(partidos.length) && !chequear_permutacion(ultimo_array)){
            combinaciones_posibles(ultimo_array, n, lista_de_combinaciones);}
    }
    boolean chequear_permutacion(int[] array){

        for (int i = 0; i < equipos.length; i++){
            String equipo = equipos[i][0];
            int puntos = Integer.parseInt(equipos[i][1]);
            for (int j = 0; j < array.length; j++){
                if (Objects.equals(equipo, partidos[j][0]) || Objects.equals(equipo, partidos[j][1])){
                    if (array[j] == 1 && Objects.equals(equipo, partidos[j][0]))
                        puntos = puntos -3;
                    if (array[j] == 2 && Objects.equals(equipo, partidos[j][1]))
                        puntos = puntos -3;
                    if (array[j] == 0)
                        puntos = puntos -1;
                }
            }
            if(puntos != 0){
                return false;
            }
        }
        System.out.println("\nCombinación correcta");
        for (int k : array) {
            System.out.print(k);
            System.out.print(" ");
        }

        return true;
    }


}
