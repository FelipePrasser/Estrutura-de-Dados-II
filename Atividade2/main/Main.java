package main;

import java.util.ArrayList;

import grafo.Grafo;
import grafo.Vertice;

public class Main{
    public static void main(String[] args) {
        Grafo grafo=new Grafo();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();


        ArrayList<Vertice> lVertices=grafo.getlVertices();

        grafo.insereA(lVertices.get(0), lVertices.get(1));
        grafo.insereA(lVertices.get(0), lVertices.get(2));
        grafo.insereA(lVertices.get(1), lVertices.get(2));
        grafo.insereA(lVertices.get(1), lVertices.get(5));

        grafo.insereA(lVertices.get(3), lVertices.get(4));

        System.out.println("Vértice: "+ grafo.getlVertices());
        System.out.println("Arestas: "+grafo.getlArestas());
        System.out.println(grafo.buscaLargura(lVertices.get(0)));
        System.out.println(grafo.lAdjGrafo(lVertices.get(0)));
    }
}