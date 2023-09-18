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

        ArrayList<Vertice> lVertices=grafo.getlVertices();

        grafo.insereA(lVertices.get(0), lVertices.get(0));
        grafo.insereA(lVertices.get(0), lVertices.get(1));

        System.out.println(grafo.getTamanho());
        System.out.println(grafo.vertices());
        System.out.println(grafo.arestas());
        grafo.removeA(grafo.getlArestas().get(0));
        System.out.println(grafo.getTamanho());
    }
}