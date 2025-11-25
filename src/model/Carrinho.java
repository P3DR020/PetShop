package model;

import java.util.ArrayList;

public class Carrinho {

  private Cliente cliente;
  private Animal animal;

  private ArrayList<CarrinhoProduto> produtos = new ArrayList<>();
  private ArrayList<CarrinhoServico> servicos = new ArrayList<>();

  public Carrinho(Cliente cliente, Animal animal) {
    this.cliente = cliente;
    this.animal = animal;
  }

  // ADICIONAR PRODUTO
  public void adicionarProduto(Produto produto, int quantidade) {
    produtos.add(new CarrinhoProduto(produto, quantidade));
  }

  // ADICIONAR SERVIÇO
  public void adicionarServico(Servico servico) {
    servicos.add(new CarrinhoServico(servico));
  }

  // REMOVER PRODUTO
  public void removerProduto(int index) {
    produtos.remove(index);
  }

  // REMOVER SERVIÇO
  public void removerServico(int index) {
    servicos.remove(index);
  }

  // ESVAZIAR CARRINHO
  public void limpar() {
    produtos.clear();
    servicos.clear();
  }

  // CALCULOS
  public double getTotalProdutos() {
    return produtos.stream().mapToDouble(CarrinhoProduto::getTotal).sum();
  }

  public double getTotalServicos() {
    return servicos.stream().mapToDouble(CarrinhoServico::getTotal).sum();
  }

  public double getSubtotal() {
    return getTotalProdutos() + getTotalServicos();
  }

  // GETTERS
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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("\n===== CARRINHO =====\n");

    sb.append("Cliente: ").append(cliente.getNome()).append("\n");
    sb.append("Animal: ").append(animal.getNome()).append("\n\n");

    sb.append("Produtos:\n");
    if (produtos.isEmpty())
      sb.append("  Nenhum\n");
    else
      produtos.forEach(p -> sb.append("  ").append(p).append("\n"));

    sb.append("\nServiços:\n");
    if (servicos.isEmpty())
      sb.append("  Nenhum\n");
    else
      servicos.forEach(s -> sb.append("  ").append(s).append("\n"));

    sb.append("\nSubtotal: R$ ").append(String.format("%.2f", getSubtotal()));
    sb.append("\n=====================\n");

    return sb.toString();
  }
}
