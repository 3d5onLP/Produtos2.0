package org.example;


import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class Produtos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Gerenciadorestoque gerenciador = new Gerenciadorestoque();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Adicionar Estoque");
            System.out.println("4. Remover Estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    Produto produto = new Produto(nome, preco, quantidade);
                    gerenciador.addProduto(produto);
                    break;
                case 2:
                    System.out.println("Id do produto para remoção: ");
                    var id = scanner.nextInt();
                    gerenciador.deleteProduto(id);
                    break;

                case 3:

                    System.out.printf("O produto %s custa R$ %.2f e temos %d unidades em estoque.%n",
                            produto.getNome(), produto.getPreco(), produto.getQuantidade());


                    break;
            /*     case 4:
                    System.out.print("Descrição do produto para remover estoque: ");
                    String descricaoRemover = scanner.nextLine();
                    Produto produtoRemover = gerenciador.encontrarProduto(descricaoRemover);
                    if (produtoRemover != null) {
                        System.out.print("Quantidade de produto a remover: ");
                        int qtdRemover = scanner.nextInt();
                        produtoRemover.removerEstoque(qtdRemover);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;*/
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
