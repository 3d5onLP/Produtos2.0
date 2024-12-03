package org.example;


import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class Produtos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Gerenciadorestoque gerenciador = new Gerenciadorestoque();
        Produto produto = null;
        var id = 0;
        String nome = null;
        Double preco = null;
        int quantidade = 0;

        while (true) {
            produto =  null;
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Estoques");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Editar Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do produto: ");
                    nome = scanner.nextLine();
                    System.out.print("Preço do produto: ");
                    preco = scanner.nextDouble();
                    System.out.print("Quantidade do produto: ");
                    quantidade = scanner.nextInt();
                    produto = new Produto(nome, preco, quantidade);
                    gerenciador.addProduto(produto);
                    break;
                case 2:
                    System.out.println("Id do produto para remoção: ");
                    id = scanner.nextInt();
                    gerenciador.deleteProduto(id);
                    break;

                case 3:
                    System.out.println("Id do produto para exibição: ");
                    id = scanner.nextInt();
                    produto = gerenciador.getProduto(id);
                    System.out.println(produto.toString());

                    break;
                case 4:
                    System.out.println("Id do protudo que  voce quer altera a valor ou quantidade:");
                    id = scanner.nextInt();
                    produto = gerenciador.getProduto(id);
                    System.out.println(produto.toString());
                    System.out.println("Edite: ");
                    System.out.println("Descrição do produto: ");
                    nome = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Preço do produto: ");
                    preco = scanner.nextDouble();
                    System.out.println("Quantidade do produto: ");
                    quantidade = scanner.nextInt();
                    produto = new Produto(nome, preco, quantidade);
                    gerenciador.updateProduto( id, produto);

                    break;
                case 5:
                    System.out.println("Saindo. Muito obrigado por usar nosso serviços");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
