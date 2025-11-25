package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;
import model.Compra;
import model.Credito;
import model.Debito;
import model.Dinheiro;
import model.FormaPagamento;
import model.Pix;
import model.Produto;

public class CompraService {

  // Lista onde todas as compras realizadas serão armazenadas
  private final ArrayList<Compra> compras = new ArrayList<>();

  /**
   * Método responsável por registrar uma compra.
   * O usuário escolhe cliente, produto e forma de pagamento.
   */
  public void realizarCompra(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Produto> produtos) {

    System.out.println("\n=== REALIZAR COMPRA ===");

    // --- LISTAGEM DE CLIENTES ---
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

    // --- LISTAGEM DE PRODUTOS ---
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

    // --- ESCOLHA DA FORMA DE PAGAMENTO ---
    System.out.println("\nFormas de Pagamento:");
    System.out.println("1 - Dinheiro");
    System.out.println("2 - Crédito");
    System.out.println("3 - Débito");
    System.out.println("4 - Pix");
    System.out.print("Escolha: ");
    int forma = sc.nextInt();
    sc.nextLine();

    FormaPagamento pagamento;

    switch (forma) {
      case 1 -> pagamento = new Dinheiro();
      case 2 -> pagamento = new Credito();
      case 3 -> pagamento = new Debito();
      case 4 -> pagamento = new Pix();
      default -> {
        System.out.println("Forma inválida!");
        return;
      }
    }

    // Calcula o valor total
    double valorBruto = produto.getPreco();
    double valorTotal = pagamento.calcularPagamento(valorBruto);

    // Cria a compra com cliente, produto e forma de pagamento
    Compra compra = new Compra(cliente, produto, pagamento);

    // Armazena a compra na lista geral
    compras.add(compra);

    System.out.println("\n=== COMPRA REGISTRADA COM SUCESSO! ===");
    System.out.println("Valor original: R$ " + String.format("%.2f", valorBruto));
    System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
  }

  /**
   * Lista todas as compras registradas no sistema.
   */
  public void listarCompras() {
    if (compras.isEmpty()) {
      System.out.println("Nenhuma compra registrada.");
      return;
    }

    System.out.println("\n=== LISTA DE COMPRAS ===");
    for (Compra c : compras) {
      System.out.println(c); // usa o toString da classe Compra
      // ou, se preferir formato custom:
      // System.out.printf("Cliente: %s | Produto: %s | Total: R$ %.2f%n",
      //     c.getCliente().getNome(), c.getProduto().toString(), c.getValorTotal());
    }
  }
}
