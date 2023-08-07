package main;
import grafos.Grafos;
public class Main{
    public static void main(String[] args) {
        Grafos grafo=new Grafos();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
        grafo.insereV();
                grafo.insereV();

        System.out.println(grafo.getOrdem());
        
    }
}