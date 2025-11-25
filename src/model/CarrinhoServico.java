package model;

public class CarrinhoServico {

  private Servico servico;

  public CarrinhoServico(Servico servico) {
    this.servico = servico;
  }

  public Servico getServico() {
    return servico;
  }

  public double getTotal() {
    return servico.getPreco();
  }

  @Override
  public String toString() {
    return servico.getTipo() +
        " = R$ " + String.format("%.2f", servico.getPreco());
  }
}
