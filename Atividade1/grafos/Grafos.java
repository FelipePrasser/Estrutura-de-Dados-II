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
        ArrayList <Integer> aux=new ArrayList<>();
        for (int i = 0; i < lArestas.size(); i++) {
            if (lArestas.get(i).getVertice1()==v || lArestas.get(i).getVertice2()==v) {
                    aux.add(i);
                }
        }
        for (int i = aux.size()-1; i >=0 ; i--) {
            lArestas.remove(aux.get(i).intValue());
        }
        
        for (int i = 0; i < lVertices.size(); i++) {
            if(lVertices.get(i)==v){
                lVertices.remove(i);
            }
        }

    }

    public void insereA(Vertice u, Vertice v){
        numAresta++;
        Arestas a = new Arestas(numAresta, u, v);
        lArestas.add(a);
        u.setAresta(a);
        v.setAresta(a);
    }

    public void removeA(Arestas e){
        for (int i = 0; i < lArestas.size(); i++) {
            if (lArestas.get(i)==e || lArestas.get(i)==e) {
                    lArestas.remove(i);
                }
        }
    }

    public ArrayList<Vertice> adj(Vertice u){
        ArrayList <Vertice> lVertAdj=new ArrayList<>();
        for (int i=0; i<lArestas.size(); i++){
            if (lArestas.get(i).getVertice1()==u){
                lVertAdj.add(lArestas.get(i).getVertice2());
            }
            if(lArestas.get(i).getVertice2()==u){
                lVertAdj.add(lArestas.get(i).getVertice1());
            }
        }
        return lVertAdj;
    }

    public Arestas getA(Vertice u, Vertice v){
        for (int i=0; i<lArestas.size(); i++){
            if((lArestas.get(i).getVertice1()==u || lArestas.get(i).getVertice1()==v) && (lArestas.get(i).getVertice2()==u || lArestas.get(i).getVertice2()==v)){
                return lArestas.get(i);
            }
        }
        return null;
    }

    public int grau(Vertice v){
        int numGrau=0;
        for (int i = 0; i < lArestas.size(); i++) {
            if((lArestas.get(i).getVertice1()==v || lArestas.get(i).getVertice2()==v)){
                if(lArestas.get(i).getVertice1()==v && lArestas.get(i).getVertice2()==v){
                    numGrau+=2;
                }else{
                    numGrau++;
                }
            }
        }
        return numGrau;
    }

    public ArrayList<Vertice> verticeA(Arestas e){
        ArrayList<Vertice> parDeVertices=new ArrayList<>();
        for (int i = 0; i < lArestas.size(); i++) {
            if(lArestas.get(i)==e){
                parDeVertices.add(lArestas.get(i).getVertice1());
                parDeVertices.add(lArestas.get(i).getVertice2());
            }
        }
        return parDeVertices;
    }

    public Vertice oposto(Vertice v, Arestas e){
        ArrayList<Vertice> parDeVertices=verticeA(e);
        if(parDeVertices.get(0)==v){
            return parDeVertices.get(1);
        }else{
            return parDeVertices.get(0);
        }
        
    }
}