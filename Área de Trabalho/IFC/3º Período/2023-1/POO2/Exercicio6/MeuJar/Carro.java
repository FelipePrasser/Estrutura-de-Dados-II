package Exercicio6.MeuJar;

public class Carro {
    private String fabricante;
    private String modelo;
    private String ano;
    
    public Carro(String fabricante, String modelo, String ano) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int acelerar(int velocidade, boolean ligado){
        if (ligado==true){
            velocidade++;
            return velocidade;
        }else{
            System.out.println("O carro está desligado. Não pode ser acelerado.");
            return -1;
        }
    }    
}
