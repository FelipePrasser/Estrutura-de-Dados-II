package grafo;

import java.util.ArrayList;

public class Vertice{
    private int numVert;
    private ArrayList<Aresta> lAresta;
    
    public Vertice(int numVert) {
        this.numVert = numVert;
        this.lAresta = new ArrayList<Aresta>();
    }

    public int getNumVert() {
        return numVert;
    }

    public void setNumVert(int numVert) {
        this.numVert = numVert;
    }

    public ArrayList<Aresta> getAresta() {
        return lAresta;
    }

    public void setAresta(Aresta aresta) {
        this.lAresta.add(aresta);
    }

    @Override
    public String toString(){
        String resposta = "";
        resposta = resposta + this.numVert;
        return resposta;
    }

}