package application;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import entity.Product;

public class Program {

    public static void main(String[] args) {

        // =========================
        // HashSet
        // =========================
        Set<Product> hashSetProd = new HashSet<>();

        hashSetProd.add(new Product("TV", 900.0));
        hashSetProd.add(new Product("Celular", 1200.0));
        hashSetProd.add(new Product("Notebook", 500.0));

        Product prod1 = new Product("Celular", 1200.0);

        // contains verifica se existe algum produto com os mesmos valores lógicos
        // Caso equals() e hashCode() não estejam implementados em Product,
        // a comparação será feita por referência de memória
        // Mesmo que os valores sejam iguais, os objetos estarão em posições
        // diferentes na memória, resultando em false
        // Para comparar o conteúdo do objeto, é necessário sobrescrever
        // equals() e hashCode()

        System.out.println(hashSetProd.contains(prod1));

        // =========================
        // TreeSet
        // =========================
        Set<Product> treeSetProd = new TreeSet<>();

        // Ao adicionar elementos no TreeSet, eles já são armazenados de forma ordenada
        // Para isso, a classe Product deve implementar Comparable<Product>
        // A ordenação pode ser feita, por exemplo, pelo nome do produto
        // Utilizar toUpperCase() no compareTo torna a comparação case-insensitive,
        // garantindo uma ordenação alfabética mais previsível

        treeSetProd.add(new Product("TV", 900.0));
        treeSetProd.add(new Product("Celular", 1200.0));
        treeSetProd.add(new Product("Notebook", 500.0));

        for (Product product : treeSetProd) {
            System.out.println(product);
        }
    }
}
