package grafos;

import java.util.ArrayList;

public class Vertice{
    private int numVert;
    private ArrayList<Arestas> lAresta;
    
    public Vertice(int numVert) {
        this.numVert = numVert;
        this.lAresta = new ArrayList<Arestas>();
    }

    public int getNumVert() {
        return numVert;
    }

    public void setNumVert(int numVert) {
        this.numVert = numVert;
    }

    public ArrayList<Arestas> getAresta() {
        return lAresta;
    }

    public void setAresta(Arestas aresta) {
        this.lAresta.add(aresta);
    }

    @Override
    public String toString(){
        String resposta = "";
        resposta = resposta + this.numVert;
        return resposta;
    }

}