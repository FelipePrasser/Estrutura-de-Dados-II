package grafos;

import java.util.ArrayList;

public class Grafos{
    private ArrayList<Vertice> lVertices=new ArrayList<>(); 
    private ArrayList<Arestas> lArestas=new ArrayList<>();
    private int numVert=0, numAresta=0;
    
    public Grafos() {
    }

    public ArrayList<Vertice> getlVertices() {
        return lVertices;
    }
    public void setlVertices(ArrayList<Vertice> lVertices) {
        this.lVertices = lVertices;
    }

    public ArrayList<Arestas> getlArestas() {
        return lArestas;
    }
    public void setlArestas(ArrayList<Arestas> lArestas) {
        this.lArestas = lArestas;
    }



    public int getOrdem(){
        return(numVert);
    }
    
    public int getTamanho(){
        return(numAresta);
    }

    public ArrayList<Vertice> vertices(){
        return lVertices;
    }

    public ArrayList<Arestas> arestas(){
        return lArestas;
    }

    public void insereV(){
        numVert++;
        lVertices.add(new Vertice(numVert));
    }

    public void removeV(Vertice v){
        
    }

    public void insereA(Vertice u, Vertice v){
        numAresta++;
        Arestas a = new Arestas(numAresta, u, v);
        lArestas.add(a);
        u.setAresta(a);
        v.setAresta(a);
    }
}