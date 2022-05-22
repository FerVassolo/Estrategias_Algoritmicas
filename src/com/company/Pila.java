package com.company;

public class Pila {

    private int tope; //peek
    private int tamaño = 10000;
    private int[] pil = new int[tamaño]; //El caballo puede tener un max de 8 movimientos posibles en el mayor de los casos

    public Pila()
    {
        tope=-1;// explico en apilar

    }

    public void desapilar()//Pop
    {
        tope--;
    }
    public int valorTope(){
        return tope;
    }

    public void apilar(int x)//push
    {
        if (tope == tamaño){
            agrandarArray();
        }
        tope++; // en el primero, tope es 0
        pil[tope]=x;

    }

    public boolean esVacia()//IsEmpty
    {
        return tope == -1;
    }

    public int verTope() { //peek
        if (!esVacia()){
            int a = pil[tope];
            return a;
        } else
            return -1;
    }
    public void agrandarArray(){
        int[] auxArray = new int[tamaño + 100];
        for (int i = 0; i<tamaño; i++){
            auxArray[i] = pil[i];
        }
        tamaño = auxArray.length;
        pil = auxArray;
    }

}
