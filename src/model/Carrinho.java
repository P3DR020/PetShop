package model;

import java.util.ArrayList;

/**
 * Classe Carrinho
 * Representa uma compra em andamento.
 * O carrinho pode ter:
 * - Cliente (obrigatório)
 * - Animal (opcional, pode ser null)
 * - Lista de produtos
 * - Lista de serviços
 */
public class Carrinho {

  private Cliente cliente; // Cliente dono do carrinho
  private Animal animal; // Animal escolhido (pode ser NULL)

  private ArrayList<CarrinhoProduto> produtos = new ArrayList<>(); // Produtos adicionados
  private ArrayList<CarrinhoServico> servicos = new ArrayList<>(); // Serviços adicionados

  /**
   * Construtor do carrinho.
   * Permite criar um carrinho COM ou SEM animal.
   */
  public Carrinho(Cliente cliente, Animal animal) {
    this.cliente = cliente;
    this.animal = animal; // pode vir null
  }

  /**
   * Permite definir ou trocar o animal após o carrinho ser criado.
   * Usado quando o cliente decide escolher o animal no menu.
   */
  public void setAnimal(Animal animal) {
    this.animal = animal;
  }

  // ==========================
  // PRODUTOS
  // ==========================

  /**
   * Adiciona um produto ao carrinho, com quantidade.
   */
  public void adicionarProduto(Produto produto, int quantidade) {
    produtos.add(new CarrinhoProduto(produto, quantidade));
  }

  /**
   * Remove um produto do carrinho pelo índice.
   */
  public void removerProduto(int index) {
    produtos.remove(index);
  }

  // ==========================
  // SERVIÇOS
  // ==========================

  /**
   * Adiciona um serviço ao carrinho.
   * Só funciona se um animal tiver sido selecionado.
   */
  public void adicionarServico(Servico servico) {
    servicos.add(new CarrinhoServico(servico));
  }

  /**
   * Remove serviço do carrinho pelo índice.
   */
  public void removerServico(int index) {
    servicos.remove(index);
  }

  // ==========================
  // UTILITÁRIOS
  // ==========================

  /**
   * Limpa o carrinho completamente.
   */
  public void limpar() {
    produtos.clear();
    servicos.clear();
  }

  /**
   * Soma total dos produtos do carrinho.
   */
  public double getTotalProdutos() {
    return produtos.stream().mapToDouble(CarrinhoProduto::getTotal).sum();
  }

  /**
   * Soma total dos serviços do carrinho.
   */
  public double getTotalServicos() {
    return servicos.stream().mapToDouble(CarrinhoServico::getTotal).sum();
  }

  /**
   * Soma total (produtos + serviços) — ainda sem forma de pagamento.
   */
  public double getSubtotal() {
    return getTotalProdutos() + getTotalServicos();
  }

  // ==========================
  // GETTERS
  // ==========================

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

  // ==========================
  // EXIBIÇÃO
  // ==========================

  /**
   * Exibe o conteúdo do carrinho de forma organizada.
   * Animal aparece como "Nenhum selecionado" se for null.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("\n===== CARRINHO =====\n");

    sb.append("Cliente: ").append(cliente.getNome()).append("\n");

    // Ternário, pois o animal pode ser NULL
    sb.append("Animal: ")
        .append(animal == null ? "Nenhum selecionado" : animal.getNome())
        .append("\n\n");

    // Produtos
    sb.append("Produtos:\n");
    if (produtos.isEmpty())
      sb.append("  Nenhum\n");
    else
      produtos.forEach(p -> sb.append("  ").append(p).append("\n"));

    // Serviços
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
