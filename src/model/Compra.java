package model;

public class Compra {
  private Cliente cliente;
  private Produto produto;
  private FormaPagamento pagamento;

  public Compra(Cliente c, Produto p, FormaPagamento f) {
    this.cliente = c;
    this.produto = p;
    this.pagamento = f;
  }

  @Override
  public String toString() {
    return "Compra - Cliente: " + cliente.getNome() +
        " | Produto: " + produto +
        " | Pagamento: " + pagamento;
  }
}
