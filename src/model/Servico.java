package model;

/**
 * Classe Servico
 * Representa um serviço oferecido pelo PetShop,
 * como "Banho e Tosa", "Consulta", etc.
 */
public class Servico {

  // Tipo do serviço oferecido (ex: Banho e Tosa)
  private final String tipo;

  /**
   * Construtor do serviço.
   * Recebe apenas o tipo, já que um serviço não tem preço ou estoque neste sistema.
   */
  public Servico(String tipo) {
    this.tipo = tipo;
  }

  // Retorna o tipo do serviço
  public String getTipo() {
    return tipo;
  }

  /**
   * Representação em texto do serviço.
   */
  @Override
  public String toString() {
    return "Serviço: " + tipo;
  }
}
