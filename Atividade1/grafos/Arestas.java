package grafos;
public class Arestas{
    private Vertice vertice1, vertice2;
    private int numAresta;

    public Arestas(int numAresta, Vertice vertice1, Vertice vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.numAresta=numAresta;
    }

    public Vertice getVertice1() {
        return vertice1;
    }

    public void setVertice1(Vertice vertice1) {
        this.vertice1 = vertice1;
    }

    public Vertice getVertice2() {
        return vertice2;
    }

    public void setVertice2(Vertice vertice2) {
        this.vertice2 = vertice2;
    }
    
    @Override
    public String toString(){
        String resposta = "";
        resposta = resposta + this.numAresta;
        return resposta;
    }
}