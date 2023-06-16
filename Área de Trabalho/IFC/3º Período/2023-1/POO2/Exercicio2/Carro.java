package Exercicio2;


public class Carro extends Veiculo {
    private int qtdPortas;

    public Carro(String marca, String modelo, String anoFabricacao, int qtdPortas) {
        super(marca, modelo, anoFabricacao);
        this.qtdPortas = qtdPortas;
    }

    public void ligar(){
        System.out.println("Ligando o carro.");
    }

    public void desligar(){
        System.out.println("Desligando o carro.");
    }
}
