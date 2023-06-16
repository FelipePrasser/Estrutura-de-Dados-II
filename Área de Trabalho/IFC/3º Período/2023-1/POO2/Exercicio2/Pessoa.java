package Exercicio2;

public class Pessoa {
    private String nome;
    private Carro carro;

    public Pessoa(String nome, Carro carro) {
        this.nome = nome;
        this.carro = carro;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void dirigir(){
        carro.ligar();
        carro.acelerar();
        carro.acelerar();
        carro.freiar();
        carro.desligar();
    }

}
