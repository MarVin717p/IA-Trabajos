package com.mycompany.puzzle_8;

public class Main {

    public static void main(String[] args) {
        String estadoInicial = "1234*6758"; 
        String estadoObjetivo = "12345678*";

        Nodo raiz = new Nodo(estadoInicial, null, 0);
        ArbolDeBusqueda arbol = new ArbolDeBusqueda(raiz);
        
        Nodo solucion = arbol.busquedaPrimeroAnchura(estadoObjetivo);
        
        System.out.println(solucion.nivel);
    }
}
