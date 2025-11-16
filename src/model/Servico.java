package model;

public class Servico {
  private String tipo;

  public Servico(String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  @Override
  public String toString() {
    return "Serviço: " + tipo;
  }
}
