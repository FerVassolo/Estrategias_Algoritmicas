package com.company;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Consola {

    public static void inputs(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingrese:\n" +
                "1. Iniciar programa con datos predeterminados\n" +
                "0. Salir");
        String intro = myObj.nextLine();
        if (Objects.equals(intro, "1"))
        {
            String[][] equipos = new String[][]{{"River", "4"}, {"Racing", "6"}, {"Boca", "3"},
                    {"Independiente", "5"}, {"Estudiantes", "10"}, {"Gimnasia", "0"}};
            String[][] partidos = Data.partidos_random(11, equipos);
            Data.presentar_data(equipos, partidos);
            BruteForce brute = new BruteForce(equipos, partidos);
            brute.combinaciones_posibles(10, 4);
        }
    }


}
