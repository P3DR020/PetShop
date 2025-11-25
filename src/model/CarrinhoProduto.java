package model;

public class CarrinhoProduto {

  private Produto produto;
  private int quantidade;

  public CarrinhoProduto(Produto produto, int quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public Produto getProduto() {
    return produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public double getTotal() {
    return produto.getPreco() * quantidade;
  }

  @Override
  public String toString() {
    return produto.getNome() + " x" + quantidade +
        " = R$ " + String.format("%.2f", getTotal());
  }
}
