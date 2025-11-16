package model;

public class Produto extends Item {
  private int estoque;

  public Produto(String nome, double preco, int estoque) {
    super(nome, preco);
    this.estoque = estoque;
  }

  @Override
  public String toString() {
    return super.toString() + " | Estoque: " + estoque;
  }
}
