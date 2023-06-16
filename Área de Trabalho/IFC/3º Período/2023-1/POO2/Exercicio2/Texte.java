package Exercicio2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Texte {
    public static void main(String[] args) throws Exception {
        Class<?> classeVeiculo = Veiculo.class;
        Class<?> classeCarro = Carro.class;
        Class<?> classePessoa = Pessoa.class;

        System.out.println("-----Classe Veículo-----\n->Atributos:");
        Field[] fieldVeiculo = classeVeiculo.getDeclaredFields();
        for (Field field : fieldVeiculo) {
            System.out.println("    " + field.getName());
        }

        System.out.println("->Métodos:");
        Method[] metodoVeiculo = classeVeiculo.getDeclaredMethods();
        for (Method method : metodoVeiculo) {
            System.out.println("    " + method.getName());
        }


        Veiculo veiculo = new Veiculo("Ford", "Mustang", "1969");
        Method metodoAcelerar = classeVeiculo.getDeclaredMethod("acelerar");
        metodoAcelerar.invoke(veiculo);

        System.out.println("\n-----Classe Carro-----\n->Atributos:");
        Field[] fieldCarro = classeCarro.getDeclaredFields();
        for (Field field : fieldCarro) {
            System.out.println("    " + field.getName());
        }

        System.out.println("->Métodos:");
        Method[] metodoCarro = classeCarro.getDeclaredMethods();
        for (Method method : metodoCarro) {
            System.out.println("    " + method.getName());
        }


        Carro carro = new Carro("Ford", "Mustang", "1969", 2);
        Method metodoLigar = classeCarro.getDeclaredMethod("ligar");
        metodoLigar.invoke(carro);

        System.out.println("\n-----Classe Pessoa-----\n->Atributos:");
        Field[] fieldPessoa = classePessoa.getDeclaredFields();
        for (Field field : fieldPessoa) {
            System.out.println("    " + field.getName());
        }

        System.out.println("->Métodos:");
        Method[] metodoPessoa = classePessoa.getDeclaredMethods();
        for (Method method : metodoPessoa) {
            System.out.println("    " + method.getName());
        }
    }
}