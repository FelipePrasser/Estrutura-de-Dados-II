package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo{
    private ArrayList<Vertice> lVertices=new ArrayList<>(); 
    private ArrayList<Aresta> lArestas=new ArrayList<>();
    private int numVert=0, numAresta=0;
    
    public Grafo() {
    }

    public ArrayList<Vertice> getlVertices() {
        return lVertices;
    }
    public void setlVertices(ArrayList<Vertice> lVertices) {
        this.lVertices = lVertices;
    }

    public ArrayList<Aresta> getlArestas() {
        return lArestas;
    }
    public void setlArestas(ArrayList<Aresta> lArestas) {
        this.lArestas = lArestas;
    }



    public int getOrdem(){
        return(lVertices.size());
    }
    
    public int getTamanho(){
        return(lArestas.size());
    }

    public ArrayList<Vertice> vertices(){
        return lVertices;
    }

    public ArrayList<Aresta> arestas(){
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
        Aresta a = new Aresta(numAresta, u, v);
        lArestas.add(a);
        u.setAresta(a);
        v.setAresta(a);
    }

    public void removeA(Aresta e){
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
        if(lVertAdj.size()==0){
            return null;
        }else{
            return lVertAdj;
        }
    }

    public Aresta getA(Vertice u, Vertice v){
        for (int i=0; i<lArestas.size(); i++){
            if((lArestas.get(i).getVertice1()==u || lArestas.get(i).getVertice1()==v) && (lArestas.get(i).getVertice2()==u || lArestas.get(i).getVertice2()==v)){
                if((u!=v)&&(lArestas.get(i).getVertice1()!=lArestas.get(i).getVertice2())){
                    return lArestas.get(i);
                }
                if((u==v)&&(lArestas.get(i).getVertice1()==lArestas.get(i).getVertice2())){
                    return lArestas.get(i);
                }
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

    public ArrayList<Vertice> verticeA(Aresta e){
        ArrayList<Vertice> parDeVertices=new ArrayList<>();
        for (int i = 0; i < lArestas.size(); i++) {
            if(lArestas.get(i)==e){
                parDeVertices.add(lArestas.get(i).getVertice1());
                parDeVertices.add(lArestas.get(i).getVertice2());
            }
        }
        return parDeVertices;
    }

    public Vertice oposto(Vertice v, Aresta e){
        ArrayList<Vertice> parDeVertices=verticeA(e);
        if(parDeVertices.get(0)==v){
            return parDeVertices.get(1);
        }else{
            return parDeVertices.get(0);
        }
        
    }

    public HashMap<Vertice, Vertice> buscaLargura(Vertice v){
        HashMap<Vertice,Vertice> vetorPredecessor=new HashMap<>();
        ArrayList <String> estadoVertice=new ArrayList<>();
        ArrayList <Vertice> lAux=lAdjGrafo(v);

        for (int i = 0; i < lVertices.size(); i++) {
            if(lVertices.get(i)==v){
                    vetorPredecessor.put(v, null);
                    estadoVertice.add("v");
            }else{
                if(lAux.contains(lVertices.get(i))){
                    estadoVertice.add("n_v");
                }else{
                    estadoVertice.add("n_e");
                    vetorPredecessor.put(lVertices.get(i), null);
                }
            }                            
        }
        buscaLargura(v, estadoVertice, vetorPredecessor);
        return vetorPredecessor;
        
    }

    private void buscaLargura(Vertice v, ArrayList<String> estadoVertice, HashMap<Vertice, Vertice> vetorPredecessor){
        ArrayList<Vertice> lAdj=adj(v);
        for(int i=0; i<lVertices.size(); i++){
            for (int j = 0; j < lAdj.size(); j++) {
                if(estadoVertice.get(i)=="n_v"){
                    if (lVertices.get(i)==lAdj.get(j)){
                        vetorPredecessor.put(lAdj.get(j), v);
                        estadoVertice.set(i, "v");
                        buscaLargura(lAdj.get(j), estadoVertice, vetorPredecessor);
                    }
                }
            }
        }
    }

    private ArrayList<Vertice> lAdjGrafo(Vertice v) {
        ArrayList<Vertice> lAdj = new ArrayList<>();
        ArrayList<Vertice> visitados = new ArrayList<>();
        Queue<Vertice> fila = new LinkedList<>();

        // Inicialize a busca a partir do vértice v
        fila.add(v);
        visitados.add(v);

        while (!fila.isEmpty()) {
            Vertice u = fila.poll();
            lAdj.add(u);

            ArrayList<Vertice> adjacentes = adj(u);
            for (Vertice adjacente : adjacentes) {
                if (!visitados.contains(adjacente)) {
                    fila.add(adjacente);
                    visitados.add(adjacente);
                }
            }
        }

        return lAdj;
    }

    public HashMap <Vertice, Vertice> buscaProfundidade(Vertice v){
        HashMap<Vertice,Vertice> vetorPredecessor=new HashMap<>();
        ArrayList <String> estadoVertice=new ArrayList<>();
        ArrayList <Vertice> lAux=lAdjGrafo(v);

        for (int i = 0; i < lVertices.size(); i++) {
            if(lVertices.get(i)==v){
                    vetorPredecessor.put(v, null);
                    estadoVertice.add("v");
            }else{
                if(lAux.contains(lVertices.get(i))){
                    estadoVertice.add("n_v");
                }else{
                    estadoVertice.add("n_e");
                    vetorPredecessor.put(lVertices.get(i), null);
                }
            }      
        }
        buscaProfundidade(v, estadoVertice, vetorPredecessor);
        return vetorPredecessor;
    }
    
    private void buscaProfundidade (Vertice v, ArrayList <String> estadoVertice, HashMap<Vertice, Vertice> vetorPredecessor){
        ArrayList <Vertice> lAdj=adj(v);
        int k=lAdj.size()-1;
        boolean aux=true;
        
        while(k>=0){
            if(k==0){
                if (lAdj.get(k) instanceof Vertice==false) {
                    break;
                }
            }
            for (int index = 0; index < lVertices.size(); index++) {    
                if(lAdj.get(k)==lVertices.get(index)){          
                    if(estadoVertice.get(index)=="n_v"){
                        vetorPredecessor.put(lVertices.get(index), v);
                        estadoVertice.set(index, "v");
                        buscaProfundidade(lAdj.get(k), estadoVertice, vetorPredecessor);
                        k--;
                        // if(k>0){
                        //     k--;
                        // }
                        // // break;
                    }
                }
            }
        }
        // aux=estadoVertice.contains("n_v");
    }
    
}