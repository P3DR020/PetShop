package model;

/**
 * Classe Produto — herda de Item.
 * Representa um produto físico vendido no PetShop,
 * contendo nome, preço e quantidade em estoque.
 */
public class Produto extends Item {

  // Quantidade disponível do produto em estoque
  private final int estoque;

  /**
   * Construtor do Produto.
   * Recebe nome e preço (Item) + estoque específico do produto.
   */
  public Produto(String nome, double preco, int estoque) {
    super(nome, preco); // chama construtor da classe Item
    this.estoque = estoque;
  }

  @Override
  public String toString() {
    return super.toString() + " | Estoque: " + estoque;
  }

  public int getEstoque() {
    return estoque;
  }

  public double getPreco() {
    return preco;
  }
}
