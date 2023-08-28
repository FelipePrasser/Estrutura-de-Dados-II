package main;

import java.util.ArrayList;

import grafos.Arestas;
import grafos.Grafos;
import grafos.Vertice;

public class Main{
    public static void main(String[] args) {
        Grafos grafo=new Grafos();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();

        ArrayList<Vertice> lVertices=grafo.getlVertices();
        grafo.insereA(lVertices.get(0), lVertices.get(1));
        grafo.insereA(lVertices.get(1), lVertices.get(2));
        grafo.insereA(lVertices.get(1), lVertices.get(3));
        grafo.insereA(lVertices.get(2), lVertices.get(3));
        grafo.insereA(lVertices.get(3), lVertices.get(0));
        grafo.insereA(lVertices.get(0), lVertices.get(2));
        grafo.insereA(lVertices.get(1), lVertices.get(4));
        grafo.insereA(lVertices.get(0), lVertices.get(4));
        grafo.insereA(lVertices.get(0), lVertices.get(0));

        System.out.println(grafo.oposto(lVertices.get(0), grafo.getlArestas().get(0)));
        System.out.println(grafo.adj(lVertices.get(1)));
        System.out.println(grafo.getA(lVertices.get(0), lVertices.get(1)));
        System.out.println("-----------");
        System.out.println(grafo.grau(lVertices.get(1)));
        System.out.println("par"+grafo.verticeA(grafo.getlArestas().get(0)));

        System.out.println(grafo.vertices());
        System.out.println(grafo.arestas());
        System.out.println(grafo.getTamanho());
        System.out.println(grafo.getOrdem());

        grafo.removeV(lVertices.get(1));

        System.out.println(grafo.vertices());
        System.out.println(grafo.arestas());

        Arestas a=grafo.getlArestas().get(2);
        grafo.removeA(a);
        System.out.println(grafo.vertices());
        System.out.println(grafo.arestas());
    }
}