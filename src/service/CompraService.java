package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;
import model.Compra;
import model.FormaPagamento;
import model.Produto;

public class CompraService {

  private final ArrayList<Compra> compras = new ArrayList<>();

  public void realizarCompra(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Produto> produtos) {

    System.out.println("\n=== REALIZAR COMPRA ===");

    // LISTAR CLIENTES
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

    // LISTAR PRODUTOS
    System.out.println("\nProdutos disponíveis:");
    for (int i = 0; i < produtos.size(); i++) {
      System.out.println((i + 1) + " - " + produtos.get(i));
    }

    System.out.print("Escolha o produto: ");
    int prodIndex = sc.nextInt() - 1;
    sc.nextLine();

    if (prodIndex < 0 || prodIndex >= produtos.size()) {
      System.out.println("Produto inválido!");
      return;
    }

    Produto produto = produtos.get(prodIndex);

    // FORMA DE PAGAMENTO
    System.out.println("\nFormas de Pagamento:");
    System.out.println("1 - Dinheiro");
    System.out.println("2 - Cartão");
    System.out.println("3 - Pix");
    System.out.print("Escolha: ");
    int forma = sc.nextInt();
    sc.nextLine();

    FormaPagamento pagamento;

    switch (forma) {
      case 1 -> pagamento = FormaPagamento.DINHEIRO;
      case 2 -> pagamento = FormaPagamento.CARTAO;
      case 3 -> pagamento = FormaPagamento.PIX;
      default -> {
        System.out.println("Forma inválida!");
        return;
      }
    }

    Compra compra = new Compra(cliente, produto, pagamento);
    compras.add(compra);

    System.out.println("\nCOMPRA REGISTRADA COM SUCESSO!");
    System.out.println(compra);
  }

  public void listarCompras() {
    if (compras.isEmpty()) {
      System.out.println("Nenhuma compra registrada.");
      return;
    }

    System.out.println("\n=== LISTA DE COMPRAS ===");
    compras.forEach(System.out::println);
  }

  public ArrayList<Compra> getCompras() {
    return compras;
  }
}
