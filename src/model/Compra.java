package model;

public class Compra {

  private final Cliente cliente;
  private final Produto produto;
  private final FormaPagamento pagamento;

  public Compra(Cliente cliente, Produto produto, FormaPagamento pagamento) {
    this.cliente = cliente;
    this.produto = produto;
    this.pagamento = pagamento;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Produto getProduto() {
    return produto;
  }

  public FormaPagamento getPagamento() {
    return pagamento;
  }

  @Override
  public String toString() {
    return """
        COMPRA:
        Cliente: %s
        Produto: %s
        Pagamento: %s
        --------------------------------------""".formatted(cliente.getNome(), produto, pagamento);
  }
}
