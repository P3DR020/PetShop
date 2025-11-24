package model;

/**
 * Classe Item
 * Representa um item simples com nome e preço.
 * Pode ser usada como base para produtos ou serviços no sistema.
 */
public class Item {

  // Nome do item (ex: "Ração Premium", "Banho e Tosa")
  private final String nome;

  // Preço do item
  private final double preco;

  /**
   * Construtor que inicializa nome e preço do item.
   */
  public Item(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  /**
   * Representação em texto do item,
   * exibindo nome e preço formatado.
   */
  @Override
  public String toString() {
    return nome + " - R$ " + preco;
  }
}
