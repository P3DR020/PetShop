package model;

import java.util.ArrayList;

public class Compra {

  private Cliente cliente;
  private Animal animal;
  private FormaPagamento pagamento;

  private ArrayList<CarrinhoProduto> produtos;
  private ArrayList<CarrinhoServico> servicos;

  private double subtotal;
  private double totalFinal;

  public Compra(Carrinho carrinho, FormaPagamento pagamento) {

    this.cliente = carrinho.getCliente();
    this.animal = carrinho.getAnimal();
    this.pagamento = pagamento;

    // copia dos itens do carrinho
    this.produtos = new ArrayList<>(carrinho.getProdutos());
    this.servicos = new ArrayList<>(carrinho.getServicos());

    // subtotal (produtos + serviços)
    this.subtotal = carrinho.getSubtotal();

    // total final (aplica taxa do pagamento)
    this.totalFinal = pagamento.calcularPagamento(subtotal);
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Animal getAnimal() {
    return animal;
  }

  public ArrayList<CarrinhoProduto> getProdutos() {
    return produtos;
  }

  public ArrayList<CarrinhoServico> getServicos() {
    return servicos;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public double getTotalFinal() {
    return totalFinal;
  }

  public FormaPagamento getPagamento() {
    return pagamento;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("\n===== COMPRA COMPLETA =====\n");

    sb.append("Cliente: ").append(cliente.getNome()).append("\n");
    sb.append("Animal: ").append(animal.getNome()).append("\n\n");

    sb.append("PRODUTOS:\n");
    if (produtos.isEmpty())
      sb.append("  Nenhum\n");
    else
      produtos.forEach(p -> sb.append("  ").append(p).append("\n"));

    sb.append("\nSERVIÇOS:\n");
    if (servicos.isEmpty())
      sb.append("  Nenhum\n");
    else
      servicos.forEach(s -> sb.append("  ").append(s).append("\n"));

    sb.append("\nSubtotal: R$ ").append(String.format("%.2f", subtotal)).append("\n");
    sb.append("Pagamento: ").append(pagamento.getClass().getSimpleName()).append("\n");
    sb.append("TOTAL FINAL: R$ ").append(String.format("%.2f", totalFinal)).append("\n");
    sb.append("===========================\n");

    return sb.toString();
  }
}
