package model;

/**
 * Classe Servico
 * Representa um serviço oferecido pelo PetShop,
 * como "Banho e Tosa", "Consulta", etc.
 */
public class Servico {

  // Tipo do serviço oferecido (ex: Banho e Tosa)
  private final String tipo;
  private final double preco;

  /**
   * Construtor do serviço.
   * Recebe apenas o tipo, já que um serviço não tem preço ou estoque neste
   * sistema.
   */
  public Servico(String tipo, double preco) {
    this.tipo = tipo;
    this.preco = preco;
  }

  // Retorna o tipo do serviço
  public String getTipo() {
    return tipo;
  }

  public double getPreco() {
    return preco;
  }

  /**
   * Representação em texto do serviço.
   */
  @Override
  public String toString() {
    return "Serviço: " + tipo + " | Preço: R$ " + String.format("%.2f", preco);
  }
}
