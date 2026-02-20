package com.mycompany.puzzle_8;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    String estado;
    Nodo padre;
    //List<Nodo> hijos; opcional
    int nivel;
    //int costo; por ahora no

    public Nodo(String estado, Nodo padre, int nivel){
        this.estado = estado;
        this.padre = padre;
        this.nivel = nivel;
    }

    
    public void imprimirCamino() {
    // Si el nodo tiene un padre, primero llamamos recursivamente al padre
    if (this.padre != null) {
        this.padre.imprimirCamino();
    }

    // Imprime el estado actual del nodo en formato matriz 3x3
    for (int i = 0; i < 9; i++) {
        System.out.print(this.estado.charAt(i) + " ");
        if ((i + 1) % 3 == 0) {
            System.out.println();
        }
    }

    // Imprime el nivel y una línea separadora
    System.out.println("Nivel: " + this.nivel);
    System.out.println("--------------------");
}
    
    public List<Nodo> generarSucesores() {
    String[] estadosHijos = Puzzle8.generarSucesores(this.estado);
    List<Nodo> hijos = new ArrayList<Nodo>();
    
   
    if (estadosHijos != null) {
        for (String estadoHijo : estadosHijos) {
            if (estadoHijo != null) { 
                Nodo nodoHijo = new Nodo(estadoHijo, this, this.nivel + 1);
                hijos.add(nodoHijo);
            }
        }
    }
    return hijos;
}


    public String getEstado() {
        return estado;
    }

}
