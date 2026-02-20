package com.mycompany.puzzle_8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArbolDeBusqueda {
    Nodo raiz;
    
    public ArbolDeBusqueda(Nodo raiz){
        this.raiz = raiz;
    }
    public Nodo busquedaPrimeroAnchura(String estadoObjetivo){
        if(raiz == null) return null;
        
        HashSet<String> visitados = new HashSet<String>();
        Queue<Nodo> cola = new LinkedList<Nodo>();
        Nodo actual = null;
        cola.add(raiz);
        while(!cola.isEmpty() ){
            actual = cola.poll();
            actual.imprimirCamino();
            
        //Test Objetivo
        if(actual.estado.equals(estadoObjetivo)){
            return actual;
        }else{
            visitados.add(actual.estado);
            List<Nodo> succesores = actual.generarSucesores();
            for(Nodo nodoHijo : succesores){
                if(!visitados.contains(nodoHijo.estado)){
                    cola.add(nodoHijo);
                    visitados.add(nodoHijo.estado);
                }
            }
        }
        }
        
        return null;
    
}
    
    public Nodo busquedaPrimeroProfundidad(String estadoObjetivo){
        if(raiz == null) return null;
        
        Stack<String> visitados = new Stack<String>();
        Stack<Nodo> cola = new Stack<Nodo>();
        Nodo actual = null;
        cola.add(raiz);
        while(!cola.isEmpty() ){
            actual = cola.pop();
            
            actual.imprimirCamino();
            
        //Test Objetivo
        if(actual.estado.equals(estadoObjetivo)){
            return actual;
        }else{
            visitados.add(actual.estado);
            List<Nodo> succesores = actual.generarSucesores();
            for(Nodo nodoHijo : succesores){
                if(!visitados.contains(nodoHijo.estado)){
                    cola.add(nodoHijo);
                    visitados.add(nodoHijo.estado);
                }
            }
        }
        }
        
        return null;
    
}
}
