package grafo;

import java.util.ArrayList;
import java.util.HashMap;

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
        return lVertAdj;
    }

    public Aresta getA(Vertice u, Vertice v){
        for (int i=0; i<lArestas.size(); i++){
            if((lArestas.get(i).getVertice1()==u || lArestas.get(i).getVertice1()==v) && (lArestas.get(i).getVertice2()==u || lArestas.get(i).getVertice2()==v)){
                if((u!=v)&&(lArestas.get(i).getVertice1()!=lArestas.get(i).getVertice2())){
                    return lArestas.get(i);
                }
                System.out.println("oi");
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

    // public ArrayList <ArrayList<Vertice>> buscaLargura(Vertice v){
    //     ArrayList<ArrayList <Vertice>> vetorPredecessores=new ArrayList<>();
    //     ArrayList <Vertice> lVerticeEPredecessores=new ArrayList<>();
    //     ArrayList<String> estadoVertice=new ArrayList<>();
        
    //     for(int j=0; j<lVertices.size(); j++) {
    //         if(lVertices.get(j)==v){
    //             estadoVertice.add("v");
    //             lVerticeEPredecessores.add(v);
    //             lVerticeEPredecessores.add(v);
    //             System.out.println(lVerticeEPredecessores);
    //             vetorPredecessores.add(new ArrayList<>());
    //             vetorPredecessores.set(j, lVerticeEPredecessores);
    //             System.out.println("oi");
    //         }else{
    //             estadoVertice.add("n");
    //             vetorPredecessores.add(new ArrayList<>());
    //         }
    //         lVerticeEPredecessores.clear();
    //     }
    //     System.out.println(estadoVertice);
    //     System.out.println("busca:"+vetorPredecessores);
        
    //     for (int i=0; i<lVertices.size(); i++){
    //         ArrayList <Vertice> lAdj=adj(v);
    //         for (int k = 0; k < estadoVertice.size(); k++) {
    //             int j=0;
    //             if(lAdj.get(j)==lVertices.get(i)){
    //                 if (estadoVertice.get(k).equals("n")) {
    //                     estadoVertice.set(i, "v");                  
    //                     lVerticeEPredecessores.add(lAdj.get(j));
    //                     lVerticeEPredecessores.add(v);
    //                     vetorPredecessores.set(i, lVerticeEPredecessores);
    //                     System.out.println("busca"+vetorPredecessores);
    //                     lVerticeEPredecessores.clear();
    //                     //buscaLargura(lAdj.get(j));
    //                     j++;
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(estadoVertice);
    //     return vetorPredecessores;
    // }

    public HashMap<Vertice, Vertice> buscaLargura(Vertice v){
        HashMap<Vertice,Vertice> vetorPredecessor=new HashMap<>();
        ArrayList <String> estadoVertice=new ArrayList<>();

        for (int i = 0; i < lVertices.size(); i++) {
            if(lVertices.get(i)==v){
                vetorPredecessor.put(v, null);
                estadoVertice.add("v");
            }else{
                estadoVertice.add("n_v");
            }
        }
        buscaLargura(v, estadoVertice, vetorPredecessor);
        return vetorPredecessor;
        
    }

    private void buscaLargura(Vertice v, ArrayList<String> estadoVertice, HashMap<Vertice, Vertice> vetorPredecessor){
        ArrayList<Vertice> lAdj=adj(v);
        int j=0;
        for(int i=0; i<lVertices.size(); i++){
            if(lVertices.get(i)==lAdj.get(j) && estadoVertice.get(i).equals("n_v")){
                vetorPredecessor.put(lAdj.get(j), v);
                estadoVertice.set(i, "v");
                buscaLargura(lAdj.get(j), estadoVertice, vetorPredecessor);
                j++;
            }
        }
    }
}