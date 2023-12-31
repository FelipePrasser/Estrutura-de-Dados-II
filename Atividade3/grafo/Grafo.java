package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grafo{
    private ArrayList<Vertice> lVertices=new ArrayList<>(); 
    private ArrayList<Aresta> lArestas=new ArrayList<>();
    private int numVert=0, id=0;
    
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

    public void insereA(Vertice u, Vertice v, int valor){
        id++;
        Aresta a = new Aresta(id, u, v, valor);
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

    // public Map<Vertice, Map<Integer, Vertice>> prim(Grafo G, Vertice r){
    //     Map<Vertice, Map<Integer, Vertice>> tabelaMinimo=new HashMap<>();
    //     Map<Integer, Vertice> aux=new HashMap<>();
    //     aux.put(0, null);
    //     tabelaMinimo.put(r, aux);
    //     ArrayList <Vertice> lVerticeUtilizando=new ArrayList<>();
    //     lVerticeUtilizando.add(r);
    //     ArrayList <Vertice> lVertAdj=new ArrayList<>();
    //     ArrayList <Aresta> lArestVert=new ArrayList<>();
    //     ArrayList <Integer> lValorAresta=new ArrayList<>();
    
        
    //     while (lVerticeUtilizando.size() < lVertices.size()) {
    //         Vertice v = lVerticeUtilizando.get(lVerticeUtilizando.size() - 1);
    //         lVertAdj.clear();
    //         lVertAdj = adj(v);
        
    //         // Inicializar com um valor grande para garantir que o primeiro valor seja menor
    //         int menorValor = Integer.MAX_VALUE;
    //         Aresta arestaEscolhida = null;
        
    //         for (int i = 0; i < lVertAdj.size(); i++) {
    //             Aresta aresta = getA(v, lVertAdj.get(i));
    //             int valorAresta = aresta.getValor();
        
    //             // Verificar se o valor da aresta é menor que o menor valor encontrado até agora
    //             if (valorAresta < menorValor) {
    //                 menorValor = valorAresta;
    //                 arestaEscolhida = aresta;
    //             }
    //         }
        
    //         if (arestaEscolhida != null) {
    //             lVerticeUtilizando.add(v);
    //             aux.clear();
    //             aux.put(menorValor, oposto(v, arestaEscolhida));
    //             tabelaMinimo.put(v, aux);
    //             System.out.println(tabelaMinimo);
    //             aux.clear();
    //             v = oposto(v, arestaEscolhida);
    //         }
    //     }

    //     return tabelaMinimo;
    // }
    public Map<Vertice, Map<Integer, Vertice>> prim(Grafo G, Vertice r) {
        Map<Vertice, Map<Integer, Vertice>> tabelaMinimo = new HashMap<>();
        Map<Integer, Vertice> aux = new HashMap<>();
        aux.put(0, null);
        tabelaMinimo.put(r, aux);
    
        ArrayList<Vertice> lVerticeUtilizando = new ArrayList<>();
        lVerticeUtilizando.add(r);
    
        while (lVerticeUtilizando.size() < G.getlVertices().size()) {
            Vertice v = lVerticeUtilizando.get(lVerticeUtilizando.size() - 1);
            ArrayList<Vertice> lVertAdj = adj(v);
    
            int menorValor = Integer.MAX_VALUE;
            Aresta arestaEscolhida = null;
            Vertice w = null;
    
            for (int i = 0; i < lVertAdj.size(); i++) {
                Vertice adjacente = lVertAdj.get(i);
                Aresta aresta = getA(v, adjacente);
                int valorAresta = aresta.getValor();
    
                if (!lVerticeUtilizando.contains(adjacente) && valorAresta < menorValor) {
                    menorValor = valorAresta;
                    arestaEscolhida = aresta;
                    w = adjacente;
                }
            }
    
            if (arestaEscolhida != null) {
                lVerticeUtilizando.add(w);
                aux = new HashMap<>();
                aux.put(menorValor, w);
                tabelaMinimo.put(v, aux);
            }
        }
    
        return tabelaMinimo;
    }
}