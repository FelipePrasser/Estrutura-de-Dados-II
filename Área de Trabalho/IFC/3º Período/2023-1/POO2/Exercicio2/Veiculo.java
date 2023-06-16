package Exercicio2;

public class Veiculo {
    private String marca, modelo, anoFabricacao;

    public Veiculo(String marca, String modelo, String anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }
    
    public void acelerar(){
        System.out.println("Acelerando.");
    }
    
    public void freiar(){
        System.out.println("Freiando.");
    }
}