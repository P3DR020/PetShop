package model;

public class Cliente extends Pessoa {
  private final String cpf;
  private final String telefone;
  private final String endereco;

  public Cliente(String nome, int idade, String cpf, String telefone, String endereco) {
    super(nome, idade);
    this.cpf = cpf;
    this.telefone = telefone;
    this.endereco = endereco;
  }
  public String getCpf() {
    return cpf;
  }
  public String getTelefone() {
    return telefone;
  }
  public String getEndereco() {
    return endereco;
  }
  @Override
  public String toString(){
    return String.format(
      "Nome: %s\nIdade: %d\nCPF: %s\nTelefone: %s\nEndereço: %s", 
      nome, idade, cpf, telefone, endereco);
  }

  
}
