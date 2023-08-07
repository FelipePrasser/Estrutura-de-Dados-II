package grafos;

import java.util.ArrayList;

public class Vertice{
    private int numVert;
    private ArrayList<Arestas> aresta;
    
    public Vertice(int numVert) {
        this.numVert = numVert;
    }

    public int getNumVert() {
        return numVert;
    }

    public void setNumVert(int numVert) {
        this.numVert = numVert;
    }

    public ArrayList<Arestas> getAresta() {
        return aresta;
    }

    public void setAresta(ArrayList<Arestas> aresta) {
        this.aresta = aresta;
    }

}