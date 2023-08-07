package grafos;

import java.util.ArrayList;

public class Grafos{
    private ArrayList<Vertice> vertices=new ArrayList<>(); 
    private int numVert=0;
    public Grafos() {
    }

    public int getOrdem(){
        return(numVert);
    }
    
    public void insereV(){
        numVert++;
        vertices.add(new Vertice(numVert));
    }
}