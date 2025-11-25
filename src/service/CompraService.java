package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Animal;
import model.Carrinho;
import model.Cliente;
import model.Compra;
import model.Credito;
import model.Debito;
import model.Dinheiro;
import model.FormaPagamento;
import model.Pix;
import model.Produto;
import model.Servico;

public class CompraService {

  private final ArrayList<Compra> compras = new ArrayList<>();

  public void abrirCarrinho(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Produto> produtos,
      ArrayList<Animal> animais, ArrayList<Servico> servicosDisponiveis) {

    System.out.println("\n=== INICIAR COMPRA (CARRINHO) ===");

    // === Escolher cliente ===
    System.out.println("\nClientes disponíveis:");
    for (int i = 0; i < clientes.size(); i++) {
      System.out.println((i + 1) + " - " + clientes.get(i).getNome());
    }

    System.out.print("Escolha o cliente: ");
    int clienteIndex = sc.nextInt() - 1;
    sc.nextLine();

    if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
      System.out.println("Cliente inválido!");
      return;
    }

    Cliente cliente = clientes.get(clienteIndex);

    // === Escolher animal do cliente ===
    ArrayList<Animal> animaisCliente = new ArrayList<>();

    for (Animal a : animais)
      if (a.getDono().equals(cliente))
        animaisCliente.add(a);

    if (animaisCliente.isEmpty()) {
      System.out.println("Este cliente não possui animais!");
      return;
    }

    System.out.println("\nAnimais desse cliente:");
    for (int i = 0; i < animaisCliente.size(); i++) {
      System.out.println((i + 1) + " - " + animaisCliente.get(i).getNome());
    }

    System.out.print("Escolha o animal: ");
    int aniIndex = sc.nextInt() - 1;
    sc.nextLine();

    Animal animal = animaisCliente.get(aniIndex);

    // === Criar carrinho ===
    Carrinho carrinho = new Carrinho(cliente, animal);

    int opc;
    do {
      System.out.println("\n===== CARRINHO =====");
      System.out.println("1 - Adicionar produto");
      System.out.println("2 - Adicionar serviço");
      System.out.println("3 - Remover produto");
      System.out.println("4 - Remover serviço");
      System.out.println("5 - Ver carrinho");
      System.out.println("6 - Finalizar compra");
      System.out.println("7 - Cancelar compra");
      System.out.print("Escolha: ");
      opc = sc.nextInt();
      sc.nextLine();

      switch (opc) {

        case 1 -> {
          // === ADICIONAR PRODUTO ===
          System.out.println("\nProdutos disponíveis:");
          for (int i = 0; i < produtos.size(); i++)
            System.out.println((i + 1) + " - " + produtos.get(i));

          System.out.print("Escolha o produto: ");
          int pIndex = sc.nextInt() - 1;
          sc.nextLine();

          System.out.print("Quantidade: ");
          int qtd = sc.nextInt();
          sc.nextLine();

          carrinho.adicionarProduto(produtos.get(pIndex), qtd);
          System.out.println("Produto adicionado!");
        }

        case 2 -> {
          // === ADICIONAR SERVIÇO ===
          System.out.println("\nServiços disponíveis:");
          for (int i = 0; i < servicosDisponiveis.size(); i++)
            System.out.println((i + 1) + " - " + servicosDisponiveis.get(i));

          System.out.print("Escolha o serviço: ");
          int sIndex = sc.nextInt() - 1;
          sc.nextLine();

          carrinho.adicionarServico(servicosDisponiveis.get(sIndex));
          System.out.println("Serviço adicionado!");
        }

        case 3 -> {
          // === REMOVER PRODUTO ===
          if (carrinho.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto no carrinho.");
            break;
          }

          System.out.println("\nProdutos no carrinho:");
          for (int i = 0; i < carrinho.getProdutos().size(); i++)
            System.out.println((i + 1) + " - " + carrinho.getProdutos().get(i));

          System.out.print("Escolha para remover: ");
          int rIndex = sc.nextInt() - 1;
          sc.nextLine();

          carrinho.removerProduto(rIndex);
          System.out.println("Produto removido!");
        }

        case 4 -> {
          // === REMOVER SERVIÇO ===
          if (carrinho.getServicos().isEmpty()) {
            System.out.println("Nenhum serviço no carrinho.");
            break;
          }

          System.out.println("\nServiços no carrinho:");
          for (int i = 0; i < carrinho.getServicos().size(); i++)
            System.out.println((i + 1) + " - " + carrinho.getServicos().get(i));

          System.out.print("Escolha para remover: ");
          int rrIndex = sc.nextInt() - 1;
          sc.nextLine();

          carrinho.removerServico(rrIndex);
          System.out.println("Serviço removido!");
        }

        case 5 -> System.out.println(carrinho);

        case 6 -> {
          // === FINALIZAR COMPRA ===
          System.out.println("\nFormas de Pagamento:");
          System.out.println("1 - Dinheiro");
          System.out.println("2 - Crédito");
          System.out.println("3 - Débito");
          System.out.println("4 - Pix");
          System.out.print("Escolha: ");
          int forma = sc.nextInt();
          sc.nextLine();

          FormaPagamento pagamento = switch (forma) {
            case 1 -> new Dinheiro();
            case 2 -> new Credito();
            case 3 -> new Debito();
            case 4 -> new Pix();
            default -> null;
          };

          if (pagamento == null) {
            System.out.println("Forma inválida.");
            break;
          }

          Compra compra = new Compra(carrinho, pagamento);
          compras.add(compra);

          System.out.println("\n=== COMPRA FINALIZADA ===");
          System.out.println(compra);

          return;
        }

        case 7 -> {
          System.out.println("Compra cancelada.");
          return;
        }

      }

    } while (opc != 7);
  }

  public void listarCompras() {
    if (compras.isEmpty()) {
      System.out.println("Nenhuma compra registrada.");
    } else {
      System.out.println("\n=== TODAS AS COMPRAS ===");
      compras.forEach(System.out::println);
    }
  }
}
