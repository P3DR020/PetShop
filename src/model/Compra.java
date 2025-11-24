package model;

/**
 * Classe Compra
 * Representa uma compra feita no PetShop, contendo:
 * - o cliente que comprou
 * - o produto escolhido
 * - a forma de pagamento utilizada
 */
public class Compra {

  // Cliente que realizou a compra
  private final Cliente cliente;

  // Produto adquirido
  private final Produto produto;

  // Tipo de pagamento (enum: DINHEIRO, CARTAO ou PIX)
  private final FormaPagamento pagamento;

  /**
   * Construtor da Compra.
   * Inicializa cliente, produto e forma de pagamento.
   */
  public Compra(Cliente cliente, Produto produto, FormaPagamento pagamento) {
    this.cliente = cliente;
    this.produto = produto;
    this.pagamento = pagamento;
  }

  // Getters
  public Cliente getCliente() {
    return cliente;
  }

  public Produto getProduto() {
    return produto;
  }

  public FormaPagamento getPagamento() {
    return pagamento;
  }

  /**
   * Representação textual da compra.
   * Usa texto multilinha (""" """) para organizar a visualização.
   */
  @Override
  public String toString() {
    return """
        COMPRA:
        Cliente: %s
        Produto: %s
        Pagamento: %s
        --------------------------------------"""
        .formatted(cliente.getNome(), produto, pagamento);
  }
}
