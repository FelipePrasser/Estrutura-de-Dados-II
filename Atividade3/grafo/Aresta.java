package grafo;
public class Aresta{
    private Vertice vertice1, vertice2;
    private int id, valor;

    public Aresta(int id, Vertice vertice1, Vertice vertice2, int valor) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.id=id;
        this.valor = valor;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        String resposta = "";
        resposta = resposta + this.id;
        return resposta;
    }

    
}